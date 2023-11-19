package ar.com.educacionit.bootcamp.connectors;

import java.util.List;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

public class RestClientConnector<T> {
	private String url;
	private Class<T> type;
	private GenericType<List<T>> listType;

	public RestClientConnector(String url, Class<T> type, GenericType<List<T>> listType) {
		super();
		this.url = url;
		this.type = type;
		this.listType = listType;
	}

	public T get(String path) {
		Client client = ClientBuilder.newClient();

		WebTarget target = client.target(url);

		if (path != null) {
			target = target.path(path);
		}

		Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);

		Response response = invocation.get();

		if (response.getStatus() != Status.OK.getStatusCode()) {
			throw new RuntimeException(response.getStatusInfo().getReasonPhrase());
		}

		T responseDto = this.buildFromResponse(response);

		return responseDto;
	}

	private T buildFromResponse(Response response) {
		return response.readEntity(this.type);
	}
}
