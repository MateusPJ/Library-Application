package br.com.phoebus.capacitacao.repositorys;

import org.springframework.web.bind.annotation.PutMapping;

import br.com.phoebus.capacitacao.entitys.LoanRequest;
import br.com.phoebus.capacitacao.exception.BookListIsEmptyException;
import br.com.phoebus.capacitacao.exception.BookNotExistException;
import br.com.phoebus.capacitacao.exception.LoanNotExistException;
import br.com.phoebus.capacitacao.exception.UserNotExistException;

/**
 * 
 * Interface respons�vel por controlar o servi�o de atualiza��o dos empr�stimos.
 * 
 * @author Mateus P Jorge
 *
 */
@FunctionalInterface
public interface UpdateLoanService {

	/**
	 * 
	 * M�todo respons�vel por realizar todas as atualiza��es dos empr�stimos.
	 * 
	 * @param id
	 * @param dto
	 * @return
	 * @throws LoanNotExistException
	 * @throws UserNotExistException
	 * @throws BookListIsEmptyException
	 * @throws BookNotExistException
	 */
	@PutMapping("/updateLoan")
	LoanRequest update(Long id, LoanRequest dto)
			throws LoanNotExistException, UserNotExistException, BookListIsEmptyException, BookNotExistException;

}