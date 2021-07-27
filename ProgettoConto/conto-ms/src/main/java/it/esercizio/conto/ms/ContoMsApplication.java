package it.esercizio.conto.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * ContoMsApplication.java
 *
 * @Change
 * @history
 * @author Inmatica SpA - ldemartinis
 * @version 1.0
 * @DateUpdate 21 lug 2021
 * @Description prima versione
 * 
 */
@EnableFeignClients(basePackages = {"it.esercizio.conto.feign.client", })
@EntityScan("it.esercizio.conto.entities")  
@SpringBootApplication
@EnableJpaRepositories("it.esercizio.conto.repository")
@ComponentScan(basePackages = { "it.esercizio.conto.***"})
public class ContoMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContoMsApplication.class, args);
	}

}
