package it.esercizio.conto.dto;
import static it.esercizio.conto.common.Costanti.PATTERN;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

/**
 * AmountDTO.java
 * DTO per output creazione CreazioneBonificoOutputDTO
 * @author ldemartinis
 *
 * @version 1.0
 * @DateUpdate  23 lug 2021
 * @description prima versione 
 */
@Data
public class CreazioneBonificoOutputDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8973640675026530686L;


	String moneyTransferId;
	
	String status;
	
	String direction;
	
	PersonDTO creditor;
	
	PersonDTO debtor;
	
	String cro;
	
	String uri;
	
	String trn;
	
	String description;
	
	@DateTimeFormat(pattern = PATTERN)
	Date createdDatetime;
	
	@DateTimeFormat(pattern = PATTERN)
	Date accountedDatetime;
	
	@DateTimeFormat(pattern = PATTERN)
	Date creditorValueDate;
	
	@DateTimeFormat(pattern = PATTERN)
	Date debtorValueDate;
	
	AmountDTO amount;
	
	Boolean isUrgent;
	
	Boolean isInstant;
	
	String feeType;
	
	String feeAccountId;
	
	List<FeeDTO> fees;
	
	Boolean hasTaxRelief;
	
	
	
	
}
