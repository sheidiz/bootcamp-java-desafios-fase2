package ar.com.educacionit.bootcamp.connectors.pokemon;

import java.util.Collection;

import ar.com.educacionit.bootcamp.dto.Pokemon;

public class PokeApiServiceImpl implements PokeApiService {
	
	private PokeApiConnector executor;
	private String url = "https://pokeapi.co/api/v2";
	
	
	public PokeApiServiceImpl() {
		executor = new PokeApiConnector(url);
	}

	@Override
	public void guardar(Pokemon entidad) {
		
	}

	@Override
	public Collection<Pokemon> buscarTodos() {
		return null;
	}

	@Override
	public Pokemon buscarPorId(int id) {
		return this.executor.get("/pokemon/" + id);
	}

	@Override
	public Pokemon buscarPorCampo(String campo, String valor) {
		return this.executor.get("/pokemon/" + valor);
	}

	@Override
	public void actualizar(Pokemon entidad) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarPorId(int id) {
		// TODO Auto-generated method stub

	}

}
