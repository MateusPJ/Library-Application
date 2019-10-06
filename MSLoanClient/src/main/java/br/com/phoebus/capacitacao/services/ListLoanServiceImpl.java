package br.com.phoebus.capacitacao.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.phoebus.capacitacao.entitys.Loan;
import br.com.phoebus.capacitacao.exception.LoanListIsEmptyException;
import br.com.phoebus.capacitacao.repositorys.ListLoanService;
import br.com.phoebus.capacitacao.repositorys.LoanRepository;
import lombok.RequiredArgsConstructor;

/**
 * 
 * Classe responsável por retornar todos os empréstimos cadastrados.
 * 
 * @author Mateus P Jorge
 *
 */
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