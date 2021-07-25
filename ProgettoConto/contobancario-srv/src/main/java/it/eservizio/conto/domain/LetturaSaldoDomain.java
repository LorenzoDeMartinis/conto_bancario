package it.eservizio.conto.domain;

import java.util.Date;

import lombok.Data;

@Data
public class LetturaSaldoDomain{


	private Date date;
	
	private Float balance;
	
	private Float availableBalance;
	
	private String currency;
}
