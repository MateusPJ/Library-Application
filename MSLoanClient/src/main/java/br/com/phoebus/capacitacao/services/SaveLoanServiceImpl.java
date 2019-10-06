package br.com.phoebus.capacitacao.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.phoebus.capacitacao.entitys.BookDTO;
import br.com.phoebus.capacitacao.entitys.LoanRequest;
import br.com.phoebus.capacitacao.entitys.UserDTO;
import br.com.phoebus.capacitacao.exception.BookListIsEmptyException;
import br.com.phoebus.capacitacao.exception.BookNotExistException;
import br.com.phoebus.capacitacao.exception.UserNotExistException;
import br.com.phoebus.capacitacao.repositorys.BookClientRepository;
import br.com.phoebus.capacitacao.repositorys.LoanRepository;
import br.com.phoebus.capacitacao.repositorys.SaveLoanService;
import br.com.phoebus.capacitacao.repositorys.UserClientRepository;
import lombok.RequiredArgsConstructor;

/**
 * 
 * Classe responsável por realizar o tratamento de cadastro de empréstimos.
 * 
 * @author Mateus P Jorge
 *
 */
@Service
@RequiredArgsConstructor
public class SaveLoanServiceImpl implements SaveLoanService {

	private final LoanRepository loanRepository;
	private final UserClientRepository userClient;
	private final BookClientRepository bookClient;

	public LoanRequest save(LoanRequest dto) throws BookListIsEmptyException, UserNotExistException, BookNotExistException {
		UserDTO user = userClient.existsByUser(dto.getUser().getId());
		List<BookDTO> books = new ArrayList<>();
		if (user == null) {
			throw new UserNotExistException();
		} else if (dto.getBooks().isEmpty() || dto.getBooks() == null) {
			throw new BookListIsEmptyException();
		} else {
			for (BookDTO book : dto.getBooks()) {
				if (bookClient.existsByBook(book.getId()) == null) {
					throw new BookNotExistException();
				} else {
					BookDTO bookdto = bookClient.existsByBook(book.getId());
					books.add(bookdto);
				}
			}
			dto.setUser(user);
			dto.setBooks(books);
			dto.setLoantime(LocalDateTime.now());
			loanRepository.save(Util.converterToLoan(dto));
		}
		return dto;
	}

}