package br.com.phoebus.capacitacao.repositorys;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.phoebus.capacitacao.exception.BookNotExistException;

/**
 * 
 * Interface responsável por controlar o serviço de exclusão dos livros.
 * 
 * @author Mateus P Jorge
 *
 */
@FunctionalInterface
public interface DeleteBookService {

	/**
	 * 
	 * Método responsável por realizar o delete dos livros.
	 * 
	 * @param id
	 * @throws BookNotExistException
	 */
	@DeleteMapping("/deleteBook/{id}")
	void delete(@PathVariable("id") Long id) throws BookNotExistException;

}