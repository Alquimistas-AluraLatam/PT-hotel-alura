package jdbc.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import jdbc.modelo.Hospedes;


public class HospedesDAO {
private Connection connection;
	
	public HospedesDAO(Connection connection) {
		this.connection = connection;
	}
	
	public void salvar(Hospedes hospedes) {
		try {
			String sql = "INSERT INTO hospedes (nome, sobrenome, data_nascimento, nacionalidade, telefone, idReserva) VALUES (?, ?, ?, ?,?,?)";

			try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

				pstm.setString(1, hospedes.getNome());
				pstm.setString(2, hospedes.getSobrenome());
				pstm.setDate(3, hospedes.getDataNascimento());
				pstm.setString(4, hospedes.getNacionalidade());
				pstm.setString(5, hospedes.getTelefone());
				pstm.setInt(6, hospedes.getIdReserva());

				pstm.execute();

				try (ResultSet rst = pstm.getGeneratedKeys()) {
					while (rst.next()) {
						hospedes.setId(rst.getInt(1));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<Hospedes> listarHospedes() {
		List<Hospedes> hospedes = new ArrayList<>();
		try {
			String sql = "SELECT id, nome, sobrenome, data_nascimento, nacionalidade, telefone, idReserva FROM hospedes";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.execute();

				transformarResultSetEmHospede(hospedes, pstm);
			}
			return hospedes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Hospedes> buscarId(String id) {
		List<Hospedes> hospedes = new ArrayList<Hospedes>();
		try {

			String sql = "SELECT id, nome, sobrenome, data_nascimento, nacionalidade, telefone, idReserva FROM hospedes WHERE id = ?";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.setString(1, id);
				pstm.execute();

				transformarResultSetEmHospede(hospedes, pstm);
			}
			return hospedes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void atualizar(String nome, String sobrenome, Date dataNascimento, String nacionalidade, String telefone, Integer idReserva, Integer id) {
		try (PreparedStatement stm = connection
				.prepareStatement("UPDATE hospedes SET nome = ?, sobrenome = ?, data_nascimento = ?, nacionalidade = ?, telefone = ?, idReserva = ? WHERE id = ?")) {
			stm.setString(1, nome);
			stm.setString(2, sobrenome);
			stm.setDate(3, dataNascimento);
			stm.setString(4, nacionalidade);
			stm.setString(5, telefone);
			stm.setInt(6, idReserva);
			stm.setInt(7, id);
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void deletar(Integer id) {
		try (PreparedStatement stm = connection.prepareStatement("DELETE FROM hospedes WHERE id = ?")) {
			stm.setInt(1, id);
			stm.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void transformarResultSetEmHospede(List<Hospedes> reservas, PreparedStatement pstm) throws SQLException {
		try (ResultSet rst = pstm.getResultSet()) {
			while (rst.next()) {
				Hospedes hospedes = new Hospedes(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDate(4), rst.getString(5), rst.getString(6), rst.getInt(7));
				reservas.add(hospedes);
			}
		}				
	}
	
	
		
}

