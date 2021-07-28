package it.esercizio.conto.dto.client;

import java.io.Serializable;

import lombok.Data;
/**
 * CreditorClientDTO.java
 * classe per rappresentazioni informazioni del creditore del bonifico
 * @Change @history
 * @author ldemartinis
 * @version     1.0
 * @DateUpdate 28 lug 2021
 * @Description prima versione
 *
 */
@Data
public class CreditorClientDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7254301259232510744L;

	private String name;
	
	private AccountClientDTO account;
	
}
