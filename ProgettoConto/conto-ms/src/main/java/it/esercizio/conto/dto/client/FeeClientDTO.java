package it.esercizio.conto.dto.client;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import it.esercizio.conto.dto.FeeDTO;
import it.esercizio.conto.dto.PersonDTO;
import lombok.Data;
/**
 * FeeClientDTO.java
 * classe per rappresentazioni informazioni del fee
 * @Change @history
 * @author ldemartinis
 * @version     1.0
 * @DateUpdate 28 lug 2021
 * @Description prima versione
 *
 */
@Data
public class FeeClientDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 43603310874724218L;
	
	String feeCode;
	
	String description;
	
	Float amount;
	
	String currency;
}
