package br.com.phoebus.capacitacao.loan;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.phoebus.capacitacao.clients.BookClientRepository;
import br.com.phoebus.capacitacao.clients.BookDTO;
import br.com.phoebus.capacitacao.clients.UserClientRepository;
import br.com.phoebus.capacitacao.clients.UserDTO;
import br.com.phoebus.capacitacao.exception.BookListIsEmptyException;
import br.com.phoebus.capacitacao.exception.BookNotExistException;
import br.com.phoebus.capacitacao.exception.UserNotExistException;
import lombok.RequiredArgsConstructor;

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