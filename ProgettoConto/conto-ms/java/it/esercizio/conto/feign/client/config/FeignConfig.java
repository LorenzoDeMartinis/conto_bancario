package it.esercizio.conto.feign.client.config;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import feign.codec.Decoder;

/**
 * FeignConfig.java configurazioni feign client
 * 
 * @Change @history
 * @author Inmatica SpA - ldemartinis
 * @version 1.0
 * @DateUpdate 23 lug 2021
 * @Description prima versione
 */
@Configuration
public class FeignConfig {

	 
	
	public ObjectMapper customObjectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        //Customize as much as you want
        return objectMapper;
    }
}
