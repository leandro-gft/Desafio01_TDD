package br.com.gft.projetocarro.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.gft.projetocarro.model.Carro;

public class CarroServiceTest {

	private Carro carro;
	
	private CarroService carroService;

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
