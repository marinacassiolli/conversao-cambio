package br.com.fiap.nubank.conversaocambio.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.fiap.nubank.conversaocambio.model.Cotacao;
import br.com.fiap.nubank.conversaocambio.model.ptax.CotacaoPTAX;
import br.com.fiap.nubank.conversaocambio.model.ptax.ValorPTAX;

@Service
public class CambioService { 
	
	@Autowired
	private RestTemplate restTemplate;
	 
	@Value(value = "${bcb.endpoint.url.conversao}")
	private String urlBcbApiConversao;
	 
	public Cotacao getCambio(String moeda, String data) {
		final String uri = urlBcbApiConversao
		 		+ "(moeda=@moeda,dataCotacao=@dataCotacao)?"
		 		+ "@moeda='"+ moeda.toUpperCase() +"'&"
		 		+ "@dataCotacao='" + data + "'&"
		 		+ "$top=1&"
		 		+ "$orderby=dataHoraCotacao desc&"
		 		+ "$format=json&"
		 		+ "$select=cotacaoCompra";

		ArrayList<CotacaoPTAX> resultado = restTemplate
				 .getForObject(uri, ValorPTAX.class)
				 .getValue();
		
		if (resultado.isEmpty()) return null;
		
		return new Cotacao(moeda, resultado.get(0).getCotacaoCompra());
	 }
}
