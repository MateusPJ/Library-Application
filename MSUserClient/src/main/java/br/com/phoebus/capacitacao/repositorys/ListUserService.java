package br.com.phoebus.capacitacao.repositorys;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import br.com.phoebus.capacitacao.entitys.User;
import br.com.phoebus.capacitacao.exception.UserListIsEmptyException;

/**
 * 
 * Interface responsável por controlar o serviço de listagem dos usuários.
 * 
 * @author Mateus P Jorge
 *
 */
@FunctionalInterface
public interface ListUserService {

	/**
	 * 
	 * Método responsável por listar todos os usuários cadastrados.
	 * 
	 * @return listAllUsers
	 * @throws UserListIsEmptyException
	 */
	@GetMapping("/listAllUsers")
	List<User> findAll() throws UserListIsEmptyException;

}