package br.com.phoebus.capacitacao.book;

import org.springframework.stereotype.Service;

import br.com.phoebus.capacitacao.exception.BookNotExistException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DeleteBookServiceImpl implements DeleteBookService {

	private BookRepository bookRepository;

	public void delete(Long id) throws BookNotExistException {
		Book book = bookRepository.findById(id).orElseThrow(BookNotExistException::new);
		bookRepository.delete(book);
	}

}