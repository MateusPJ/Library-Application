package br.com.phoebus.capacitacao.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

	private Long id;

	private String name;

	private int age;

	private String phone;

	public static User to(UserRequest request) {
		return new User(request.getId(), request.getName(), request.getAge(), request.getPhone());
	}

}