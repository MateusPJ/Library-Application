package br.com.phoebus.capacitacao.book;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import br.com.phoebus.capacitacao.exception.BookInvalid;
import br.com.phoebus.capacitacao.exception.BookNotExistException;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@DisplayName("Validation of the update book method")
class UpdateBookServiceTest {

	@Mock
	private BookRepository bookRepository;

	private UpdateBookService updateBookService;

	@BeforeEach
	public void setUp() {
		updateBookService = new UpdateBookServiceImpl(bookRepository);
	}

	@Test
	@DisplayName("Update book without error")
	public void shouldSaveSuccessfully() throws BookInvalid, BookNotExistException {
		Mockito.when(bookRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(BookRequest.to(createBook())));
		Mockito.when(bookRepository.save(Mockito.any(Book.class))).thenReturn(BookRequest.to(createBook()));
		updateBookService.update(1L, createBook());
		Mockito.verify(bookRepository).save(Mockito.any(Book.class));
	}

	@Test
	@DisplayName("Validate if book id exists")
	public void shouldThrowErrorIfBookIdNotFound() {
		Mockito.when(bookRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
		assertThrows(BookNotExistException.class, () -> updateBookService.update(1L, createBook()));
	}

	@Test
	@DisplayName("Validate if all fields have been filled")
	public void shouldThrowErrorIfAnyFieldsAreMissing() {
		BookRequest book = new BookRequest();
		book.setId(1L);
		book.setAuthor("Henrik Fexeus");
		book.setTitle("A Arte de ler mentes.");
		book.setYear(2013);
		book.setIsbn("9788532646491");
		Mockito.when(bookRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(BookRequest.to(book)));
		Mockito.when(bookRepository.save(Mockito.any(Book.class))).thenReturn(BookRequest.to(book));
		assertThrows(BookInvalid.class, () -> updateBookService.update(1L, book));
	}

	private BookRequest createBook() {
		BookRequest book = new BookRequest();
		book.setId(1L);
		book.setAuthor("Henrik Fexeus");
		book.setTitle("A Arte de ler mentes.");
		book.setYear(2013);
		book.setSummary("Como interpretar gestos e influenciar pessoas.");
		book.setIsbn("9788532646491");

		return book;
	}

}