package it.esercizio.conto.dto.client;

import java.io.Serializable;

import lombok.Data;

@Data
public class AccountClientDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 38072934974192131L;

	private String accountCode;
	
	private String bicCode;
}
