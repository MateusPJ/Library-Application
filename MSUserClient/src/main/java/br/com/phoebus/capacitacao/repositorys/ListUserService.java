package br.com.phoebus.capacitacao.repositorys;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import br.com.phoebus.capacitacao.entitys.User;
import br.com.phoebus.capacitacao.exception.UserListIsEmptyException;

/**
 * 
 * Interface respons�vel por controlar o servi�o de listagem dos usu�rios.
 * 
 * @author Mateus P Jorge
 *
 */
@FunctionalInterface
public interface ListUserService {

	/**
	 * 
	 * M�todo respons�vel por listar todos os usu�rios cadastrados.
	 * 
	 * @return listAllUsers
	 * @throws UserListIsEmptyException
	 */
	@GetMapping("/listAllUsers")
	List<User> findAll() throws UserListIsEmptyException;

}