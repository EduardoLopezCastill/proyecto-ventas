package clienteGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import projectVentasClases.Cliente;
import projectVentasUtils.ArchivoTexto;
import projectVentasUtils.Utils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.toedter.calendar.JDateChooser;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.ComponentOrientation;

public class ClienteNuevoLogin {

	public JFrame frmRegistrarse;
	private JTextField textUsuario;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textCorreo;
	private JTextField textTelefono;
	private JTextField textClave;
	private JComboBox comboBox;
	private JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteNuevoLogin window = new ClienteNuevoLogin();
					window.frmRegistrarse.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ClienteNuevoLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistrarse = new JFrame();
		frmRegistrarse.getContentPane().setBackground(new Color(255, 255, 204));
		frmRegistrarse.setTitle("Registrarse");
		frmRegistrarse.setBounds(100, 100, 506, 358);
		frmRegistrarse.getContentPane().setLayout(null);
		frmRegistrarse.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 204));
		panel.setBounds(20, 49, 367, 260);
		frmRegistrarse.getContentPane().add(panel);
		panel.setLayout(null);

		textNombre = new JTextField();
		textNombre.setBackground(new Color(204, 204, 204));
		textNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		textNombre.setBounds(77, 83, 213, 23);
		panel.add(textNombre);
		textNombre.setColumns(10);

		JLabel lblNewLabel = new JLabel("Usuario :");
		// lblNewLabel.setLayout( (LayoutManager) new BevelBorder(BevelBorder.RAISED));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 11, 57, 23);

		panel.add(lblNewLabel);

		textUsuario = new JTextField();
		textUsuario.setBackground(new Color(204, 204, 204));
		textUsuario.setFont(new Font("Arial", Font.PLAIN, 12));
		textUsuario.setBounds(77, 12, 127, 23);
		panel.add(textUsuario);

		textUsuario.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombre.setBounds(10, 83, 57, 23);
		panel.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido :");
		lblApellido.setFont(new Font("Arial", Font.PLAIN, 12));
		lblApellido.setBounds(10, 115, 57, 23);
		panel.add(lblApellido);

		textApellido = new JTextField();
		textApellido.setBackground(new Color(204, 204, 204));
		textApellido.setFont(new Font("Arial", Font.PLAIN, 12));
		textApellido.setBounds(77, 115, 213, 23);
		panel.add(textApellido);
		textApellido.setColumns(10);

		JLabel lblCorreo = new JLabel("Correo :");
		lblCorreo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCorreo.setBounds(10, 149, 57, 23);
		panel.add(lblCorreo);

		textCorreo = new JTextField();
		textCorreo.setBackground(new Color(204, 204, 204));
		textCorreo.setFont(new Font("Arial", Font.PLAIN, 12));
		textCorreo.setColumns(10);
		textCorreo.setBounds(77, 149, 213, 23);
		panel.add(textCorreo);

		comboBox = new JComboBox();
		comboBox.setBackground(new Color(204, 204, 153));
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Seleccionar..", "Fijo", "Celular" }));
		comboBox.setBounds(126, 222, 111, 23);
		panel.add(comboBox);

		JLabel lblTipoDeTelefono = new JLabel("Tipo de Telefono");
		lblTipoDeTelefono.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTipoDeTelefono.setBounds(10, 222, 106, 23);
		panel.add(lblTipoDeTelefono);

		textTelefono = new JTextField();
		textTelefono.setBackground(new Color(204, 204, 204));
		textTelefono.setFont(new Font("Arial", Font.PLAIN, 12));
		textTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				// Verificar si la tecla pulsada no es un digito
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b' /* corresponde a BACK_SPACE */)) {
					e.consume(); // ignorar el evento de teclado
				}

				String caracteres = textTelefono.getText();
				Integer limitadorDeCaracteres = Utils.limitadorDeCaracteres(caracteres, 9);
				if (limitadorDeCaracteres == 0) {
					e.consume();
				}
			}
		});
		textTelefono.setColumns(10);
		textTelefono.setBounds(247, 222, 99, 23);
		panel.add(textTelefono);

		JLabel lblClave = new JLabel("Clave :");
		lblClave.setFont(new Font("Arial", Font.PLAIN, 12));
		lblClave.setBounds(10, 45, 57, 23);
		panel.add(lblClave);

		textClave = new JTextField();
		textClave.setBackground(new Color(204, 204, 204));
		textClave.setFont(new Font("Arial", Font.PLAIN, 12));
		textClave.setColumns(10);
		textClave.setBounds(77, 46, 127, 23);
		panel.add(textClave);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento :");
		lblFechaDeNacimiento.setBackground(new Color(255, 255, 255));
		lblFechaDeNacimiento.setFont(new Font("Arial", Font.PLAIN, 12));
		lblFechaDeNacimiento.setBounds(10, 188, 143, 23);
		panel.add(lblFechaDeNacimiento);

		dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooser.setBounds(163, 188, 127, 23);
		panel.add(dateChooser);

		JLabel lblNewLabel_1 = new JLabel("REGISTRO");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel_1.setBounds(20, 11, 115, 27);
		frmRegistrarse.getContentPane().add(lblNewLabel_1);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 12));
		btnCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCancelar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCancelar.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\cancelar.png"));
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setBounds(393, 200, 90, 74);
		frmRegistrarse.getContentPane().add(btnCancelar);
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Arial", Font.BOLD, 12));
		btnGuardar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnGuardar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnGuardar.setBounds(393, 76, 90, 74);
		frmRegistrarse.getContentPane().add(btnGuardar);
		btnGuardar.setToolTipText("");
		btnGuardar.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\disquete.png"));
		btnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
				btnGuardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						ArrayList<Cliente> listaCliente = ArchivoTexto.leerArchivoCliente();
						String usuario = textUsuario.getText();
						String clave = textClave.getText();
						String nombre = textNombre.getText();
						String apellido = textApellido.getText();
						String correo = textCorreo.getText();
						Date fechaDeNacimiento = dateChooser.getDate();
						String tipoDeTelefono = comboBox.getSelectedItem().toString();
						String telefono = textTelefono.getText();
						boolean confirmacion = verificarCajaVacias(usuario, clave, nombre, apellido, correo, tipoDeTelefono,
								telefono);
						if (confirmacion) {
							Cliente cliente = new Cliente(usuario, clave, nombre, apellido, correo, fechaDeNacimiento,
									tipoDeTelefono, Integer.parseInt(telefono));
							listaCliente.add(cliente);
							ArchivoTexto.crearArchivoCliente(listaCliente);
							frmRegistrarse.setVisible(false);
							InicioCliente principal = new InicioCliente();
							principal.frmInicio.setVisible(true);
						}
					}
				});

		textUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent event) {
				String caracteres = textUsuario.getText();
				Integer limitadorDeCaracteres = Utils.limitadorDeCaracteres(caracteres, 15);
				if (limitadorDeCaracteres == 0) {
					event.consume();
				}
			}
		});

		textClave.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent event) {
				String caracteres = textClave.getText();
				Integer limitadorDeCaracteres = Utils.limitadorDeCaracteres(caracteres, 15);
				if (limitadorDeCaracteres == 0) {
					event.consume();
				}
			}
		});

		textApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = textApellido.getText();
				Integer limitadorDeCaracteres = Utils.limitadorDeCaracteres(caracteres, 25);
				if (limitadorDeCaracteres == 0) {
					e.consume();
				}
			}
		});

		textCorreo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = textCorreo.getText();
				Integer limitadorDeCaracteres = Utils.limitadorDeCaracteres(caracteres, 25);
				if (limitadorDeCaracteres == 0) {
					e.consume();
				}
			}
		});

		textNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = textNombre.getText();
				Integer limitadorDeCaracteres = Utils.limitadorDeCaracteres(caracteres, 25);
				if (limitadorDeCaracteres == 0) {
					e.consume();
				}
			}
		});

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmRegistrarse.setVisible(false);
				InicioCliente principal = new InicioCliente();
				principal.frmInicio.setVisible(true);
			}
		});
	}

	public boolean verificarCajaVacias(String usuario, String clave, String nombre, String apellido, String correo,
			String tipoDeTelefono, String telefono) {
		boolean confirmar = false;
		if (usuario.equals("")) {
			JOptionPane.showMessageDialog(null, "Usuario ingresado incorrecto");
		} else if (clave.equals("")) {
			JOptionPane.showMessageDialog(null, "Clave ingresado incorrecto");
		} else if (nombre.equals("")) {
			JOptionPane.showMessageDialog(null, "Nombre ingresado incorrecto");
		} else if (apellido.equals("")) {
			JOptionPane.showMessageDialog(null, "Apellido ingresada incorrecto");
		} else if (correo.equals("")) {
			JOptionPane.showMessageDialog(null, "Correo ingresado incorrecto");
		} else if (tipoDeTelefono.equals("") || tipoDeTelefono.equals("Seleccionar..")) {
			JOptionPane.showMessageDialog(null, "Tipo De Telefono ingresado incorrecto");
		} else if (telefono.equals("")) {
			JOptionPane.showMessageDialog(null, "Telefono ingresado incorrecto");
		} else {
			confirmar = true;
		}
		return confirmar;
	}
}
