package br.com.phoebus.capacitacao.entitys;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * Classe que representa uma resposta para as requisições do controller.
 * 
 * @author Mateus P Jorge
 *
 */
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserResponse {

	private String name;

	private int age;

	/**
	 * 
	 * Método de conversão para responder as requisições.
	 * 
	 * @param user
	 * @return UserResponse
	 */
	public static UserResponse requestConverter(User user) {
		return new UserResponse(user.getName(), user.getAge());
	}

}