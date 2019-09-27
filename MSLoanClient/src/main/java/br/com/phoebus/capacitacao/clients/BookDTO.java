package br.com.phoebus.capacitacao.clients;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

	private Long id;

	private String title;

	private String summary;

	private String isbn;

	private String author;

	private int year;

}