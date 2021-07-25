package it.esercizio.conto.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 * LetturaTransazioniInputDTO.java
 * DTO di input per lettura delle transazioni
 * @author ldemartinis
 *
 * @version 1.0
 * @DateUpdate  23 lug 2021
 * @description prima versione 
 */
@Data
public class LetturaTransazioniInputDTO {

	@DateTimeFormat(pattern = "YYYY-MM-DD")
	Date fromAccountingDate;
	
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	Date toAccountingDate;
	
}
