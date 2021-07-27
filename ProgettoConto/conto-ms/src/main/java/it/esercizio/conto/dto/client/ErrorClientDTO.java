package it.esercizio.conto.dto.client;

import java.io.Serializable;

import lombok.Data;

@Data
public class ErrorClientDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3320792720047061162L;
	
	private String code;
	
	private String description;

}
