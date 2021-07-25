package it.esercizio.conto.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * ContentWrapperListDTO.java
 * DTO wrapper per contenuto lista
 * @author ldemartinis
 *
 * @version 1.0
 * @DateUpdate  23 lug 2021
 * @description prima versione 
 */
@Data
public class ContentWrapperListDTO<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6369259843152963563L;

	private String status;
	
	private List<ErrorDTO> error;
	
	private PayLoadListDTO<T> payload;
	
}