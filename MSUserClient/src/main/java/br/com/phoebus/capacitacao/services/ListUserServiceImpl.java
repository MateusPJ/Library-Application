package br.com.phoebus.capacitacao.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.phoebus.capacitacao.entitys.User;
import br.com.phoebus.capacitacao.exception.UserListIsEmptyException;
import br.com.phoebus.capacitacao.repositorys.ListUserService;
import br.com.phoebus.capacitacao.repositorys.UserRepository;
import lombok.RequiredArgsConstructor;

/**
 * 
 * Método responsável por retornar todos os usuários cadastrados.
 * 
 * @author Mateus P Jorge
 *
 */
@Service
@RequiredArgsConstructor
public class ListUserServiceImpl implements ListUserService {

	private final UserRepository userRepository;

	public List<User> findAll() throws UserListIsEmptyException {
		List<User> listUsers = userRepository.findAll();
		if (listUsers.isEmpty()) {
			throw new UserListIsEmptyException();
		}
		return listUsers;
	}

}