package it.esercizio.conto.enumerali;

import java.io.Serializable;

import lombok.Data;

@Data
public class TransactionType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7342909699404968424L;

	private String enumeration;
	
	private String value;
	
	public TransactionType(String enumeration,String value) {
		this.enumeration = enumeration;
		this.value = value;
	}
	
}
