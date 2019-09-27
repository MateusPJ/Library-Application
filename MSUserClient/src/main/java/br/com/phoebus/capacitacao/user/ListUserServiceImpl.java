package br.com.phoebus.capacitacao.user;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.phoebus.capacitacao.exception.UserListIsEmptyException;
import lombok.RequiredArgsConstructor;

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