package ar.com.educacionit.bootcamp.service;

import ar.com.educacionit.bootcamp.dto.Pokemon;
import ar.com.educacionit.bootcamp.repository.PokemonRepositoryImpl;

public class PokemonServiceImpl extends AbstractEntidadBaseService<Pokemon> implements PokemonService {

	public PokemonServiceImpl() {
		super(new PokemonRepositoryImpl());
	}


}
