package it.esercizio.conto.assembler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import it.esercizio.conto.dto.ContentWrapperDTO;
import it.esercizio.conto.dto.ContentWrapperListDTO;
import it.esercizio.conto.dto.LetturaSaldoDTO;
import it.esercizio.conto.dto.LetturaTransazioniOutputDTO;
import it.esercizio.conto.dto.PayLoadListDTO;
import it.esercizio.conto.dto.TransactionTypeDTO;
import it.esercizio.conto.dto.client.LetturaSaldoClientDTO;
import it.esercizio.conto.dto.client.LetturaTransazioniClientDTO;
import it.esercizio.conto.entities.DTransactionType;
import it.eservizio.conto.domain.LetturaSaldoDomain;
import it.eservizio.conto.domain.LetturaTransazioniDomain;

@Component
public class ContoBancarioAssembler {

	/**assemblo l'entita di dominio nel dto che tornerà in output dal servizio
	 * 
	 * @param letturaSaldoDomain
	 * @return
	 */
	public LetturaSaldoClientDTO assemblerLetturaSaldoDTO(LetturaSaldoDomain letturaSaldoDomain) {
		LetturaSaldoClientDTO dto = new LetturaSaldoClientDTO();
		dto.setAvailableBalance(letturaSaldoDomain.getAvailableBalance());
		dto.setBalance(letturaSaldoDomain.getBalance());
		dto.setCurrency(letturaSaldoDomain.getCurrency());
		dto.setDate(letturaSaldoDomain.getDate());
		return dto;
	}
	/**assemblo il dto di output del servizio fabrick nell'entità di dominio
	 * 
	 * @param letturaSaldoDomain
	 * @param output
	 * @return
	 */
	public LetturaSaldoDomain assemblerLetturaSaldoDomain(ContentWrapperDTO<LetturaSaldoDTO> output) {
		LetturaSaldoDomain letturaSaldoDomain = new LetturaSaldoDomain();
		
		LetturaSaldoDTO payLoad = output.getPayload();
		letturaSaldoDomain.setAvailableBalance(payLoad.getAvailableBalance());
		letturaSaldoDomain.setBalance(payLoad.getBalance());
		letturaSaldoDomain.setCurrency(payLoad.getCurrency());
		letturaSaldoDomain.setDate(payLoad.getDate());
		
		return letturaSaldoDomain;
	}
	
	/**assemblo il dto di output del servizio fabrick nell'entità di dominio
	 * 
	 * @param output
	 * @return
	 */
	public List<LetturaTransazioniDomain> assemblerLetturaTransazioniDomain(ContentWrapperListDTO<LetturaTransazioniOutputDTO> output) {
		List<LetturaTransazioniDomain> domainList = new ArrayList<LetturaTransazioniDomain>();
		
		PayLoadListDTO<LetturaTransazioniOutputDTO> payLoad = output.getPayload();
		
		for(LetturaTransazioniOutputDTO dto : payLoad.getList()){
			LetturaTransazioniDomain letturaTransazioniDomain = new LetturaTransazioniDomain();
			letturaTransazioniDomain.setAccountingDate(dto.getAccountingDate());
			letturaTransazioniDomain.setCurrency(dto.getCurrency());
			letturaTransazioniDomain.setDescription(dto.getDescription());
			letturaTransazioniDomain.setOperationId(dto.getOperationId());
			letturaTransazioniDomain.setTransactionId(dto.getTransactionId());
			letturaTransazioniDomain.setType(assembleTransactionType(dto.getType()));
			letturaTransazioniDomain.setValueDate(dto.getValueDate());
			domainList.add(letturaTransazioniDomain);
		}
		
		
		return domainList;
	}
	/**
	 * 
	 * @param transactionType
	 * @return
	 */
	public DTransactionType assembleTransactionType(TransactionTypeDTO transactionType) {
		DTransactionType transactionTypeDomain = new DTransactionType();
		transactionTypeDomain.setEnumeration(transactionType.getEnumeration());
		transactionTypeDomain.setValue(transactionType.getValue());
		return transactionTypeDomain;
	}
	/**
	 * 
	 * @param transactionType
	 * @return
	 */
	public  TransactionTypeDTO assembleTransactionTypeDTO(DTransactionType transactionType) {
		TransactionTypeDTO transactionTypeDto = new TransactionTypeDTO(transactionType.getEnumeration(),
				transactionType.getValue());
		return transactionTypeDto;
	}
	/**assemblo l'entita di dominio nel dto che tornerà in output dal servizio
	 * 
	 * @param listaDomini
	 * @return
	 */
	public List<LetturaTransazioniClientDTO> assemblerLetturaTransazioniClientDTO(List<LetturaTransazioniDomain> listaDomini){
		List<LetturaTransazioniClientDTO> listDto = new ArrayList<LetturaTransazioniClientDTO>();
		
		for(LetturaTransazioniDomain dominio : listaDomini) {
			LetturaTransazioniClientDTO dto = new LetturaTransazioniClientDTO();
			dto.setAccountingDate(dominio.getAccountingDate());
			dto.setCurrency(dominio.getCurrency());
			dto.setDescription(dominio.getDescription());
			dto.setOperationId(dominio.getOperationId());
			dto.setTransactionId(dominio.getTransactionId());
			dto.setType(assembleTransactionTypeDTO(dominio.getType()));
			dto.setValueDate(dominio.getValueDate());
			listDto.add(dto);
			
		}
		
		return listDto;
	}
}
