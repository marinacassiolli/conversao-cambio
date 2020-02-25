package br.com.fiap.nubank.conversaocambio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.fiap.nubank.conversaocambio.model.Conversao;
import br.com.fiap.nubank.conversaocambio.service.ConversaoService;
import br.com.fiap.nubank.conversaocambio.service.ConversaoServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConversaoServiceImplTest {
	
	@TestConfiguration
	static class ConversaoServiceImplTestContextConfiguration {
		
		@Bean
		public ConversaoService conversaoService() {
			return new ConversaoServiceImpl();
		}
		
	}
	
	@Autowired
	private ConversaoService conversaoService;
	
	Conversao conversaoBody = null;
	
	@BeforeEach
	public void setUp() {
		conversaoBody = new Conversao();

		conversaoBody.setMoeda("usd");
		conversaoBody.setValorVendaMoeda(4.00);
		conversaoBody.setQuantidade(100);
	}
	
	@Test
	void test_converter() {
		// when
		Conversao conversao = conversaoService.converter(conversaoBody);
		
		// then
		assertEquals(conversaoBody.getMoeda(), conversao.getMoeda());
		assertEquals(conversaoBody.getValorVendaMoeda(), conversao.getValorVendaMoeda());
		assertEquals(conversaoBody.getQuantidade(), conversao.getQuantidade());
		assertTrue(conversao.getValorTotalComTaxas() > 0);
	}
	
	@Test
	void test_historico() {
		// when
		Iterable<Conversao> historico = conversaoService.buscarHistorico();
		
		// then
		assertEquals(conversaoBody.getId(), historico.iterator().next().getId());
	}

}
