package br.com.phoebus.capacitacao.entitys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * Classe que representa um objeto para transferências de dados.
 * 
 * @author Mateus P Jorge
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {

	private Long id;

	private String title;

	private String summary;

	private String isbn;

	private String author;

	private int year;

	/**
	 * 
	 * Método de conversão do DTO para um livro.
	 * 
	 * @param request
	 * @return Book
	 */
	public static Book to(BookRequest request) {
		return new Book(request.getId(), request.getTitle(), request.getSummary(), request.getIsbn(),
				request.getAuthor(), request.getYear());
	}

}