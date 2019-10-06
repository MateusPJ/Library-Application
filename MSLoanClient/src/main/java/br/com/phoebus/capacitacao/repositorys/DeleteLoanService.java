package br.com.phoebus.capacitacao.repositorys;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.phoebus.capacitacao.exception.LoanNotExistException;
import br.com.phoebus.capacitacao.exception.UserHasLoansException;

/**
 * 
 * Interface responsável por controlar o serviço de exclusão dos empréstimos.
 * 
 * @author Mateus P Jorge
 *
 */
@FunctionalInterface
public interface DeleteLoanService {

	/**
	 * 
	 * Método responsável por realizar o delete dos empréstimos.
	 * 
	 * @param id
	 * @throws LoanNotExistException
	 * @throws UserHasLoansException
	 */
	@DeleteMapping("/deleteLoan/{id}")
	void delete(@PathVariable("id") Long id) throws LoanNotExistException, UserHasLoansException;

}