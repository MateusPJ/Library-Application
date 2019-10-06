package br.com.phoebus.capacitacao.controller;

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

import br.com.phoebus.capacitacao.entitys.User;
import br.com.phoebus.capacitacao.entitys.UserRequest;
import br.com.phoebus.capacitacao.entitys.UserResponse;
import br.com.phoebus.capacitacao.exception.UserInvalid;
import br.com.phoebus.capacitacao.exception.UserListIsEmptyException;
import br.com.phoebus.capacitacao.exception.UserNotExistException;
import br.com.phoebus.capacitacao.repositorys.DeleteUserService;
import br.com.phoebus.capacitacao.repositorys.ListUserService;
import br.com.phoebus.capacitacao.repositorys.SaveUserService;
import br.com.phoebus.capacitacao.repositorys.UpdateUserService;
import br.com.phoebus.capacitacao.services.UserVerifyImpl;
import lombok.RequiredArgsConstructor;

/**
 * 
 * Classe controladora dos serviços de usuários.
 * 
 * @author Mateus P Jorge
 *
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

	private final SaveUserService saveUserService;
	private final DeleteUserService deleteUserService;
	private final UpdateUserService updateUserService;
	private final ListUserService listUserService;
	private final UserVerifyImpl userVerifyImpl;

	/**
	 * 
	 * Método responsável por realizar o cadastro dos usuários.
	 * 
	 * @param dto
	 * @return UserResponse
	 * @throws UserInvalid
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserResponse saveUser(@RequestBody UserRequest dto) throws UserInvalid {
		saveUserService.save(dto);
		return UserResponse.requestConverter(UserRequest.to(dto));
	}

	/**
	 * 
	 * Método responsável por deletar um usuário.
	 * 
	 * @param id
	 * @throws UserNotExistException
	 */
	@DeleteMapping(value = "{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void deleteUser(@PathVariable("id") Long id) throws UserNotExistException {
		deleteUserService.delete(id);
	}

	/**
	 * 
	 * Método responsável por atualizar as informações de um usuário cadastrado.
	 * 
	 * @param id
	 * @param dto
	 * @throws UserNotExistException
	 * @throws UserInvalid
	 */
	@PutMapping(value = "{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void updateUser(@PathVariable("id") Long id, @RequestBody UserRequest dto)
			throws UserNotExistException, UserInvalid {
		updateUserService.update(id, dto);
	}

	/**
	 * 
	 * Método responsável por listar todos usuários cadastrados.
	 * 
	 * @return listAllBooks
	 * @throws UserListIsEmptyException
	 */
	@GetMapping
	public List<User> listUsers() throws UserListIsEmptyException {
		return listUserService.findAll();
	}

	/**
	 * 
	 * Método responsável por buscar um usuário cadastrado.
	 * 
	 * @param id
	 * @return
	 * @throws UserNotExistException
	 */
	@GetMapping("/{id}")
	public User existsByUser(@PathVariable("id") Long id) throws UserNotExistException {
		return userVerifyImpl.existsByUser(id);
	}

}