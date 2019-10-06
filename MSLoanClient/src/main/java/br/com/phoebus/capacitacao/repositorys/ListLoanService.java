package br.com.phoebus.capacitacao.repositorys;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import br.com.phoebus.capacitacao.entitys.Loan;
import br.com.phoebus.capacitacao.exception.LoanListIsEmptyException;

/**
 * 
 * Interface respons�vel por controlar o servi�o de listagem dos empr�stimos.
 * 
 * @author Mateus P Jorge
 *
 */
@FunctionalInterface
public interface ListLoanService {

	/**
	 * 
	 * M�todo respons�vel por listar todos os empr�stimos cadastrados.
	 * 
	 * @return listAllLoans
	 * @throws LoanListIsEmptyException
	 */
	@GetMapping("/listAllLoans")
	List<Loan> findAll() throws LoanListIsEmptyException;

}