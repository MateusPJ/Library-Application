package br.com.phoebus.capacitacao.loan;

import java.util.ArrayList;
import java.util.List;

import br.com.phoebus.capacitacao.clients.BookDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoanResponse {

	private String user;

	private List<String> books;
	
	public static LoanResponse requestConverter(LoanRequest dto) {
		List<String> listTitles = new ArrayList<>();
		for (BookDTO book : dto.getBooks()) {
			listTitles.add(book.getTitle());
		}
		return new LoanResponse(dto.getUser().getName(), listTitles);
	}

}