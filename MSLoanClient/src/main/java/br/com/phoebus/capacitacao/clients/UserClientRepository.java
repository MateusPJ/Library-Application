package br.com.phoebus.capacitacao.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("ms-user-client")
public interface UserClientRepository {

	@GetMapping("/users/{id}")
	UserDTO existsByUser(@PathVariable("id") Long id);
	
}