package br.com.phoebus.capacitacao.user;

import org.springframework.stereotype.Service;

import br.com.phoebus.capacitacao.exception.UserNotExistException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DeleteUserServiceImpl implements DeleteUserService {

	private UserRepository userRepository;

	public void delete(Long id) throws UserNotExistException {
		User user = userRepository.findById(id).orElseThrow(UserNotExistException::new);
		userRepository.delete(user);
	}

}