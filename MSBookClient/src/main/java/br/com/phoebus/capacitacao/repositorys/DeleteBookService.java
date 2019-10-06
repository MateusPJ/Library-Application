package br.com.phoebus.capacitacao.repositorys;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.phoebus.capacitacao.exception.BookNotExistException;

/**
 * 
 * Interface respons�vel por controlar o servi�o de exclus�o dos livros.
 * 
 * @author Mateus P Jorge
 *
 */
@FunctionalInterface
public interface DeleteBookService {

	/**
	 * 
	 * M�todo respons�vel por realizar o delete dos livros.
	 * 
	 * @param id
	 * @throws BookNotExistException
	 */
	@DeleteMapping("/deleteBook/{id}")
	void delete(@PathVariable("id") Long id) throws BookNotExistException;

}