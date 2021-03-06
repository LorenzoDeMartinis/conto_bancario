package it.eservizio.conto.domain;

import it.esercizio.conto.entities.DLetturaTransazioni;
import it.esercizio.conto.entities.DTransactionType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class LetturaTransazioniDomain extends DLetturaTransazioni{
	
	private DTransactionType type;

}