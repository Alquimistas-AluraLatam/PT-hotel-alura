package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Genesys\\Documents\\imagenesAluraHotel\\perfil-del-usuario.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Genesys\\Documents\\imagenesAluraHotel\\hotel.png"));
		lblNewLabel.setBounds(-53, 0, 422, 499);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(409, 181, 234, 33);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Usuario");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(409, 156, 57, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(409, 261, 234, 33);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Senha");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(409, 236, 133, 14);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setIcon(new ImageIcon("C:\\Users\\Genesys\\Documents\\imagenesAluraHotel\\perfil-del-usuario.png"));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
		});
		btnLogin.setBounds(409, 322, 109, 33);
		contentPane.add(btnLogin);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon("C:\\Users\\Genesys\\Documents\\imagenesAluraHotel\\cerrar-24px.png"));
		btnCancelar.setBounds(528, 322, 115, 33);
		contentPane.add(btnCancelar);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Genesys\\Documents\\imagenesAluraHotel\\Ha-100px.png"));
		lblNewLabel_1.setBounds(470, 30, 103, 94);
		contentPane.add(lblNewLabel_1);
	}
}
