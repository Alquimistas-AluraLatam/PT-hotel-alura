package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import jdbc.controller.HospedesController;
import jdbc.controller.ReservasController;
import jdbc.modelo.Hospedes;
import jdbc.modelo.Reserva;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Date;
import java.util.List;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Optional;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class Busca extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHospedes;
	private JTable tbReservas;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloHospede;
	private ReservasController reservaController;
	private HospedesController hospedesController;
	private JLabel labelAtras;
	private JLabel labelExit;
	int xMouse, yMouse;
	String reserva;
	String hospedes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busca frame = new Busca();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Busca() {
		this.reservaController = new ReservasController();
		this.hospedesController = new HospedesController();
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busca.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setUndecorated(true);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane(tbReservas);
		
		
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		
		JLabel lblTitulo = new JLabel("SISTEMA DE BUSCA");
		lblTitulo.setBounds(331, 62, 280, 42);
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setFont(new Font("Roboto Black", Font.BOLD, 24));
		contentPane.add(lblTitulo);
		
		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBounds(20, 169, 865, 328);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		contentPane.add(panel);
		
		

		tbHospedes = new JTable();
		tbHospedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.addTab("Hóspedes", new ImageIcon(Busca.class.getResource("/imagenes/pessoas.png")), tbHospedes, null);
		modeloHospede = (DefaultTableModel) tbHospedes.getModel();
		modeloHospede.addColumn("Numero de Hóspede");
		modeloHospede.addColumn("Nome");
		modeloHospede.addColumn("Sobrenome");
		modeloHospede.addColumn("Data de Nascimento");
		modeloHospede.addColumn("Nacionalidade");
		modeloHospede.addColumn("Telefone");
		modeloHospede.addColumn("Numero de Reserva");
		preencherTabelaHospedes();

		
		
		
		tbReservas = new JTable();
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.addTab("Reservas", new ImageIcon(Busca.class.getResource("/imagenes/reservado.png")), tbReservas, null);
		modelo = (DefaultTableModel) tbReservas.getModel();
		modelo.addColumn("Numero de Reserva");
		modelo.addColumn("Data Check In");
		modelo.addColumn("Data Check Out");
		modelo.addColumn("Valor");
		modelo.addColumn("Forma de Pagamento");
		tbReservas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		preencherTabelaReservas();
		
		JLabel logo = new JLabel("");
		logo.setBounds(56, 51, 104, 107);
		logo.setIcon(new ImageIcon(Busca.class.getResource("/imagenes/Ha-100px.png")));
		contentPane.add(logo);
		
		JPanel header = new JPanel();
		header.setBounds(0, 0, 910, 36);
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			     
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		contentPane.add(header);
		
		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(Color.white);
			     labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnexit.setBackground(Color.white);
			     labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(539, 159, 193, 2);
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		contentPane.add(separator_1_2);
		
		JPanel btnbuscar = new JPanel();
		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				limparTabela();
				preencherTabelaReservasId();
				preencherTabelaHospedesId();
			}
		});
		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);
		
		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JPanel btnEditar = new JPanel();
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				atualizarReservas();
				limparTabela();
				preencherTabelaReservas();
			}
		});
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);
		
		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);
		
		JPanel btnEliminar = new JPanel();
		btnEliminar.setBounds(767, 508, 122, 35);
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int filaReservas = tbReservas.getSelectedRow();
				int filaHospedes = tbHospedes.getSelectedRow();

				if (filaReservas >= 0) {

					reserva = tbReservas.getValueAt(filaReservas, 0).toString();
					int confirmar = JOptionPane.showConfirmDialog(null, "¿Deseja excluir os dados?");

					if(confirmar == JOptionPane.YES_OPTION){

						String valor = tbReservas.getValueAt(filaReservas, 0).toString();			
						reservaController.deletar(Integer.valueOf(valor));
						JOptionPane.showMessageDialog(contentPane, "Registro Excluído");
						limparTabela();
						preencherTabelaReservas();
					}
				}

				 if (filaHospedes >= 0) {

					hospedes = tbHospedes.getValueAt(filaHospedes, 0).toString();
					int confirmarh = JOptionPane.showConfirmDialog(null, "¿Deseja excluir os dados?");

					if(confirmarh == JOptionPane.YES_OPTION){

						String valor = tbHospedes.getValueAt(filaHospedes, 0).toString();
						hospedesController.deletar(Integer.valueOf(valor));
						JOptionPane.showMessageDialog(contentPane, "Registro Excluído");
						limparTabela();
						preencherTabelaHospedes();
						preencherTabelaReservas();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Erro: fileira não selecionada, por favor realize uma busca e selecione uma fileira para excluir");
				}							
			}
		});
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(12, 138, 199));
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);
		
		JLabel lblEliminar = new JLabel("EXCLUIR");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		setResizable(false);
	}
	private List<Reserva> buscarReservas() {
		return this.reservaController.buscar();
	}
	
	private List<Reserva> buscarReservasId() {
		return this.reservaController.buscarId(txtBuscar.getText());
	} 
	private List<Hospedes> buscarHospedes() {
		return this.hospedesController.listarHospedes();
	}
	
	private List<Hospedes> BuscarHospedesId() {
		return this.hospedesController.listarHospedesId(txtBuscar.getText());
	}
	
	private void limparTabela() {
		((DefaultTableModel) tbHospedes.getModel()).setRowCount(0);
		((DefaultTableModel) tbReservas.getModel()).setRowCount(0);
	}
	private void preencherTabelaReservas() {

	    // Povoar tabela
		List<Reserva> reservaLista = buscarReservas();
		try {
			for (Reserva reserva : reservaLista) {
				modelo.addRow(new Object[] { reserva.getId(), reserva.getDataEntrada(), reserva.getDataSaida(), reserva.getValor(), reserva.getFormaPagamento() });
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	private void preencherTabelaReservasId() {

	    // Povoar tabela
		List<Reserva> reservaLista = buscarReservasId();
		try {
			for (Reserva reserva : reservaLista) {
				modelo.addRow(new Object[] { reserva.getId(), reserva.getDataEntrada(), reserva.getDataSaida(), reserva.getValor(), reserva.getFormaPagamento() });
			}
		} catch (Exception e) {
			throw e;
		}
	}

	private void preencherTabelaHospedes() {
	    //Preencher Tabela
		List<Hospedes> hospedesLista = buscarHospedes();
		try {
			for (Hospedes hospede : hospedesLista) {
				modeloHospede.addRow(new Object[] { hospede.getId(), hospede.getNome(), hospede.getSobrenome(), hospede.getDataNascimento(), hospede.getNacionalidade(), hospede.getTelefone(), hospede.getIdReserva() });
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	private void preencherTabelaHospedesId() {
	    //Preencher Tabela
		List<Hospedes> hospedesLista = BuscarHospedesId();
		try {
			for (Hospedes hospede : hospedesLista) {
				modeloHospede.addRow(new Object[] { hospede.getId(), hospede.getNome(), hospede.getSobrenome(), hospede.getDataNascimento(), hospede.getNacionalidade(), hospede.getTelefone(), hospede.getIdReserva() });
			}
		} catch (Exception e) {
			throw e;
		}
	}
	
	private void atualizarReservas() {

		Optional.ofNullable(modelo.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
				.ifPresentOrElse(fila -> {

					Date dataEntrada = Date.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 1).toString());
					Date dataSaida = Date.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 2).toString());
					String valor = (String) modelo.getValueAt(tbReservas.getSelectedRow(), 3);
					String formaPagamento = (String) modelo.getValueAt(tbReservas.getSelectedRow(), 4);
					Integer id = Integer.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString());
					this.reservaController.atualizar(dataEntrada,dataSaida, valor, formaPagamento, id);
					JOptionPane.showMessageDialog(this, String.format("Registro modificado com êxito"));
				}, () -> JOptionPane.showMessageDialog(this, "Por favor, escolha um registro"));
	}

	private void atualizarHospede() {
		Optional.ofNullable(modeloHospede.getValueAt(tbHospedes.getSelectedRow(), tbHospedes.getSelectedColumn()))
				.ifPresentOrElse(filaHuesped -> {

					String nome = (String) modeloHospede.getValueAt(tbHospedes.getSelectedRow(), 1);
					String sobrenome = (String) modeloHospede.getValueAt(tbHospedes.getSelectedRow(), 2);
					Date dataNascimento = Date.valueOf(modeloHospede.getValueAt(tbHospedes.getSelectedRow(), 3).toString());
					String nacionalidade = (String) modeloHospede.getValueAt(tbHospedes.getSelectedRow(), 4);
					String telefone = (String) modeloHospede.getValueAt(tbHospedes.getSelectedRow(), 5);
					Integer idReserva = Integer.valueOf(modeloHospede.getValueAt(tbHospedes.getSelectedRow(), 6).toString());
					Integer id = Integer.valueOf(modeloHospede.getValueAt(tbHospedes.getSelectedRow(), 0).toString());
					this.hospedesController.atualizar(nome,sobrenome,dataNascimento, nacionalidade, telefone, idReserva, id);
					JOptionPane.showMessageDialog(this, String.format("Registro modificado com êxito"));
				}, () -> JOptionPane.showMessageDialog(this, "Por favor, escolha um registro"));

	}
	
	 private void headerMousePressed(java.awt.event.MouseEvent evt) {
	        xMouse = evt.getX();
	        yMouse = evt.getY();
	    }

	    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
	        int x = evt.getXOnScreen();
	        int y = evt.getYOnScreen();
	        this.setLocation(x - xMouse, y - yMouse);
}
}
