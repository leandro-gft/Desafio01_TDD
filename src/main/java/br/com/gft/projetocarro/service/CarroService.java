package br.com.gft.projetocarro.service;

import br.com.gft.projetocarro.model.Carro;

public class CarroService {

	private Carro carro;
	
	public void acelerar(boolean isLigado, double valorAcelerado, double combustivelGasto) {
		
	}

	public void ligar() {
		if (carro.isLigado() == false) {
			carro.setLigado(true);
	}
		throw new CarroJaEstaLigadoException();
	}

	public void abastecer(double qtdLitros) {
	}

}
