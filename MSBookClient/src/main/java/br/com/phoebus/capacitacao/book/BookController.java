package br.com.phoebus.capacitacao.book;

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

import br.com.phoebus.capacitacao.exception.BookInvalid;
import br.com.phoebus.capacitacao.exception.BookListIsEmptyException;
import br.com.phoebus.capacitacao.exception.BookNotExistException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

	private final SaveBookService saveBookService;
	private final DeleteBookService deleteBookService;
	private final UpdateBookService updateBookService;
	private final ListBookService listBookService;
	private final BookVerifyImpl bookVerifyImpl;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public BookResponse saveBook(@RequestBody BookRequest dto) throws BookInvalid {
		saveBookService.save(dto);
		return BookResponse.requestConverter(BookRequest.to(dto));
	}

	@DeleteMapping(value = "{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void deleteBook(@PathVariable("id") Long id) throws BookNotExistException {
		deleteBookService.delete(id);
	}

	@PutMapping(value = "{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void updateBook(@PathVariable("id") Long id, @RequestBody BookRequest dto)
			throws BookNotExistException, BookInvalid {
		updateBookService.update(id, dto);
	}

	@GetMapping
	public List<Book> listBooks() throws BookListIsEmptyException {
		return listBookService.findAll();
	}

	@GetMapping("/{id}")
	public Book existsByBook(@PathVariable("id") Long id) throws BookNotExistException {
		return bookVerifyImpl.existsByBook(id);
	}

}