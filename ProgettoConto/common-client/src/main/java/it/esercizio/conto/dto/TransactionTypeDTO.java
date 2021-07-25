package it.esercizio.conto.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class TransactionTypeDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7342909699404968424L;

	private String enumeration;
	
	private String value;
	
	public TransactionTypeDTO(String enumeration,String value) {
		this.enumeration = enumeration;
		this.value = value;
	}
	
}
