package projectVentas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import vendedorGUI.LoginVendedor;
import vendedorGUI.MantenimientoCategoria;
import vendedorGUI.MantenimientoProductos;

import javax.swing.JMenu;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.SwingConstants;

import clienteGUI.LoginCliente;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class PrincipalAdmin {

	public JFrame frame;
	private JTextField textHora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalAdmin window = new PrincipalAdmin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PrincipalAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 248, 255));
		frame.setBounds(100, 100, 695, 567);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);


		JLabel lblFondo = new JLabel("");
		lblFondo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFondo.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblFondo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFondo.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\admin1.png"));
		lblFondo.setBounds(0, 0, 679, 438);
		frame.getContentPane().add(lblFondo);
		
		JLabel lblTitulo = new JLabel("Administrador");
		lblTitulo.setFont(new Font("Arial Black", Font.BOLD, 35));
		lblTitulo.setBounds(23, 69, 345, 67);
		frame.getContentPane().add(lblTitulo);
		
		textHora = new JTextField();
		textHora.setBackground(new Color(204, 204, 204));
		textHora.setEditable(false);
		textHora.setFont(new Font("Arial", Font.BOLD, 22));
		textHora.setBounds(121, 312, 118, 29);
		frame.getContentPane().add(textHora);
		textHora.setColumns(10);
		
		JLabel lblHoraTitul = new JLabel("Hora :");
		lblHoraTitul.setFont(new Font("Arial", Font.BOLD, 24));
		lblHoraTitul.setBounds(10, 312, 87, 29);
		frame.getContentPane().add(lblHoraTitul);
		
		JButton btnCerrarSesion = new JButton("CERRAR SESION");
		btnCerrarSesion.setHorizontalAlignment(SwingConstants.LEFT);
		btnCerrarSesion.setFont(new Font("Arial Black", Font.PLAIN, 18));
		btnCerrarSesion.setBounds(186, 379, 205, 48);
		frame.getContentPane().add(btnCerrarSesion);
		frame.setLocationRelativeTo(null); 	
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(240, 248, 255));
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Mantenimiento");
		mnNewMenu.setForeground(new Color(0, 0, 0));
		mnNewMenu.setFont(new Font("Arial", Font.BOLD, 13));
		mnNewMenu.setVerticalAlignment(SwingConstants.BOTTOM);
		mnNewMenu.setVerticalTextPosition(SwingConstants.BOTTOM);
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu.setHorizontalTextPosition(SwingConstants.CENTER);
		mnNewMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnNewMenu.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\mantenimiento-web.png"));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmProductos = new JMenuItem("Productos");
		mntmProductos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmProductos.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\esta.png"));
		mntmProductos.setFont(new Font("Arial", Font.BOLD, 12));
		mntmProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MantenimientoProductos principal=new MantenimientoProductos();
				principal.frame.setVisible(true);
			}
		});
		mnNewMenu.add(mntmProductos);
		
		JMenuItem mntmCategoria = new JMenuItem("Categoria");
		mntmCategoria.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmCategoria.setFont(new Font("Arial", Font.BOLD, 12));
		mntmCategoria.setForeground(new Color(0, 0, 0));
		mntmCategoria.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\categorias.png"));
		mntmCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MantenimientoCategoria principal=new MantenimientoCategoria();
				principal.frame.setVisible(true);				
			}
		});
		mnNewMenu.add(mntmCategoria);
		
		JMenu mnAnadir = new JMenu("A\u00F1adir");
		mnAnadir.setForeground(new Color(0, 0, 0));
		mnAnadir.setFont(new Font("Arial", Font.BOLD, 13));
		mnAnadir.setVerticalTextPosition(SwingConstants.BOTTOM);
		mnAnadir.setHorizontalTextPosition(SwingConstants.CENTER);
		mnAnadir.setHorizontalAlignment(SwingConstants.CENTER);
		mnAnadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnAnadir.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\expedinte.png"));
		menuBar.add(mnAnadir);
		
		JMenuItem mntmUsuarios = new JMenuItem("Usuarios");
		mntmUsuarios.setFont(new Font("Arial", Font.BOLD, 12));
		mntmUsuarios.setForeground(new Color(0, 0, 0));
		mntmUsuarios.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\anadir.png"));
		mntmUsuarios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnAnadir.add(mntmUsuarios);
		
		JMenuItem mntmPersonal = new JMenuItem("Personal");
		mntmPersonal.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\informacion-personal.png"));
		mntmPersonal.setFont(new Font("Arial", Font.BOLD, 12));
		mntmPersonal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnAnadir.add(mntmPersonal);
		
		JMenuItem mntmAsignacion = new JMenuItem("Asignacion");
		mntmAsignacion.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\recurso.png"));
		mntmAsignacion.setFont(new Font("Arial", Font.BOLD, 12));
		mntmAsignacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnAnadir.add(mntmAsignacion);
		
		JMenu mnAnular = new JMenu("Atencion Al Cliente");
		mnAnular.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnAnular.setForeground(new Color(0, 0, 0));
		mnAnular.setFont(new Font("Arial", Font.BOLD, 13));
		mnAnular.setVerticalTextPosition(SwingConstants.BOTTOM);
		mnAnular.setHorizontalTextPosition(SwingConstants.CENTER);
		mnAnular.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\atencion-al-cliente.png"));
		menuBar.add(mnAnular);
		
		JMenuItem mntmAnularVentas = new JMenuItem("Anular Ventas");
		mntmAnularVentas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmAnularVentas.setFont(new Font("Arial", Font.BOLD, 13));
		mntmAnularVentas.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\tarjeta-de-credito.png"));
		mnAnular.add(mntmAnularVentas);
		
		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mntmClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmClientes.setFont(new Font("Arial", Font.BOLD, 13));
		mntmClientes.setForeground(new Color(0, 0, 0));
		mntmClientes.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\comentarios-de-los-clientes.png"));
		mnAnular.add(mntmClientes);
		
		
		

		frame.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				textHora.setText(obtenerHora());
			}
		});
		
		
		mntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MantenimientoClientes principal=new MantenimientoClientes();
				principal.frame.setVisible(true);
			}
		});
				

		mntmUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistroUsuarios principal=new RegistroUsuarios();
				principal.frame.setVisible(true);
			}
		});
	
		mntmPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistroPersonal principal=new RegistroPersonal();
				principal.frame.setVisible(true);
			}
		});
		
		mntmAsignacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AsignacionUsuario principal=new AsignacionUsuario();
				principal.frame.setVisible(true);
			}
		});

		mntmAnularVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AnularVentasAdmin principal;
				try {
					principal = new AnularVentasAdmin();
					principal.frame.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				LoginVendedor principal=new LoginVendedor();
				principal.frmLogin.setVisible(true);
			}
		});
	}
	public String obtenerHora() {
		Calendar calendario = new GregorianCalendar();
		Integer hora =calendario.get(Calendar.HOUR_OF_DAY);
		Integer minutos = calendario.get(Calendar.MINUTE);
		Integer segundos = calendario.get(Calendar.SECOND);
		String horaCadena=hora.toString();
		String minutosCadena=minutos.toString();
		String segundosCadena=segundos.toString();
		if(hora<10) {
			horaCadena="0"+hora;
		}
		if(minutos<10) {
			minutosCadena="0"+minutos;
		}
		if(segundos<10) {
			segundosCadena="0"+segundos;
		}
		return horaCadena + ": " + minutosCadena + ": " + segundosCadena;
	}
}
