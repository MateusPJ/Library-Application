package br.com.phoebus.capacitacao.repositorys;

import org.springframework.web.bind.annotation.PostMapping;

import br.com.phoebus.capacitacao.entitys.User;
import br.com.phoebus.capacitacao.entitys.UserRequest;
import br.com.phoebus.capacitacao.exception.UserInvalid;

/**
 * 
 * Interface responsável por controlar o serviço de cadastro dos usuários.
 * 
 * @author Mateus P Jorge
 *
 */
@FunctionalInterface
public interface SaveUserService {

	/**
	 * 
	 * Método responsável por realizar todos os cadastros de usuários.
	 * 
	 * @param dto
	 * @return User
	 * @throws UserInvalid
	 */
	@PostMapping("/createUser")
	User save(UserRequest dto) throws UserInvalid;

}