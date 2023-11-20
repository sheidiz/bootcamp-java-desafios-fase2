package ar.com.educacionit.bootcamp.controllers;

import java.io.IOException;

import ar.com.educacionit.bootcamp.service.pokemon.PokemonService;
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

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PokemonService serviceDB = (PokemonService) ServiceLocator.getService(PokemonService.class);
		
		Pokemon pkmn = serviceDB.buscarPorId(5);
		System.out.println(pkmn);
		resp.getWriter().print(pkmn);
	}
}
