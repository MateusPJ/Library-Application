package br.com.phoebus.capacitacao.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * Classe da API de representação do livro.
 * 
 * @author Mateus P Jorge
 *
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BOOKS")
public class Book {

	@Id
	@Column(name = "BOOK_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NM_TITLE", nullable = false)
	private String title;

	@Column(name = "DS_SUMMARY", nullable = false)
	private String summary;

	@Column(name = "NR_ISBN", nullable = false)
	private String isbn;

	@Column(name = "NM_AUTHOR", nullable = false)
	private String author;

	@Column(name = "NR_YEAR", nullable = false)
	private int year;

}