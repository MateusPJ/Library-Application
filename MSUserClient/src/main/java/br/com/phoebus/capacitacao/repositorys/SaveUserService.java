package br.com.phoebus.capacitacao.repositorys;

import org.springframework.web.bind.annotation.PostMapping;

import br.com.phoebus.capacitacao.entitys.User;
import br.com.phoebus.capacitacao.entitys.UserRequest;
import br.com.phoebus.capacitacao.exception.UserInvalid;

/**
 * 
 * Interface respons�vel por controlar o servi�o de cadastro dos usu�rios.
 * 
 * @author Mateus P Jorge
 *
 */
@FunctionalInterface
public interface SaveUserService {

	/**
	 * 
	 * M�todo respons�vel por realizar todos os cadastros de usu�rios.
	 * 
	 * @param dto
	 * @return User
	 * @throws UserInvalid
	 */
	@PostMapping("/createUser")
	User save(UserRequest dto) throws UserInvalid;

}