package br.com.phoebus.capacitacao.repositorys;

import org.springframework.web.bind.annotation.PutMapping;

import br.com.phoebus.capacitacao.entitys.User;
import br.com.phoebus.capacitacao.entitys.UserRequest;
import br.com.phoebus.capacitacao.exception.UserInvalid;
import br.com.phoebus.capacitacao.exception.UserNotExistException;

/**
 * 
 * Interface responsável por controlar o serviço de atualização dos usuários.
 * 
 * @author Mateus P Jorge
 *
 */
@FunctionalInterface
public interface UpdateUserService {

	/**
	 * 
	 * Método responsável por realizar todas as atualizações dos usuários.
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