package it.esercizio.conto.dto;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 * CreazioneBonificoDTO.java
 * DTO di input per la creazione di un bonifico
 * @author ldemartinis
 *
 * @version 1.0
 * @DateUpdate  21 lug 2021
 * @description prima versione 
 */
@Data
public class CreazioneBonificoInputDTO {

	private Long accountId;
	
	private String receiverName;
	
	private String description;
	
	private String currency;
	
	private String amount;
	
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	private String executionDate;
	
}
