package br.com.phoebus.capacitacao.user;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserResponse {

	private String name;

	private int age;

	public static UserResponse requestConverter(User user) {
		return new UserResponse(user.getName(), user.getAge());
	}

}