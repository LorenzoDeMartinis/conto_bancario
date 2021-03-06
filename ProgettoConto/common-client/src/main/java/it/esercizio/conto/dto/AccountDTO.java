package it.esercizio.conto.dto;

import java.io.Serializable;

import lombok.Data;
/**
 * AccountDTO.java 
 * classe dto per dati account
 * 
 * @Change @history
 * @author      Inmatica SpA - ldemartinis
 * @version     1.0
 * @DateUpdate  28 lug 2021
 * @Description prima versione
 */
@Data
public class AccountDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1697287484189742986L;

	private String accountCode;
	
	private String bicCode;
}
