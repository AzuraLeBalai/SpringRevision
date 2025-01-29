package fr.butinfo.flight;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class ServiceEnregistrement {

	ObjectMapper mapper;
	String secret="xxxxx";

	//Pour permettre de ne pas péter avec les LocalTime
	public ServiceEnregistrement() {
		mapper = new ObjectMapper()
				.registerModule( new JavaTimeModule() )
				.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	}
	
	public String encodeCarte(CarteEmbarquement carte) {
		try {
			return mapper.writeValueAsString(carte);
		} catch (JsonProcessingException e) {
			throw new IllegalArgumentException("Impossible d'encoder cette carte", e);
		}
	}
	
	public String calculerEmpreinte(String value) {
		try {
			return Base64.getEncoder()
				.withoutPadding()
				.encodeToString( 
					MessageDigest.getInstance("SHA-256")
					.digest(value.getBytes(StandardCharsets.UTF_8))
				);
		} catch(NoSuchAlgorithmException e) {
			throw new IllegalArgumentException("Impossible de calculer l'empreinte de la carte d'embarquement", e);
		}
	}
    
	/*
	public String calculerEmpreinteSecurise(String value) {
		return calculerEmpreinte(secret+value);
	}
	*/
    
	public CarteEmbarquement lireEtVerifier(String json, String empreinte) {
		String expected = calculerEmpreinte(json);  // json+secret  ensuite
		if ( !expected.equals(empreinte) ) {
			throw new IllegalArgumentException("Empreinte incorrecte");
		}
		try {
			return mapper.readValue(json, CarteEmbarquement.class);
		} catch(JsonProcessingException e) {
			throw new IllegalArgumentException("Impossible de lire la carte d'embarquement", e);
		}
	}
}
