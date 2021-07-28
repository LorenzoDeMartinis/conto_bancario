package it.esercizio.conto.dto.client;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
/**
 * BonificoClientDTO.java
 * classe per rappresentazioni informazioni bonifico
 * @Change @history
 * @author ldemartinis
 * @version     1.0
 * @DateUpdate 28 lug 2021
 * @Description prima versione
 *
 */
@Data
public class BonificoClientDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7772570639433177707L;
	
	@DateTimeFormat(pattern = "PATTERN")
	Date executionDate;
	
	private String description;
	
	private Long amount;
	
	private String currency;
	
	private String reciverName;
	
}
