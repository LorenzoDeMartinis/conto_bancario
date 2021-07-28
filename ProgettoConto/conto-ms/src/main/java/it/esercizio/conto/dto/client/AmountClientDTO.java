package it.esercizio.conto.dto.client;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * AmountClientDTO.java
 * classe per rappresentazioni informazioni del amount client
 * @Change @history
 * @author ldemartinis
 * @version     1.0
 * @DateUpdate 28 lug 2021
 * @Description prima versione
 *
 */
@Data
public class AmountClientDTO implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -7109828606486203500L;
	
	private String debtorAmount;
	
	private String debtorCurrency;
	
	private String creditorAmount;
	
	private String creditorCurrency;
	
	private Date creditorCurrencyDate;
	
	private Long exchangeRate;
}
