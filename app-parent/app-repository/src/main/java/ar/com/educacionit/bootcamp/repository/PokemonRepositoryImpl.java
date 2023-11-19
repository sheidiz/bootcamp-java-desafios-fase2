package ar.com.educacionit.bootcamp.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ar.com.educacionit.bootcamp.dto.Pokemon;

public class PokemonRepositoryImpl extends BaseCrud<Pokemon> implements PokemonRepository {
	
	public PokemonRepositoryImpl() {
		super(Pokemon.class,"POKEMON");
	}
	
	@Override
	protected String getSaveSQL() {
		return "(id, name, baseExperience, height, weight) values (?,?,?,?,?)";
	}

	@Override
	protected void saveEntity(Pokemon entidad, PreparedStatement pst) throws SQLException {
		pst.setInt(1, entidad.getId());
		pst.setString(2, entidad.getName());
		pst.setInt(3, entidad.getBaseExperience());
		pst.setInt(4, entidad.getHeight());
		pst.setInt(5, entidad.getWeight());
	}
	
	@Override
	protected Pokemon fromResultSetToEntity(ResultSet res) throws SQLException {
		int id = res.getInt(1);
		String name = res.getString(2);
		int baseExperience = res.getInt(3);
		int height = res.getInt(4);
		int weight = res.getInt(5);
		
		return new Pokemon(id, name, baseExperience, height, weight);
	}
	
}
