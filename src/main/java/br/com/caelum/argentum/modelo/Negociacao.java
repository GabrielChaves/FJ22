package br.com.caelum.argentum.modelo;

import java.util.Calendar;

public final class Negociacao implements Comparable<Negociacao> {
	private final double preco;
	private final int quantidade;
	private final Calendar data;
	
	public Negociacao(double preco, int quantidade, Calendar data) {
		if(data==null){
			throw new IllegalArgumentException("data não pode ser mula!");
		}
		
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}

	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Calendar getData() {
		return (Calendar) this.data.clone();
	}	
	
	//Métodos
	
	public double getVolume(){
		return preco * quantidade;
	}
	
	//Verifica se é do mesmo dia, mesme mês e mesmo ano
	public boolean isMesmoDia(Calendar outraData) {
		return 	data.get(Calendar.DATE) == outraData.get(Calendar.DATE) && 
		    	data.get(Calendar.MONTH) == outraData.get(Calendar.MONTH) &&
		    	data.get(Calendar.YEAR) == outraData.get(Calendar.YEAR);
	}
	
	@Override
	public int compareTo(Negociacao o) {
		
		if ( this.getData().after(o.getData()) )
			return 1;
		
		if ( this.getData().before(o.getData()) )
			return -1;
		
		return 0;
	}
}
