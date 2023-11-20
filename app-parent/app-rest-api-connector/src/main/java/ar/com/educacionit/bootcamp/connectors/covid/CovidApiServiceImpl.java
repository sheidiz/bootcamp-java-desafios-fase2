package ar.com.educacionit.bootcamp.connectors.covid;

import java.util.Collection;

import ar.com.educacionit.bootcamp.dto.Covid;

public class CovidApiServiceImpl implements CovidApiService {

	private CovidApiConnector executor;
	private String url = "https://api.covidtracking.com/v1/us/";
	
	
	public CovidApiServiceImpl() {
		executor = new CovidApiConnector(url);
	}

	@Override
	public void guardar(Covid entidad) {
		
	}

	@Override
	public Collection<Covid> buscarTodos() {
		return null;
	}

	@Override
	public Covid buscarPorId(int id) {
		return null;
	}

	@Override
	public Covid buscarPorCampo(String campo, String valor) {
		return this.executor.get("/" + valor + ".json");
	}

	@Override
	public void actualizar(Covid entidad) {

	}

	@Override
	public void eliminarPorId(int id) {

	}

}
