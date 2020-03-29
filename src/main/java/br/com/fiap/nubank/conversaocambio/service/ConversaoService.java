package br.com.fiap.nubank.conversaocambio.service;

import br.com.fiap.nubank.conversaocambio.model.Conversao;

public interface ConversaoService { 

	public Conversao converter(Conversao conversaoBody);
	
	public Conversao buscarUltimaCotacao();
	
}
