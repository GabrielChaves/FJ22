package br.com.caelum.argentum.modelo;

import static org.junit.Assert.*;

import java.util.Calendar;



import org.junit.Test;

public class CandlestickTest {

	@Test(expected=IllegalArgumentException.class)
	public void precoMaximoNaoPodeSerMenorQueMinimo() {
		new Candlestick(10, 20, 20, 10, 10000, Calendar.getInstance());	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void dataNaoPodeSerNula(){
		new Candlestick(10, 20, 20, 30, 1000, null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void naoPodeTerValorNegativo(){
		new Candlestick(10, 20, 20, -10, 1000, Calendar.getInstance());
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void negociacoesEmOrdemCrescente(){
		new Candlestick(10, 20, 30, 40, 1000, Calendar.getInstance());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void negociacoesEmOrdemDescente(){
		new Candlestick(40, 30, 20, 10, 1000, Calendar.getInstance());
	}
	
	@Test
	public void quandoAberturaIgualFechamentoEhAlta(){
		Candlestick candle = new Candlestick(45.0, 45.0, 20, 55.5, 4050.0, Calendar.getInstance());
		assertTrue(candle.isAlta());
	}
}
