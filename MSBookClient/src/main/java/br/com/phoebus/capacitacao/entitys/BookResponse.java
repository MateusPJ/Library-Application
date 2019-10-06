package br.com.phoebus.capacitacao.entitys;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * Classe que representa uma resposta para as requisi��es do controller.
 * 
 * @author Mateus P Jorge
 *
 */
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BookResponse {

	private String title;

	private String author;

	/**
	 * 
	 * M�todo de convers�o para responder as requisi��es.
	 * 
	 * @param book
	 * @return BookResponse
	 */
	public static BookResponse requestConverter(Book book) {
		return new BookResponse(book.getTitle(), book.getAuthor());
	}

}