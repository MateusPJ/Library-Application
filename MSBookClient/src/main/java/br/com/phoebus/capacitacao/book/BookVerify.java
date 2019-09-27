package br.com.phoebus.capacitacao.book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.phoebus.capacitacao.exception.BookNotExistException;

@FunctionalInterface
public interface BookVerify {

	@GetMapping("/exitsByBook/{id}")
	Book existsByBook(@PathVariable("id") Long id) throws BookNotExistException;

}