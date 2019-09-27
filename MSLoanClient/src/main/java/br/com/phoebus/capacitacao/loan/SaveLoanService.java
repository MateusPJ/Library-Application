package br.com.phoebus.capacitacao.loan;

import org.springframework.web.bind.annotation.PostMapping;

import br.com.phoebus.capacitacao.exception.BookListIsEmptyException;
import br.com.phoebus.capacitacao.exception.BookNotExistException;
import br.com.phoebus.capacitacao.exception.UserNotExistException;

@FunctionalInterface
public interface SaveLoanService {

	@PostMapping("/createLoan")
	LoanRequest save(LoanRequest dto) throws BookListIsEmptyException, UserNotExistException, BookNotExistException;

}