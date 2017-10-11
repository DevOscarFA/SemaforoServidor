package servidor;

import presentacion.Modelo;

public class Iniciador {

    private Modelo serverApp;

    public Iniciador() {
        serverApp = new Modelo();
        serverApp.iniciar();
    }

    public static void main(String[] args) {
        new Iniciador();
    }

}
