package br.com.fiap.nubank.conversaocambio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.nubank.conversaocambio.model.Conversao;
import br.com.fiap.nubank.conversaocambio.repository.ConversaoRepository;

@Service
public class ConversaoService { 

	@Autowired
	private ConversaoRepository conversaoRepository;
	
	public Conversao converter(Conversao conversaoBody) {
		
		Conversao conversao = new Conversao();
		conversao.setMoeda(conversaoBody.getMoeda());
		conversao.setValorVendaMoeda(conversaoBody.getValorVendaMoeda());
		conversao.setQuantidade(conversaoBody.getQuantidade());
		conversao.setValorTotalComTaxas();
		
		conversaoRepository.save(conversao);
		
		return conversao;
	}

	public Iterable<Conversao> historico() {
		return conversaoRepository.findAll();
	}
}
