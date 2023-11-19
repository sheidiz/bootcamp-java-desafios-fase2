package ar.com.educacionit.bootcamp.dto;

import java.io.Serializable;

public abstract class Entity {

	protected int id;

	public void setId(int id) {
		this.id = id;
	}

	public Serializable getId() {
		return this.id;
	}
}