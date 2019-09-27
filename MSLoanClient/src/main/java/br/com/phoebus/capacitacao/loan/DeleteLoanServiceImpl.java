package br.com.phoebus.capacitacao.loan;

import org.springframework.stereotype.Service;

import br.com.phoebus.capacitacao.exception.LoanNotExistException;
import br.com.phoebus.capacitacao.exception.UserHasLoansException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteLoanServiceImpl implements DeleteLoanService {

	private final LoanRepository loanRepository;

	public void delete(Long id) throws LoanNotExistException, UserHasLoansException {
		Loan loan = loanRepository.findById(id).orElseThrow(LoanNotExistException::new);
		loanRepository.delete(loan);
	}

}