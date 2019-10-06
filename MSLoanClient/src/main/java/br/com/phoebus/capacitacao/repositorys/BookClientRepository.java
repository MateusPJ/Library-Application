package br.com.phoebus.capacitacao.repositorys;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.phoebus.capacitacao.entitys.BookDTO;

/**
 * 
 * Interface que realiza a comunicação com o controller dos livros.
 * 
 * @author Mateus P Jorge
 *
 */
@FeignClient("ms-book-client")
public interface BookClientRepository {

	/**
	 * 
	 * Método que referência uma porta no controller dos livros.
	 * 
	 * @param id
	 * @return BookDTO
	 */
	@GetMapping("/books/{id}")
	BookDTO existsByBook(@PathVariable("id") Long id);
	
}
