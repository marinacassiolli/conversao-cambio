package br.com.fiap.nubank.conversaocambio.service;

import java.util.List;

import br.com.fiap.nubank.conversaocambio.model.Conversao;

public interface ConversaoService { 

	public Conversao converter(Conversao conversaoBody);
	
	public List<Conversao> buscarHistorico();
	
}
