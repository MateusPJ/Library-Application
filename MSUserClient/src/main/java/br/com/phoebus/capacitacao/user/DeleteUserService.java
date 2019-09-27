package br.com.phoebus.capacitacao.user;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.phoebus.capacitacao.exception.UserNotExistException;

@FunctionalInterface
public interface DeleteUserService {

	@DeleteMapping("/deleteUser/{id}")
	void delete(@PathVariable("id") Long id) throws UserNotExistException;

}