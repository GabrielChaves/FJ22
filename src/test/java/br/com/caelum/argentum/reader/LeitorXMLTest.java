package br.com.caelum.argentum.reader;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.*;

import br.com.caelum.argentum.modelo.Negociacao;

public class LeitorXMLTest {

	@Test
	public void carregaXmlComUmaNegociacaoEmListaUnitaria() {
		String xmlDeTeste = "<list>" 
								+"<negociacao>"
								+"		<preco>43.5</preco>" 
								+		"<quantidade>1000</quantidade>"
								+		"<data>"
								+			"<time>1322233344455</time>"
								+		"</data>"
								+"</negociacao>"
						   + "</list>";
		LeitorXML leitor = new LeitorXML();
		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		List<Negociacao> negociacoes = leitor.carrega(xml); 
										
		assertTrue(negociacoes.size() == 1);
		assertEquals(43.5, negociacoes.get(0).getPreco(),0.000001);
		assertEquals(1000, negociacoes.get(0).getQuantidade(), 0.000001);
	}
	
	//Opcional: Para zero negociações;
	@Test
	public void carregaXmlComZeroNegociacoes(){
			String xmlDeTeste = "<list></list>"; //Nenhuma Negociação
			
			LeitorXML leitor = new LeitorXML();
			InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
			List<Negociacao> negociacoes = leitor.carrega(xml); 
			
			assertTrue(negociacoes.isEmpty());	
	}
	
	//Opcional: Preço Faltanto
	public void carregaXmlComPrecoFaltanto(){
		String xmlDeTeste = "<list>" 
								+"<negociacao>"
								+"		<preco></preco>" 
								+		"<quantidade>1000</quantidade>"
								+		"<data>"
								+			"<time>1322233344455</time>"
								+		"</data>"
								+"</negociacao>"
						   + "</list>";
		
		LeitorXML leitor = new LeitorXML();
		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		List<Negociacao> negociacoes = leitor.carrega(xml); 
		
		assertEquals(0.0, negociacoes.get(0).getPreco(), 0.000001);
	}
	
	//Opcionao: Com quantidades diversas
	@Test
	public void carregaXmlComOutrasQuantidades() {
		String xmlDeTeste = "<list>" 
								+"<negociacao>"
								+"		<preco>43.5</preco>" 
								+		"<quantidade>1000</quantidade>"
								+		"<data>"
								+			"<time>1322233344455</time>"
								+		"</data>"
								+"</negociacao>"
								+"<negociacao>"
								+"		<preco>43.5</preco>" 
								+		"<quantidade>3</quantidade>"
								+		"<data>"
								+			"<time>1322233344455</time>"
								+		"</data>"
								+"</negociacao>"
								+"<negociacao>"
								+"		<preco>43.5</preco>" 
								+		"<quantidade>22</quantidade>"
								+		"<data>"
								+			"<time>1322233344455</time>"
								+		"</data>"
								+"</negociacao>"
								+"<negociacao>"
								+"		<preco>43.5</preco>" 
								+		"<quantidade>50</quantidade>"
								+		"<data>"
								+			"<time>1322233344455</time>"
								+		"</data>"
								+"</negociacao>"
						   + "</list>";
		LeitorXML leitor = new LeitorXML();
		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		List<Negociacao> negociacoes = leitor.carrega(xml); 
		
		assertTrue(negociacoes.size() == 4);
		assertEquals(3, negociacoes.get(1).getQuantidade(), 0.00001);
		assertEquals(22, negociacoes.get(2).getQuantidade(), 0.00001);
		assertEquals(50, negociacoes.get(3).getQuantidade(), 0.00001);
	}
	
}
