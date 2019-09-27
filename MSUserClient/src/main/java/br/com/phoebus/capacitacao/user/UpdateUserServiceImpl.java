package br.com.phoebus.capacitacao.user;

import org.springframework.stereotype.Service;

import br.com.phoebus.capacitacao.exception.UserInvalid;
import br.com.phoebus.capacitacao.exception.UserNotExistException;
import lombok.RequiredArgsConstructor;

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