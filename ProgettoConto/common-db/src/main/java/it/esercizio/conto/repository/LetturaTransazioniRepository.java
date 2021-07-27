package it.esercizio.conto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.esercizio.conto.entities.DLetturaTransazioni;

@Repository
public interface LetturaTransazioniRepository extends JpaRepository<DLetturaTransazioni, Long>{

}
