package br.com.phoebus.capacitacao.book;

import org.springframework.stereotype.Service;

import br.com.phoebus.capacitacao.exception.BookNotExistException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookVerifyImpl implements BookVerify {

	private final BookRepository bookRepository;

	public Book existsByBook(Long id) throws BookNotExistException {
		return bookRepository.findById(id).orElseThrow(BookNotExistException::new);
	}

}