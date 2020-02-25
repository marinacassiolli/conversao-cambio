package br.com.fiap.nubank.conversaocambio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.GsonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.fiap.nubank.conversaocambio.controller.ConversaoCambioController;
import br.com.fiap.nubank.conversaocambio.model.Conversao;
import br.com.fiap.nubank.conversaocambio.service.ConversaoServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(ConversaoCambioController.class)
public class ConversaoCambioControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private ConversaoServiceImpl conversaoService;
	
	Conversao conversaoBody = null;
	
	@BeforeEach
	public void setUp() throws Exception {
		conversaoBody = new Conversao();

		conversaoBody.setMoeda("usd");
		conversaoBody.setValorVendaMoeda(4.00);
		conversaoBody.setQuantidade(100);
	}
	
	@Test
	void test() throws Exception {
		
		
	}

}
