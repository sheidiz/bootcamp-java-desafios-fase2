package ar.com.educacionit.bootcamp.connectors.covid;

import java.util.List;

import ar.com.educacionit.bootcamp.connectors.RestClientConnector;
import ar.com.educacionit.bootcamp.dto.Covid;
import jakarta.ws.rs.core.GenericType;

public class CovidApiConnector extends RestClientConnector<Covid> {

	public CovidApiConnector(String url) {
		super(url, Covid.class, new GenericType<List<Covid>>() {});
	}

}
