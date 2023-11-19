package ar.com.educacionit.bootcamp.repository;

import java.util.Collection;

public interface BaseRepository<T> {
	public void guardar(T entidad);
	public Collection<T> buscarTodos();
	public T buscarPorId(int id);
	public T buscarPorCampo(String campo, String valor);
	public void actualizar(T entidad);
	public void eliminar(int id);
}
