package br.com.caelum.argentum.modelo;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

public class NegociacaoTest {

	@Test
	public void dataNegociacaoEhImutavel() {
		//se criar um negocio no dia 15
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 15);
		Negociacao n = new Negociacao(10, 5, c);
		
		//Tentativa de mudar a data para 20
		n.getData().set(Calendar.DAY_OF_MONTH, 20);
		
		//A data permanece 15
		//Usei aqui um import estatico para o uso de assert
		assertEquals(15, n.getData().get(Calendar.DAY_OF_MONTH));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void naoCriaNegociacaoComDataNula(){
		new Negociacao(10,5,null);
	}
	
	//Tetsar se é do mesmo dia.
	@Test
	public void mesmoMilissegundoEhDoMesmoDia(){
		Calendar agora = Calendar.getInstance();
		Calendar mesmoMomento = (Calendar) agora.clone();
		
		Negociacao negociacao = new Negociacao(40.0, 100, agora);
		Assert.assertTrue(negociacao.isMesmoDia(mesmoMomento));
	}
	
	//Testa se é mesmo dia, porém horários diferentes.
	@Test
	public void comHorariosDiferentesEhDoMesmoDia(){
		//Utilizando o Gregorian Calendar (ano, mês, dia, hora, minuto)
		Calendar manha = new GregorianCalendar(2015,10,20,8,30);
		Calendar tarde = new GregorianCalendar(2015,10,20,15,30);
		
		Negociacao negociacao = new Negociacao(40.0, 100, manha);
		Assert.assertTrue(negociacao.isMesmoDia(tarde));	
	}
	
	@Test
	public void mesmoDiaMasMesesDiferentesNaoDoSaoMesmoDia(){
		//Utilizando o Gregorian Calendar (ano, mês, dia, hora, minuto)
		Calendar junho = new GregorianCalendar(2015, 5, 20);
		Calendar setembro = new GregorianCalendar(2015, 8, 20);
				
		Negociacao negociacao = new Negociacao(40.0, 100, junho);
		Assert.assertFalse(negociacao.isMesmoDia(setembro));
	}
	
	public void mesmoDiaEMesMasAnosDiferentesNaoSaoMesmoDia(){
		//Utilizando o Gregorian Calendar (ano, mês, dia, hora, minuto)
		Calendar junho2014 = new GregorianCalendar(2014, 5, 20);
		Calendar junho2015 = new GregorianCalendar(2015, 8, 20);
		
		Negociacao negociacao = new Negociacao(40.0, 100, junho2014);
		Assert.assertFalse(negociacao.isMesmoDia(junho2015));
	}
}
