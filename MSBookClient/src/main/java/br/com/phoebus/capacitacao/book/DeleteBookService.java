package br.com.phoebus.capacitacao.book;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.phoebus.capacitacao.exception.BookNotExistException;

@FunctionalInterface
public interface DeleteBookService {

	@DeleteMapping("/deleteBook/{id}")
	void delete(@PathVariable("id") Long id) throws BookNotExistException;

}