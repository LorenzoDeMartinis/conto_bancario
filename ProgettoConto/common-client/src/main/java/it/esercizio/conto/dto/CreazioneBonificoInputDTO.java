package it.esercizio.conto.dto;

import java.io.Serializable;
import java.util.Date;

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
public class CreazioneBonificoInputDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3376190433395923598L;

	private PersonDTO creditor;
	
	@DateTimeFormat(pattern = "PATTERN")
	Date executionDate;
	
	private String description;
	
	private Long amount;
	
	private String currency;
	
	private String reciverName;
	
}
