package it.esercizio.conto.assembler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import it.esercizio.conto.dto.AccountDTO;
import it.esercizio.conto.dto.AmountDTO;
import it.esercizio.conto.dto.ContentWrapperDTO;
import it.esercizio.conto.dto.ContentWrapperListDTO;
import it.esercizio.conto.dto.CreazioneBonificoInputDTO;
import it.esercizio.conto.dto.CreazioneBonificoOutputDTO;
import it.esercizio.conto.dto.FeeDTO;
import it.esercizio.conto.dto.LetturaSaldoDTO;
import it.esercizio.conto.dto.LetturaTransazioniOutputDTO;
import it.esercizio.conto.dto.PayLoadListDTO;
import it.esercizio.conto.dto.PersonDTO;
import it.esercizio.conto.dto.TransactionTypeDTO;
import it.esercizio.conto.dto.client.AmountClientDTO;
import it.esercizio.conto.dto.client.BonificoClientDTO;
import it.esercizio.conto.dto.client.CreazioneBonificoClientDTO;
import it.esercizio.conto.dto.client.FeeClientDTO;
import it.esercizio.conto.dto.client.LetturaSaldoClientDTO;
import it.esercizio.conto.dto.client.LetturaTransazioniClientDTO;
import it.esercizio.conto.dto.client.PersonClientDTO;
import it.esercizio.conto.entities.DTransactionType;
import it.eservizio.conto.domain.LetturaSaldoDomain;
import it.eservizio.conto.domain.LetturaTransazioniDomain;

@Component
public class ContoBancarioAssembler {

	private String CREDITOR_NAME 	= 	"John Doe";
	private String ACCOUNT_CODE 	= 	"IT23A0336844430152923804660";
	private String BIT_CODE			=	"SELBIT2BXXX";
	
	public CreazioneBonificoClientDTO assemblerCreazioneBonificoClient(ContentWrapperDTO<CreazioneBonificoOutputDTO> input) {
		CreazioneBonificoClientDTO creazioneBonificoOutput = new CreazioneBonificoClientDTO();
		CreazioneBonificoOutputDTO inputDto = input.getPayload();
		
		creazioneBonificoOutput.setAccountedDatetime(inputDto.getAccountedDatetime());
		creazioneBonificoOutput.setAmount(assemblerAmountClient(inputDto.getAmount()));
		creazioneBonificoOutput.setCreatedDatetime(inputDto.getCreatedDatetime());
		creazioneBonificoOutput.setCreditor(assemblerPersonClient(inputDto.getCreditor()));
		creazioneBonificoOutput.setCro(inputDto.getCro());
		creazioneBonificoOutput.setDebtor(assemblerPersonClient(inputDto.getDebtor()));
		creazioneBonificoOutput.setDebtorValueDate(inputDto.getDebtorValueDate());
		creazioneBonificoOutput.setDescription(inputDto.getDescription());
		creazioneBonificoOutput.setDirection(inputDto.getDirection());
		creazioneBonificoOutput.setFeeAccountId(inputDto.getFeeAccountId());
		creazioneBonificoOutput.setFees(assemblerFeesClient(inputDto.getFees()));
		creazioneBonificoOutput.setFeeType(inputDto.getFeeType());
		creazioneBonificoOutput.setHasTaxRelief(inputDto.getHasTaxRelief());
		creazioneBonificoOutput.setIsInstant(inputDto.getIsInstant());
		creazioneBonificoOutput.setIsUrgent(inputDto.getIsUrgent());
		creazioneBonificoOutput.setMoneyTransferId(inputDto.getMoneyTransferId());
		creazioneBonificoOutput.setStatus(inputDto.getStatus());
		creazioneBonificoOutput.setTrn(inputDto.getTrn());
		creazioneBonificoOutput.setUri(inputDto.getUri());
		
		return creazioneBonificoOutput;
	}
	/**assembler amount
	 * 
	 * @param input
	 * @return
	 */
	public AmountClientDTO assemblerAmountClient(AmountDTO input) {
		AmountClientDTO clientDto = new AmountClientDTO();
		clientDto.setCreditorAmount(input.getCreditorAmount());
		clientDto.setCreditorCurrency(input.getCreditorCurrency());
		clientDto.setCreditorCurrencyDate(input.getCreditorCurrencyDate());
		clientDto.setDebtorAmount(input.getDebtorAmount());
		clientDto.setDebtorCurrency(input.getDebtorCurrency());
		clientDto.setExchangeRate(input.getExchangeRate());
		return clientDto;
	}
	
	/**Assembler Person
	 * 
	 * @param input
	 * @return
	 */
	public PersonClientDTO assemblerPersonClient(PersonDTO input) {
		PersonClientDTO personDto = new PersonClientDTO();
		personDto.setAccount(input.getAccount());
		personDto.setName(input.getName());
		return personDto;
		
	}
	/**assembler Fee
	 * 
	 * @param input
	 * @return
	 */
	public List<FeeClientDTO> assemblerFeesClient(List<FeeDTO> input){
		List<FeeClientDTO> listFee = new ArrayList<FeeClientDTO>();
		input.forEach(fee->{
			FeeClientDTO feeDto = new FeeClientDTO();
			feeDto.setAmount(fee.getAmount());
			feeDto.setCurrency(fee.getCurrency());
			feeDto.setDescription(fee.getDescription());
			feeDto.setFeeCode(fee.getFeeCode());
		});
		return listFee;
		
	}
	/**assembler BonificoClientDTO to CreazioneBonificoInputDTO
	 * 
	 * @param input
	 * @return
	 */
	public CreazioneBonificoInputDTO assemblerCreazioneBonifico(BonificoClientDTO input) {
		CreazioneBonificoInputDTO bonifico = new CreazioneBonificoInputDTO();
		bonifico.setAmount(input.getAmount());
		bonifico.setCreditor(assemblerCreditor());
		bonifico.setCurrency(input.getCurrency());
		bonifico.setDescription(input.getDescription());
		bonifico.setExecutionDate(input.getExecutionDate());
		bonifico.setReciverName(input.getReciverName());
		return bonifico;
	}
	/**assembler CreditorClientDTO to CreditorDTO
	 * 
	 * @param input
	 * @return
	 */
	public PersonDTO assemblerCreditor() {
		PersonDTO creditor = new PersonDTO();
		creditor.setAccount(assemblerAccount());
		creditor.setName(CREDITOR_NAME);
		return creditor;
	}
	/**assembler AccountClientDTO to AccountDTO
	 * 
	 * @param input
	 * @return
	 */
	public AccountDTO assemblerAccount() {
		AccountDTO account = new AccountDTO();
		account.setAccountCode(ACCOUNT_CODE);
		account.setBicCode(BIT_CODE);
		return account;		
	}
	
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
