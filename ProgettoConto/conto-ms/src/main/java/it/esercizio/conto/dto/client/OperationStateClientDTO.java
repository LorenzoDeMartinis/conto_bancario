package it.esercizio.conto.dto.client;

import java.io.Serializable;

import lombok.Data;

@Data
public class OperationStateClientDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5501648357981748318L;
	
	Boolean opState;
	
	String description;
	
	String code;
}
