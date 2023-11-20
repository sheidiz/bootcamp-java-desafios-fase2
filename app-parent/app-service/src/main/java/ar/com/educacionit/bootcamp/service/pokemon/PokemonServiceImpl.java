package ar.com.educacionit.bootcamp.service.pokemon;

import ar.com.educacionit.bootcamp.dto.Pokemon;
import ar.com.educacionit.bootcamp.repository.pokemon.PokemonRepositoryImpl;
import ar.com.educacionit.bootcamp.service.AbstractEntidadBaseService;

public class PokemonServiceImpl extends AbstractEntidadBaseService<Pokemon> implements PokemonService {

	public PokemonServiceImpl() {
		super(new PokemonRepositoryImpl());
	}


}
