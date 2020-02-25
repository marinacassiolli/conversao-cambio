package br.com.fiap.nubank.conversaocambio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.fiap.nubank.conversaocambio.model.Conversao;
import br.com.fiap.nubank.conversaocambio.repository.ConversaoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ConversaoRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ConversaoRepository conversaoRepository;

	@Test
	void test_saveRepository() {
		// given
		Conversao conversao = new Conversao();
		conversao.setMoeda("USD");
		conversao.setValorVendaMoeda(4);
		conversao.setQuantidade(100);
		
		conversaoRepository.save(conversao);
		
		// when
		Conversao found = conversaoRepository.findById(conversao.getId()).get();
		
		// then
		assertEquals(conversao.getMoeda(), found.getMoeda());
		assertEquals(conversao.getValorVendaMoeda(), found.getValorVendaMoeda());
		assertEquals(conversao.getQuantidade(), found.getQuantidade());
	}

}
