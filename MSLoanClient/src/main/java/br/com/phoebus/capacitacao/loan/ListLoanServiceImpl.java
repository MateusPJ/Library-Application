package br.com.phoebus.capacitacao.loan;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.phoebus.capacitacao.exception.LoanListIsEmptyException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ListLoanServiceImpl implements ListLoanService {

	private final LoanRepository loanRepository;

	public List<Loan> findAll() throws LoanListIsEmptyException {
		List<Loan> listLoans = loanRepository.findAll();
		if (listLoans.isEmpty()) {
			throw new LoanListIsEmptyException();
		}
		return listLoans;
	}

}