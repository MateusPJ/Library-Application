package br.com.phoebus.capacitacao.loan;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.phoebus.capacitacao.entitys.Loan;
import br.com.phoebus.capacitacao.exception.LoanListIsEmptyException;
import br.com.phoebus.capacitacao.repositorys.ListLoanService;
import br.com.phoebus.capacitacao.repositorys.LoanRepository;
import br.com.phoebus.capacitacao.services.ListLoanServiceImpl;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
@DisplayName("Validation of the save loan method")
class ListLoanServiceTest {

	@Mock
	private LoanRepository loanRepository;

	private ListLoanService listLoanService;
	
	@BeforeEach
	public void setUp() {
		listLoanService = new ListLoanServiceImpl(loanRepository);
	}

	@Test
	@DisplayName("Validate if loan list is null or is Empty")
	public void shouldThrowErrorIfLoanListIsEmpty() {
		Mockito.when(loanRepository.findAll()).thenReturn(new ArrayList<>());
		assertThrows(LoanListIsEmptyException.class, () -> listLoanService.findAll());
	}

	@Test
	@DisplayName("List loans without error")
	public void shouldListAllSuccessfully() throws LoanListIsEmptyException {
		Mockito.when(loanRepository.findAll()).thenReturn(Collections.singletonList(createLoan()));
		listLoanService.findAll();
		Mockito.verify(loanRepository).findAll();
	}
	
	private Loan createLoan() {
		Loan loan = new Loan();
		loan.setId(10L);
		loan.setId(5L);
//		loan.setIdBooks(Arrays.asList(1L, 2L, 3L));
//		loan.setLoanTime(LocalDateTime.now());

		return loan;
	}

}