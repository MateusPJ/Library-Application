package br.com.phoebus.capacitacao.book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

	boolean findByTitle(String title);

}