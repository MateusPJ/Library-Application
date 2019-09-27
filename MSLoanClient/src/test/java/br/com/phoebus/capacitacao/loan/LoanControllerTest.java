package br.com.phoebus.capacitacao.loan;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
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
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import br.com.phoebus.capacitacao.exception.ErrorConvertingObjectException;

@ExtendWith(SpringExtension.class)
@WebMvcTest(LoanController.class)
@DisplayName("Loan controller validation call methods")
class LoanControllerTest {

	@Autowired
	protected MockMvc mockMvc;

	@MockBean
	private SaveLoanService saveLoanService;

	@MockBean
	private DeleteLoanService deleteLoanService;

	@MockBean
	private ListLoanService listLoanService;

	@MockBean
	private UpdateLoanService updateLoanService;

	@Test
	@DisplayName("Save loan without error")
	public void testPostSaveLoanWithoutError() throws Exception {
		LoanRequest lr = createLoanRequest();
//		Loan expectedLoan = LoanRequest.to(lr);
//		when(saveLoanService.save(Mockito.any(LoanRequest.class))).thenReturn(expectedLoan);
		mockMvc.perform(post("/loans").content(asJsonString(lr)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").doesNotExist())
				.andExpect(MockMvcResultMatchers.jsonPath("$.idUser").value(5L))
				.andExpect(MockMvcResultMatchers.jsonPath("$.idBooks").exists());
	}

	@Test
	@DisplayName("Delete loan without error")
	public void testDeleteLoanWithoutError() throws Exception {
		doNothing().when(deleteLoanService).delete(anyLong());
		mockMvc.perform(delete("/loans/{id}", 1L).contentType(MediaType.ALL_VALUE)).andExpect(status().isAccepted());
	}

	@Test
	@DisplayName("Update loan without error")
	public void testPutUpdateLoanWithoutError() throws Exception {
		LoanRequest lr = createLoanRequest();
//		Loan expectedLoan = LoanRequest.to(lr);
//		when(updateLoanService.update(anyLong(), Mockito.any(LoanRequest.class))).thenReturn(expectedLoan);
		mockMvc.perform(put("/loans").content(asJsonString(lr)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isAccepted());
	}

	@Test
	@DisplayName("List loans without error")
	public void testGetListLoansWithoutError() throws Exception {
		List<Loan> loans = new ArrayList<>();
//		LoanRequest lr = createLoanRequest();
//		loans.add(LoanRequest.to(lr));
//		when(listLoanService.findAll()).thenReturn(loans);
		mockMvc.perform(get("/loans").content(asJsonString(loans)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().is2xxSuccessful())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1L))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].idUser").value(5L))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].idBooks").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].loanTime").exists());
	}

	private LoanRequest createLoanRequest() {
		List<Long> books = new ArrayList<>();
		books.add(1L);
		books.add(2L);
		books.add(3L);
		LoanRequest loan = new LoanRequest();
		loan.setId(1L);
//		loan.setIdUserDto(5L);
//		loan.setIdBooksDto(books);
//		loan.setLoanTime(LocalDateTime.now());

		return loan;
	}

	public static String asJsonString(final Object obj) throws ErrorConvertingObjectException {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());
			mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new ErrorConvertingObjectException();
		}
	}

}