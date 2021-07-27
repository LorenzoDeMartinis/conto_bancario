package it.esercizio.conto.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CreditorDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6611264813606594654L;


	private String name;
	
	private AccountDTO account;
}
