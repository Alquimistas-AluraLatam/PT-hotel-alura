package jdbc.controller;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import jdb.factory.ConnectionFactory;
import jdbc.dao.ReservaDAO;
import jdbc.modelo.Reserva;

public class ReservasController {
 private ReservaDAO reservaDAO;
 
 public ReservasController() {
		Connection connection = new ConnectionFactory().recuperarConexao();
		this.reservaDAO = new ReservaDAO(connection);
	}
 
	public void salvar(Reserva reserva) {
		this.reservaDAO.salvar(reserva);
	}
		
	public List<Reserva> buscar() {
		return this.reservaDAO.buscar();
	}
	
	public List<Reserva> buscarId(String id) {
		return this.reservaDAO.buscarId(id);
	}
	
	public void atualizar(Date dataEntrada, Date dataSaida, String valor, String formaPagamento, Integer id) {
		this.reservaDAO.atualizar(dataEntrada, dataSaida, valor, formaPagamento, id);
	}
	
	public void deletar(Integer id) {
		this.reservaDAO.deletar(id);
	}
}
