package ar.com.educacionit.bootcamp.service;

import java.util.Collection;

import ar.com.educacionit.bootcamp.repository.BaseRepository;

public class AbstractEntidadBaseService<T> implements EntidadBaseService<T> {

	protected BaseRepository<T> repository;
	
	
	public AbstractEntidadBaseService(BaseRepository<T> repository) {
		this.repository = repository;
	}

	@Override
	public void guardar(T entidad) {
		this.repository.guardar(entidad);
	}

	@Override
	public Collection<T> buscarTodos() {
		return this.repository.buscarTodos();
	}

	@Override
	public T buscarPorId(int id) {
		return this.repository.buscarPorId(id);
	}

	@Override
	public T buscarPorCampo(String campo, String valor) {
		return this.repository.buscarPorCampo(campo, valor);
	}

	@Override
	public void actualizar(T entidad) {
		this.repository.actualizar(entidad);
	}

	@Override
	public void eliminarPorId(int id) {
		this.repository.eliminar(id);
	}

}
