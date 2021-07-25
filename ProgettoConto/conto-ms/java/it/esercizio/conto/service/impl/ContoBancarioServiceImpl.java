package it.esercizio.conto.service.impl;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import it.esercizio.conto.dto.ContentWrapperDTO;
import it.esercizio.conto.dto.ContentWrapperListDTO;
import it.esercizio.conto.dto.CreazioneBonificoInputDTO;
import it.esercizio.conto.dto.CreazioneBonificoOutputDTO;
import it.esercizio.conto.dto.LetturaSaldoDTO;
import it.esercizio.conto.dto.LetturaTransazioniOutputDTO;
import it.esercizio.conto.feign.client.ContoBancarioFacade;
import it.esercizio.conto.service.ContoBancarioService;

@Service
@Transactional(rollbackOn = Exception.class)
public class ContoBancarioServiceImpl implements ContoBancarioService {

	@Autowired
	ContoBancarioFacade	contoBancarioFacade;
	
	@Value("${accountId}")
	private Long accountId;
	@Value("${fabrick.client.apikey}")
	private String apikey;
	@Value("${fabrick.client.authschema}")
	private String authSchema;
	
	
	@Override
	public ContentWrapperDTO<LetturaSaldoDTO> letturaSaldo() {
		return this.contoBancarioFacade.letturaSaldo(accountId, apikey,authSchema);
	}


	@Override
	public ContentWrapperDTO<CreazioneBonificoOutputDTO> creazioneBonifico(CreazioneBonificoInputDTO input) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public ContentWrapperListDTO<LetturaTransazioniOutputDTO> letturaTransazioni(LocalDate fromAccountingDate,LocalDate toAccountingDate) {
		return this.contoBancarioFacade.letturaTransazioni(accountId, fromAccountingDate,
				toAccountingDate, apikey, authSchema);
		
	}

}
