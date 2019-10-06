package br.com.phoebus.capacitacao.repositorys;

import org.springframework.web.bind.annotation.PutMapping;

import br.com.phoebus.capacitacao.entitys.LoanRequest;
import br.com.phoebus.capacitacao.exception.BookListIsEmptyException;
import br.com.phoebus.capacitacao.exception.BookNotExistException;
import br.com.phoebus.capacitacao.exception.LoanNotExistException;
import br.com.phoebus.capacitacao.exception.UserNotExistException;

/**
 * 
 * Interface responsável por controlar o serviço de atualização dos empréstimos.
 * 
 * @author Mateus P Jorge
 *
 */
@FunctionalInterface
public interface UpdateLoanService {

	/**
	 * 
	 * Método responsável por realizar todas as atualizações dos empréstimos.
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