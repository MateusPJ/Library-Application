package br.com.phoebus.capacitacao.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.phoebus.capacitacao.entitys.Book;
import br.com.phoebus.capacitacao.entitys.BookRequest;
import br.com.phoebus.capacitacao.entitys.BookResponse;
import br.com.phoebus.capacitacao.exception.BookInvalid;
import br.com.phoebus.capacitacao.exception.BookListIsEmptyException;
import br.com.phoebus.capacitacao.exception.BookNotExistException;
import br.com.phoebus.capacitacao.repositorys.DeleteBookService;
import br.com.phoebus.capacitacao.repositorys.ListBookService;
import br.com.phoebus.capacitacao.repositorys.SaveBookService;
import br.com.phoebus.capacitacao.repositorys.UpdateBookService;
import br.com.phoebus.capacitacao.services.BookVerifyImpl;
import lombok.RequiredArgsConstructor;

/**
 * 
 * Classe controladora dos serviços dos livros
 * 
 * @author Mateus P Jorge
 *
 */
@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

	private final SaveBookService saveBookService;
	private final DeleteBookService deleteBookService;
	private final UpdateBookService updateBookService;
	private final ListBookService listBookService;
	private final BookVerifyImpl bookVerifyImpl;

	/**
	 * 
	 * Método responsável por realizar o cadastro dos livros.
	 * 
	 * @param dto
	 * @return BookResponse
	 * @throws BookInvalid
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public BookResponse saveBook(@RequestBody BookRequest dto) throws BookInvalid {
		saveBookService.save(dto);
		return BookResponse.requestConverter(BookRequest.to(dto));
	}

	/**
	 * 
	 * Método responsável por deletar um livro.
	 * 
	 * @param id
	 * @throws BookNotExistException
	 */
	@DeleteMapping(value = "{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void deleteBook(@PathVariable("id") Long id) throws BookNotExistException {
		deleteBookService.delete(id);
	}

	/**
	 * 
	 * Método responsável por atualizar as informações de um livro cadastrado.
	 * 
	 * @param id
	 * @param dto
	 * @throws BookNotExistException
	 * @throws BookInvalid
	 */
	@PutMapping(value = "{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void updateBook(@PathVariable("id") Long id, @RequestBody BookRequest dto)
			throws BookNotExistException, BookInvalid {
		updateBookService.update(id, dto);
	}

	/**
	 * 
	 * Método responsável por listar todos livros cadastrados.
	 * 
	 * @return listAllBooks
	 * @throws BookListIsEmptyException
	 */
	@GetMapping
	public List<Book> listBooks() throws BookListIsEmptyException {
		return listBookService.findAll();
	}

	/**
	 * 
	 * Método responsável por buscar um livro cadastrado.
	 * 
	 * @param id
	 * @return Book
	 * @throws BookNotExistException
	 */
	@GetMapping("/{id}")
	public Book existsByBook(@PathVariable("id") Long id) throws BookNotExistException {
		return bookVerifyImpl.existsByBook(id);
	}

}