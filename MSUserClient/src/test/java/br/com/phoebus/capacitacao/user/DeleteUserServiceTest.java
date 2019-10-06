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

import br.com.phoebus.capacitacao.entitys.User;
import br.com.phoebus.capacitacao.exception.UserNotExistException;
import br.com.phoebus.capacitacao.repositorys.DeleteUserService;
import br.com.phoebus.capacitacao.repositorys.UserRepository;
import br.com.phoebus.capacitacao.services.DeleteUserServiceImpl;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@DisplayName("Validation of the delete user method")
public class DeleteUserServiceTest {

	@Mock
	private UserRepository userRepository;

	private DeleteUserService deleteUserService;

	@BeforeEach
	public void setUp() {
		deleteUserService = new DeleteUserServiceImpl(userRepository);
	}

	@Test
	@DisplayName("Validate if user exists")
	public void shouldThrowErrorIfUserNotExists() {
		Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
		assertThrows(UserNotExistException.class, () -> deleteUserService.delete(1L));
	}

	@Test
	@DisplayName("Delete user without error")
	public void shouldDeletedSuccessFully() throws UserNotExistException {
		Mockito.when(userRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(createUser()));
		deleteUserService.delete(1L);
		Mockito.verify(userRepository).delete(Mockito.any(User.class));
	}

	private User createUser() {
		User user = new User();
		user.setId(1L);
		user.setName("Mateus P Jorge");
		user.setPhone("99988-7766");
		user.setAge(19);

		return user;
	}

}