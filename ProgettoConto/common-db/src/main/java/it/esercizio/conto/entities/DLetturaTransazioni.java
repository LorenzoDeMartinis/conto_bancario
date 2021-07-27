package it.esercizio.conto.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="d_lettura_transazioni_h")
public class DLetturaTransazioni {

	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="idLetturaTransazione")
	 private Long idLetturaTransazione;
	
	 //bi-directional many-to-one association to DLetturaTransazioniPk
	 @ManyToOne
	 @JoinColumn(name="FK_CONFIGURAZIONE_FUA_PK")
	 public DLetturaTransazioniPk dLetturaTransazioniPk;
	 
	 @Column(name="transaction_id")
	 private String transactionId;
	
	 @Column(name="operation_id")
	 private String operationId;
	
	 @Column(name="accounting_date")
	 private Date accountingDate;
	
	 @Column(name="value_date")
	 private Date valueDate;
	
	 @Column(name="type")
	 private Long type;
	
	 @Column(name="currency")
	 private String currency;
	
	 @Column(name="description")
	 private String description;
	 
	
}
