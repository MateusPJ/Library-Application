package br.com.phoebus.capacitacao.user;

import static org.junit.jupiter.api.Assertions.assertThrows;

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

import br.com.phoebus.capacitacao.entitys.User;
import br.com.phoebus.capacitacao.entitys.UserRequest;
import br.com.phoebus.capacitacao.exception.UserInvalid;
import br.com.phoebus.capacitacao.repositorys.SaveUserService;
import br.com.phoebus.capacitacao.repositorys.UserRepository;
import br.com.phoebus.capacitacao.services.SaveUserServiceImpl;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@DisplayName("Validation of the save user method")
class SaveUserServiceTest {

	@Mock
	private UserRepository userRepository;

	private SaveUserService saveUserService;

	@BeforeEach
	public void setUp() {
		saveUserService = new SaveUserServiceImpl(userRepository);
	}

	@Test
	@DisplayName("Save user without error")
	public void shouldSaveSuccessfully() throws UserInvalid {
		Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(UserRequest.to(createUser()));
		saveUserService.save(createUser());
		Mockito.verify(userRepository).save(Mockito.any(User.class));
	}

	@Test
	@DisplayName("Validate if all fields have been filled")
	public void shouldThrowErrorIfAnyFieldsAreMissing() {
		UserRequest user = new UserRequest();
		user.setName("Mateus P Jorge");
		user.setPhone("99988-7766");
		user.setAge(17);
		Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(UserRequest.to(user));
		assertThrows(UserInvalid.class, () -> saveUserService.save(user));
	}

	private UserRequest createUser() {
		UserRequest user = new UserRequest();
		user.setName("Mateus P Jorge");
		user.setPhone("99988-7766");
		user.setAge(19);

		return user;
	}

}