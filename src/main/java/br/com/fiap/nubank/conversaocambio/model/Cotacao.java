package br.com.fiap.nubank.conversaocambio.model;

public class Cotacao {

	private String moeda;
	private double valorCompraCotacaoPtax;
	private double spread;
	private double iof;
	
	public Cotacao(String moeda, double valorCompraCotacaoPtax) {
		super();
		this.moeda = moeda;
		this.valorCompraCotacaoPtax = valorCompraCotacaoPtax;
		this.spread = Taxa.SPREAD;
		this.iof = Taxa.IOF;
	}

	public String getMoeda() {
		return moeda;
	}

	public void setMoeda(String moeda) {
		this.moeda = moeda;
	}

	public double getValorCompraCotacaoPtax() {
		return valorCompraCotacaoPtax;
	}

	public void setValorCompraCotacaoPtax(double valorCompraCotacaoPtax) {
		this.valorCompraCotacaoPtax = valorCompraCotacaoPtax;
	}

	public double getSpread() {
		return spread;
	}

	public double getIof() {
		return iof;
	}
	
}
