package br.com.fiap.nubank.conversaocambio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;

import br.com.fiap.nubank.conversaocambio.controller.ConversaoCambioController;
import br.com.fiap.nubank.conversaocambio.model.Conversao;
import br.com.fiap.nubank.conversaocambio.service.ConversaoServiceImpl;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(ConversaoCambioController.class)
public class ConversaoCambioControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private ConversaoServiceImpl service;
	
	Conversao conversaoBody = null;
	
	@BeforeEach
	public void setUp() throws Exception {
		conversaoBody = new Conversao();

		conversaoBody.setMoeda("usd");
		conversaoBody.setValorVendaMoeda(4.00);
		conversaoBody.setQuantidade(100);
	}
	
	@Test
	void whenPostConversao_thenCreateConversao() throws Exception {
		Gson gson = new Gson();
		
		given(service.converter(Mockito.any())).willReturn(conversaoBody);
		
		mvc.perform(post("/conversao")
				.contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(conversaoBody)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.moeda", is("USD")));
		 
	    verify(service, VerificationModeFactory.times(1)).converter(Mockito.any());
        
        reset(service);
	}

	@Test
	void givenConversao_whenGetConversao_thenReturnHistorico() throws Exception {
		List<Conversao> historico = new ArrayList<Conversao>();
		historico.add(conversaoBody);
		
        given(service.buscarHistorico()).willReturn(historico);

        mvc.perform(get("/conversao/historico")
        		.contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].moeda", is(conversaoBody.getMoeda())));
        
        verify(service, VerificationModeFactory.times(1)).buscarHistorico();
        
        reset(service);
	}

}
