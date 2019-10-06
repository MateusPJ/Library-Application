package br.com.phoebus.capacitacao.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.phoebus.capacitacao.entitys.Loan;

/**
 * 
 * Repositório base utilizado para consultas em todos os serviços de empréstimo.
 * 
 * @author Mateus P Jorge
 *
 * @param <Loan> - Entidade genérica que recebe apenas Loan.
 * @param <Long> - Entidade genérica que recebe o tipo do id da entidade Loan(Long).
 */
public interface LoanRepository extends JpaRepository<Loan, Long> {

}