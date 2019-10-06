package br.com.phoebus.capacitacao.services;

import org.springframework.stereotype.Service;

import br.com.phoebus.capacitacao.entitys.Book;
import br.com.phoebus.capacitacao.entitys.BookRequest;
import br.com.phoebus.capacitacao.exception.BookInvalid;
import br.com.phoebus.capacitacao.repositorys.BookRepository;
import br.com.phoebus.capacitacao.repositorys.SaveBookService;
import lombok.RequiredArgsConstructor;

/**
 * 
 * Classe responsável por realizar o tratamento do cadastro dos livros.
 * 
 * @author Mateus P Jorge
 *
 */
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