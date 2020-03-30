package br.com.gft.projetocarro.model;

import br.com.gft.projetocarro.exceptions.CarroDesligadoException;
import br.com.gft.projetocarro.exceptions.CarroJaEstaLigadoException;
import br.com.gft.projetocarro.exceptions.CarroParadoOuDesligadoException;
import br.com.gft.projetocarro.exceptions.TanqueCheioException;
import br.com.gft.projetocarro.exceptions.TanqueVazioOuCarroDesligadoException;

public class Carro {

	private String marca;
	private String modelo;
	private Cor cor;
	private boolean isLigado;
	private int litrosCombustivel;
	private int velocidade;
	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public boolean isLigado() {
		return isLigado;
	}

	public void setLigado(boolean isLigado) {
		this.isLigado = isLigado;
	}

	public int getLitrosCombustivel() {
		return litrosCombustivel;
	}

	public void setLitrosCombustivel(int litrosCombustivel) {
		this.litrosCombustivel = litrosCombustivel;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	public boolean ligar() {
		if (isLigado() == false) 
			return isLigado = true;
		else
			throw new CarroJaEstaLigadoException();
	}

	public void acelerar() {
		if (isLigado() == true && litrosCombustivel > 0) {
			setVelocidade(getVelocidade() + 20);
			setLitrosCombustivel(getLitrosCombustivel() - 1);
		} else {
			throw new TanqueVazioOuCarroDesligadoException();
		}
	}

	public double abastecer(int qtdLitros) {
		litrosCombustivel += qtdLitros;
		if (litrosCombustivel < 100) 
			return litrosCombustivel;
		else
			throw new TanqueCheioException();

	}

	public int frear() {
		if (isLigado() == true && velocidade > 10) 
			return velocidade -= 10;
		else if (isLigado() == true && velocidade > 0 && velocidade <= 10 ) 
			return velocidade = 0;
		else 
			throw new CarroParadoOuDesligadoException();
	}

	public Cor pintar(Cor cor) {
		return this.cor = cor;
	}

	public boolean desligar() {
		if (isLigado == true) 
			return isLigado = false;
		throw new CarroDesligadoException();
	}
}