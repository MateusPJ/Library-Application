package br.com.phoebus.capacitacao.book;

import org.springframework.web.bind.annotation.PutMapping;

import br.com.phoebus.capacitacao.exception.BookInvalid;
import br.com.phoebus.capacitacao.exception.BookNotExistException;

@FunctionalInterface
public interface UpdateBookService {

	@PutMapping("/updateBook")
	Book update(Long id, BookRequest dto) throws BookNotExistException, BookInvalid;

}