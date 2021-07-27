package it.esercizio.conto.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class AccountDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1697287484189742986L;

	private String accountCode;
	
	private String bicCode;
}
