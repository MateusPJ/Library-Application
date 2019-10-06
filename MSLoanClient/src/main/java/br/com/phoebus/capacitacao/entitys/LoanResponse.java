package br.com.phoebus.capacitacao.entitys;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * Classe que representa uma resposta para as requisições do controller.
 * 
 * @author Mateus P Jorge
 *
 */
@Getter
@Setter
@AllArgsConstructor
public class LoanResponse {

	private String user;

	private List<String> books;
	
	/**
	 * 
	 * Método de conversão para responder as requisições.
	 * 
	 * @param dto
	 * @return LoanResponse
	 */
	public static LoanResponse requestConverter(LoanRequest dto) {
		List<String> listTitles = new ArrayList<>();
		for (BookDTO book : dto.getBooks()) {
			listTitles.add(book.getTitle());
		}
		return new LoanResponse(dto.getUser().getName(), listTitles);
	}

}