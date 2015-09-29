package br.com.caelum.argentum.modelo;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

public class CandleBuilderTest {

	@Test(expected=IllegalStateException.class)
	public void geracaoDeCandleDeveTerTodosOsDadosNecessarios(){
		new CandleBuilder().geraCandle();
	}
	
	
}