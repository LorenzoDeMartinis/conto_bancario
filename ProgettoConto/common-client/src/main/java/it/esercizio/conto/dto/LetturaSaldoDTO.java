package it.esercizio.conto.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * LetturaSaldoDTO.java
 * DTO di output per la lettura del saldo.
 * @author ldemartinis
 *
 * @version 1.0
 * @DateUpdate  21 lug 2021
 * @description prima versione 
 */
@Data
public class LetturaSaldoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2672967163601399356L;
	
	/*The reference date for the retrieved balance.*/
	private Date date;
	/*Account balance: the reserved entries are not accounted.*/
	private Float balance;
	/*Net account balance: the reserved entries are coounted.*/
	private Float availableBalance;
	/*The currency amount.*/
	private String currency;
	
}
