package br.com.phoebus.capacitacao.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.phoebus.capacitacao.entitys.Book;
import br.com.phoebus.capacitacao.exception.BookListIsEmptyException;
import br.com.phoebus.capacitacao.repositorys.BookRepository;
import br.com.phoebus.capacitacao.repositorys.ListBookService;
import lombok.RequiredArgsConstructor;

/**
 * 
 * Método responsável por retornar todos os livros cadastrados.
 * 
 * @author Mateus P Jorge
 *
 */
@Service
@RequiredArgsConstructor
public class ListBookServiceImpl implements ListBookService {

	private final BookRepository bookRepository;

	public List<Book> findAll() throws BookListIsEmptyException {
		List<Book> listBooks = bookRepository.findAll();
		if (listBooks.isEmpty()) {
			throw new BookListIsEmptyException();
		}
		return listBooks;
	}

}