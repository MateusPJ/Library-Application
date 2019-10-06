package br.com.phoebus.capacitacao.repositorys;

import org.springframework.web.bind.annotation.PostMapping;

import br.com.phoebus.capacitacao.entitys.Book;
import br.com.phoebus.capacitacao.entitys.BookRequest;
import br.com.phoebus.capacitacao.exception.BookInvalid;

/**
 * 
 * Interface respons�vel por controlar o servi�o de cadastro dos livros.
 * 
 * @author Mateus P Jorge
 *
 */
@FunctionalInterface
public interface SaveBookService {

	/**
	 * 
	 * M�todo respons�vel por realizar todos os cadastros de livro.
	 * 
	 * @param dto
	 * @return Book
	 * @throws BookInvalid
	 */
	@PostMapping("/createBook")
	Book save(BookRequest dto) throws BookInvalid;

}