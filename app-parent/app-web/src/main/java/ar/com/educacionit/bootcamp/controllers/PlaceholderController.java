package ar.com.educacionit.bootcamp.controllers;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.educacionit.bootcamp.connectors.placeholder.PlaceholderApiService;
import ar.com.educacionit.bootcamp.dto.Placeholder;
import ar.com.educacionit.bootcamp.service.ServiceLocator;
import ar.com.educacionit.bootcamp.service.placeholder.PlaceholderService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/placeholder")
public class PlaceholderController extends HttpServlet {

	private static final long serialVersionUID = 8779896911337927637L;
	private PlaceholderService serviceDB = (PlaceholderService) ServiceLocator.getService(PlaceholderService.class);
	private PlaceholderApiService serviceAPI = (PlaceholderApiService) ServiceLocator
			.getService(PlaceholderApiService.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer id = Integer.parseInt(req.getParameter("id"));
		Placeholder post = serviceDB.buscarPorId(id);

		// si no lo encontro lo busca en la api
		if (post == null) {
			Placeholder postAPI = serviceAPI.buscarPorId(id);
			if (postAPI != null) {
				serviceDB.guardar(postAPI);
				post = serviceDB.buscarPorId(id);
			}
		}
		this.enviarJson(resp, post);
	}

	private void enviarJson(HttpServletResponse resp, Placeholder post) throws IOException {
		if (post != null) {
			resp.setContentType("application/json");
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonPost = objectMapper.writeValueAsString(post);
			System.out.println(jsonPost);
			resp.getWriter().print(jsonPost);
		}
	}
}
