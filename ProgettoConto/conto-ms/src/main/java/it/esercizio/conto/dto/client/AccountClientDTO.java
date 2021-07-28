package it.esercizio.conto.dto.client;

import java.io.Serializable;

import lombok.Data;
/**
 * AccountClientDTO.java
 * classe per rappresentazioni informazioni account
 * @Change @history
 * @author ldemartinis
 * @version     1.0
 * @DateUpdate 28 lug 2021
 * @Description prima versione
 *
 */
@Data
public class AccountClientDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 38072934974192131L;

	private String accountCode;
	
	private String bicCode;
}
