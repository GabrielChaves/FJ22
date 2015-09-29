package br.com.caelum.argentum.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class CandlestickFactory {
	public Candlestick constroiCandlestickParaData(Calendar data, List<Negociacao> negociacoes){
		double maximo = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
		double minimo = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
		double volume = 0;
		
		for (Negociacao negociacao : negociacoes) {
			volume += negociacao.getVolume();
			
			if(negociacao.getPreco() > maximo){
				maximo = negociacao.getPreco();
			}else if(negociacao.getPreco() < minimo){
				minimo = negociacao.getPreco();
			}
		}
		
		double abertura = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
		double fechamento = negociacoes.isEmpty() ? 0 : 
			negociacoes.get(negociacoes.size() - 1).getPreco();
		
		
		return new Candlestick(abertura, fechamento, minimo, maximo, volume, data);
	}
	
	//Creditos:
	//Neste exercicio foi utilizado uma consulta ao repositporio do Dronan (https://github.com/dronan), para melhor entendimento do desafio.
	//Foi criado um @Override do método CompareTo na classe negociação, que por sua vez implementa "Comparable" 
	//Deixo minha gratidão ao Dronan, que de certo modo me ajudou a resover esta questão. Pg.72
	public List<Candlestick> constroiCandles(List<Negociacao> todasNegociacoes) {
			
			Collections.sort(todasNegociacoes);
			
			List<Candlestick> candles = new ArrayList<Candlestick>();
			List<Negociacao> negociacoesDoDia = new ArrayList<	>();
	
			Calendar dataAtual = todasNegociacoes.get(0).getData();
	
			for (Negociacao negociacao : todasNegociacoes) {	
				if (negociacao.getData().before(dataAtual)){
					throw new IllegalStateException("Ordem incorreta da lista de negociações");
				}
				if (!negociacao.isMesmoDia(dataAtual)) {
					criaEGuardaCandle(candles, negociacoesDoDia, dataAtual);
					negociacoesDoDia = new ArrayList<Negociacao>();
					dataAtual = negociacao.getData();
				}
	
				negociacoesDoDia.add(negociacao);
			}
	
			criaEGuardaCandle(candles, negociacoesDoDia, dataAtual);
			return candles;
		}
	
	private void criaEGuardaCandle(List<Candlestick> candles, List<Negociacao> negociacoesDoDia, Calendar dataAtual) {
		Candlestick candleDoDia = constroiCandlestickParaData(dataAtual,negociacoesDoDia);
		candles.add(candleDoDia);
	}

		
		
}
