package it.esercizio.conto.dto.client;

import java.io.Serializable;

import it.esercizio.conto.dto.AccountDTO;
import lombok.Data;
/**
 * CreditorDTO.java 
 * classe dto per i dati del creditore e debitors
 * 
 * @Change @history
 * @author      Inmatica SpA - ldemartinis
 * @version     1.0
 * @DateUpdate  28 lug 2021
 * @Description prima versione
 */
@Data
public class PersonClientDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -593036623891377942L;

	private String name;
	
	private AccountDTO account;
}
