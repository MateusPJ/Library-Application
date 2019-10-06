package br.com.phoebus.capacitacao.entitys;

import java.time.LocalDateTime;
import java.util.List;

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
public class LoanRequest {

	private Long id;

	private UserDTO user;

	private List<BookDTO> books;

	private LocalDateTime loantime;

}