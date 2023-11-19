package ar.com.educacionit.bootcamp;

import ar.com.educacionit.bootcamp.connectors.pokemon.PokeApiService;
import ar.com.educacionit.bootcamp.dto.Pokemon;
import ar.com.educacionit.bootcamp.service.PokemonService;
import ar.com.educacionit.bootcamp.service.ServiceLocator;

public class PokemonMain {

	public static void main(String[] args) {
		PokemonService serviceDB = (PokemonService) ServiceLocator.getService(PokemonService.class);

		System.out.println("---Buscar por ID:5 en DB---");
		Pokemon pkmn = serviceDB.buscarPorId(5);

		if (pkmn != null) {
			// si lo encuentra lo muestra
			System.out.println(pkmn);
		} else {
			// si no, lo busca en la api
			System.out.println("No se encontro en la bd, recolectando de API...");
			PokeApiService serviceAPI = (PokeApiService) ServiceLocator.getService(PokeApiService.class);
			pkmn = serviceAPI.buscarPorId(5);
			serviceDB.guardar(pkmn);
			System.out.println(serviceDB.buscarPorId(5));
		}

	}

}
