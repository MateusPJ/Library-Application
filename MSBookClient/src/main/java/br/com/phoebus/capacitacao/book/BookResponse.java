package br.com.phoebus.capacitacao.book;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BookResponse {

	private String title;

	private String author;

	public static BookResponse requestConverter(Book book) {
		return new BookResponse(book.getTitle(), book.getAuthor());
	}

}