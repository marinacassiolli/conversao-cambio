package br.com.fiap.nubank.conversaocambio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.nubank.conversaocambio.model.Conversao;
import br.com.fiap.nubank.conversaocambio.service.ConversaoService;

@CrossOrigin(origins = "*")
@RestController
public class ConversaoCambioController {
	
	@Autowired
	public ConversaoService conversaoService;
	
	@PostMapping("/conversao")
	public Conversao converterValor(@RequestBody Conversao conversaoBody) {
		return conversaoService.converter(conversaoBody);
	}
		
	@GetMapping("/conversao")
	public Conversao buscarUltimaCotacao() {
		return conversaoService.buscarUltimaCotacao();
	}
}
