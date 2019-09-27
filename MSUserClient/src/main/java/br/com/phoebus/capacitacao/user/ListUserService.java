package br.com.phoebus.capacitacao.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import br.com.phoebus.capacitacao.exception.UserListIsEmptyException;

@FunctionalInterface
public interface ListUserService {

	@GetMapping("/listAllUsers")
	List<User> findAll() throws UserListIsEmptyException;

}