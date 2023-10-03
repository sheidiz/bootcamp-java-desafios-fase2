package ar.com.educationit.desafio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppMain {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Ingrese la cantidad de alumnos: ");
		int cantidadAlumnos = teclado.nextInt();
		
		List<Alumno> alumnos = cargadoAlumnos(teclado, cantidadAlumnos);
		Alumno alumnoMayorCalificacion = obtenerAlumnoMayorCalificacion(alumnos); 
		Alumno alumnoMenorCalificacion = obtenerAlumnoMenorCalificacion(alumnos); 
		List<Alumno> alumnosPromocion = obtenerAlumnosPromocionados(alumnos);
		List<Alumno> alumnosRecursar = obtenerAlumnosQueRecursaran(alumnos);
		
		System.out.println("1) Alumno/s con la calificación más alta: " + alumnoMayorCalificacion.toString());
		System.out.println("2) Alumno/s con la calificación más baja: " + alumnoMenorCalificacion.toString());
		System.out.println("3) Alumnos que promocionan:");
		for(Alumno a : alumnosPromocion) {
			System.out.println("- " + a.toString());
		}
		System.out.println("4) Alumnos que deben recursar la materia:");
		for(Alumno a : alumnosRecursar) {
			System.out.println("- " + a.toString());
		}
		
		teclado.close();
	}
	public static List<Alumno> cargadoAlumnos(Scanner teclado, int cantidadAlumnos){

		List<Alumno> alumnos = new ArrayList<>();
		Alumno alumno;
		for(int i = 0; i < cantidadAlumnos; i++) {
			System.out.println("-Alumno " + (i+1) + "-");
			System.out.println("Nombre: ");
			String nombre = teclado.next();
			System.out.println("Apellido: ");
			String apellido = teclado.next();
			System.out.println("Examenes: ");
			int examenes = teclado.nextInt();
			alumno = new Alumno(nombre, apellido, examenes);
			for(int j = 0; j < examenes; j++) {
				System.out.println("Nota " + (j+1) + ": ");
				int nota = teclado.nextInt();
				alumno.setNota(nota);
			}
			alumnos.add(alumno);
		}
		return alumnos;
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
