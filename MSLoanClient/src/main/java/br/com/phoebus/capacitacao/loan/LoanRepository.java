package br.com.phoebus.capacitacao.loan;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {

//	@GetMapping("/ListAllLoansForUser/{idUser}")
//	@Query("SELECT l.idUser FROM Loan l WHERE l.idUser = :userId")
//	boolean existsUserIdInLoan(@PathVariable("userId") Long idUser);

}