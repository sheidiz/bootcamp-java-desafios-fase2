package ar.com.educationit.desafio3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainTorreDeControl {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		List<IVolador> voladores = new ArrayList<>();
		voladores.add(new Avion());
		voladores.add(new Helicoptero());
		voladores.add(new Pajaro());
		
		TorreDeControl torre = new TorreDeControl() {
			@Override
			public void autorizarAterrizaje(IVolador volador) {
				if(volador instanceof IPuedeAterrizar) {
					((IPuedeAterrizar) volador).aterrizarPista1();
				}else{
					System.out.println("Sin autorización. Debe pedir autorización adicional");
					System.out.println("Solicitando aprobación...");
					//Uso un random para obtener una autorizacion aleatoria
					if(Math.round(Math.random()*10) > 5) {
						System.out.println("Puede aterrizar en Pista 2!");
					}else{
						System.out.println("Permiso denegado para aterrizar en Pista 2");
					}
				}
			}	
		};
		for(IVolador volador : voladores) {
			volador.volar();
			torre.autorizarAterrizaje(volador);
			System.out.println("------------> \n");
		}
	}
}
