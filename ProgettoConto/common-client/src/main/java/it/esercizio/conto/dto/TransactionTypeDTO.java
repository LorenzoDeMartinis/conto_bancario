package it.esercizio.conto.dto;

import java.io.Serializable;

import lombok.Data;
/**
 * PayLoadListDTO.java 
 * classe dto per il tipo di transazione
 * 
 * @Change @history
 * @author      Inmatica SpA - ldemartinis
 * @version     1.0
 * @DateUpdate  28 lug 2021
 * @Description prima versione
 */
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
