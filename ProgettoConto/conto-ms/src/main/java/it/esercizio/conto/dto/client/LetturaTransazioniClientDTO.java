package it.esercizio.conto.dto.client;

import java.io.Serializable;
import java.util.Date;

import it.esercizio.conto.dto.TransactionTypeDTO;
import lombok.Data;
/**
 * LetturaTransazioniClientDTO.java
 * classe per rappresentazioni informazioni delle transazioni
 * @Change @history
 * @author ldemartinis
 * @version     1.0
 * @DateUpdate 28 lug 2021
 * @Description prima versione
 *
 */
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
