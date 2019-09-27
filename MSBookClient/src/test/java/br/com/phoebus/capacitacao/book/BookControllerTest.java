package br.com.phoebus.capacitacao.book;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.phoebus.capacitacao.exception.ErrorConvertingObjectException;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BookController.class)
@DisplayName("Book controller validation call methods")
class BookControllerTest {

	@Autowired
	protected MockMvc mockMvc;

	@MockBean
	private DeleteBookService deleteBookService;

	@MockBean
	private ListBookService listBookService;

	@MockBean
	private SaveBookService saveBookService;

	@MockBean
	private UpdateBookService updateBookService;

	@Test
	@DisplayName("Save book without error")
	public void testPostSaveBookWithoutError() throws Exception {
		BookRequest br = createBookRequest();
		Book expectedBook = BookRequest.to(br);
		when(saveBookService.save(any(BookRequest.class))).thenReturn(expectedBook);
		mockMvc.perform(post("/books").content(asJsonString(br)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").doesNotExist())
				.andExpect(MockMvcResultMatchers.jsonPath("$.title").value(expectedBook.getTitle()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.summary").doesNotExist())
				.andExpect(MockMvcResultMatchers.jsonPath("$.isbn").doesNotExist())
				.andExpect(MockMvcResultMatchers.jsonPath("$.author").value(expectedBook.getAuthor()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.year").doesNotExist());
	}

	@Test
	@DisplayName("Delete book without error")
	public void testDeleteBookWithoutError() throws Exception {
		doNothing().when(deleteBookService).delete(anyLong());
		mockMvc.perform(delete("/books/{id}", 1L).contentType(MediaType.ALL_VALUE)).andExpect(status().isAccepted());
	}

	@Test
	@DisplayName("Update book without error")
	public void testPutUpdateBookWithoutError() throws Exception {
		BookRequest br = createBookRequest();
		Book expectedBook = BookRequest.to(br);
		when(updateBookService.update(anyLong(), any(BookRequest.class))).thenReturn(expectedBook);
		mockMvc.perform(
				put("/books/"+br.getId())
				.content(asJsonString(br))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isAccepted());
	}

	@Test
	@DisplayName("List books without error")
	public void testGetListBooksWithoutError() throws Exception {
		List<Book> books = new ArrayList<>();
		BookRequest br = createBookRequest();
		books.add(BookRequest.to(br));
		when(listBookService.findAll()).thenReturn(books);
		mockMvc.perform(get("/books").content(asJsonString(books)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1L))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value("A Arte de ler mentes."))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].summary")
						.value("Como interpretar gestos e influenciar pessoas."))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].isbn").value("9788532646491"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].author").value("Henrik Fexeus"))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].year").value(2013));
	}

	private BookRequest createBookRequest() {
		BookRequest br = new BookRequest();
		br.setId(1L);
		br.setTitle("A Arte de ler mentes.");
		br.setSummary("Como interpretar gestos e influenciar pessoas.");
		br.setIsbn("9788532646491");
		br.setAuthor("Henrik Fexeus");
		br.setYear(2013);
		return br;
	}

	public static String asJsonString(final Object obj) throws ErrorConvertingObjectException {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new ErrorConvertingObjectException();
		}
	}

}