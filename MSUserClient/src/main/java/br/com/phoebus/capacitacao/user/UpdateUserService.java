package br.com.phoebus.capacitacao.user;

import org.springframework.web.bind.annotation.PutMapping;

import br.com.phoebus.capacitacao.exception.UserInvalid;
import br.com.phoebus.capacitacao.exception.UserNotExistException;

@FunctionalInterface
public interface UpdateUserService {

	@PutMapping("/updateUser")
	User update(Long id, UserRequest dto) throws UserNotExistException, UserInvalid;

}