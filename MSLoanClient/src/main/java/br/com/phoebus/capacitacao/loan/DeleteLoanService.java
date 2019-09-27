package br.com.phoebus.capacitacao.loan;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.phoebus.capacitacao.exception.LoanNotExistException;
import br.com.phoebus.capacitacao.exception.UserHasLoansException;

@FunctionalInterface
public interface DeleteLoanService {

	@DeleteMapping("/deleteLoan/{id}")
	void delete(@PathVariable("id") Long id) throws LoanNotExistException, UserHasLoansException;

}