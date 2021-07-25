package it.esercizio.conto.controller;

import static it.esercizio.conto.common.Costanti.BONIFICO;
import static it.esercizio.conto.common.Costanti.LETTURA_SALDO;
import static it.esercizio.conto.common.Costanti.LISTA_TRANSAZIONI;
import static it.esercizio.conto.common.Costanti.URL_BASE_CONTO;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.esercizio.conto.assembler.ContoBancarioAssembler;
import it.esercizio.conto.dto.client.LetturaSaldoClientDTO;
import it.esercizio.conto.dto.client.LetturaTransazioniClientDTO;
import it.esercizio.conto.service.ContoBancarioService;

/**
 * ContoController.java
 * @Change @history
 * @author ldemartinis
 * @version     1.0
 * @DateUpdate 21 lug 2021
 * @Description prima versione
 *
 */

@RestController
@RequestMapping(value = URL_BASE_CONTO)
public class ContoController {

	@Autowired
	ContoBancarioService	contoBancarioService;
	
	@Autowired
	ContoBancarioAssembler	contoBancarioAssembler;
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = LETTURA_SALDO, method = RequestMethod.GET,
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody LetturaSaldoClientDTO letturaSaldo(HttpServletRequest request) {
		return  this.contoBancarioAssembler.assemblerLetturaSaldoDTO(
				this.contoBancarioAssembler.assemblerLetturaSaldoDomain(this.contoBancarioService.letturaSaldo()));
	}
	
	/**
	 * 
	 * @param fromAccountingDate
	 * @param toAccountingDate
	 * @param request
	 * @return
	 */
	@RequestMapping(value = LISTA_TRANSAZIONI, method = RequestMethod.GET,	produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<LetturaTransazioniClientDTO>  listaTransazioni
	(@RequestParam("fromAccountingDate")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  
	LocalDate fromAccountingDate,@RequestParam("toAccountingDate")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) 
	LocalDate toAccountingDate,HttpServletRequest request)  {
		return this.contoBancarioAssembler.assemblerLetturaTransazioniClientDTO(
				this.contoBancarioAssembler.assemblerLetturaTransazioniDomain(
						(this.contoBancarioService.letturaTransazioni(fromAccountingDate,toAccountingDate))));
	}
	
	
	
	@RequestMapping(value = BONIFICO, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void bonifico(@RequestBody Long identificativoDTO,HttpServletRequest request){
		
	}
	
}
