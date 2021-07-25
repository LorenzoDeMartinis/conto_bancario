package it.esercizio.conto.controller;

import static it.esercizio.conto.common.Costanti.LETTURA_SALDO;
import static it.esercizio.conto.common.Costanti.URL_BASE_CONTO;
import static it.esercizio.conto.common.Costanti.LISTA_TRANSAZIONI;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.esercizio.conto.dto.client.LetturaSaldoClientDTO;
import it.esercizio.conto.dto.client.LetturaTransazioniClientDTO;

public class ContoControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	public void letturaSaldoTest() throws Exception {
		
		ResultActions result = mockMvc.perform(post("/" + URL_BASE_CONTO + LETTURA_SALDO).contentType("application/json"));

		if (result.andReturn().getResponse().getStatus() != 200) {
			fail();
		} else {
			MvcResult mvcResult = result.andReturn();
			String response = mvcResult.getResponse().getContentAsString();

			LetturaSaldoClientDTO  outputDTO = 
					objectMapper.readValue(response, new TypeReference<LetturaSaldoClientDTO>() {});
			assertNotNull(outputDTO);
		}
	}
	@Test
	public void letturaTransazioni() throws Exception {
		
		ResultActions result = mockMvc.perform(post("/" + URL_BASE_CONTO + LISTA_TRANSAZIONI)
				.contentType("application/json")
				.queryParam("fromAccountingDate", "2019-01-01")
				.queryParam("toAccountingDate", "2019-12-01"));

		if (result.andReturn().getResponse().getStatus() != 200) {
			fail();
		} else {
			MvcResult mvcResult = result.andReturn();
			String response = mvcResult.getResponse().getContentAsString();

			List<LetturaTransazioniClientDTO>  outputDTO = 
					objectMapper.readValue(response, new TypeReference<List<LetturaTransazioniClientDTO>>() {});
			assertTrue(outputDTO.size() > 0);
		}
	}
}
