package ar.com.educacionit.bootcamp.service;

import java.util.Collection;

public interface EntidadBaseService<T> {
	public void guardar(T entidad);
	public Collection<T> buscarTodos();
	public T buscarPorId(int id);
	public T buscarPorCampo(String campo, String valor);
	public void actualizar(T entidad);
	public void eliminarPorId(int id);
}
