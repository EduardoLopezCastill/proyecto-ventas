package clienteGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.SwingConstants;

import projectVentasClases.Cliente;
import projectVentasUtils.ArchivoTexto;
import projectVentasUtils.Utils;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class MantenimientoCliente {

	public JFrame frame;
	private JTextField textNombre;
	private JTextField textUsuario;
	private JTextField textApellido;
	private JTextField textCorreo;
	private JTextField textTelefono;
	private JTextField textClave;
	public Cliente clienteCopia;
	private JComboBox comboBox;
	private JDateChooser dateChooser;
	private JFrame frame2;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public MantenimientoCliente(Cliente clienteCopia,JFrame frame) {
		this.frame2=frame;
		this.clienteCopia = clienteCopia;
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 204));
		frame.setTitle("Mantenimiento Cliente");
		frame.setBounds(100, 100, 545, 377);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
	
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 204));
		panel.setBounds(404, 43, 115, 284);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnModificar.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\actualizar.png"));
		btnModificar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnModificar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnModificar.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnModificar.setBounds(10, 105, 95, 70);
		panel.add(btnModificar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnGuardar.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\disquete.png"));
		btnGuardar.setEnabled(false);
		btnGuardar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnGuardar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnGuardar.setToolTipText("");
		btnGuardar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnGuardar.setBounds(10, 11, 95, 70);
		panel.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\cancelar.png"));
		btnCancelar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnCancelar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCancelar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCancelar.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnCancelar.setBounds(10, 198, 95, 70);
		panel.add(btnCancelar);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 204));
		panel_1.setLayout(null);
		panel_1.setBounds(10, 43, 376, 284);
		frame.getContentPane().add(panel_1);

		textNombre = new JTextField();
		textNombre.setBackground(new Color(204, 204, 204));
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
		textNombre.setForeground(new Color(0, 0, 0));
		textNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		textNombre.setEditable(false);
		textNombre.setColumns(10);
		textNombre.setBounds(77, 95, 174, 22);
		textNombre.setText(clienteCopia.getNombre());
		panel_1.add(textNombre);

		JLabel lblNewLabel = new JLabel("Usuario :");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 22, 57, 22);
		panel_1.add(lblNewLabel);

		textUsuario = new JTextField();
		textUsuario.setBackground(new Color(204, 204, 204));
		textUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = textUsuario.getText();
				Integer limitadorDeCaracteres = Utils.limitadorDeCaracteres(caracteres, 15);
				if (limitadorDeCaracteres == 0) {
					e.consume();
				}
			}
		});
		textUsuario.setForeground(new Color(0, 0, 0));
		textUsuario.setFont(new Font("Arial", Font.PLAIN, 12));
		textUsuario.setEditable(false);
		textUsuario.setColumns(10);
		textUsuario.setBounds(77, 23, 86, 22);
		textUsuario.setText(clienteCopia.getUsuario());
		panel_1.add(textUsuario);

		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNombre.setBounds(10, 95, 57, 22);
		panel_1.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido :");
		lblApellido.setFont(new Font("Arial", Font.PLAIN, 12));
		lblApellido.setBounds(10, 131, 57, 22);
		panel_1.add(lblApellido);

		textApellido = new JTextField();
		textApellido.setBackground(new Color(204, 204, 204));
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
		textApellido.setForeground(new Color(0, 0, 0));
		textApellido.setFont(new Font("Arial", Font.PLAIN, 12));
		textApellido.setEditable(false);
		textApellido.setColumns(10);
		textApellido.setBounds(77, 131, 174, 22);
		textApellido.setText(clienteCopia.getApellido());
		panel_1.add(textApellido);

		JLabel lblCorreo = new JLabel("Correo :");
		lblCorreo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCorreo.setBounds(10, 171, 57, 22);
		panel_1.add(lblCorreo);

		textCorreo = new JTextField();
		textCorreo.setBackground(new Color(204, 204, 204));
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
		textCorreo.setForeground(new Color(0, 0, 0));
		textCorreo.setFont(new Font("Arial", Font.PLAIN, 12));
		textCorreo.setEditable(false);
		textCorreo.setColumns(10);
		textCorreo.setBounds(77, 171, 174, 22);
		textCorreo.setText(clienteCopia.getCorreo());
		panel_1.add(textCorreo);

		comboBox = new JComboBox();
		comboBox.setForeground(new Color(0, 0, 0));
		comboBox.setBackground(new Color(204, 204, 204));
		comboBox.setFont(new Font("Arial", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar..", "Fijo", "Celular"}));
		comboBox.setBounds(113, 251, 113, 22);
		comboBox.setSelectedItem(clienteCopia.getTipoDeTelefono());
		panel_1.add(comboBox);

		JLabel lblTipoDeTelefono = new JLabel("Tipo de Telefono");
		lblTipoDeTelefono.setFont(new Font("Arial", Font.PLAIN, 12));
		lblTipoDeTelefono.setBounds(10, 251, 93, 22);
		panel_1.add(lblTipoDeTelefono);

		textTelefono = new JTextField();
		textTelefono.setBackground(new Color(204, 204, 204));
		textTelefono.setForeground(new Color(0, 0, 0));
		textTelefono.setFont(new Font("Arial", Font.PLAIN, 12));
		textTelefono.setEditable(false);
		textTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b' /* corresponde a BACK_SPACE */)) {
					e.consume();
				}
				String caracteres = textTelefono.getText();
				Integer limitadorDeCaracteres = Utils.limitadorDeCaracteres(caracteres, 9);
				if (limitadorDeCaracteres == 0) {
					e.consume();
				}
			}
		});
		textTelefono.setColumns(10);
		textTelefono.setBounds(236, 251, 99, 22);
		textTelefono.setText(clienteCopia.getTelefono().toString());
		panel_1.add(textTelefono);

		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Clave :");
		lblNewLabel_3_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3_1_1_1_1.setBounds(10, 56, 66, 22);
		panel_1.add(lblNewLabel_3_1_1_1_1);

		textClave = new JTextField();
		textClave.setBackground(new Color(204, 204, 204));
		textClave.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = textClave.getText();
				Integer limitadorDeCaracteres = Utils.limitadorDeCaracteres(caracteres,15);
				if (limitadorDeCaracteres == 0) {
					e.consume();
				}
			}
		});
		textClave.setForeground(new Color(0, 0, 0));
		textClave.setFont(new Font("Arial", Font.PLAIN, 12));
		textClave.setEditable(false);
		textClave.setColumns(10);
		textClave.setBounds(77, 56, 115, 22);
		textClave.setText(clienteCopia.getClave());
		panel_1.add(textClave);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento :");
		lblFechaDeNacimiento.setFont(new Font("Arial", Font.PLAIN, 12));
		lblFechaDeNacimiento.setBounds(10, 211, 128, 22);
		panel_1.add(lblFechaDeNacimiento);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(159, 211, 111, 22);
		dateChooser.setDate(clienteCopia.getFechaDeNacimiento());
		dateChooser.setEnabled(false);
		panel_1.add(dateChooser);

		JLabel lblNewLabel_1 = new JLabel("DATOS CLIENTE");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 11, 193, 29);
		frame.getContentPane().add(lblNewLabel_1);

		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				permitirIngresarDatos(true);
				btnGuardar.setEnabled(true);
				btnModificar.setEnabled(false);
			}
		});

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clienteCopia = ingresarDatos();
				ArrayList<Cliente> listaCliente = ArchivoTexto.leerArchivoCliente();
				for (int i = 0; i < listaCliente.size(); i++) {
					String userArchivo = listaCliente.get(i).getUsuario();
					String userCliente = clienteCopia.getUsuario();
					if (userArchivo.equals(userCliente)) {
						listaCliente.set(i, clienteCopia);
						frame2.setVisible(false);
						ArchivoTexto.crearArchivoCliente(listaCliente);
					}
				}
				PrincipalCliente principal = new PrincipalCliente(clienteCopia);
				principal.frame.setVisible(true);
				principal.textNombre.setText(clienteCopia.getNombre()+" "+clienteCopia.getApellido());
				frame.setVisible(false);
			}
		});

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnGuardar.setEnabled(false);
				btnModificar.setEnabled(true);
				permitirIngresarDatos(false);
			}
		});
	}

	public void permitirIngresarDatos(boolean bolean) {
		textNombre.setEditable(bolean);
		textUsuario.setEditable(bolean);
		textApellido.setEditable(bolean);
		textCorreo.setEditable(bolean);
		textTelefono.setEditable(bolean);
		textClave.setEditable(bolean);
		dateChooser.setEnabled(bolean);
		comboBox.setEnabled(bolean);
	}

	public Cliente ingresarDatos() {
		String usuario = textUsuario.getText();
		String clave = textClave.getText();
		String nombre = textNombre.getText();
		String apellido = textApellido.getText();
		String correo = textCorreo.getText();
		Date fechaDeNacimiento = dateChooser.getDate();
		String tipoDeTelefono = comboBox.getSelectedItem().toString();
		String telefono = textTelefono.getText();
		Cliente cliente = new Cliente(usuario, clave, nombre, apellido, correo, fechaDeNacimiento, tipoDeTelefono,
				Integer.parseInt(telefono));
		return cliente;
	}
	public boolean verificarCajaVacias(String usuario, String clave, String nombre, String apellido, String correo,
			String tipoDeTelefono, String telefono) {
		boolean confirmar = false;
		if (nombre.equals("")) {
			JOptionPane.showMessageDialog(null, "Nombre ingresado incorrecto");
		} else if (apellido.equals("")) {
			JOptionPane.showMessageDialog(null, "Apellido ingresado incorrecto");
		} else if (correo.equals("")) {
			JOptionPane.showMessageDialog(null, "Correo ingresado incorrecto");
		} else if (usuario.equals("")) {
			JOptionPane.showMessageDialog(null, "Usuario ingresado incorrecto");
		} else if (clave.equals("")) {
			JOptionPane.showMessageDialog(null, "Clave ingresada incorrecto");
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
