package vendedorGUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import projectVentas.InicioProjct;
import projectVentas.PrincipalAdmin;
import projectVentas.RegistroUsuarios;
import projectVentasClases.Asignacion;
import projectVentasClases.Personal;
import projectVentasClases.Usuarios;
import projectVentasUtils.ArchivoTexto;
import projectVentasUtils.Utils;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.w3c.dom.events.EventTarget;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Cursor;

public class LoginVendedor {

	public JFrame frmLogin;
	private JPanel panel;
	private JPasswordField passwordField;
	private JLabel passwordLabel;
	private JLabel userLabel;
	private JTextField textUsuario;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginVendedor window = new LoginVendedor();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginVendedor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.getContentPane().setBackground(new Color(204, 255, 255));
		frmLogin.setTitle("LOGIN");
		frmLogin.setForeground(Color.WHITE);
		frmLogin.setBounds(100, 100, 397, 315);
		frmLogin.setLocationRelativeTo(null);
		frmLogin.getContentPane().setLayout(null);
		frmLogin.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Eduardo Lopez\\Downloads\\fondo.png"));

		JButton btnAtras = new JButton("");
		btnAtras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAtras.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\atras.png"));
		btnAtras.setBounds(304, 206, 65, 63);
		frmLogin.getContentPane().add(btnAtras);

		panel = new JPanel();
		panel.setBackground(new Color(153, 255, 204));
		panel.setBounds(39, 27, 318, 146);
		frmLogin.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIngresar.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnIngresar.setBounds(158, 96, 148, 36);
		panel.add(btnIngresar);

		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(204, 204, 204));
		passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent event) {
				String caracteres=passwordField.getText();
				Integer limitadorDeCaracteres=Utils.limitadorDeCaracteres(caracteres,15);
				if(limitadorDeCaracteres==0) {
					event.consume();
				}
			}
		});
		
		passwordField.setBounds(124, 60, 160, 25);
		panel.add(passwordField);
		passwordLabel = new JLabel("PASSWORD :");
		passwordLabel.setBackground(new Color(255, 255, 204));
		passwordLabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		passwordLabel.setBounds(10, 60, 104, 25);
		passwordLabel.setOpaque(true);
		panel.add(passwordLabel);

		userLabel = new JLabel("USUARIO :");
		userLabel.setBackground(new Color(255, 255, 204));
		userLabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		userLabel.setBounds(10, 26, 104, 25);
		userLabel.setOpaque(true);
		panel.add(userLabel);

		textUsuario = new JTextField(20);
		textUsuario.setBackground(new Color(204, 204, 204));
		textUsuario.setFont(new Font("Arial", Font.PLAIN, 16));
		textUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent event) {
				String caracteres=textUsuario.getText();
				Integer limitadorDeCaracteres=Utils.limitadorDeCaracteres(caracteres,15);
				if(limitadorDeCaracteres==0) {
					event.consume();
				}
			}
		});
		textUsuario.setBounds(124, 26, 160, 25);
		panel.add(textUsuario);

		JButton btnContrasenaNueva = new JButton("");
		btnContrasenaNueva.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnContrasenaNueva.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\candado.png"));
		btnContrasenaNueva.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnContrasenaNueva.setHorizontalTextPosition(SwingConstants.CENTER);
		btnContrasenaNueva.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnContrasenaNueva.setBounds(27, 217, 65, 52);
		frmLogin.getContentPane().add(btnContrasenaNueva);

		lblNewLabel = new JLabel("\u00BFOlvido la contrase\u00F1a?");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 191, 159, 25);
		frmLogin.getContentPane().add(lblNewLabel);

		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InicioProjct principal = new InicioProjct();
				principal.frmFerreteria.setVisible(true);
				frmLogin.setVisible(false);
			}
		});

		btnContrasenaNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Solicitar codigo de usuario
				String seleccion = JOptionPane.showInputDialog(null,"Ingrese codigo de trabajor",JOptionPane.QUESTION_MESSAGE);
				ArrayList<Usuarios> listaUsuario = ArchivoTexto.leerArchivoUsuario();
				boolean ingresoCodigo=false;
				for(Usuarios usuario:listaUsuario) {
					Integer codigo=usuario.getCodigo();
					if(seleccion!=null&&seleccion.equals(codigo.toString())) {
						RecuperarContrasenaVendedor principal = new RecuperarContrasenaVendedor(usuario);
						principal.frame.setVisible(true);
						ingresoCodigo=true;
					}
				}				
				if(!ingresoCodigo) {
					JOptionPane.showMessageDialog(null, "Codigo no encontrado");
				}
			}
		});

		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String user = textUsuario.getText();
				String contrasena = passwordField.getText();
				ArrayList<Usuarios> listaUsuario = ArchivoTexto.leerArchivoUsuario();
				if (user.equals("admin") && contrasena.equals("12345678")) {
					PrincipalAdmin principal = new PrincipalAdmin();
					principal.frame.setVisible(true);
					frmLogin.setVisible(false);
				} else {
					for (int i = 0; i < listaUsuario.size(); i++) {
						Usuarios usuario= listaUsuario.get(i);
						if (usuario.getUsuario().equalsIgnoreCase(user) && usuario.getClave().equals(contrasena)) {
							ArrayList<Asignacion> listaAsignacion=ArchivoTexto.leerArchivoAsignacion();
							boolean estado=verificarEstado(usuario.getCodigo(),listaAsignacion);
							if(estado) {
								Personal personal=devolverPersonal(usuario.getCodigo());
								PrincipalVendedor principal = new PrincipalVendedor(personal);
								principal.frmPrincipal.setVisible(true);
								frmLogin.setVisible(false);
								break;
							}
						}
					}
				}
				textUsuario.setText("");
				passwordField.setText("");
			}
		});
	}

	//****************************
	
	public boolean verificarEstado(Integer codigo,ArrayList<Asignacion> listaAsignacion) {
		boolean booleanEstado=false;
		for(Asignacion asignacion:listaAsignacion) {
			String estado = asignacion.getEstado();
			Integer codigoUsuario=asignacion.getCodUsuario();
			if(codigo==codigoUsuario) {
				if(estado.equalsIgnoreCase("Activo")) {
					booleanEstado = true;
				}
			}
		}
		return booleanEstado;
	}

	public Personal devolverPersonal(Integer codigo) {
		Personal personalADevolver=new Personal(null,null,null,null,null,null,null,null,null);
		ArrayList<Personal> listaPersonal=ArchivoTexto.leerArchivoPersonal();
		ArrayList<Asignacion> listaAsignacion=ArchivoTexto.leerArchivoAsignacion();
		for(Asignacion asignacion:listaAsignacion) {
			Integer codigoUsuario=asignacion.getCodUsuario();
			Integer codigoPersonal=asignacion.getCodPersonal();
			if(codigo==codigoUsuario) {
				for(Personal personal:listaPersonal) {
					Integer codPersonal=personal.getCodigo();
					if(codPersonal==codigoPersonal) {
						personalADevolver=personal;
					}
				}
			}
		}
		return personalADevolver;
	}
}
