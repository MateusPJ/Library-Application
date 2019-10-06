package br.com.phoebus.capacitacao.repositorys;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.phoebus.capacitacao.entitys.UserDTO;

/**
 * 
 * Interface que realiza a comunica��o com o controller dos usu�rios.
 * 
 * @author Mateus P Jorge
 *
 */
@FeignClient("ms-user-client")
public interface UserClientRepository {

	/**
	 * 
	 * M�todo que refer�ncia uma porta no controller dos usu�rios.
	 * 
	 * @param id
	 * @return UserDTO
	 */
	@GetMapping("/users/{id}")
	UserDTO existsByUser(@PathVariable("id") Long id);
	
}