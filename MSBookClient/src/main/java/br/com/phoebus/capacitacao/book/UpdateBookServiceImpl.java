package br.com.phoebus.capacitacao.book;

import org.springframework.stereotype.Service;

import br.com.phoebus.capacitacao.exception.BookInvalid;
import br.com.phoebus.capacitacao.exception.BookNotExistException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateBookServiceImpl implements UpdateBookService {

	private final BookRepository bookRepository;

	public Book update(Long id, BookRequest dto) throws BookNotExistException, BookInvalid {
		if (!bookRepository.findById(id).isPresent()) {
			throw new BookNotExistException();
		} else if (dto.getTitle() == null || dto.getTitle().isEmpty()) {
			throw new BookInvalid();
		} else if (dto.getAuthor() == null || dto.getAuthor().isEmpty()) {
			throw new BookInvalid();
		} else if (dto.getSummary() == null || dto.getSummary().isEmpty()) {
			throw new BookInvalid();
		} else if (dto.getIsbn() == null || dto.getIsbn().isEmpty()) {
			throw new BookInvalid();
		} else if (dto.getYear() <= 2000) {
			throw new BookInvalid();
		} else {
			dto.setId(id);
			bookRepository.save(BookRequest.to(dto));
		}
		return BookRequest.to(dto);
	}

}