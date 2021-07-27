package it.esercizio.conto.dto.client;

import java.io.Serializable;

import lombok.Data;

@Data
public class CreditorClientDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7254301259232510744L;

	private String name;
	
	private AccountClientDTO account;
	
}
