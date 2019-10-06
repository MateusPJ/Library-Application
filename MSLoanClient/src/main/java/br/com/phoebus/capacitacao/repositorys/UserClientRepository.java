package br.com.phoebus.capacitacao.repositorys;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.phoebus.capacitacao.entitys.UserDTO;

/**
 * 
 * Interface que realiza a comunicação com o controller dos usuários.
 * 
 * @author Mateus P Jorge
 *
 */
@FeignClient("ms-user-client")
public interface UserClientRepository {

	/**
	 * 
	 * Método que referência uma porta no controller dos usuários.
	 * 
	 * @param id
	 * @return UserDTO
	 */
	@GetMapping("/users/{id}")
	UserDTO existsByUser(@PathVariable("id") Long id);
	
}