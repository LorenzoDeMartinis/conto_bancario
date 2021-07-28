package it.esercizio.conto.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * PayLoadListDTO.java 
 * classe contenitore del body di response
 * 
 * @Change @history
 * @author      Inmatica SpA - ldemartinis
 * @version     1.0
 * @DateUpdate  28 lug 2021
 * @Description prima versione
 */
@Data
public class PayLoadListDTO<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7273832790011386301L;
	
	private List<T> list;
}
