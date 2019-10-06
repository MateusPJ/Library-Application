package br.com.phoebus.capacitacao.repositorys;

import org.springframework.web.bind.annotation.PutMapping;

import br.com.phoebus.capacitacao.entitys.Book;
import br.com.phoebus.capacitacao.entitys.BookRequest;
import br.com.phoebus.capacitacao.exception.BookInvalid;
import br.com.phoebus.capacitacao.exception.BookNotExistException;

/**
 * 
 * Interface respons�vel por controlar o servi�o de atualiza��o dos livros.
 * 
 * @author Mateus P Jorge
 *
 */
@FunctionalInterface
public interface UpdateBookService {

	/**
	 * 
	 * M�todo respons�vel por realizar todas as atualiza��es do livro.
	 * 
	 * @param id
	 * @param dto
	 * @return
	 * @throws BookNotExistException
	 * @throws BookInvalid
	 */
	@PutMapping("/updateBook")
	Book update(Long id, BookRequest dto) throws BookNotExistException, BookInvalid;

}