package br.com.phoebus.capacitacao.services;

import org.springframework.stereotype.Service;

import br.com.phoebus.capacitacao.entitys.Book;
import br.com.phoebus.capacitacao.exception.BookNotExistException;
import br.com.phoebus.capacitacao.repositorys.BookRepository;
import br.com.phoebus.capacitacao.repositorys.DeleteBookService;
import lombok.AllArgsConstructor;

/**
 * 
 * Classe responsável por implementar a exclusão dos livros.
 * 
 * @author Mateus P Jorge
 *
 */
@Service
@AllArgsConstructor
public class DeleteBookServiceImpl implements DeleteBookService {

	private BookRepository bookRepository;

	public void delete(Long id) throws BookNotExistException {
		Book book = bookRepository.findById(id).orElseThrow(BookNotExistException::new);
		bookRepository.delete(book);
	}

}