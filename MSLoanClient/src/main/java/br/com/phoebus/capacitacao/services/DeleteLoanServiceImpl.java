package br.com.phoebus.capacitacao.services;

import org.springframework.stereotype.Service;

import br.com.phoebus.capacitacao.entitys.Loan;
import br.com.phoebus.capacitacao.exception.LoanNotExistException;
import br.com.phoebus.capacitacao.exception.UserHasLoansException;
import br.com.phoebus.capacitacao.repositorys.DeleteLoanService;
import br.com.phoebus.capacitacao.repositorys.LoanRepository;
import lombok.RequiredArgsConstructor;

/**
 * 
 * Classe responsável por implementar a exclusão de empréstimos.
 * 
 * @author Mateus P Jorge
 *
 */
@Service
@RequiredArgsConstructor
public class DeleteLoanServiceImpl implements DeleteLoanService {

	private final LoanRepository loanRepository;

	public void delete(Long id) throws LoanNotExistException, UserHasLoansException {
		Loan loan = loanRepository.findById(id).orElseThrow(LoanNotExistException::new);
		loanRepository.delete(loan);
	}

}