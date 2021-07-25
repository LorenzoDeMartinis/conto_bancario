package it.esercizio.conto.dto;

import lombok.Data;

/**
 * ErrorDTO.java
 * DTO per gestione errori
 * @author ldemartinis
 *
 * @version 1.0
 * @DateUpdate  23 lug 2021
 * @description prima versione 
 */
@Data
public class ErrorDTO {

	private String code;
	
	private String description;
	
	private String params;
}
