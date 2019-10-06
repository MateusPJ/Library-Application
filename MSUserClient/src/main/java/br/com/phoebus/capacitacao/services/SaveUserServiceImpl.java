package br.com.phoebus.capacitacao.services;

import org.springframework.stereotype.Service;

import br.com.phoebus.capacitacao.entitys.User;
import br.com.phoebus.capacitacao.entitys.UserRequest;
import br.com.phoebus.capacitacao.exception.UserInvalid;
import br.com.phoebus.capacitacao.repositorys.SaveUserService;
import br.com.phoebus.capacitacao.repositorys.UserRepository;
import lombok.RequiredArgsConstructor;

/**
 * 
 * Classe responsável por realizar o tratamento de cadastro dos usuários.
 * 
 * @author Mateus P Jorge
 *
 */
@Service
@RequiredArgsConstructor
public class SaveUserServiceImpl implements SaveUserService {

	private final UserRepository userRepository;

	public User save(UserRequest dto) throws UserInvalid {
		if (dto.getName() == null || dto.getName().isEmpty()) {
			throw new UserInvalid();
		} else if (dto.getAge() < 18) {
			throw new UserInvalid();
		} else if (dto.getPhone() == null || dto.getPhone().isEmpty()) {
			throw new UserInvalid();
		} else {
			userRepository.save(UserRequest.to(dto));
		}
		return UserRequest.to(dto);
	}

}