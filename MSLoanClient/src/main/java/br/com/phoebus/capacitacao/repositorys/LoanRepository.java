package br.com.phoebus.capacitacao.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.phoebus.capacitacao.entitys.Loan;

/**
 * 
 * Reposit�rio base utilizado para consultas em todos os servi�os de empr�stimo.
 * 
 * @author Mateus P Jorge
 *
 * @param <Loan> - Entidade gen�rica que recebe apenas Loan.
 * @param <Long> - Entidade gen�rica que recebe o tipo do id da entidade Loan(Long).
 */
public interface LoanRepository extends JpaRepository<Loan, Long> {

}