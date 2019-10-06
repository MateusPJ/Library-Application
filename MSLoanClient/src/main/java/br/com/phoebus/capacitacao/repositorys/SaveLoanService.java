package br.com.phoebus.capacitacao.repositorys;

import org.springframework.web.bind.annotation.PostMapping;

import br.com.phoebus.capacitacao.entitys.LoanRequest;
import br.com.phoebus.capacitacao.exception.BookListIsEmptyException;
import br.com.phoebus.capacitacao.exception.BookNotExistException;
import br.com.phoebus.capacitacao.exception.UserNotExistException;

/**
 * 
 * Interface responsável por controlar o serviço de cadastro dos empréstimos.
 * 
 * @author Mateus P Jorge
 *
 */
@FunctionalInterface
public interface SaveLoanService {

	/**
	 * 
	 * Método responsável por realizar todos os cadastros dos empréstimos.
	 * 
	 * @param dto
	 * @return LoanRequest
	 * @throws BookListIsEmptyException
	 * @throws UserNotExistException
	 * @throws BookNotExistException
	 */
	@PostMapping("/createLoan")
	LoanRequest save(LoanRequest dto) throws BookListIsEmptyException, UserNotExistException, BookNotExistException;

}