package br.com.phoebus.capacitacao.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.phoebus.capacitacao.entitys.LoanRequest;
import br.com.phoebus.capacitacao.entitys.LoanResponse;
import br.com.phoebus.capacitacao.exception.BookListIsEmptyException;
import br.com.phoebus.capacitacao.exception.BookNotExistException;
import br.com.phoebus.capacitacao.exception.LoanListIsEmptyException;
import br.com.phoebus.capacitacao.exception.LoanNotExistException;
import br.com.phoebus.capacitacao.exception.UserHasLoansException;
import br.com.phoebus.capacitacao.exception.UserNotExistException;
import br.com.phoebus.capacitacao.repositorys.DeleteLoanService;
import br.com.phoebus.capacitacao.repositorys.ListLoanService;
import br.com.phoebus.capacitacao.repositorys.SaveLoanService;
import br.com.phoebus.capacitacao.repositorys.UpdateLoanService;
import br.com.phoebus.capacitacao.services.Util;
import lombok.RequiredArgsConstructor;

/**
 * 
 * Classe controladora dos servi�os de empr�stimo.
 * 
 * @author Mateus P Jorge
 *
 */
@RestController
@RequestMapping("/loans")
@RequiredArgsConstructor
public class LoanController {

	private final SaveLoanService saveLoanService;
	private final DeleteLoanService deleteLoanService;
	private final ListLoanService listLoanService;
	private final UpdateLoanService updateLoanService;

	/**
	 * 
	 * M�todo respons�vel por realizar o cadastro de empr�stimos.
	 * 
	 * @param dto
	 * @return LoanResponse
	 * @throws BookListIsEmptyException
	 * @throws UserNotExistException
	 * @throws BookNotExistException
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public LoanResponse saveLoan(@RequestBody LoanRequest dto)
			throws BookListIsEmptyException, UserNotExistException, BookNotExistException {
		saveLoanService.save(dto);
		return LoanResponse.requestConverter(dto);
	}

	/**
	 * 
	 * M�todo respons�vel por deletar um empr�stimo.
	 * 
	 * @param id
	 * @throws LoanNotExistException
	 * @throws UserHasLoansException
	 */
	@DeleteMapping(value = "{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void deleteLoan(@PathVariable("id") Long id) throws LoanNotExistException, UserHasLoansException {
		deleteLoanService.delete(id);
	}

	/**
	 * 
	 * M�todo respons�vel por atualizar as informa��es de um empr�stimo cadastrado.
	 * 
	 * @param id
	 * @param dto
	 * @throws BookListIsEmptyException
	 * @throws UserNotExistException
	 * @throws LoanNotExistException
	 * @throws BookNotExistException
	 */
	@PutMapping(value = "{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void updateLoan(@PathVariable("id") Long id, @RequestBody LoanRequest dto)
			throws BookListIsEmptyException, UserNotExistException, LoanNotExistException, BookNotExistException {
		updateLoanService.update(id, dto);
	}

	/**
	 * 
	 * M�todo respons�vel por listar todos empr�stimos cadastrados.
	 * 
	 * @return litsAllLoans
	 * @throws LoanListIsEmptyException
	 */
	@GetMapping
	public List<LoanResponse> listLoans() throws LoanListIsEmptyException {
		return Util.converterLoanListToResponseList(listLoanService.findAll());
	}

}