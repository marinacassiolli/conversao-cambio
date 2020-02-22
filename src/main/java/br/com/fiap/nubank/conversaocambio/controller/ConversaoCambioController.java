package br.com.fiap.nubank.conversaocambio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.nubank.conversaocambio.model.Cotacao;
import br.com.fiap.nubank.conversaocambio.service.CambioService;

@RestController
@RequestMapping("/cambio")
public class ConversaoCambioController {
	
	@Autowired
	public CambioService cambioService;
	
	@RequestMapping("/{moeda}")
	public Cotacao cotacaoCambioPTAX(
			@PathVariable String moeda
			, @RequestParam(required = true) String data) {
		
		return cambioService.getCambio(moeda, data);
	}	
}
