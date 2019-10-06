package br.com.phoebus.capacitacao.repositorys;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.phoebus.capacitacao.entitys.User;
import br.com.phoebus.capacitacao.exception.UserNotExistException;

/**
 * 
 * Interface responsável por buscar usuários cadastrados.
 * 
 * @author Mateus P Jorge
 *
 */
@FunctionalInterface
public interface UserVerify {

	/**
	 * 
	 * Método responsável por buscar um usuário cadastrado.
	 * 
	 * @param id
	 * @return User
	 * @throws UserNotExistException
	 */
	@GetMapping("/exitsByUser/{id}")
	User existsByUser(@PathVariable("id") Long id) throws UserNotExistException;

}