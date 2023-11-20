package ar.com.educacionit.bootcamp.connectors.placeholder;

import java.util.List;

import ar.com.educacionit.bootcamp.connectors.RestClientConnector;
import ar.com.educacionit.bootcamp.dto.Placeholder;
import jakarta.ws.rs.core.GenericType;

public class PlaceholderApiConnector extends RestClientConnector<Placeholder> {

	public PlaceholderApiConnector(String url) {
		super(url, Placeholder.class, new GenericType<List<Placeholder>>() {});
	}

}
