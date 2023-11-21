package ar.com.educacionit.bootcamp.repository.placeholder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import ar.com.educacionit.bootcamp.dto.Placeholder;
import ar.com.educacionit.bootcamp.repository.BaseCrud;

public class PlaceholderRepositoryImpl extends BaseCrud<Placeholder> implements PlaceholderRepository {

	public PlaceholderRepositoryImpl() {
		super(Placeholder.class, "PLACEHOLDER");
	}

	@Override
	protected String getSaveSQL() {
		return "(userId, id, title, body) values (?,?,?,?)";
	}

	@Override
	protected void saveEntity(Placeholder entidad, PreparedStatement pst) throws SQLException {
		pst.setInt(1, entidad.getUserId());
		pst.setInt(2, entidad.getId());
		pst.setString(3, entidad.getTitle());
		pst.setString(4, entidad.getBody());
	}

	@Override
	protected Placeholder fromResultSetToEntity(ResultSet res) throws SQLException {
		int userId = res.getInt(1);
		int id_ = res.getInt(2);
		String title = res.getString(3);
		String body = res.getString(4);

		return new Placeholder(userId, id_, title, body);
	}

}
