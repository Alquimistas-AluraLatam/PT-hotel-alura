package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.SystemColor;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class MenuUsuario extends JFrame {

	private JPanel contentPane;
	int xMouse, yMouse;
	private JLabel labelExit;
	private JLabel labelRegistro;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuUsuario.class.getResource("/imagenes/aH-40px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 944, 609);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		JPanel header = new JPanel();
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
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(12, 138, 199));
		panelMenu.setBounds(0, 0, 257, 609);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setBounds(50, 58, 150, 150);
		panelMenu.add(logo);
		logo.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/aH-150px.png")));
		
		JPanel btnRegistro = new JPanel();
		btnRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegistro.setBackground(new Color(118, 187, 223));				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnRegistro.setBackground(new Color(12, 138, 199));	
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				ReservasView reservas = new ReservasView();
				reservas.setVisible(true);
				dispose();
			}
		});
		btnRegistro.setBounds(0, 255, 257, 56);
		btnRegistro.setBackground(new Color(12, 138, 199));
		panelMenu.add(btnRegistro);
		btnRegistro.setLayout(null);
		btnRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		labelRegistro = new JLabel("Registro de reservas");
		labelRegistro.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/reservado.png")));
		labelRegistro.setForeground(SystemColor.text);
		labelRegistro.setBounds(25, 11, 205, 34);
		labelRegistro.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelRegistro.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegistro.add(labelRegistro);
		
		JPanel btnBuscar = new JPanel();
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBuscar.setBackground(new Color(118, 187, 223));				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBuscar.setBackground(new Color(12, 138, 199));	
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Busca busca = new Busca();
				busca.setVisible(true);
				dispose();
			}
		});
		btnBuscar.setBounds(0, 312, 257, 56);
		btnBuscar.setBackground(new Color(12, 138, 199));
		panelMenu.add(btnBuscar);
		btnBuscar.setLayout(null);
		btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		JLabel lblBuscaDeReservas = new JLabel("Busca");
		lblBuscaDeReservas.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/pessoas.png")));
		lblBuscaDeReservas.setBounds(27, 11, 200, 34);
		lblBuscaDeReservas.setHorizontalAlignment(SwingConstants.LEFT);
		lblBuscaDeReservas.setForeground(Color.WHITE);
		lblBuscaDeReservas.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnBuscar.add(lblBuscaDeReservas);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(26, 219, 201, 2);
		panelMenu.add(separator);
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 944, 36);
		contentPane.add(header);
		
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
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
		btnexit.setBounds(891, 0, 53, 36);
		header.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		
	    JPanel panelData = new JPanel();
	    panelData.setBackground(new Color(118, 187, 223));
	    panelData.setBounds(256, 84, 688, 121);
	    contentPane.add(panelData);
	    panelData.setLayout(null);
	    
	    JLabel lblTituloPrincipal = new JLabel("Sistema de reservas Hotel Alura");
	    lblTituloPrincipal.setBounds(180, 11, 356, 42);
	    panelData.add(lblTituloPrincipal);
	    lblTituloPrincipal.setForeground(Color.WHITE);
	    lblTituloPrincipal.setFont(new Font("Roboto", Font.PLAIN, 24));
	    
	    JLabel labelData = new JLabel("New label");
	    labelData.setBounds(35, 64, 294, 36);
	    panelData.add(labelData);
	    labelData.setForeground(Color.WHITE);
	    labelData.setFont(new Font("Roboto", Font.PLAIN, 33));
	    Date dataAtual = new Date(); //data e hora atuais
	    String data = new SimpleDateFormat("dd/MM/yyyy").format(dataAtual); //formata a data numa string
	    labelData.setText("Hoje é " + data); //estabelece a data na label
	    
	    JLabel lblTitulo = new JLabel("Bem-vindo");
	    lblTitulo.setFont(new Font("Roboto", Font.BOLD, 24));
	    lblTitulo.setBounds(302, 234, 147, 46);
	    contentPane.add(lblTitulo);
	    
	    String textoDescricao = "<html><body>Sistema de reservas de hotéis. Controle e gerencie de forma otimizada e fácil <br> o fluxo de reservas e hóspedes do hotel   </body></html>";
	    JLabel labelDescricao = new JLabel(textoDescricao);
	    labelDescricao.setFont(new Font("Roboto", Font.PLAIN, 17));
	   
	    labelDescricao.setBounds(312, 291, 598, 66);
	    contentPane.add(labelDescricao);
	    
	    String textoDescricao1 = "<html><body> Esta ferramenta permitirá que você mantenha um controle completo e detalhado de suas reservas e hóspedes, você terá acesso a ferramentas especiais para tarefas específicas como:</body></html>";
	    JLabel labelDescricao_1 = new JLabel(textoDescricao1);
	    labelDescricao_1.setFont(new Font("Roboto", Font.PLAIN, 17));
	    labelDescricao_1.setBounds(311, 345, 569, 88);
	    contentPane.add(labelDescricao_1);
	    
	    JLabel lblDescricao_3 = new JLabel("- Registro de Reservas e Hóspedes");
	    lblDescricao_3.setFont(new Font("Roboto", Font.PLAIN, 17));
	    lblDescricao_3.setBounds(312, 444, 295, 27);
	    contentPane.add(lblDescricao_3);
	    
	    JLabel lblDescricao_4 = new JLabel("- Edição de Reservas e Hóspedes existentes");
	    lblDescricao_4.setFont(new Font("Roboto", Font.PLAIN, 17));
	    lblDescricao_4.setBounds(312, 482, 355, 27);
	    contentPane.add(lblDescricao_4);
	    
	    JLabel lblDescricao_5 = new JLabel("- Excluir todos os tipos de registros");
	    lblDescricao_5.setFont(new Font("Roboto", Font.PLAIN, 17));
	    lblDescricao_5.setBounds(312, 520, 295, 27);
	    contentPane.add(lblDescricao_5);
	}
	
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }
}
