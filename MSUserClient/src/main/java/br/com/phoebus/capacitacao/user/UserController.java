package br.com.phoebus.capacitacao.user;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.phoebus.capacitacao.exception.UserInvalid;
import br.com.phoebus.capacitacao.exception.UserListIsEmptyException;
import br.com.phoebus.capacitacao.exception.UserNotExistException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	private final SaveUserService saveUserService;
	private final DeleteUserService deleteUserService;
	private final UpdateUserService updateUserService;
	private final ListUserService listUserService;
	private final UserVerifyImpl userVerifyImpl;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserResponse saveUser(@RequestBody UserRequest dto) throws UserInvalid {
		saveUserService.save(dto);
		return UserResponse.requestConverter(UserRequest.to(dto));
	}

	@DeleteMapping(value = "{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void deleteUser(@PathVariable("id") Long id) throws UserNotExistException {
		deleteUserService.delete(id);
	}

	@PutMapping(value = "{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void updateUser(@PathVariable("id") Long id, @RequestBody UserRequest dto)
			throws UserNotExistException, UserInvalid {
		updateUserService.update(id, dto);
	}

	@GetMapping
	public List<User> listUsers() throws UserListIsEmptyException {
		return listUserService.findAll();
	}

	@GetMapping("/{id}")
	public User existsByUser(@PathVariable("id") Long id) throws UserNotExistException {
		return userVerifyImpl.existsByUser(id);
	}

}