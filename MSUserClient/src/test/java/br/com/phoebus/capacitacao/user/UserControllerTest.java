package br.com.phoebus.capacitacao.user;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.phoebus.capacitacao.controller.UserController;
import br.com.phoebus.capacitacao.entitys.User;
import br.com.phoebus.capacitacao.entitys.UserRequest;
import br.com.phoebus.capacitacao.exception.ErrorConvertingObjectException;
import br.com.phoebus.capacitacao.repositorys.DeleteUserService;
import br.com.phoebus.capacitacao.repositorys.ListUserService;
import br.com.phoebus.capacitacao.repositorys.SaveUserService;
import br.com.phoebus.capacitacao.repositorys.UpdateUserService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
@DisplayName("User controller validation call methods")
class UserControllerTest {

	@Autowired
	protected MockMvc mockMvc;

	@MockBean
	private DeleteUserService deleteUserService;

	@MockBean
	private SaveUserService saveUserService;

	@MockBean
	private ListUserService listUserService;

	@MockBean
	private UpdateUserService updateUserService;

	@Test
	@DisplayName("Save user without error")
	public void testPostSaveUserWithoutError() throws Exception {
		UserRequest ur = createUserRequest();
		User expectedUser = UserRequest.to(ur);
		Mockito.when(saveUserService.save(Mockito.any(UserRequest.class))).thenReturn(expectedUser);
		mockMvc.perform(post("/users").content(asJsonString(ur)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").doesNotExist())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value(expectedUser.getName()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.age").value(expectedUser.getAge()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.phone").doesNotExist());
	}

	@Test
	@DisplayName("Delete user without error")
	public void testDeleteUsersWithoutError() throws Exception {
		doNothing().when(deleteUserService).delete(anyLong());
		mockMvc.perform(delete("/users/{id}", 1L).contentType(MediaType.ALL_VALUE)).andExpect(status().isAccepted());
	}

	@Test
	@DisplayName("Update user without error")
	public void testPutUpdateUserWithoutError() throws Exception {
		UserRequest ur = createUserRequest();
		User expectedUser = UserRequest.to(ur);
		Mockito.when(updateUserService.update(anyLong(), Mockito.any(UserRequest.class))).thenReturn(expectedUser);
		mockMvc.perform(put("/users").content(asJsonString(ur)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isAccepted());
	}

	@Test
	@DisplayName("List users without error")
	public void testGetListUsersWithoutError() throws Exception {
		List<User> users = new ArrayList<>();
		UserRequest ur = createUserRequest();
		users.add(UserRequest.to(ur));
		when(listUserService.findAll()).thenReturn(users);
		mockMvc.perform(get("/users").content(asJsonString(users)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1L))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Mateus P Jorge"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].age").value(19))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].phone").value("99988-7766"));
	}

	private UserRequest createUserRequest() {
		UserRequest user = new UserRequest();
		user.setId(1L);
		user.setName("Mateus P Jorge");
		user.setAge(19);
		user.setPhone("99988-7766");
		return user;
	}

	public static String asJsonString(final Object obj) throws ErrorConvertingObjectException {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new ErrorConvertingObjectException();
		}
	}

}