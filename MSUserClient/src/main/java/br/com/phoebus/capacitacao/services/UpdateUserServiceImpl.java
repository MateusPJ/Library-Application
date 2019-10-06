package br.com.phoebus.capacitacao.services;

import org.springframework.stereotype.Service;

import br.com.phoebus.capacitacao.entitys.User;
import br.com.phoebus.capacitacao.entitys.UserRequest;
import br.com.phoebus.capacitacao.exception.UserInvalid;
import br.com.phoebus.capacitacao.exception.UserNotExistException;
import br.com.phoebus.capacitacao.repositorys.UpdateUserService;
import br.com.phoebus.capacitacao.repositorys.UserRepository;
import lombok.RequiredArgsConstructor;

/**
 * 
 * Classe responsável por realizar o tratamento das atualizações dos usuários.
 * 
 * @author Mateus P Jorge
 *
 */
@Service
@RequiredArgsConstructor
public class UpdateUserServiceImpl implements UpdateUserService {

	private final UserRepository userRepository;

	public User update(Long id, UserRequest dto) throws UserNotExistException, UserInvalid {
		if (!userRepository.findById(id).isPresent()) {
			throw new UserNotExistException();
		} else if (dto.getName() == null || dto.getName().isEmpty()) {
			throw new UserInvalid();
		} else if (dto.getAge() < 18) {
			throw new UserInvalid();
		} else if (dto.getPhone() == null || dto.getPhone().isEmpty()) {
			throw new UserInvalid();
		} else {
			dto.setId(id);
			userRepository.save(UserRequest.to(dto));
		}
		return UserRequest.to(dto);
	}

}