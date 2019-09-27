package br.com.phoebus.capacitacao.loan;

import org.springframework.web.bind.annotation.PutMapping;

import br.com.phoebus.capacitacao.exception.BookListIsEmptyException;
import br.com.phoebus.capacitacao.exception.BookNotExistException;
import br.com.phoebus.capacitacao.exception.LoanNotExistException;
import br.com.phoebus.capacitacao.exception.UserNotExistException;

@FunctionalInterface
public interface UpdateLoanService {

	@PutMapping("/updateLoan")
	LoanRequest update(Long id, LoanRequest dto)
			throws LoanNotExistException, UserNotExistException, BookListIsEmptyException, BookNotExistException;

}