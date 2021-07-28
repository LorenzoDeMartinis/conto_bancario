package it.esercizio.conto.dto.client;

import java.io.Serializable;

import lombok.Data;
/**
 * ErrorClientDTO.java
 * classe per rappresentazione codice e descrizione dell'errore
 * @Change @history
 * @author ldemartinis
 * @version     1.0
 * @DateUpdate 28 lug 2021
 * @Description prima versione
 *
 */
@Data
public class ErrorClientDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3320792720047061162L;
	
	private String code;
	
	private String description;

}
