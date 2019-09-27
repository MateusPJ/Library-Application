package br.com.phoebus.capacitacao.book;

import static org.junit.jupiter.api.Assertions.*;

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

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@DisplayName("Validation of the save book method")
class SaveBookServiceTest {

	@Mock
	private BookRepository bookRepository;

	private SaveBookService saveBookService;

	@BeforeEach
	public void setUp() {
		saveBookService = new SaveBookServiceImpl(bookRepository);
	}

	@Test
	@DisplayName("Save book without error")
	public void shouldSaveSuccessfully() throws BookInvalid {
		Mockito.when(bookRepository.save(Mockito.any(Book.class))).thenReturn(BookRequest.to(createBook()));
		saveBookService.save(createBook());
		Mockito.verify(bookRepository).save(Mockito.any(Book.class));
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
		Mockito.when(bookRepository.save(Mockito.any(Book.class))).thenReturn(BookRequest.to(book));
		assertThrows(BookInvalid.class, () -> saveBookService.save(book));
	}

	private BookRequest createBook() {
		BookRequest book = new BookRequest();
		book.setAuthor("Henrik Fexeus");
		book.setTitle("A Arte de ler mentes.");
		book.setYear(2013);
		book.setSummary("Como interpretar gestos e influenciar pessoas.");
		book.setIsbn("9788532646491");

		return book;
	}

}