package br.com.phoebus.capacitacao.loan;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

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

import br.com.phoebus.capacitacao.entitys.Loan;
import br.com.phoebus.capacitacao.entitys.LoanRequest;
import br.com.phoebus.capacitacao.exception.BookListIsEmptyException;
import br.com.phoebus.capacitacao.exception.UserNotExistException;
import br.com.phoebus.capacitacao.repositorys.LoanRepository;
import br.com.phoebus.capacitacao.repositorys.SaveLoanService;
import br.com.phoebus.capacitacao.repositorys.UserClientRepository;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@DisplayName("Validation of the save loan method")
class SaveLoanServiceTest {

	@Mock
	private LoanRepository loanRepository;

	@Mock
	UserClientRepository userClient;

	private SaveLoanService saveLoanService;

	@BeforeEach
	public void setUp() {
//		saveLoanService = new SaveLoanServiceImpl(loanRepository, userClient);
	}

	@Test
	@DisplayName("Validate if the loan user exists")
	public void shouldThrowErrorIfLoanUserIsInvalidOrNull() {
//		Mockito.when(userClient.existsByUser(Mockito.anyLong())).thenReturn(false);
		assertThrows(UserNotExistException.class, () -> saveLoanService.save(createLoanRequest()));
	}

	@Test
	@DisplayName("Save loan without error")
	public void shouldSaveSuccessfully() throws UserNotExistException, BookListIsEmptyException {
//		Mockito.when(userClient.existsByUser(Mockito.anyLong())).thenReturn(true);
//		Mockito.when(loanRepository.save(Mockito.any(Loan.class))).thenReturn(LoanRequest.to(createLoanRequest()));
//		saveLoanService.save(createLoanRequest());
		Mockito.verify(loanRepository).save(Mockito.any(Loan.class));
	}

	private LoanRequest createLoanRequest() {
		List<Long> books = new ArrayList<>();
		books.add(1L);
		books.add(2L);
		books.add(3L);
		LoanRequest loan = new LoanRequest();
		loan.setId(10L);
//		loan.setIdUserDto(5L);
//		loan.setIdBooksDto(books);
//		loan.setLoanTime(LocalDateTime.now());

		return loan;
	}
}