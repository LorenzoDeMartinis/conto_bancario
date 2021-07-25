package it.esercizio.conto.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import it.esercizio.conto.enumerali.TransactionType;
import lombok.Data;

/**
 * LetturaTransazioniOutputDTO.java
 * DTO di output per la lettura delle transazioni
 * @author ldemartinis
 *
 * @version 1.0
 * @DateUpdate  23 lug 2021
 * @description prima versione 
 */
@Data
public class LetturaTransazioniOutputDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5899675835850914932L;

	String transactionId;
	
	String operationId;
	
	Date accountingDate;
	
	Date valueDate;
	
	TransactionType type;
	
	String currency;
	
	String description;
	
}
