package br.com.phoebus.capacitacao.repositorys;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import br.com.phoebus.capacitacao.entitys.Book;
import br.com.phoebus.capacitacao.exception.BookListIsEmptyException;

/**
 * 
 * Interface respons�vel por controlar o servi�o de listagem dos livros.
 * 
 * @author Mateus P Jorge
 *
 */
@FunctionalInterface
public interface ListBookService {

	/**
	 * 
	 * M�todo respons�vel por listar todos os livros cadastrados.
	 * 
	 * @return listAllBooks
	 * @throws BookListIsEmptyException
	 */
	@GetMapping("/listAllBooks")
	List<Book> findAll() throws BookListIsEmptyException;

}