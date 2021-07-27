package it.eservizio.conto.domain;

import it.esercizio.conto.entities.DLetturaTransazioni;
import it.esercizio.conto.entities.DTransactionType;
import lombok.Data;

@Data
public class LetturaTransazioniDomain extends DLetturaTransazioni{
	
	private DTransactionType type;

}