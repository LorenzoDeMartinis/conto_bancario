package it.esercizio.conto.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class DLetturaTransazioni {

	 @Id
	 @Column(name="SEQU_ID_LETTURA_TRANS")
	 private Long idLetturaTransazione;
	
	 @Column(name="TRANSACTION_ID")
	 private String transactionId;
	
	 @Column(name="OPERATION_ID")
	 private String operationId;
	
	 @Column(name="ACCOUNTING_DATE")
	 private Date accountingDate;
	
	 @Column(name="VALUE_DATE")
	 private Date valueDate;
	
	 @Column(name="TRANSACTION_TYPE")
	 private DTransactionType type;
	
	 @Column(name="CURRENCY")
	 private String currency;
	
	 @Column(name="DESCRIPTION")
	 private String description;
	
}
