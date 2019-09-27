package br.com.phoebus.capacitacao.book;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import br.com.phoebus.capacitacao.exception.BookListIsEmptyException;

@FunctionalInterface
public interface ListBookService {

	@GetMapping("/listAllBooks")
	List<Book> findAll() throws BookListIsEmptyException;

}