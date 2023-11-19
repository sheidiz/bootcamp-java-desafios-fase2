package ar.com.educacionit.bootcamp;

import ar.com.educacionit.bootcamp.dto.Pokemon;
import ar.com.educacionit.bootcamp.service.PokemonService;
import ar.com.educacionit.bootcamp.service.ServiceLocator;

public class PokemonMain {

	public static void main(String[] args) {
		PokemonService serviceDB = (PokemonService) ServiceLocator.getService(PokemonService.class);

		System.out.println("---Buscar por 1---");
		Pokemon one = serviceDB.buscarPorId(3);
		System.out.println(one);
	}

}
