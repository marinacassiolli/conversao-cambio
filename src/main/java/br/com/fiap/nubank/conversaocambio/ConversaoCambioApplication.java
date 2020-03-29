package br.com.fiap.nubank.conversaocambio;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConversaoCambioApplication {

	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("GMT-3:00"));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ConversaoCambioApplication.class, args);
	}

}
