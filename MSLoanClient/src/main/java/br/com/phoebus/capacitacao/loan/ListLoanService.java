package br.com.phoebus.capacitacao.loan;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import br.com.phoebus.capacitacao.exception.LoanListIsEmptyException;

@FunctionalInterface
public interface ListLoanService {

	@GetMapping("/listAllLoans")
	List<Loan> findAll() throws LoanListIsEmptyException;

}