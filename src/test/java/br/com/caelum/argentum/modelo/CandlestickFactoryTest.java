package br.com.caelum.argentum.modelo;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CandlestickFactoryTest {

	// Exercicio 3.8 - 1,2
		@Test
		public void sequenciaSimplesDeNegociacoes() {

			Calendar hoje = Calendar.getInstance();

			Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
			Negociacao negociacao2 = new Negociacao(39.8, 100, hoje);
			Negociacao negociacao3 = new Negociacao(42.3, 100, hoje);
			Negociacao negociacao4 = new Negociacao(45.0, 100, hoje);

			List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2,
					negociacao3, negociacao4);

			CandlestickFactory fabrica = new CandlestickFactory();

			Candlestick candle = fabrica.constroiCandlestickParaData(hoje, negociacoes);

			// Inicio das assercoes - assert
			Assert.assertEquals(40.5, candle.getAbertura(), 0.00001);
			Assert.assertEquals(45.0, candle.getFechamento(), 0.00001);
			Assert.assertEquals(39.8, candle.getMinimo(), 0.00001);
			Assert.assertEquals(45.0, candle.getMaximo(), 0.00001);
			Assert.assertEquals(16760.0, candle.getVolume(), 0.00001);

		}
	
	@Test
	public void semNegociacoesGeraCandlleComZero(){
		Calendar hoje = Calendar.getInstance();
		
		List<Negociacao> negociacoes = Arrays.asList();
		
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandlestickParaData(hoje, negociacoes);
		Assert.assertEquals(0.0, candle.getAbertura(), 0.00001);
		Assert.assertEquals(0.0, candle.getFechamento(), 0.00001);
		Assert.assertEquals(0.0, candle.getMinimo(), 0.00001);
		Assert.assertEquals(0.0, candle.getMaximo(), 0.00001);
	}
	
	@Test
	public void apenasUmaNegociacaoGeraCandleComValoresIguais() {

		Calendar hoje = Calendar.getInstance();

		Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);

		List<Negociacao> negociacoes = Arrays.asList(negociacao1);

		CandlestickFactory fabrica = new CandlestickFactory();

		Candlestick candle = fabrica.constroiCandlestickParaData(hoje, negociacoes);

		Assert.assertEquals(40.5, candle.getAbertura(), 0.00001);
		Assert.assertEquals(40.5, candle.getFechamento(), 0.00001);
		Assert.assertEquals(40.5, candle.getMinimo(), 0.00001);
		Assert.assertEquals(40.5, candle.getMaximo(), 0.00001);
		Assert.assertEquals(4050.0, candle.getVolume(), 0.00001);

	}

}
