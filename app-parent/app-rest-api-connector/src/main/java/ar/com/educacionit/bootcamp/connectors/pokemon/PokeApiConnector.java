package ar.com.educacionit.bootcamp.connectors.pokemon;

import java.util.List;

import ar.com.educacionit.bootcamp.connectors.RestClientConnector;
import ar.com.educacionit.bootcamp.dto.Pokemon;
import jakarta.ws.rs.core.GenericType;

public class PokeApiConnector extends RestClientConnector<Pokemon> {

	public PokeApiConnector(String url) {
		super(url, Pokemon.class, new GenericType<List<Pokemon>>() {});
	}

}
