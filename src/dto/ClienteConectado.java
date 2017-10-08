package dto;

import java.util.List;

public class ClienteConectado {
	private String ipCliente;
	private List<Bombilla> listaLinea1;
	private List<Bombilla> listaLinea2;

	public ClienteConectado() {

	}

	public ClienteConectado(String ipCliente, List<Bombilla> listaLinea1, List<Bombilla> listaLinea2) {
		this.ipCliente = ipCliente;
		this.listaLinea1 = listaLinea1;
		this.listaLinea2 = listaLinea2;
	}

	public String getIpCliente() {
		return ipCliente;
	}

	public void setIpCliente(String ipCliente) {
		this.ipCliente = ipCliente;
	}

	public List<Bombilla> getListaLinea1() {
		return listaLinea1;
	}

	public void setListaLinea1(List<Bombilla> listaLinea1) {
		this.listaLinea1 = listaLinea1;
	}

	public List<Bombilla> getListaLinea2() {
		return listaLinea2;
	}

	public void setListaLinea2(List<Bombilla> listaLinea2) {
		this.listaLinea2 = listaLinea2;
	}

}