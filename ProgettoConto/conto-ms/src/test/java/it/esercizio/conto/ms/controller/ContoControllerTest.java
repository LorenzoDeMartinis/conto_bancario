package it.esercizio.conto.ms.controller;

import static it.esercizio.conto.common.Costanti.BONIFICO;
import static it.esercizio.conto.common.Costanti.CODICE_ERRORE;
import static it.esercizio.conto.common.Costanti.LETTURA_SALDO;
import static it.esercizio.conto.common.Costanti.LISTA_TRANSAZIONI;
import static it.esercizio.conto.common.Costanti.URL_BASE_CONTO;
import static it.esercizio.conto.common.Costanti.PATTERN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.esercizio.conto.dto.client.BonificoClientDTO;
import it.esercizio.conto.dto.client.FaultResponse;
import it.esercizio.conto.dto.client.LetturaSaldoClientDTO;
import it.esercizio.conto.dto.client.LetturaTransazioniClientDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ContoControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Test
	public void letturaSaldoTest() throws Exception {
		
		ResultActions result = mockMvc.perform(get(URL_BASE_CONTO + LETTURA_SALDO).contentType("application/json"));

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
		
		ResultActions result = mockMvc.perform(get(URL_BASE_CONTO + LISTA_TRANSAZIONI)
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
	@Test
	public void creazioneBonifico() throws Exception {
		
		BonificoClientDTO dto = new BonificoClientDTO();
		dto.setAmount(800L);
		dto.setCurrency("EUR");
		dto.setDescription(URL_BASE_CONTO);
		dto.setExecutionDate(new SimpleDateFormat(PATTERN).parse("2021-07-27"));
		dto.setReciverName("esempio");
		
		ResultActions result = mockMvc.perform(post(URL_BASE_CONTO + BONIFICO)
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(dto)));

		MvcResult mvcResult = result.andReturn();
		String response = mvcResult.getResponse().getContentAsString();

		FaultResponse  outputDTO = 
				objectMapper.readValue(response, new TypeReference<FaultResponse>() {});
		assertEquals(outputDTO.getErrorCode(), CODICE_ERRORE);
	}
}
