package it.esercizio.conto.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PayLoadListDTO<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7273832790011386301L;
	
	private List<T> list;
}
