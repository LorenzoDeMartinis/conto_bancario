package it.esercizio.conto.service.impl;

import static it.esercizio.conto.common.Costanti.UTENTE_ADMIN;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import feign.FeignException;
import it.esercizio.conto.dto.ContentWrapperDTO;
import it.esercizio.conto.dto.ContentWrapperListDTO;
import it.esercizio.conto.dto.CreazioneBonificoInputDTO;
import it.esercizio.conto.dto.CreazioneBonificoOutputDTO;
import it.esercizio.conto.dto.LetturaSaldoDTO;
import it.esercizio.conto.dto.LetturaTransazioniOutputDTO;
import it.esercizio.conto.entities.DLetturaTransazioni;
import it.esercizio.conto.entities.DLetturaTransazioniPk;
import it.esercizio.conto.feign.client.ContoBancarioFacade;
import it.esercizio.conto.repository.LetturaTransazioniRepository;
import it.esercizio.conto.service.ContoBancarioService;

@Service
@Transactional(rollbackOn = Exception.class)
public class ContoBancarioServiceImpl implements ContoBancarioService {

	@Autowired
	ContoBancarioFacade	contoBancarioFacade;
	
	@Autowired
	LetturaTransazioniRepository letturaTransazioniRepository;
	
	@Value("${accountId}")
	private Long accountId;
	
	@Value("${fabrick.client.apikey}")
	private String apikey;
	
	@Value("${fabrick.client.authschema}")
	private String authSchema;
	
	@Value("${fabrick.client.xtimezone}")
	private String xTimeZone;
	
	@Override
	public ContentWrapperDTO<LetturaSaldoDTO> letturaSaldo() {
		//istanzio l'entita di dominio e la assemblo con le informazioni in output del servizio
		return 	this.contoBancarioFacade.letturaSaldo(accountId, apikey,authSchema);
	}




	@Override
	public ContentWrapperDTO<CreazioneBonificoOutputDTO> creazioneBonifico(CreazioneBonificoInputDTO input) throws FeignException {
		return this.contoBancarioFacade.creazioneBonifico(input, accountId, apikey, authSchema,xTimeZone);
	}


	@Override
	public ContentWrapperListDTO<LetturaTransazioniOutputDTO> letturaTransazioni(LocalDate fromAccountingDate,LocalDate toAccountingDate) {
		ContentWrapperListDTO<LetturaTransazioniOutputDTO> outputList = 
				this.contoBancarioFacade.letturaTransazioni(accountId, fromAccountingDate,toAccountingDate, apikey, authSchema);
		
		this.storicizza(outputList.getPayload().getList().stream().map(output ->{
			DLetturaTransazioni transazione = new DLetturaTransazioni();
			transazione.setCurrency(output.getCurrency());
			transazione.setAccountingDate(output.getAccountingDate());
			transazione.setDescription(output.getDescription());
			transazione.setOperationId(output.getOperationId());
			transazione.setTransactionId(output.getTransactionId());
			transazione.setType(null);
			transazione.setValueDate(output.getValueDate());
			return transazione;
		}).collect(Collectors.toList()));
		
		return outputList;
		
	}

	public Boolean storicizza(List<DLetturaTransazioni> transazioni) {
		
		for(DLetturaTransazioni transazione : transazioni) {
			DLetturaTransazioniPk pk = new DLetturaTransazioniPk();
			pk.setUtenteUltimaModifica(UTENTE_ADMIN);
			pk.setDataUltimaModifica(new Date());
			transazione.setDLetturaTransazioniPk(pk);
			this.letturaTransazioniRepository.save(transazione);
		}
		
		return null;
	}
}
