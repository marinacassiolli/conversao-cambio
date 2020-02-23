package br.com.fiap.nubank.conversaocambio.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.fiap.nubank.conversaocambio.model.Conversao;

public interface ConversaoRepository extends 
	PagingAndSortingRepository<Conversao, Long> {

}
