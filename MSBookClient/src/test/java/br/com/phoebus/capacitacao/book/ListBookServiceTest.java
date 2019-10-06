package br.com.phoebus.capacitacao.book;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.phoebus.capacitacao.entitys.Book;
import br.com.phoebus.capacitacao.exception.BookListIsEmptyException;
import br.com.phoebus.capacitacao.repositorys.BookRepository;
import br.com.phoebus.capacitacao.repositorys.ListBookService;
import br.com.phoebus.capacitacao.services.ListBookServiceImpl;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
@DisplayName("Validation of the method listing books")
class ListBookServiceTest {

	@Mock
	private BookRepository bookRepository;

	private ListBookService listBookService;

	@BeforeEach
	public void setUp() {
		listBookService = new ListBookServiceImpl(bookRepository);
	}

	@Test
	@DisplayName("Validate if book list is Empty")
	public void shouldThrowErrorIfBookListIsEmpty() {
		List<Book> books = new ArrayList<>();
		Mockito.when(bookRepository.findAll()).thenReturn(books);
		assertThrows(BookListIsEmptyException.class, () -> listBookService.findAll());
	}

	@Test
	@DisplayName("List books without error")
	public void shouldListAllSuccessfully() throws BookListIsEmptyException {
		List<Book> books = new ArrayList<>();
		books.add(createBook());
		Mockito.when(bookRepository.findAll()).thenReturn(books);
		listBookService.findAll();
		Mockito.verify(bookRepository).findAll();
	}

	private Book createBook() {
		Book book = new Book();
		book.setAuthor("Henrik Fexeus");
		book.setTitle("A Arte de ler mentes.");
		book.setYear(2013);
		book.setSummary("Como interpretar gestos e influenciar pessoas.");
		book.setIsbn("9788532646491");

		return book;
	}

}