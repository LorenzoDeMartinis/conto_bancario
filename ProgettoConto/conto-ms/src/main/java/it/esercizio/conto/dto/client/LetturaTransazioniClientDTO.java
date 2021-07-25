package it.esercizio.conto.dto.client;

import java.io.Serializable;
import java.util.Date;

import it.esercizio.conto.dto.TransactionTypeDTO;
import lombok.Data;

@Data
public class LetturaTransazioniClientDTO implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -5263289145015620856L;

	String transactionId;
	
	String operationId;
	
	Date accountingDate;
	
	Date valueDate;
	
	TransactionTypeDTO type;
	
	String currency;
	
	String description;
}
