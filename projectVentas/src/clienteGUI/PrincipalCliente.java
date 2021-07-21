package clienteGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import projectVentasClases.Cliente;
import vendedorGUI.LoginVendedor;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Cursor;

public class PrincipalCliente {

	public JFrame frame;
	public Cliente clienteCopia;
	public JTextField textNombre;
	private JTextField textFecha;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public PrincipalCliente(Cliente clienteCopia) {
		this.clienteCopia=clienteCopia;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(153, 204, 204));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 868, 604);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido Al Sistema");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 44));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(70, 41, 673, 85);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cliente :");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(20, 399, 93, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		textNombre = new JTextField();
		textNombre.setFont(new Font("Arial", Font.BOLD, 18));
		textNombre.setEditable(false);
		textNombre.setBounds(123, 399, 237, 27);
		frame.getContentPane().add(textNombre);
		textNombre.setText(clienteCopia.getNombre()+" "+clienteCopia.getApellido());
		textNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha Actual :");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2.setBounds(502, 317, 139, 27);
		frame.getContentPane().add(lblNewLabel_2);
		
		textFecha = new JTextField();
		textFecha.setHorizontalAlignment(SwingConstants.CENTER);
		textFecha.setFont(new Font("Arial", Font.BOLD, 18));
		textFecha.setEditable(false);
		textFecha.setColumns(10);
		textFecha.setBounds(646, 317, 139, 27);
		frame.getContentPane().add(textFecha);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(102, 153, 153));
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("MANTENIMIENTO");
		mnNewMenu_1.setForeground(new Color(0, 0, 0));
		mnNewMenu_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		mnNewMenu_1.setVerticalAlignment(SwingConstants.BOTTOM);
		mnNewMenu_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		mnNewMenu_1.setHorizontalTextPosition(SwingConstants.CENTER);
		mnNewMenu_1.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu_1.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\mantenimiento-web.png"));
		mnNewMenu_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Actualizar cuenta");
		mntmNewMenuItem.setFont(new Font("Arial Black", Font.BOLD, 12));
		mntmNewMenuItem.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\rotacion.png"));
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_2 = new JMenu("COMPRAS");
		mnNewMenu_2.setForeground(new Color(0, 0, 0));
		mnNewMenu_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		mnNewMenu_2.setVerticalTextPosition(SwingConstants.BOTTOM);
		mnNewMenu_2.setVerticalAlignment(SwingConstants.BOTTOM);
		mnNewMenu_2.setHorizontalTextPosition(SwingConstants.CENTER);
		mnNewMenu_2.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnNewMenu_2.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\consumidor.png"));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("A\u00F1adir compra");
		mntmNewMenuItem_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		mntmNewMenuItem_1.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\venta.png"));
		mnNewMenu_2.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_3 = new JMenu("SERVICIOS");
		mnNewMenu_3.setFont(new Font("Arial Black", Font.BOLD, 12));
		mnNewMenu_3.setForeground(new Color(0, 0, 0));
		mnNewMenu_3.setHorizontalTextPosition(SwingConstants.CENTER);
		mnNewMenu_3.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu_3.setVerticalAlignment(SwingConstants.BOTTOM);
		mnNewMenu_3.setVerticalTextPosition(SwingConstants.BOTTOM);
		mnNewMenu_3.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\servicio-al-cliente.png"));
		mnNewMenu_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Servicio Tecnico");
		mntmNewMenuItem_2.setHorizontalAlignment(SwingConstants.LEFT);
		mntmNewMenuItem_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		mntmNewMenuItem_2.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\soporte-tecnico.png"));
		mnNewMenu_3.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu = new JMenu("AYUDA");
		mnNewMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnNewMenu.setBackground(new Color(255, 255, 255));
		mnNewMenu.setFont(new Font("Arial Black", Font.BOLD, 12));
		mnNewMenu.setForeground(Color.BLACK);
		mnNewMenu.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\informacion.png"));
		mnNewMenu.setVerticalTextPosition(SwingConstants.BOTTOM);
		mnNewMenu.setHorizontalTextPosition(SwingConstants.CENTER);
		menuBar.add(mnNewMenu);
		
		JButton btnCalculadora = new JButton("Calculadora");
		btnCalculadora.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnCalculadora.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCalculadora.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\calculadora.png"));
		mnNewMenu.add(btnCalculadora);
		
		SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
		textFecha.setText(formateador.format(new Date()));
		
		JButton btnCerrarSesion = new JButton("CERRAR SESION");
		btnCerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCerrarSesion.setFont(new Font("Arial Black", Font.PLAIN, 18));
		btnCerrarSesion.setBounds(584, 386, 222, 51);
		frame.getContentPane().add(btnCerrarSesion);
		

		btnCalculadora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//aqui mostrara una calculadora
			Calculadora principal=new Calculadora();
			principal.frmCalculadora.setVisible(true);
			}
		});
		

		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			MantenimientoCliente principal=new MantenimientoCliente(clienteCopia,frame);
			principal.frame.setVisible(true);
			}
		});
		

		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ServicioTecnico principal=new ServicioTecnico();
				principal.frmServicioTecnico.setVisible(true);
			}
		});

		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CompraCliente principal=new CompraCliente(clienteCopia);
				principal.frame.setVisible(true);
			
			}
		});

		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				LoginCliente principal=new LoginCliente();
				principal.frmLogin.setVisible(true);
			}
		});
	}
}
