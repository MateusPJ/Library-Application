package br.com.phoebus.capacitacao.loan;

import java.util.ArrayList;
import java.util.List;

import br.com.phoebus.capacitacao.clients.BookClientRepository;
import br.com.phoebus.capacitacao.clients.BookDTO;
import br.com.phoebus.capacitacao.clients.UserClientRepository;
import br.com.phoebus.capacitacao.clients.UserDTO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Util {

	private static UserClientRepository userClient;
	private static BookClientRepository bookClient;

	public static Loan converterToLoan(LoanRequest dto) {
		return new Loan(dto.getId(), dto.getUser().getId(), converterBookListToIdList(dto.getBooks()),
				dto.getLoantime());
	}

	public static LoanRequest converterToLoanDTO(Loan loan) {
		List<BookDTO> listBooksDTO = new ArrayList<>();
		System.out.println("\n\n\n"+loan.getIdUser());
		UserDTO userDTO = userClient.existsByUser(loan.getIdUser());
		for (Long idBook : loan.getIdBooks()) {
			listBooksDTO.add(bookClient.existsByBook(idBook));
		}
		return new LoanRequest(loan.getId(), userDTO, listBooksDTO, loan.getLoantime());
	}

	public static List<Long> converterBookListToIdList(List<BookDTO> listDto) {
		List<Long> idBooks = new ArrayList<>();
		for (BookDTO book : listDto) {
			idBooks.add(book.getId());
		}
		return idBooks;
	}

	public static List<LoanResponse> converterLoanListToResponseList(List<Loan> loans) {
		List<LoanResponse> responseList = new ArrayList<>();
		for (Loan loan : loans) {
			LoanRequest loanDTO = converterToLoanDTO(loan);
			responseList.add(LoanResponse.requestConverter(loanDTO));
		}
		return responseList;
	}

}