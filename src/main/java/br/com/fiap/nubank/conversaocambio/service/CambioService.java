package br.com.fiap.nubank.conversaocambio.service;

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
	 
	public Cotacao getCambioDiaAnterior(String moeda, String dataDiaAnterior) {
		final String uri = urlBcbApiConversao
		 		+ "(moeda=@moeda,dataCotacao=@dataCotacao)?"
		 		+ "@moeda='"+ moeda.toUpperCase() +"'&"
		 		+ "@dataCotacao='" + dataDiaAnterior + "'&"
		 		+ "$top=1&"
		 		+ "$orderby=dataHoraCotacao desc&"
		 		+ "$format=json&"
		 		+ "$select=cotacaoCompra";

		CotacaoPTAX resultado = restTemplate
				 .getForObject(uri, ValorPTAX.class)
				 .getValue()
				 .get(0);
		 
		return new Cotacao(moeda, resultado.getCotacaoCompra());
	 }
}
