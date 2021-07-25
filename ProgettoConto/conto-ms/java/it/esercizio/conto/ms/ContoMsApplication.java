package it.esercizio.conto.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

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
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableFeignClients(basePackages = {"it.esercizio.conto.feign.client", })
@SpringBootApplication
@ComponentScan(basePackages = { "it.esercizio.conto.***"})
public class ContoMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContoMsApplication.class, args);
	}

}
