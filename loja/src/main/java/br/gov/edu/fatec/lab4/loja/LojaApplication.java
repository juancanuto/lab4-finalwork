package br.gov.edu.fatec.lab4.loja;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LojaApplication {
	
	@PostConstruct
	void started() {
	    TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
	}
	 
	public static void main(String[] args) {
		SpringApplication.run(LojaApplication.class, args);
	}
}
