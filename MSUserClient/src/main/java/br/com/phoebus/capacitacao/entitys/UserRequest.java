package br.com.phoebus.capacitacao.entitys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * Classe que representa um objeto para transfer�ncias de dados.
 * 
 * @author Mateus P Jorge
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

	private Long id;

	private String name;

	private int age;

	private String phone;

	/**
	 * 
	 * M�todo de convers�o do DTO para um usu�rio.
	 * 
	 * @param request
	 * @return User
	 */
	public static User to(UserRequest request) {
		return new User(request.getId(), request.getName(), request.getAge(), request.getPhone());
	}

}