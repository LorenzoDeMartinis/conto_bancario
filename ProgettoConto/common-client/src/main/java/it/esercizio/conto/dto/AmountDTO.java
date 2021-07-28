package it.esercizio.conto.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * AmountDTO.java
 * DTO wrapper amount
 * @author ldemartinis
 *
 * @version 1.0
 * @DateUpdate  23 lug 2021
 * @description prima versione 
 */
@Data
public class AmountDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2630827679505046639L;

	String debtorAmount;
	String debtorCurrency;
	String creditorAmount;
	String creditorCurrency;
	Date creditorCurrencyDate;
	Long exchangeRate;
	
}
