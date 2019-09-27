package br.com.phoebus.capacitacao.user;

import org.springframework.stereotype.Service;

import br.com.phoebus.capacitacao.exception.UserNotExistException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserVerifyImpl implements UserVerify {

	private final UserRepository userRepository;

	public User existsByUser(Long id) throws UserNotExistException {
		return userRepository.findById(id).orElseThrow(UserNotExistException::new);
	}

}