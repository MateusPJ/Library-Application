package br.com.phoebus.capacitacao.loan;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import br.com.phoebus.capacitacao.exception.LoanNotExistException;
import br.com.phoebus.capacitacao.exception.UserHasLoansException;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@DisplayName("Validation of the delete loan method")
class DeleteLoanServiceTest {

	@Mock
	private LoanRepository loanRepository;

	private DeleteLoanService deleteLoanService;

	@BeforeEach
	public void setUp() {
		deleteLoanService = new DeleteLoanServiceImpl(loanRepository);
	}

	@Test
	@DisplayName("Validate if loan exists")
	public void shouldThrowErrorIfLoanNotExist() {
		Mockito.when(loanRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
		assertThrows(LoanNotExistException.class, () -> deleteLoanService.delete(1L));
	}

	@Test
	@DisplayName("Validate if loan user exist")
	public void shouldThrowErrorIfLoanUserNotExist() {
		Mockito.when(loanRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(createLoan()));
//		Mockito.when(loanRepository.existsUserIdInLoan(Mockito.anyLong())).thenReturn(true);
		assertThrows(UserHasLoansException.class, () -> deleteLoanService.delete(1L));
	}

	@Test
	@DisplayName("Delete loan without error")
	public void shouldDeletedSuccessfully() throws LoanNotExistException, UserHasLoansException {
		Mockito.when(loanRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(createLoan()));
//		Mockito.when(loanRepository.existsUserIdInLoan(Mockito.anyLong())).thenReturn(false);
		deleteLoanService.delete(1L);
		Mockito.verify(loanRepository).delete(Mockito.any(Loan.class));
	}

	private Loan createLoan() {
		List<Long> books = new ArrayList<>();
		books.add(1L);
		books.add(2L);
		books.add(3L);
		Loan loan = new Loan();
		loan.setId(10L);
//		loan.setIdUser(5L);
//		loan.setIdBooks(books);
//		loan.setLoanTime(LocalDateTime.now());

		return loan;
	}

}