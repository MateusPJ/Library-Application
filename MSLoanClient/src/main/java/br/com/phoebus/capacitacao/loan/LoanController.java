package br.com.phoebus.capacitacao.loan;

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

import br.com.phoebus.capacitacao.exception.BookListIsEmptyException;
import br.com.phoebus.capacitacao.exception.BookNotExistException;
import br.com.phoebus.capacitacao.exception.LoanListIsEmptyException;
import br.com.phoebus.capacitacao.exception.LoanNotExistException;
import br.com.phoebus.capacitacao.exception.UserHasLoansException;
import br.com.phoebus.capacitacao.exception.UserNotExistException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/loans")
@RequiredArgsConstructor
public class LoanController {

	private final SaveLoanService saveLoanService;
	private final DeleteLoanService deleteLoanService;
	private final ListLoanService listLoanService;
	private final UpdateLoanService updateLoanService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public LoanResponse saveLoan(@RequestBody LoanRequest dto)
			throws BookListIsEmptyException, UserNotExistException, BookNotExistException {
		saveLoanService.save(dto);
		return LoanResponse.requestConverter(dto);
	}

	@DeleteMapping(value = "{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void deleteLoan(@PathVariable("id") Long id) throws LoanNotExistException, UserHasLoansException {
		deleteLoanService.delete(id);
	}

	@PutMapping(value = "{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void updateLoan(@PathVariable("id") Long id, @RequestBody LoanRequest dto)
			throws BookListIsEmptyException, UserNotExistException, LoanNotExistException, BookNotExistException {
		updateLoanService.update(id, dto);
	}
	//ERRO AO RETORNAR COMO RESPONSE
	@GetMapping
	public List<LoanResponse> listLoans() throws LoanListIsEmptyException {
		return Util.converterLoanListToResponseList(listLoanService.findAll());
	}

}