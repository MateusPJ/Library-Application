package br.com.phoebus.capacitacao.repositorys;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.phoebus.capacitacao.exception.LoanNotExistException;
import br.com.phoebus.capacitacao.exception.UserHasLoansException;

/**
 * 
 * Interface respons�vel por controlar o servi�o de exclus�o dos empr�stimos.
 * 
 * @author Mateus P Jorge
 *
 */
@FunctionalInterface
public interface DeleteLoanService {

	/**
	 * 
	 * M�todo respons�vel por realizar o delete dos empr�stimos.
	 * 
	 * @param id
	 * @throws LoanNotExistException
	 * @throws UserHasLoansException
	 */
	@DeleteMapping("/deleteLoan/{id}")
	void delete(@PathVariable("id") Long id) throws LoanNotExistException, UserHasLoansException;

}