package br.com.fiap.nubank.conversaocambio.model;

public final class Taxa {
	
	public static final double SPREAD = 0.04;
	public static final double IOF = 0.0638;
	public static final double TAXAS_PARA_CALCULO = (SPREAD + IOF) + 1; 
	
}
