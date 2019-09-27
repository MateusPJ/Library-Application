package br.com.phoebus.capacitacao.user;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.phoebus.capacitacao.exception.UserListIsEmptyException;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
@DisplayName("Validation of the method listing users")
class ListUserServiceTest {

	@Mock
	private UserRepository userRepository;

	private ListUserService listUserService;

	@BeforeEach
	public void setUp() {
		listUserService = new ListUserServiceImpl(userRepository);
	}

	@Test
	@DisplayName("Validates if list users is empty")
	public void shouldThrowErrorIfUserListIsNull() {
		List<User> users = new ArrayList<>();
		Mockito.when(userRepository.findAll()).thenReturn(users);
		assertThrows(UserListIsEmptyException.class, () -> listUserService.findAll());
	}

	@Test
	@DisplayName("List users without error")
	public void shouldListAllSuccessfully() throws UserListIsEmptyException {
		List<User> users = new ArrayList<>();
		users.add(createUser());
		Mockito.when(userRepository.findAll()).thenReturn(users);
		listUserService.findAll();
		Mockito.verify(userRepository).findAll();
	}

	private User createUser() {
		User user = new User();
		user.setName("Mateus P Jorge");
		user.setPhone("99988-7766");
		user.setAge(19);

		return user;
	}

}