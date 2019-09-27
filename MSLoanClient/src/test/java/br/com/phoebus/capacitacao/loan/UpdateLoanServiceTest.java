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

import br.com.phoebus.capacitacao.clients.UserClientRepository;
import br.com.phoebus.capacitacao.exception.BookListIsEmptyException;
import br.com.phoebus.capacitacao.exception.LoanNotExistException;
import br.com.phoebus.capacitacao.exception.UserNotExistException;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@DisplayName("Validation of the save loan method")
class UpdateLoanServiceTest {

	@Mock
	private LoanRepository loanRepository;

	@Mock
	private UserClientRepository userClient;

	private UpdateLoanService updateLoanService;

	@BeforeEach
	public void setUp() {
//		updateLoanService = new UpdateLoanServiceImpl(loanRepository, userClient);
	}

	@Test
	@DisplayName("Validate if the loan id exists")
	public void shouldThrowErrorIfLoanIdNotFound() {
		Mockito.when(loanRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
		assertThrows(LoanNotExistException.class, () -> updateLoanService.update(1L, createLoanRequest()));
	}

	@Test
	@DisplayName("Validate if the loan user exists")
	public void shouldThrowErrorIfLoanUserNotFound() {
//		Mockito.when(loanRepository.findById(Mockito.anyLong()))
//				.thenReturn(Optional.of(LoanRequest.to(createLoanRequest())));
//		Mockito.when(userClient.existsByUser(Mockito.anyLong())).thenReturn(false);
		assertThrows(UserNotExistException.class, () -> updateLoanService.update(1L, createLoanRequest()));
	}

	@Test
	@DisplayName("Update loan without error")
	public void shouldUpdateLoan() throws UserNotExistException, BookListIsEmptyException, LoanNotExistException {
//		Mockito.when(loanRepository.findById(Mockito.anyLong()))
//				.thenReturn(Optional.of(LoanRequest.to(createLoanRequest())));
//		Mockito.when(userClient.existsByUser(Mockito.anyLong())).thenReturn(true);
//		Mockito.when(loanRepository.save(Mockito.any(Loan.class))).thenReturn(LoanRequest.to(createLoanRequest()));
//		updateLoanService.update(1L,createLoanRequest());
		Mockito.verify(loanRepository).save(Mockito.any(Loan.class));
	}

	private LoanRequest createLoanRequest() {
		List<Long> books = new ArrayList<>();
		books.add(1L);
		books.add(2L);
		books.add(3L);
		LoanRequest loan = new LoanRequest();
		loan.setId(1L);
//		loan.setIdUserDto(5L);
//		loan.setIdBooksDto(books);
//		loan.setLoanTime(LocalDateTime.now());

		return loan;
	}
}