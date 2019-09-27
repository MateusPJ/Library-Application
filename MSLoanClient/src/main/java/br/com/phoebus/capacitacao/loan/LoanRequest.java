package br.com.phoebus.capacitacao.loan;

import java.time.LocalDateTime;
import java.util.List;

import br.com.phoebus.capacitacao.clients.BookDTO;
import br.com.phoebus.capacitacao.clients.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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