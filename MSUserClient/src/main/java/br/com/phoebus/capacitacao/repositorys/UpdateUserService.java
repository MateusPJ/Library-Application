package br.com.phoebus.capacitacao.repositorys;

import org.springframework.web.bind.annotation.PutMapping;

import br.com.phoebus.capacitacao.entitys.User;
import br.com.phoebus.capacitacao.entitys.UserRequest;
import br.com.phoebus.capacitacao.exception.UserInvalid;
import br.com.phoebus.capacitacao.exception.UserNotExistException;

/**
 * 
 * Interface respons�vel por controlar o servi�o de atualiza��o dos usu�rios.
 * 
 * @author Mateus P Jorge
 *
 */
@FunctionalInterface
public interface UpdateUserService {

	/**
	 * 
	 * M�todo respons�vel por realizar todas as atualiza��es dos usu�rios.
	 * 
	 * @param id
	 * @param dto
	 * @return
	 * @throws UserNotExistException
	 * @throws UserInvalid
	 */
	@PutMapping("/updateUser")
	User update(Long id, UserRequest dto) throws UserNotExistException, UserInvalid;

}