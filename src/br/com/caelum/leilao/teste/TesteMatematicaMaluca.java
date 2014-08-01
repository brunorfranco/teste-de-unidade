package br.com.caelum.leilao.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.caelum.leilao.dominio.MatematicaMaluca;


public class TesteMatematicaMaluca {
	
	@Test
	public void testaMaiorQueTrinta(){
		MatematicaMaluca matematica = new MatematicaMaluca();
		
		int resultadoEsperado = 140;
		int resultado = matematica.contaMaluca(35);
		
		assertEquals(resultadoEsperado, resultado);
	}
	
	@Test
	public void testaMaiorQueDez(){
		MatematicaMaluca matematica = new MatematicaMaluca();
		
		int resultadoEsperado = 45;
		int resultado = matematica.contaMaluca(15);
		
		assertEquals(resultadoEsperado, resultado);
	}
	
	@Test
	public void testaMenorQueDez(){
		MatematicaMaluca matematica = new MatematicaMaluca();
		
		int resultadoEsperado = 10;
		int resultado = matematica.contaMaluca(5);
		
		assertEquals(resultadoEsperado, resultado);
	}

}
