package br.com.gft.projetocarro.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.gft.projetocarro.model.Carro;
import br.com.gft.projetocarro.model.CarroDesligadoException;
import br.com.gft.projetocarro.model.CarroJaEstaLigadoException;
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
	
	@Test(expected = CarroDesligadoException.class)
	public void nãoDeveAcelerarSeEstiverDesligado() throws Exception {
		carro.acelerar();
	}
	
	@Test
	public void deveAumentarVelocidadeEm20AoAcelerar() {
		carro.ligar();
		carro.acelerar();
		assertEquals(20, carro.getVelocidade());
	}
	
	@Test
	public void deveDiminuirLitrosCombustivelEm1AoAcelerar() {
		carro.ligar();
		carro.abastecer(50);
		carro.acelerar();
		assertEquals(49, carro.getLitrosCombustivel());
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
