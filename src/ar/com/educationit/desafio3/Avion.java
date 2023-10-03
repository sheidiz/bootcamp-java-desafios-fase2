package ar.com.educationit.desafio3;

public class Avion implements IVolador, IPuedeAterrizar {

	@Override
	public void aterrizarPista1() {
		System.out.println("Avion aterrizando en Pista 1...");
	}

	@Override
	public void volar() {
		System.out.println("Avion volando...");
	}

}
