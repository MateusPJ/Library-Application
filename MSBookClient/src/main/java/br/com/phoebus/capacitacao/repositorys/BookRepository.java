package br.com.phoebus.capacitacao.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.phoebus.capacitacao.entitys.Book;

/**
 * 
 * Repositório base utilizado para consultas em todos os serviços. 
 * 
 * @author Mateus P Jorge
 *
 * @param <Book> - Entidade genérica que recebe apenas Book.
 * @param <Long> - Entidade genérica que recebe o tipo do id da entidade Book (Long).
 */
public interface BookRepository extends JpaRepository<Book, Long> {

}