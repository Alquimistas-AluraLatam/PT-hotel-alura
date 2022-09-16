package jdbc.controller;
import java.sql.Connection;
import java.util.List;

import jdb.factory.ConnectionFactory;
import jdbc.dao.HospedesDAO;
import jdbc.modelo.Hospedes;


public class HospedesController {
	 private HospedesDAO hospedesDAO;

	 public HospedesController() {
			Connection connection = new ConnectionFactory().recuperarConexao();
			this.hospedesDAO = new HospedesDAO(connection);
		}
	 
		public void salvar(Hospedes hospedes) {
			this.hospedesDAO.salvar(hospedes);
		}
		public List<Hospedes> listarHospedes() {
			return this.hospedesDAO.listarHuespedes();
		}
		
		public List<Hospedes> listarHospedesId(String id) {
			return this.hospedesDAO.buscarId(id);
		}
		
		public void deletar(Integer id) {
			this.hospedesDAO.deletar(id);
		}
}
