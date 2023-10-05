package ar.com.educacionit.desafio2;

import java.util.ArrayList;

public class Alumno {

	private String nombre;
	private String apellido;
	private int numeroDeExamenes;
	private ArrayList<Integer> notas;
	
	public Alumno(String nombre, String apellido, int numeroDeExamenes) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.numeroDeExamenes = numeroDeExamenes;
		this.notas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getNumeroDeExamenes() {
		return numeroDeExamenes;
	}

	public void setNumeroDeExamenes(int numeroDeExamenes) {
		this.numeroDeExamenes = numeroDeExamenes;
	}

	public ArrayList<Integer> getNotas() {
		return notas;
	}

	public void setNota(int nota) {
		notas.add(nota);
	}
	public int getMayorNota() {
		int mayor = this.getNotas().get(0);
		for(int nota : this.getNotas()) {
			if(nota > mayor) {
				mayor = nota;
			}
		}
		return mayor;
	}
	public int getMenorNota() {
		int menor = this.notas.get(0);
		for(int nota : this.getNotas()) {
			if(nota < menor) {
				menor = nota;
			}
		}
		return menor;
	}
	public int getPromedio() {
		int suma = 0;
		for(int nota : notas) {
			suma += nota;
		}
		return suma / this.numeroDeExamenes;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellido=" + apellido + ", numeroDeExamenes=" + numeroDeExamenes
				+ ", notas=" + notas + "]";
	}
	
}
