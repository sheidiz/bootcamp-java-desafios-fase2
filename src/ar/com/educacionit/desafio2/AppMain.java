package ar.com.educacionit.desafio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Cuando le pregunte al profe en clase dijo que en el Alumno la variable numero de examenes
 * hacia referencia a la cantidad de examenes. Por lo cual para cada alumno pide ese dato.
 * El ejercicio tampoco aclaraba que la mayor calificación se calcule por nota o por promedio,
 * asi que en el ejercicio toma la mejor nota de cada alumno y la compara con otros alumnos
 * */

public class AppMain {
	public static void main(String[] args) {
		System.out.println("Escuela Primaria xyz - Control de notas");
		Scanner teclado = new Scanner(System.in);

		System.out.print("Ingrese la cantidad de alumnos: ");
		int cantidadAlumnos = teclado.nextInt();
		
		List<Alumno> alumnos = cargadoAlumnos(teclado, cantidadAlumnos);
		
		System.out.println("--Resultados--");
		
		List<Alumno> alumnosMayorCalificacion = obtenerAlumnosMayorCalificacion(alumnos); 
		System.out.println("1) Alumno/s con la calificación más alta: ");
		for(Alumno a : alumnosMayorCalificacion) {
			System.out.println(" - " + a.toString());
		}
		
		List<Alumno> alumnosMenorCalificacion = obtenerAlumnosMenorCalificacion(alumnos); 
		System.out.println("2) Alumno/s con la calificación más baja: ");
		for(Alumno a : alumnosMenorCalificacion) {
			System.out.println(" - " + a.toString());
		}
		
		List<Alumno> alumnosPromocion = obtenerAlumnosPromocionados(alumnos);
		System.out.print("3) Alumnos que promocionan: ");
		if(!alumnosPromocion.isEmpty()) {
			System.out.print("\n");
			for(Alumno a : alumnosPromocion) {
				System.out.println(" - " + a.toString());
			}
		}else {
			System.out.println(" Ninguno promociona");	
		}
				
		List<Alumno> alumnosRecursar = obtenerAlumnosQueRecursaran(alumnos);
		System.out.print("4) Alumnos que deben recursar la materia:");
		if(!alumnosRecursar.isEmpty()) {
			System.out.print("\n");
			for(Alumno a : alumnosRecursar) {
				System.out.println(" - " + a.toString());
			}
		}else {
			System.out.println(" Ninguno recursa");
		}
		
		teclado.close();
	}
	public static List<Alumno> cargadoAlumnos(Scanner teclado, int cantidadAlumnos){

		List<Alumno> alumnos = new ArrayList<>();
		Alumno alumno;
		
		for(int i = 1; i <= cantidadAlumnos; i++) {
			System.out.println("-Alumno " + i + "-");
			
			System.out.print(" Nombre: ");
			String nombre = teclado.next();
			
			System.out.print(" Apellido: ");
			String apellido = teclado.next();
			
			System.out.print(" Examenes: ");
			int examenes = teclado.nextInt();
			
			alumno = new Alumno(nombre, apellido, examenes);
			for(int j = 1; j <= examenes; j++) {
				int nota;
				do {
					System.out.print("  Nota " + j + ": ");
					nota = teclado.nextInt();
				}while(nota<1 || nota>10);
				alumno.setNota(nota);
			}
			alumnos.add(alumno);
		}
		return alumnos;
	}

	public static int obtenerMayorCalificacion(List<Alumno> alumnos) {
		int mayorNota = alumnos.get(0).getMayorNota();
		for(Alumno alumno : alumnos) {
			int nota = alumno.getMayorNota();
			if(nota > mayorNota) mayorNota = nota;
		}
		return mayorNota;
	}
	public static List<Alumno> obtenerAlumnosMayorCalificacion(List<Alumno> alumnos) {
		int mayorNota = obtenerMayorCalificacion(alumnos);
		List<Alumno> alumnosConMayorCalificacion = new ArrayList<>();
		
		for(Alumno alumno : alumnos) {
			int nota = alumno.getMayorNota();
			if(nota == mayorNota) alumnosConMayorCalificacion.add(alumno);
		}
		return alumnosConMayorCalificacion;
	}
	public static int obtenerMenorCalificacion(List<Alumno> alumnos) {
		int menorNota = alumnos.get(0).getMenorNota();
		for(Alumno alumno : alumnos) {
			int nota = alumno.getMenorNota();
			if(nota < menorNota) menorNota = nota;
		}
		return menorNota;
	}
	public static List<Alumno> obtenerAlumnosMenorCalificacion(List<Alumno> alumnos) {
		int menorNota = obtenerMenorCalificacion(alumnos);
		List<Alumno> alumnosConMenorCalificacion = new ArrayList<>();
		
		for(Alumno alumno : alumnos) {
			int nota = alumno.getMenorNota();
			if(nota == menorNota) alumnosConMenorCalificacion.add(alumno);
		}
		return alumnosConMenorCalificacion;
	}
	public static List<Alumno> obtenerAlumnosPromocionados(List<Alumno> alumnos){
		List<Alumno> filtrados = new ArrayList<>();
		for(Alumno a : alumnos) {
			if(a.getPromedio() >= 7) {
				filtrados.add(a);
			}
		}
		return filtrados;
	}
	public static List<Alumno> obtenerAlumnosQueRecursaran(List<Alumno> alumnos){
		List<Alumno> filtrados = new ArrayList<>();
		for(Alumno a : alumnos) {
			if(a.getPromedio() < 7) {
				filtrados.add(a);
			}
		}
		return filtrados;
	}

}
