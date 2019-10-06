package br.com.phoebus.capacitacao.services;

import org.springframework.stereotype.Service;

import br.com.phoebus.capacitacao.entitys.User;
import br.com.phoebus.capacitacao.exception.UserNotExistException;
import br.com.phoebus.capacitacao.repositorys.DeleteUserService;
import br.com.phoebus.capacitacao.repositorys.UserRepository;
import lombok.AllArgsConstructor;

/**
 * 
 * Classe responsável por implementar a exclusão dos usuários.
 * 
 * @author Mateus P Jorge
 *
 */
@Service
@AllArgsConstructor
public class DeleteUserServiceImpl implements DeleteUserService {

	private UserRepository userRepository;

	public void delete(Long id) throws UserNotExistException {
		User user = userRepository.findById(id).orElseThrow(UserNotExistException::new);
		userRepository.delete(user);
	}

}