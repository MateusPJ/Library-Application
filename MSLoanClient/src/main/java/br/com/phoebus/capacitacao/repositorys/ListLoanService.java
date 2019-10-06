package br.com.phoebus.capacitacao.repositorys;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import br.com.phoebus.capacitacao.entitys.Loan;
import br.com.phoebus.capacitacao.exception.LoanListIsEmptyException;

/**
 * 
 * Interface responsável por controlar o serviço de listagem dos empréstimos.
 * 
 * @author Mateus P Jorge
 *
 */
@FunctionalInterface
public interface ListLoanService {

	/**
	 * 
	 * Método responsável por listar todos os empréstimos cadastrados.
	 * 
	 * @return listAllLoans
	 * @throws LoanListIsEmptyException
	 */
	@GetMapping("/listAllLoans")
	List<Loan> findAll() throws LoanListIsEmptyException;

}