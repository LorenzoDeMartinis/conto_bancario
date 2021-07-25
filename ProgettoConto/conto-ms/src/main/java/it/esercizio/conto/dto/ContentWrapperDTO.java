package it.esercizio.conto.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * ContentWrapperDTO.java
 * DTO wrapper per contenuto
 * @author ldemartinis
 *
 * @version 1.0
 * @DateUpdate  23 lug 2021
 * @description prima versione 
 */
@Data
public class ContentWrapperDTO<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 136736282503920984L;

	private String status;
	
	private List<ErrorDTO> error;
	
	private T payload;
	
}
