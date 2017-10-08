package dto;

public class Bombilla {
	private String color;
	private boolean estaEncendido;
	private boolean estaFundido;

	public Bombilla() {

	}

	public Bombilla(String color, boolean estaEncendido, boolean estaFundido) {
		this.color = color;
		this.estaEncendido = estaEncendido;
		this.estaFundido = estaFundido;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isEstaEncendido() {
		return estaEncendido;
	}

	public void setEstaEncendido(boolean estaEncendido) {
		this.estaEncendido = estaEncendido;
	}

	public boolean isEstaFundido() {
		return estaFundido;
	}

	public void setEstaFundido(boolean estaFundido) {
		this.estaFundido = estaFundido;
	}

}