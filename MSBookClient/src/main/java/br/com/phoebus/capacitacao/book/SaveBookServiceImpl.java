package br.com.phoebus.capacitacao.book;

import org.springframework.stereotype.Service;

import br.com.phoebus.capacitacao.exception.BookInvalid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaveBookServiceImpl implements SaveBookService {

	private final BookRepository bookRepository;

	public Book save(BookRequest dto) throws BookInvalid {
		if (dto.getTitle() == null || dto.getTitle().isEmpty()) {
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
			bookRepository.save(BookRequest.to(dto));
		}
		return BookRequest.to(dto);
	}

}