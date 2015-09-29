package br.com.caelum.argentum.modelo;

import java.util.Calendar;


public class CandleBuilder {
	
	private double abertura;
	private boolean isAberturaSet;
	private double fechamento;
	private boolean isFechamentoSet;
	private double minimo;
	private boolean isMinimoSet;
	private double maximo;
	private boolean isMaximoSet;
	private double volume;
	private boolean isVolumeSet;
	private Calendar data;
	private boolean isDataSet;
	
	public CandleBuilder comAbertura(double abertura){
		this.isAberturaSet = true;
		this.abertura = abertura;
		return this;
	}
	public CandleBuilder comFechamento(double fechamento){
		this.isFechamentoSet = true;
		this.fechamento = fechamento;
		return this;
	}
	public CandleBuilder comMinimo(double minimo){
		this.isMinimoSet = true;
		this.minimo = minimo;
		return this;
	}
	public CandleBuilder comMaximo(double maximo){
		this.isMaximoSet = true;
		this.maximo = maximo;
		return this;
	}
	public CandleBuilder comVolume(double volume){
		this.isVolumeSet = true;
		this.volume = volume;
		return this;
	}
	public CandleBuilder comData(Calendar data){
		this.isDataSet = true;
		this.data = data;
		return this;
	}
	
	public Candlestick geraCandle(){
		if (isAberturaSet && isFechamentoSet && isMinimoSet && isMaximoSet && isVolumeSet && isDataSet){
			return new Candlestick(abertura,fechamento,minimo,maximo,volume,data);
		}else{
			throw new IllegalStateException("Os dados do candle não estão completos!");
		}
	}
}