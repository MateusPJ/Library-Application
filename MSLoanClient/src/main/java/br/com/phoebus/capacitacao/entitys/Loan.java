package br.com.phoebus.capacitacao.entitys;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
 * Classe da API que representa um empréstimo.
 * 
 * @author Mateus P Jorge
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LOANS")
public class Loan {

	@Id
	@Column(name = "LOAN_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "USER_ID", nullable = false)
	private Long idUser;

	@Column(name = "BOOKS_ID", nullable = false)
	@ElementCollection
	private List<Long> idBooks;

	@Column(name = "NR_LOAN_TIME")
	private LocalDateTime loantime;

}