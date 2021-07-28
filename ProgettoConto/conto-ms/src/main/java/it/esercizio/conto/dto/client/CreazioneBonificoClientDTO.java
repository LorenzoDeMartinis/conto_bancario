package it.esercizio.conto.dto.client;

import static it.esercizio.conto.common.Costanti.PATTERN;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
/**
 * OperationStateClientDTO.java
 * classe per rappresentazioni informazioni stato operazioni
 * @Change @history
 * @author ldemartinis
 * @version     1.0
 * @DateUpdate 28 lug 2021
 * @Description prima versione
 *
 */
@Data
public class CreazioneBonificoClientDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7209911174904157247L;

	private String moneyTransferId;
	
	private String status;
	
	private String direction;
	
	private PersonClientDTO creditor;
	
	private PersonClientDTO debtor;
	
	private String cro;
	
	private String uri;
	
	private String trn;
	
	private String description;
	
	@DateTimeFormat(pattern = PATTERN)
	private Date createdDatetime;
	
	@DateTimeFormat(pattern = PATTERN)
	Date accountedDatetime;
	
	@DateTimeFormat(pattern = PATTERN)
	Date creditorValueDate;
	
	@DateTimeFormat(pattern = PATTERN)
	Date debtorValueDate;
	
	AmountClientDTO amount;
	
	Boolean isUrgent;
	
	Boolean isInstant;
	
	String feeType;
	
	String feeAccountId;
	
	List<FeeClientDTO> fees;
	
	Boolean hasTaxRelief;
	
}
