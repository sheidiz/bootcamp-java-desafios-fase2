package ar.com.educacionit.bootcamp.connectors.placeholder;

import java.util.Collection;

import ar.com.educacionit.bootcamp.dto.Placeholder;

public class PlaceholderApiServiceImpl implements PlaceholderApiService {

	private PlaceholderApiConnector executor;
	private String url = "https://jsonplaceholder.typicode.com/";

	public PlaceholderApiServiceImpl() {
		executor = new PlaceholderApiConnector(url);
	}

	@Override
	public void guardar(Placeholder entidad) {

	}

	@Override
	public Collection<Placeholder> buscarTodos() {
		return null;
	}

	@Override
	public Placeholder buscarPorId(int id) {
		return this.executor.get("/posts/" + id);
	}

	@Override
	public Placeholder buscarPorCampo(String campo, String valor) {
		return this.executor.get("/posts/" + valor);
	}

	@Override
	public void actualizar(Placeholder entidad) {

	}

	@Override
	public void eliminarPorId(int id) {

	}

}
