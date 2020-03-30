package br.com.gft.projetocarro.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.gft.projetocarro.builder.CarroBuilder;
import br.com.gft.projetocarro.exceptions.CarroDesligadoException;
import br.com.gft.projetocarro.exceptions.CarroJaEstaLigadoException;
import br.com.gft.projetocarro.exceptions.CarroParadoOuDesligadoException;
import br.com.gft.projetocarro.exceptions.TanqueCheioException;
import br.com.gft.projetocarro.exceptions.TanqueVazioOuCarroDesligadoException;
import br.com.gft.projetocarro.model.Carro;
import br.com.gft.projetocarro.model.Cor;

public class CarroTest {

	private Carro carro1;
	private Carro carro2;
	private Carro carro3;
	private Carro carro4;
	
	@Before
	public void setup() {
		carro1 = new CarroBuilder().comCor(Cor.CINZA).comMarca("Fiat").comModelo("Uno").comVelocidade(0).ligado(false).qtdCombustivel(0).construir();
		carro2 = new CarroBuilder().comCor(Cor.CINZA).comMarca("Fiat").comModelo("Uno").comVelocidade(0).ligado(true).qtdCombustivel(10).construir();
		carro3 = new CarroBuilder().comCor(Cor.CINZA).comMarca("Fiat").comModelo("Uno").comVelocidade(50).ligado(true).qtdCombustivel(10).construir();
		carro4 = new CarroBuilder().comCor(Cor.CINZA).comMarca("Fiat").comModelo("Uno").comVelocidade(8).ligado(true).qtdCombustivel(10).construir();

	}

	@Test
	public void deveLigarOCarro() throws Exception {
		carro1.ligar();
		assertEquals(true, carro1.isLigado());
	}
	
	@Test(expected = CarroJaEstaLigadoException.class)
	public void naoDeveLigarOCarroSeJaEstiverLigado() throws Exception {
		carro2.ligar();
	}
	
	@Test
	public void deveAbastecer() throws Exception {
		carro2.abastecer(50);	
		assertEquals(60, carro2.getLitrosCombustivel());
	}
	
	@Test(expected = TanqueCheioException.class)
	public void naoDeveAbastecerSeExceder100L() throws Exception {
		carro2.abastecer(91);
		
	}
	
	@Test(expected = TanqueVazioOuCarroDesligadoException.class)
	public void nãoDeveAcelerarSeEstiverDesligado() throws Exception {
		carro1.acelerar();
	}
	
	@Test
	public void deveAumentarVelocidadeEm20AoAcelerar() {
		carro2.acelerar();
		assertEquals(20, carro2.getVelocidade());
	}
	
	@Test(expected = TanqueVazioOuCarroDesligadoException.class)
	public void deveAcelerarApenasSeTiverCombustivel() throws Exception {
		carro1.acelerar();		
	}
	
	@Test
	public void deveDiminuirLitrosCombustivelEm1AoAcelerar() {
		carro2.acelerar();
		assertEquals(9, carro2.getLitrosCombustivel());
	}
	
	@Test(expected = CarroParadoOuDesligadoException.class)
	public void naoDeveFrearSeEstiverDesligado() throws Exception {
		carro1.frear();
	}
	
	@Test(expected = CarroParadoOuDesligadoException.class)
	public void naoDeveFrearSeEstiverComVelocidadeIgualA0() throws Exception {
		carro2.frear();
	}
	
	@Test
	public void deveDiminuirVelocidadeEm10AoFrear() throws Exception {
		carro3.frear();
		assertEquals(40, carro3.getVelocidade());
	}
	
	@Test ()
	public void devePararSeEstiverComVelocidadeMenorOuIgualA10() throws Exception {
		carro4.frear();
		assertEquals(0, carro4.getVelocidade());
	}
	
	@Test
	public void devePintarOCarro() throws Exception {
		carro1.pintar(Cor.AMARELO);
		assertEquals(Cor.AMARELO, carro1.getCor());		
	}
	
	@Test
	public void deveDesligarOCarro() throws Exception {
		carro2.desligar();
		assertEquals(false, carro2.isLigado());				
	}
	
	@Test(expected = CarroDesligadoException.class)
	public void naoDeveDesligarOCarroSeJaEstiverDesligado() throws Exception {
		carro1.desligar();
	}
	
		
}