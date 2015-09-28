package br.com.caelum.argentum.testes;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.argentum.modelo.Candlestick;
import br.com.caelum.argentum.modelo.CandlestickFactory;
import br.com.caelum.argentum.modelo.Negociacao;

public class TesteOpcional {
	public static void main(String [] args){
Calendar hoje = Calendar.getInstance();
		

		Negociacao petrobras = new Negociacao(30.0, 0, hoje);


		List<Negociacao> negociacoes = Arrays.asList(petrobras);
		CandlestickFactory fabrica = new CandlestickFactory();
		Candlestick candle = fabrica.constroiCandlestickParaData(hoje, negociacoes);
		
		System.out.println(candle.getAbertura());
		System.out.println(candle.getFechamento());
		System.out.println(candle.getMinimo());
		System.out.println(candle.getMaximo());
		System.out.println(candle.getVolume());
		System.out.println(candle.toString());
		System.out.println(candle.getAbertura());
	}
}
