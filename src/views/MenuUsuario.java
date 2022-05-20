package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class MenuUsuario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuUsuario frame = new MenuUsuario();
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
	public MenuUsuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Genesys\\Documents\\imagenesAluraHotel\\aH-40px.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 906, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Genesys\\Documents\\imagenesAluraHotel\\menu-img.png"));
		lblNewLabel.setBounds(-56, 0, 741, 471);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Genesys\\Documents\\imagenesAluraHotel\\Ha-100px.png"));
		lblNewLabel_2.setBounds(724, 32, 104, 107);
		contentPane.add(lblNewLabel_2);
		
		JButton btnReserva = new JButton("");
		btnReserva.setIcon(new ImageIcon("C:\\Users\\Genesys\\Documents\\imagenesAluraHotel\\1.png"));
		btnReserva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reservas reserva = new Reservas();
				reserva.setVisible(true);
				dispose();
			}
		});
		btnReserva.setForeground(Color.WHITE);
		btnReserva.setBackground(Color.WHITE);
		btnReserva.setBounds(741, 186, 71, 73);
		contentPane.add(btnReserva);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(12, 138, 199));
		panel_1.setBounds(0, 470, 894, 30);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Desarrollado por Fulanita de Tal © 2022");
		lblNewLabel_3.setForeground(new Color(12, 138, 199));
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 13));
		panel_1.add(lblNewLabel_3);
		
		JButton btnSair = new JButton("");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal principal = new MenuPrincipal();
				principal.setVisible(true);
				dispose();
			}
		});
		btnSair.setIcon(new ImageIcon("C:\\Users\\Genesys\\Documents\\imagenesAluraHotel\\cerrar-sesion 32-px.png"));
		btnSair.setForeground(Color.WHITE);
		btnSair.setBackground(Color.WHITE);
		btnSair.setBounds(823, 411, 50, 47);
		contentPane.add(btnSair);
		
		JLabel lblNewLabel_1_1 = new JLabel("Reservas");
		lblNewLabel_1_1.setForeground(new Color(12, 138, 199));
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(741, 163, 80, 17);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Buscar");
		lblNewLabel_1_1_1.setForeground(new Color(12, 138, 199));
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(741, 274, 77, 17);
		contentPane.add(lblNewLabel_1_1_1);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buscar busca = new Buscar();
				busca.setVisible(true);
				dispose();
			}
		});
		btnBuscar.setIcon(new ImageIcon("C:\\Users\\Genesys\\Documents\\imagenesAluraHotel\\busqueda.png"));
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setBackground(Color.WHITE);
		btnBuscar.setBounds(741, 302, 71, 73);
		contentPane.add(btnBuscar);
	}
}
