package br.com.phoebus.capacitacao.services;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import br.com.phoebus.capacitacao.entitys.BookDTO;
import br.com.phoebus.capacitacao.entitys.LoanRequest;
import br.com.phoebus.capacitacao.exception.BookListIsEmptyException;
import br.com.phoebus.capacitacao.exception.BookNotExistException;
import br.com.phoebus.capacitacao.exception.LoanNotExistException;
import br.com.phoebus.capacitacao.exception.UserNotExistException;
import br.com.phoebus.capacitacao.repositorys.BookClientRepository;
import br.com.phoebus.capacitacao.repositorys.LoanRepository;
import br.com.phoebus.capacitacao.repositorys.UpdateLoanService;
import br.com.phoebus.capacitacao.repositorys.UserClientRepository;
import lombok.RequiredArgsConstructor;

/**
 * 
 * Classe responsável por realizar o tratamento das atualizações de empréstimo.
 * 
 * @author Mateus P Jorge
 *
 */
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