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
		
		Alumno alumnoMayorCalificacion = obtenerAlumnoMayorCalificacion(alumnos); 
		System.out.println("1) Alumno/s con la calificación más alta: " + alumnoMayorCalificacion.toString());
		
		Alumno alumnoMenorCalificacion = obtenerAlumnoMenorCalificacion(alumnos); 
		System.out.println("2) Alumno/s con la calificación más baja: " + alumnoMenorCalificacion.toString());
		
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
			alumnos.add(cargarAlumno(teclado,i));
		}
		return alumnos;
	}
	public static Alumno cargarAlumno(Scanner teclado, int i) {
		Alumno alumno;
		
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
		return alumno;
	}
	public static Alumno obtenerAlumnoMayorCalificacion(List<Alumno> alumnos) {
		Alumno alumnoMayorNota = alumnos.get(0);
		int mayorNota = alumnoMayorNota.getMayorNota();
		
		for(Alumno alumno : alumnos) {
			int nota = alumno.getMayorNota();
			if(nota > mayorNota) {
				alumnoMayorNota = alumno;
				mayorNota = nota;
			}
		}
		return alumnoMayorNota;
	}
	public static Alumno obtenerAlumnoMenorCalificacion(List<Alumno> alumnos) {
		Alumno alumnoMenorNota = alumnos.get(0);
		int menorNota = alumnoMenorNota.getMenorNota();
		
		for(Alumno alumno : alumnos) {
			int nota = alumno.getMenorNota();
			if(nota < menorNota) {
				alumnoMenorNota = alumno;
				menorNota = nota;
			}
		}
		return alumnoMenorNota;
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
