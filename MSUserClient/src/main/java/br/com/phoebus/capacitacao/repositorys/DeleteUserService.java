package br.com.phoebus.capacitacao.repositorys;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.phoebus.capacitacao.exception.UserNotExistException;

/**
 * 
 * Interface responsável por controlar o serviço de exclusão dos usuários.
 * 
 * @author Mateus P Jorge
 *
 */
@FunctionalInterface
public interface DeleteUserService {

	/**
	 * 
	 * Método responsável por realizar o delete dos usuários.
	 * 
	 * @param id
	 * @throws UserNotExistException
	 */
	@DeleteMapping("/deleteUser/{id}")
	void delete(@PathVariable("id") Long id) throws UserNotExistException;

}