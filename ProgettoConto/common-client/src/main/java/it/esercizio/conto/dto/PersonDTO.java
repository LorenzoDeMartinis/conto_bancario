package it.esercizio.conto.dto;

import java.io.Serializable;

import lombok.Data;
/**
 * CreditorDTO.java 
 * classe dto per i dati del creditore e debitores
 * 
 * @Change @history
 * @author      Inmatica SpA - ldemartinis
 * @version     1.0
 * @DateUpdate  28 lug 2021
 * @Description prima versione
 */
@Data
public class PersonDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6611264813606594654L;


	private String name;
	
	private AccountDTO account;
}
