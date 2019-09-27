package br.com.phoebus.capacitacao.book;

import static org.junit.jupiter.api.Assertions.*;

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

import br.com.phoebus.capacitacao.exception.BookNotExistException;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
@DisplayName("Validation of the delete book method")
class DeleteBookServiceTest {

	@Mock
	private BookRepository bookRepository;

	private DeleteBookService deleteBookService;

	@BeforeEach
	public void setUp() {
		deleteBookService = new DeleteBookServiceImpl(bookRepository);
	}

	@Test
	@DisplayName("Validate if book exists")
	public void shouldThrowErrorIfBookNotExists() {
		Mockito.when(bookRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
		assertThrows(BookNotExistException.class, () -> deleteBookService.delete(1L));
	}

	@Test
	@DisplayName("Delete book without error")
	public void shouldDeletedSuccessfully() throws BookNotExistException {
		Mockito.when(bookRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(createBook()));
		deleteBookService.delete(1L);
		Mockito.verify(bookRepository).delete(Mockito.any(Book.class));
	}

	private Book createBook() {
		Book book = new Book();
		book.setId(1L);
		book.setAuthor("Henrik Fexeus");
		book.setTitle("A Arte de ler mentes.");
		book.setYear(2013);
		book.setSummary("Como interpretar gestos e influenciar pessoas.");
		book.setIsbn("9788532646491");

		return book;
	}

}