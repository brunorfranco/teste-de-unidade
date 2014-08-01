package br.com.caelum.leilao.teste;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.com.caelum.leilao.dominio.Avaliador;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class TesteDoAvaliador {
	
	@Test
	public void deveEntenderLancesEmOrdemCrescenteTest() {
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("Jose");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Playstation");
		
		leilao.propoe(new Lance(joao, 300));
		leilao.propoe(new Lance(jose, 400));
		leilao.propoe(new Lance(maria, 250));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		double maiorEsperado = 400;
		double menorEsperado = 250;
		
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
		
		
	}
	
	@Test
	public void deveEntenderLancesRandomicosTest() {
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("Jose");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Playstation");
		
		leilao.propoe(new Lance(joao, 200));
		leilao.propoe(new Lance(jose, 450));
		leilao.propoe(new Lance(maria, 120));
		leilao.propoe(new Lance(maria, 700));
		leilao.propoe(new Lance(maria, 630));
		leilao.propoe(new Lance(maria, 230));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		double maiorEsperado = 700;
		double menorEsperado = 120;
		
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
		
		
	}
	
	@Test
	public void deveEntenderLancesEmOrdemDecrescenteTest() {
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("Jose");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Playstation");
		
		leilao.propoe(new Lance(joao, 600));
		leilao.propoe(new Lance(jose, 500));
		leilao.propoe(new Lance(maria, 400));
		leilao.propoe(new Lance(maria, 300));
		leilao.propoe(new Lance(maria, 200));
		leilao.propoe(new Lance(maria, 100));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		double maiorEsperado = 600;
		double menorEsperado = 100;
		
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
		
		
	}
	
	@Test
	public void calculaMediaEntreLancesTest() {
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("Jose");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Playstation");
		
		leilao.propoe(new Lance(joao, 300));
		leilao.propoe(new Lance(jose, 400));
		leilao.propoe(new Lance(maria, 900));
		leilao.propoe(new Lance(maria, 200));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		double mediaEsperada = 450;
		
		assertEquals(mediaEsperada, leiloeiro.getValorMedioEntreLances(), 0.0001);
		
	}
	
	@Test
	public void deveEntenderLeilaoComApenasUmLanceTest() {
		Usuario joao = new Usuario("Joao");
		
		Leilao leilao = new Leilao("Playstation");
		
		leilao.propoe(new Lance(joao, 300));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		double maiorEsperado = 300;
		double menorEsperado = 300;
		
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
		
	}
	
	@Test
	public void deveEncontrarOsTresMaioresLancesTest() {
		Usuario joao = new Usuario("Joao");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Playstation");
		
		leilao.propoe(new Lance(joao, 300));
		leilao.propoe(new Lance(maria, 200));
		leilao.propoe(new Lance(joao, 350));
		leilao.propoe(new Lance(maria, 400));
		
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		List<Lance> maiores = leiloeiro.getTresMaiores();
		
		assertEquals(3, maiores.size());
		assertEquals(400, maiores.get(0).getValor(), 0.0001);
		assertEquals(350, maiores.get(1).getValor(), 0.0001);
		assertEquals(300, maiores.get(2).getValor(), 0.0001);
		
	}
	
	@Test
	public void deveEncontrarOsTresMaioresLancesDeCincoTest() {
		Usuario joao = new Usuario("Joao");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Playstation");
		
		leilao.propoe(new Lance(joao, 300));
		leilao.propoe(new Lance(maria, 200));
		leilao.propoe(new Lance(joao, 350));
		leilao.propoe(new Lance(maria, 400));
		leilao.propoe(new Lance(joao, 600));
		
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		List<Lance> maiores = leiloeiro.getTresMaiores();
		
		assertEquals(3, maiores.size());
		assertEquals(600, maiores.get(0).getValor(), 0.0001);
		assertEquals(400, maiores.get(1).getValor(), 0.0001);
		assertEquals(350, maiores.get(2).getValor(), 0.0001);
		
	}
	
	@Test
	public void deveEncontrarOsTresMaioresLancesDeDoisTest() {
		Usuario joao = new Usuario("Joao");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Playstation");
		
		leilao.propoe(new Lance(joao, 300));
		leilao.propoe(new Lance(maria, 200));
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		List<Lance> maiores = leiloeiro.getTresMaiores();
		
		assertEquals(2, maiores.size());
		assertEquals(300, maiores.get(0).getValor(), 0.0001);
		assertEquals(200, maiores.get(1).getValor(), 0.0001);
		
	}
	
	@Test
	public void deveEncontrarOsTresMaioresLancesComListaVaziaTest() {
		Usuario joao = new Usuario("Joao");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Playstation");
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		List<Lance> maiores = leiloeiro.getTresMaiores();
		
		assertEquals(0, maiores.size());
		
	}

}
