package it.esercizio.conto.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
/**
 * AmountDTO.java
 * DTO per Fees
 * @author ldemartinis
 *
 * @version 1.0
 * @DateUpdate  23 lug 2021
 * @description prima versione 
 */
@Data
public class FeeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 43603310874724218L;
	
	String feeCode;
	
	String description;
	
	Float amount;
	
	String currency;

}
