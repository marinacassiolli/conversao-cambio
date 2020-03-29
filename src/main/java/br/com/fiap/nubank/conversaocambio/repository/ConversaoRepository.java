package br.com.fiap.nubank.conversaocambio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.nubank.conversaocambio.model.Conversao;

public interface ConversaoRepository extends 
	JpaRepository<Conversao, Long> {
	
	Conversao findTopByOrderByIdDesc();
}
