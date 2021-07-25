package it.esercizio.conto.service;

import java.time.LocalDate;
import java.util.List;

import it.esercizio.conto.dto.ContentWrapperDTO;
import it.esercizio.conto.dto.ContentWrapperListDTO;
import it.esercizio.conto.dto.CreazioneBonificoInputDTO;
import it.esercizio.conto.dto.CreazioneBonificoOutputDTO;
import it.esercizio.conto.dto.LetturaSaldoDTO;
import it.esercizio.conto.dto.LetturaTransazioniOutputDTO;

/**
 * ContoBancarioService.java 
 * interfaccia del service delle operazioni di logica di business per il conto bancario
 * 
 * @Change @history
 * @author      Inmatica SpA - ldemartinis
 * @version     1.0
 * @DateUpdate  22 lug 2021
 * @Description prima versione
 */
public interface ContoBancarioService {

	/**metodo per la lettura del saldo bancario
	 * 
	 * @param accountId
	 * @return
	 */
	public ContentWrapperDTO<LetturaSaldoDTO> letturaSaldo();
	
	/**metodo per creazione bonifico
	 * 
	 * @param input
	 * @return
	 */
	public ContentWrapperDTO<CreazioneBonificoOutputDTO> creazioneBonifico(CreazioneBonificoInputDTO input);
	
	/**metodo per lettura transazioni
	 * 
	 * @param input
	 */
	public ContentWrapperListDTO<LetturaTransazioniOutputDTO> letturaTransazioni(LocalDate fromAccountingDate,LocalDate toAccountingDate);
	
}
