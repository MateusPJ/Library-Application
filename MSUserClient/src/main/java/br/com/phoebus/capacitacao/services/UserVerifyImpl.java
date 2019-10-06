package br.com.phoebus.capacitacao.services;

import org.springframework.stereotype.Service;

import br.com.phoebus.capacitacao.entitys.User;
import br.com.phoebus.capacitacao.exception.UserNotExistException;
import br.com.phoebus.capacitacao.repositorys.UserRepository;
import br.com.phoebus.capacitacao.repositorys.UserVerify;
import lombok.RequiredArgsConstructor;

/**
 * 
 * Método responsável por retonar um usuário cadastrado.
 * 
 * @author Mateus P Jorge
 *
 */
@Service
@RequiredArgsConstructor
public class UserVerifyImpl implements UserVerify {

	private final UserRepository userRepository;

	public User existsByUser(Long id) throws UserNotExistException {
		return userRepository.findById(id).orElseThrow(UserNotExistException::new);
	}

}