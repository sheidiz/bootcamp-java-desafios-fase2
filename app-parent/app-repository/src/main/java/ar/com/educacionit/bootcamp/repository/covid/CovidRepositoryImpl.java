package ar.com.educacionit.bootcamp.repository.covid;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ar.com.educacionit.bootcamp.dto.Covid;
import ar.com.educacionit.bootcamp.repository.BaseCrud;

public class CovidRepositoryImpl extends BaseCrud<Covid> implements CovidRepository {

	public CovidRepositoryImpl() {
		super(Covid.class, "COVID");
	}

	@Override
	protected String getSaveSQL() {
		return "(date, states, positive, negative, pending, hash) values (?,?,?,?,?,?)";
	}

	@Override
	protected void saveEntity(Covid entidad, PreparedStatement pst) throws SQLException {
		pst.setString(1, entidad.getDate());
		pst.setInt(2, entidad.getStates());
		pst.setInt(3, entidad.getPositive());
		pst.setInt(4, entidad.getNegative());
		pst.setInt(5, entidad.getPending());
		pst.setString(6, entidad.getHash());
	}

	@Override
	protected Covid fromResultSetToEntity(ResultSet res) throws SQLException {
		String date = res.getString(1);
		int states = res.getInt(2);
		int positive = res.getInt(3);
		int negative = res.getInt(4);
		int pending = res.getInt(5);
		String hash = res.getString(6);

		return new Covid(date, states, positive, negative, pending, hash);
	}	

}
