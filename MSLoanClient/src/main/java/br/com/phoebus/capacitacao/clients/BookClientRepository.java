package br.com.phoebus.capacitacao.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("ms-book-client")
public interface BookClientRepository {

	@GetMapping("/books/{id}")
	BookDTO existsByBook(@PathVariable("id") Long id);
	
}
