package it.esercizio.conto.dto.client;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NonNull;

/**
 * FaultResponse.java 
 * risposte con errore
 * 
 * @Change @history
 * @author      Inmatica SpA - ldemartinis 
 * @version     1.0
 * @DateUpdate  27 lug 2021
 * @Description prima versione
 */
@Getter
public class FaultResponse {

	@NonNull
	@JsonProperty("code")
	private String errorCode;

	@NonNull
	@JsonProperty("description")
	private String errorDescription;
	
	public FaultResponse(String errorCode,String errorDescription) {
		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}
	
}
