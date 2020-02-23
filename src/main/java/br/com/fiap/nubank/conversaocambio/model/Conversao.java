package br.com.fiap.nubank.conversaocambio.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Conversao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	private String moeda;
	
	@NotNull
	private double valorVendaMoeda;
	
	@NotNull
	private double quantidade;
	
	private double valorTotalComTaxas;	
	private String dataHora;
	private double spread;
	private double iof;
	
	public Conversao() { 
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date dataAtual = new Date(System.currentTimeMillis());
		
		this.dataHora = formatter.format(dataAtual);
		this.spread = 0.04;
		this.iof = 0.0638;
	}

	public long getId() {
		return id;
	}

	public String getMoeda() {
		return moeda;
	}

	public void setMoeda(String moeda) {
		this.moeda = moeda.toUpperCase();
	}

	public double getValorVendaMoeda() {
		return valorVendaMoeda;
	}

	public void setValorVendaMoeda(double valorVendaMoeda) {
		this.valorVendaMoeda = valorVendaMoeda;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorTotalComTaxas() {
		return valorTotalComTaxas;
	}

	public void setValorTotalComTaxas() {
		this.valorTotalComTaxas = 
				(valorVendaMoeda * (iof + spread + 1)) * quantidade;;
	}

	public String getDataHora() {
		return dataHora;
	}

	public double getSpread() {
		return spread;
	}

	public double getIof() {
		return iof;
	}

}
