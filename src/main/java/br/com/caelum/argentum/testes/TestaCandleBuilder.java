package br.com.caelum.argentum.testes;

import java.util.GregorianCalendar;

import br.com.caelum.argentum.modelo.CandleBuilder;
import br.com.caelum.argentum.modelo.Candlestick;

public class TestaCandleBuilder {
	public static void main (String [] args){
		
		
		Candlestick candle = new CandleBuilder().comAbertura(40.5)
				.comFechamento(42.3).comMinimo(39.8).comMaximo(45.0)
				.comVolume(167600.0)
				.comData(new GregorianCalendar(2013, 4, 22, 0, 0, 0))
				.geraCandle();
		
	
		System.out.println("Abrtura: "+ candle.getAbertura());
		System.out.println("Fechamento: "+ candle.getFechamento());
		System.out.println("Minimo: "+ candle.getMinimo());
		System.out.println("Maximo: "+ candle.getMaximo());
		System.out.println("Volume: "+ candle.getVolume());
		System.out.println("Data: "+ candle.toString());
		
	}
}
