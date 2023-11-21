package ar.com.educacionit.bootcamp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ar.com.educacionit.bootcamp.db.AdministradorDeConexiones;
import ar.com.educacionit.bootcamp.dto.Entity;

public abstract class BaseCrud<T> extends Entity implements BaseRepository<T> {

	private Class<T> type;
	private String table;

	public BaseCrud(Class<T> type, String table) {
		this.type = type;
		this.table = table;
	}

	protected abstract String getSaveSQL();

	protected abstract void saveEntity(T entidad, PreparedStatement pst) throws SQLException;

	@Override
	public void guardar(T entidad) {
		System.out.println("save" + entidad);
		String sql = "INSERT INTO " + this.table + this.getSaveSQL();
		try (Connection connection = AdministradorDeConexiones.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

			saveEntity(entidad, statement);

			statement.executeUpdate();

			ResultSet resKey = statement.getGeneratedKeys();
			if (resKey.next()) {
				((Entity) entidad).setId(resKey.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	// cada RespositoryImpl debe implementar como extrae la data desde ResultSet
	protected abstract T fromResultSetToEntity(ResultSet res) throws SQLException;
	@Override
	public Collection<T> buscarTodos() {
		System.out.println("findAll " + type.getName());
		String sql = "SELECT * FROM " + this.table;
		List<T> lista = new ArrayList<>();

		try (Connection connection = AdministradorDeConexiones.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				lista.add(this.fromResultSetToEntity(resultSet));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	@Override
	public T buscarPorId(int id) {
		System.out.println("getById " + type.getName());
		String sql = "SELECT * FROM " + this.table + " WHERE ID = " + id;
		T entidad = null;

		try (Connection connection = AdministradorDeConexiones.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet resultSet = statement.executeQuery();

			// si lo encuentra
			if (resultSet.next()) {
				entidad = this.fromResultSetToEntity(resultSet);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entidad;
	}

	@Override
	public T buscarPorCampo(String campo, String valor) {
		System.out.println("getByColumn " + type.getName());
		String sql = "SELECT * FROM " + this.table + " WHERE " + campo + " = " + valor;
		T entity = null;
		
		try (Connection connection = AdministradorDeConexiones.getConnection()) {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultSet = statement.executeQuery();
			
			// si lo encuentra
			if (resultSet.next()) {
				entity = this.fromResultSetToEntity(resultSet);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entity;
	}

	@Override
	public void actualizar(T entidad) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub

	}

}
