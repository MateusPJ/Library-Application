package br.com.phoebus.capacitacao.book;

import org.springframework.web.bind.annotation.PostMapping;

import br.com.phoebus.capacitacao.exception.BookInvalid;

@FunctionalInterface
public interface SaveBookService {

	@PostMapping("/createBook")
	Book save(BookRequest dto) throws BookInvalid;

}