package br.com.phoebus.capacitacao.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.phoebus.capacitacao.exception.UserNotExistException;

@FunctionalInterface
public interface UserVerify {

	@GetMapping("/exitsByUser/{id}")
	User existsByUser(@PathVariable("id") Long id) throws UserNotExistException;

}