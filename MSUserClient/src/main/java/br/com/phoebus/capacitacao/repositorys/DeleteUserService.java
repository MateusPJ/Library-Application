package br.com.phoebus.capacitacao.repositorys;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.phoebus.capacitacao.exception.UserNotExistException;

/**
 * 
 * Interface respons�vel por controlar o servi�o de exclus�o dos usu�rios.
 * 
 * @author Mateus P Jorge
 *
 */
@FunctionalInterface
public interface DeleteUserService {

	/**
	 * 
	 * M�todo respons�vel por realizar o delete dos usu�rios.
	 * 
	 * @param id
	 * @throws UserNotExistException
	 */
	@DeleteMapping("/deleteUser/{id}")
	void delete(@PathVariable("id") Long id) throws UserNotExistException;

}