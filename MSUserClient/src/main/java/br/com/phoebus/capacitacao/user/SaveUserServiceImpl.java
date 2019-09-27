package br.com.phoebus.capacitacao.user;

import org.springframework.stereotype.Service;

import br.com.phoebus.capacitacao.exception.UserInvalid;
import lombok.RequiredArgsConstructor;

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