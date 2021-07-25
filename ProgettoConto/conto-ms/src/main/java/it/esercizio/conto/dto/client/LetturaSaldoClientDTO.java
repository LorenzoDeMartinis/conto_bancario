package it.esercizio.conto.dto.client;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class LetturaSaldoClientDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2798978186145381887L;
	
	/*The reference date for the retrieved balance.*/
	private Date date;
	/*Account balance: the reserved entries are not accounted.*/
	private Float balance;
	/*Net account balance: the reserved entries are coounted.*/
	private Float availableBalance;
	/*The currency amount.*/
	private String currency;
}
