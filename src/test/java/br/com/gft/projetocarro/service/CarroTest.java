package br.com.gft.projetocarro.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.gft.projetocarro.exceptions.CarroDesligadoException;
import br.com.gft.projetocarro.exceptions.CarroJaEstaLigadoException;
import br.com.gft.projetocarro.exceptions.CarroParadoOuDesligadoException;
import br.com.gft.projetocarro.exceptions.TanqueCheioException;
import br.com.gft.projetocarro.exceptions.TanqueVazioOuCarroDesligadoException;
import br.com.gft.projetocarro.model.Carro;
import br.com.gft.projetocarro.model.Cor;

public class CarroTest {

	private Carro carro;
	
	@Before
	public void setup() {
		carro = new Carro();
	}

	@Test
	public void deveLigarOCarro() throws Exception {
		carro.ligar();
		assertEquals(true, carro.isLigado());
	}
	
	@Test(expected = CarroJaEstaLigadoException.class)
	public void naoDeveLigarOCarroSeJaEstiverLigado() throws Exception {
		carro.setLigado(true);
		carro.ligar();
	}
	
	@Test
	public void deveAbastecer() throws Exception {
		carro.abastecer(50);	
		assertEquals(50, carro.getLitrosCombustivel());
	}
	
	@Test(expected = TanqueCheioException.class)
	public void naoDeveAbastecerSeExceder100L() throws Exception {
		carro.abastecer(101);	
	}
	
	@Test(expected = TanqueVazioOuCarroDesligadoException.class)
	public void nãoDeveAcelerarSeEstiverDesligado() throws Exception {
		carro.acelerar();
	}
	
	@Test
	public void deveAumentarVelocidadeEm20AoAcelerar() {
		carro.ligar();
		carro.abastecer(50);
		carro.acelerar();
		assertEquals(20, carro.getVelocidade());
	}
	
	@Test(expected = TanqueVazioOuCarroDesligadoException.class)
	public void deveAcelerarApenasSeTiverCombustivel() throws Exception {
		carro.ligar();
		carro.acelerar();		
	}
	
	@Test
	public void deveDiminuirLitrosCombustivelEm1AoAcelerar() {
		carro.ligar();
		carro.abastecer(50);
		carro.acelerar();
		assertEquals(49, carro.getLitrosCombustivel());
	}
	
	@Test(expected = CarroParadoOuDesligadoException.class)
	public void naoDeveFrearSeEstiverDesligado() throws Exception {
		carro.setLigado(false);
		carro.frear();
	}
	
	@Test(expected = CarroParadoOuDesligadoException.class)
	public void naoDeveFrearSeEstiverComVelocidadeIgualA0() throws Exception {
		carro.setLigado(true);
		carro.setVelocidade(0);
		carro.frear();
	}
	
	@Test
	public void deveDiminuirVelocidadeEm10AoFrear() throws Exception {
		carro.ligar();
		carro.setVelocidade(50);
		carro.frear();
		assertEquals(40, carro.getVelocidade());
	}
	
	@Test ()
	public void devePararSeEstiverComVelocidadeMenorOuIgualA10() throws Exception {
		carro.setLigado(true);
		carro.setVelocidade(8);
		carro.frear();
		assertEquals(0, carro.getVelocidade());
	}
	
	@Test
	public void devePintarOCarro() throws Exception {
		carro.setCor(Cor.AZUL);
		carro.pintar(Cor.AMARELO);
		assertEquals(Cor.AMARELO, carro.getCor());		
	}
	
	@Test
	public void deveDesligarOCarro() throws Exception {
		carro.setLigado(true);
		carro.desligar();
		assertEquals(false, carro.isLigado());				
	}
	
	@Test(expected = CarroDesligadoException.class)
	public void naoDeveDesligarOCarroSeJaEstiverDesligado() throws Exception {
		carro.setLigado(false);
		carro.desligar();
	}
	
		
}