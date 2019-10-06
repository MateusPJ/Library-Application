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
public class BookDTO {

	private Long id;

	private String title;

	private String summary;

	private String isbn;

	private String author;

	private int year;

}