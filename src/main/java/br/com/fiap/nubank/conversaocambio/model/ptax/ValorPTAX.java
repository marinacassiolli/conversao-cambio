package br.com.fiap.nubank.conversaocambio.model.ptax;

import java.util.ArrayList;

public class ValorPTAX {
	
	private ArrayList<CotacaoPTAX> value;

	public ValorPTAX() { }
	
	public ValorPTAX(ArrayList<CotacaoPTAX> value) {
		super();
		this.value = value;
	}

	public ArrayList<CotacaoPTAX> getValue() {
		return value;
	}

	public void setValue(ArrayList<CotacaoPTAX> value) {
		this.value = value;
	}
	
	
}
