package br.com.gft.projetocarro.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.gft.projetocarro.model.Carro;
import br.com.gft.projetocarro.model.TanqueVazioOuCarroDesligadoException;
import br.com.gft.projetocarro.model.CarroJaEstaLigadoException;
import br.com.gft.projetocarro.model.CarroParadoOuDesligadoException;
import br.com.gft.projetocarro.model.TanqueCheioException;

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
	public void deveMostrarExcecaoSeOCarroJaEstiverLigadoAoLigar() throws Exception {
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
		carro.pintar();
		
	}
		
}
	
//	@Test
//	public void devePermitirAcelerarOCarro() throws Exception {
//		carro.acelerar(true, 20.0, 1.0);
//	}
//	
//	
//	
//	@Test
//	public void deveAbastecerOCarro() throws Exception {
//		carro.abastecer(20.0);
//	}
//
//}
