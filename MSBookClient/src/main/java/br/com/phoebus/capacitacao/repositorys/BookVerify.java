package br.com.phoebus.capacitacao.repositorys;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.phoebus.capacitacao.entitys.Book;
import br.com.phoebus.capacitacao.exception.BookNotExistException;

/**
 * 
 * Interface respons�vel por buscar livros cadastrados.
 * 
 * @author Mateus P Jorge
 *
 */
@FunctionalInterface
public interface BookVerify {

	/**
	 * 
	 * M�todo respons�vel por buscar um livro cadastrado.
	 * 
	 * @param id
	 * @return Book
	 * @throws BookNotExistException
	 */
	@GetMapping("/exitsByBook/{id}")
	Book existsByBook(@PathVariable("id") Long id) throws BookNotExistException;

}