package br.com.phoebus.capacitacao.book;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.phoebus.capacitacao.exception.BookListIsEmptyException;
import lombok.RequiredArgsConstructor;

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