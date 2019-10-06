package br.com.phoebus.capacitacao.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.phoebus.capacitacao.entitys.Book;

/**
 * 
 * Reposit�rio base utilizado para consultas em todos os servi�os. 
 * 
 * @author Mateus P Jorge
 *
 * @param <Book> - Entidade gen�rica que recebe apenas Book.
 * @param <Long> - Entidade gen�rica que recebe o tipo do id da entidade Book (Long).
 */
public interface BookRepository extends JpaRepository<Book, Long> {

}