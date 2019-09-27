package br.com.phoebus.capacitacao.user;

import org.springframework.web.bind.annotation.PostMapping;

import br.com.phoebus.capacitacao.exception.UserInvalid;

@FunctionalInterface
public interface SaveUserService {

	@PostMapping("/createUser")
	User save(UserRequest dto) throws UserInvalid;

}