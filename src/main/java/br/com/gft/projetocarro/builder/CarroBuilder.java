package br.com.gft.projetocarro.builder;

import br.com.gft.projetocarro.model.Carro;
import br.com.gft.projetocarro.model.Cor;

public class CarroBuilder {

	private Carro instancia;
	
	public CarroBuilder() {
		instancia = new Carro();
	}
	
	public Carro construir() {
		return instancia;
	}
	
	public CarroBuilder comModelo(String modelo) {
		instancia.setModelo(modelo);
		return this;
	}

	public CarroBuilder comCor(Cor cor) {
		instancia.setCor(cor);
		return this;
	}

	public CarroBuilder comMarca(String marca) {
		instancia.setMarca(marca);
		return this;
	}
	
	public CarroBuilder comVelocidade(int velocidade) {
		instancia.setVelocidade(velocidade);
		return this;
	}
	
	public CarroBuilder ligado(boolean isLigado) {
		instancia.setLigado(isLigado);
		return this;
	}
	
	public CarroBuilder qtdCombustivel(int litrosCombustivel) {
		instancia.setLitrosCombustivel(litrosCombustivel);
		return this;
	}
	
}
