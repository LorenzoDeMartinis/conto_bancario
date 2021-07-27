package it.esercizio.conto.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="d_lettura_transazioni_pk")
public class DLetturaTransazioniPk {

	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="idLetturaTransazionePk")
	 private Long idLetturaTransazione;
	 
	 @Column(name="utente_ultima_modifica")
	 private String utenteUltimaModifica;
	 
	 @Column(name="data_ultima_modifica")
	 private Date dataUltimaModifica;
	 
	//bi-directional many-to-one association to DLetturaTransazioni
	@OneToMany(mappedBy="dLetturaTransazioniPk")
	public List<DLetturaTransazioni> dLetturaTransazioni;
}
