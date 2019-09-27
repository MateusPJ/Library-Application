package br.com.phoebus.capacitacao.user;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import br.com.phoebus.capacitacao.exception.UserInvalid;
import br.com.phoebus.capacitacao.exception.UserNotExistException;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@DisplayName("Validation of the update user method")
class UpdateUserServiceTest {

	@Mock
	private UserRepository userRepository;

	private UpdateUserService updateUserService;

	@BeforeEach
	public void setUp() {
		updateUserService = new UpdateUserServiceImpl(userRepository);
	}

	@Test
	@DisplayName("Update user without error")
	public void shouldUpdateIfUserExists() throws UserNotExistException, UserInvalid {
		Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(UserRequest.to(createUser())));
		Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(UserRequest.to(createUser()));
		updateUserService.update(1L, createUser());
		Mockito.verify(userRepository).save(Mockito.any(User.class));
	}

	@Test
	@DisplayName("Validate if user id exists")
	public void shouldThrowErrorIfBookIdNotFound() {
		Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
		assertThrows(UserNotExistException.class, () -> updateUserService.update(1L, createUser()));
	}

	@Test
	@DisplayName("Validate if all fields have been filled")
	public void shouldThrowErrorIfAnyFieldsAreMissing() {
		UserRequest user = new UserRequest();
		user.setId(1L);
		user.setName("Mateus P Jorge");
		user.setPhone("99988-7766");
		user.setAge(17);
		Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(UserRequest.to(user)));
		Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(UserRequest.to(user));
		assertThrows(UserInvalid.class, () -> updateUserService.update(1L, user));
	}

	private UserRequest createUser() {
		UserRequest user = new UserRequest();
		user.setId(1L);
		user.setName("Mateus P Jorge");
		user.setPhone("99988-7766");
		user.setAge(19);

		return user;
	}

}