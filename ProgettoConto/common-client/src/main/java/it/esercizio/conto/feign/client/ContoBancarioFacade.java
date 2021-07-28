package it.esercizio.conto.feign.client;

import java.time.LocalDate;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import feign.FeignException;
import it.esercizio.conto.dto.ContentWrapperDTO;
import it.esercizio.conto.dto.ContentWrapperListDTO;
import it.esercizio.conto.dto.CreazioneBonificoInputDTO;
import it.esercizio.conto.dto.CreazioneBonificoOutputDTO;
import it.esercizio.conto.dto.LetturaSaldoDTO;
import it.esercizio.conto.dto.LetturaTransazioniOutputDTO;

/**
 * ContoFacade.java
 *
 * client per l'invocazione delle api esposte da Fabrick
 *
 * @Change
 * @history
 * @author Inmatica SpA - ldemartinis
 * @version 1.0
 * @DateUpdate 22 lug 2020
 * @Description prima versione
 * 
 */
@FeignClient(value = "${fabrick.client.name.contobancario}", url = "${fabrick.client.baseurl}")
public interface ContoBancarioFacade {
	
	//invocazione API https://docs.fabrick.com/platform/apis/gbs-banking-account-cash-v4.0
	@GetMapping(value = "${fabrick.client.letturasaldo}", consumes = "application/json")
	ContentWrapperDTO<LetturaSaldoDTO> letturaSaldo(@RequestParam("accountId") Long accountId,
			@RequestHeader("Api-Key") String userKey,@RequestHeader("Auth-Schema") String authschema);

	//invocazione API https://docs.fabrick.com/platform/apis/gbs-banking-payments-moneyTransfers-v4.0
	@PostMapping(value = "${fabrick.client.creazionebonifico}", consumes = "application/json")
	ContentWrapperDTO<CreazioneBonificoOutputDTO> creazioneBonifico(@RequestBody  CreazioneBonificoInputDTO input,
			@RequestParam("accountId") Long accountId,@RequestHeader("Api-Key") String userKey,
			@RequestHeader("Auth-Schema") String authschema,
			@RequestHeader("X-Time-Zone")String xTimeZone) throws FeignException;

	//invocazione API https://docs.fabrick.com/platform/apis/gbs-banking-account-cash-v4.0
	@GetMapping(value = "${fabrick.client.letturatransazioni}", consumes = "application/json")
	ContentWrapperListDTO<LetturaTransazioniOutputDTO> letturaTransazioni(@RequestParam("accountId") Long accountId,
			@RequestParam("fromAccountingDate")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  
		LocalDate fromAccountingDate,@RequestParam("toAccountingDate")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) 
		LocalDate toAccountingDate,	@RequestHeader("Api-Key") String userKey,@RequestHeader("Auth-Schema") String authschema);

	
}
