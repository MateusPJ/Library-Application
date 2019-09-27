package br.com.phoebus.capacitacao.loan;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import br.com.phoebus.capacitacao.clients.BookClientRepository;
import br.com.phoebus.capacitacao.clients.BookDTO;
import br.com.phoebus.capacitacao.clients.UserClientRepository;
import br.com.phoebus.capacitacao.exception.BookListIsEmptyException;
import br.com.phoebus.capacitacao.exception.BookNotExistException;
import br.com.phoebus.capacitacao.exception.LoanNotExistException;
import br.com.phoebus.capacitacao.exception.UserNotExistException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateLoanServiceImpl implements UpdateLoanService {

	private final LoanRepository loanRepository;
	private final UserClientRepository userClient;
	private final BookClientRepository bookClient;

	public LoanRequest update(Long id, LoanRequest dto)
			throws LoanNotExistException, UserNotExistException, BookListIsEmptyException, BookNotExistException {
		if (!loanRepository.findById(id).isPresent()) {
			throw new LoanNotExistException();
		} else if (userClient.existsByUser(dto.getUser().getId()) == null) {
			throw new UserNotExistException();
		} else if (dto.getBooks().isEmpty()) {
			throw new BookListIsEmptyException();
		} else {
			for (BookDTO bookDto : dto.getBooks()) {
				if (bookClient.existsByBook(bookDto.getId()) == null) {
					throw new BookNotExistException();
				}
			}
			dto.setId(id);
			dto.setLoantime(LocalDateTime.now());
			loanRepository.save(Util.converterToLoan(dto));
		}
		return dto;
	}

}