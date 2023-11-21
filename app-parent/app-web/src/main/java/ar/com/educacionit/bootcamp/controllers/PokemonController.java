package ar.com.educacionit.bootcamp.controllers;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.educacionit.bootcamp.service.pokemon.PokemonService;
import ar.com.educacionit.bootcamp.connectors.pokemon.PokeApiService;
import ar.com.educacionit.bootcamp.dto.Pokemon;
import ar.com.educacionit.bootcamp.service.ServiceLocator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/pokemon")
public class PokemonController extends HttpServlet {

	private static final long serialVersionUID = 4694227166969350824L;
	private PokemonService serviceDB = (PokemonService) ServiceLocator.getService(PokemonService.class);
	private PokeApiService serviceAPI = (PokeApiService) ServiceLocator.getService(PokeApiService.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.addHeader("Access-Control-Allow-Origin", "http://localhost:5500");
		Integer id = Integer.parseInt(req.getParameter("id"));
		Pokemon pkmn = serviceDB.buscarPorId(id);
		
		if(pkmn == null) {
			Pokemon pkmnApi = serviceAPI.buscarPorId(id);
			if(pkmnApi!=null) {
				serviceDB.guardar(pkmnApi);
				pkmn = serviceDB.buscarPorId(id);
			}
		}
		
		if (pkmn != null) {
			resp.setContentType("application/json");
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonPokemon = objectMapper.writeValueAsString(pkmn);
			resp.getWriter().print(jsonPokemon);
		}
	}

}
