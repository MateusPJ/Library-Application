package br.com.phoebus.capacitacao.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

	public static Book to(BookRequest request) {
		return new Book(request.getId(), request.getTitle(), request.getSummary(), request.getIsbn(),
				request.getAuthor(), request.getYear());
	}

}