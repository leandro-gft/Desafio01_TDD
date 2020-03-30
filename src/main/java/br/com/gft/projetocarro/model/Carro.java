package br.com.gft.projetocarro.model;

public class Carro {

	private String marca;
	private String modelo;
	private String cor;
	private float km;
	private boolean isLigado;
	private int litrosCombustivel;
	private int velocidade;

//	
//	public Carro() {
//		super();
//	}
//
//	public Carro(String marca, String modelo, String cor, float km, boolean isLigado, int litrosCombustivel,
//			int velocidade) {
//		super();
//		this.marca = marca;
//		this.modelo = modelo;
//		this.cor = cor;
//		this.km = km;
//		this.isLigado = isLigado;
//		this.litrosCombustivel = litrosCombustivel;
//		this.velocidade = velocidade;
//	}
//
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

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public float getKm() {
		return km;
	}

	public void setKm(float km) {
		this.km = km;
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

	public void ligar() {
		if (isLigado() == false) {
			setLigado(true);
		} else
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

	public void abastecer(int qtdLitros) {
		if (qtdLitros < 100) {
			setLitrosCombustivel(qtdLitros);
		} else
			throw new TanqueCheioException();

	}

	public void frear() {
		if (isLigado() == true && velocidade > 10) {
			setVelocidade(getVelocidade() - 10);
		}
		else if (isLigado() == true && velocidade > 0 && velocidade <= 10 ) {
			setVelocidade(0);
		} 
		else {
			throw new CarroParadoOuDesligadoException();
		}
	}

}