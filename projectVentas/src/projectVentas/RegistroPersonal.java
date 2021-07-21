package projectVentas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;

import projectVentasClases.Cliente;
import projectVentasClases.Personal;
import projectVentasUtils.ArchivoTexto;
import projectVentasUtils.Utils;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Cursor;

public class RegistroPersonal {

	public JFrame frame;
	private JTextField textBuscador;
	private JTable table;
	private JTextField textCodigo;
	private JTextField textDni;
	private JTextField textNombre;
	private JTextField textDireccion;
	private JTextField textTelefono;
	private JTextField textApellido;
	private JDateChooser dateChooser;
	private JComboBox comboBoxTipoDTelefono;
	private JComboBox comboBoxEstado;
	private ArrayList<Personal> listaPersonal = ArchivoTexto.leerArchivoPersonal();
	private JButton btnGuardar;
	private JButton btnModificar;
	private JComboBox comboBoxBuscador;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroPersonal window = new RegistroPersonal();
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
	public RegistroPersonal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 204));
		frame.setBounds(100, 100, 808, 462);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 204));
		panel.setBounds(10, 11, 247, 401);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("BUSCAR PERSONAL :");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 8, 158, 26);
		panel.add(lblNewLabel);

		textBuscador = new JTextField();
		textBuscador.setFont(new Font("Arial", Font.BOLD, 12));
		textBuscador.setBackground(new Color(204, 204, 204));
		textBuscador.setEditable(false);
		textBuscador.setBounds(10, 34, 145, 20);
		panel.add(textBuscador);
		textBuscador.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = textBuscador.getText();
				Integer limitadorDeCaracteres = Utils.limitadorDeCaracteres(caracteres,15);
				if (limitadorDeCaracteres == 0) {
					e.consume();
				}
			}
		});
		textBuscador.setColumns(10);

		comboBoxBuscador = new JComboBox();
		comboBoxBuscador.setFont(new Font("Arial", Font.BOLD, 12));
		comboBoxBuscador.setModel(new DefaultComboBoxModel(new String[] { "Codigo", "DNI", "Nombre" }));
		comboBoxBuscador.setBounds(165, 33, 72, 21);
		panel.add(comboBoxBuscador);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 227, 325);
		panel.add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Arial", Font.BOLD, 12));
		table.setSelectionBackground(new Color(153, 204, 255));
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table.setBackground(new Color(204, 255, 255));
		scrollPane.setViewportView(table);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 255, 204));
		panel_1.setBounds(267, 52, 504, 360);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Registrar datos del Personal ");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_2.setBounds(0, 0, 228, 22);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Codigo :");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 33, 66, 22);
		panel_1.add(lblNewLabel_3);

		textCodigo = new JTextField();
		textCodigo.setFont(new Font("Arial", Font.BOLD, 12));
		textCodigo.setBackground(new Color(204, 204, 204));
		textCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				// Verificar si la tecla pulsada no es un digito
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b' /* corresponde a BACK_SPACE */)) {
					e.consume(); // ignorar el evento de teclado
				}
				String caracteres = textCodigo.getText();
				Integer limitadorDeCaracteres = Utils.limitadorDeCaracteres(caracteres,5);
				if (limitadorDeCaracteres == 0) {
					e.consume();
				}
			}
		});
		textCodigo.setEditable(false);
		textCodigo.setBounds(97, 33, 86, 22);
		panel_1.add(textCodigo);
		textCodigo.setColumns(10);

		JLabel lbldni = new JLabel("DNI :");
		lbldni.setFont(new Font("Arial", Font.BOLD, 12));
		lbldni.setBounds(10, 66, 66, 22);
		panel_1.add(lbldni);

		textDni = new JTextField();
		textDni.setFont(new Font("Arial", Font.BOLD, 12));
		textDni.setBackground(new Color(204, 204, 204));
		textDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				// Verificar si la tecla pulsada no es un digito
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b' /* corresponde a BACK_SPACE */)) {
					e.consume(); // ignorar el evento de teclado
				}
				String caracteres = textDni.getText();
				Integer limitadorDeCaracteres = Utils.limitadorDeCaracteres(caracteres,8);
				if (limitadorDeCaracteres == 0) {
					e.consume();
				}
			}
		});
		textDni.setEditable(false);
		textDni.setColumns(10);
		textDni.setBounds(97, 66, 86, 22);
		panel_1.add(textDni);

		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 12));
		lblNombre.setBounds(10, 99, 66, 22);
		panel_1.add(lblNombre);

		textNombre = new JTextField();
		textNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = textNombre.getText();
				Integer limitadorDeCaracteres = Utils.limitadorDeCaracteres(caracteres,25);
				if (limitadorDeCaracteres == 0) {
					e.consume();
				}
			}
		});
		textNombre.setFont(new Font("Arial", Font.BOLD, 12));
		textNombre.setBackground(new Color(204, 204, 204));
		textNombre.setEditable(false);
		textNombre.setColumns(10);
		
		textNombre.setBounds(97, 99, 205, 22);
		
		panel_1.add(textNombre);

		textDireccion = new JTextField();
		textDireccion.setFont(new Font("Arial", Font.BOLD, 12));
		textDireccion.setBackground(new Color(204, 204, 204));
		textDireccion.setEditable(false);
		textDireccion.setColumns(10);
		textDireccion.setBounds(97, 165, 205, 22);
		textDireccion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = textDireccion.getText();
				Integer limitadorDeCaracteres = Utils.limitadorDeCaracteres(caracteres,40);
				if (limitadorDeCaracteres == 0) {
					e.consume();
				}
			}
		});
		panel_1.add(textDireccion);

		JLabel lbldirecc = new JLabel("Direccion :");
		lbldirecc.setFont(new Font("Arial", Font.BOLD, 12));
		lbldirecc.setBounds(10, 165, 66, 22);
		panel_1.add(lbldirecc);

		JLabel lblNewLabel_3_2 = new JLabel("Tipo Telefono :");
		lblNewLabel_3_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3_2.setBounds(10, 234, 106, 22);
		panel_1.add(lblNewLabel_3_2);

		comboBoxTipoDTelefono = new JComboBox();
		comboBoxTipoDTelefono.setFont(new Font("Arial", Font.BOLD, 12));
		comboBoxTipoDTelefono.setModel(new DefaultComboBoxModel(new String[] { "Celular", "Fijo" }));
		comboBoxTipoDTelefono.setBounds(126, 234, 102, 22);
		comboBoxTipoDTelefono.setEnabled(false);
		panel_1.add(comboBoxTipoDTelefono);

		textTelefono = new JTextField();
		textTelefono.setFont(new Font("Arial", Font.BOLD, 12));
		textTelefono.setBackground(new Color(204, 204, 204));
		textTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				// Verificar si la tecla pulsada no es un digito
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b' /* corresponde a BACK_SPACE */)) {
					e.consume(); // ignorar el evento de teclado
				}
				String caracteres = textDireccion.getText();
				Integer limitadorDeCaracteres = Utils.limitadorDeCaracteres(caracteres,9);
				if (limitadorDeCaracteres == 0) {
					e.consume();
				}
			}
		});
		textTelefono.setEditable(false);
		textTelefono.setColumns(10);
		textTelefono.setBounds(238, 234, 115, 22);
		panel_1.add(textTelefono);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setFont(new Font("Arial", Font.BOLD, 13));
		btnNuevo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNuevo.setBounds(10, 312, 77, 37);
		panel_1.add(btnNuevo);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Arial", Font.BOLD, 13));
		btnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGuardar.setEnabled(false);
		btnGuardar.setBounds(97, 312, 89, 37);
		panel_1.add(btnGuardar);

		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Arial", Font.BOLD, 13));
		btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificar.setEnabled(false);
		btnModificar.setBounds(196, 312, 101, 37);
		panel_1.add(btnModificar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 13));
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setBounds(307, 312, 101, 37);
		panel_1.add(btnCancelar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Arial", Font.BOLD, 13));
		btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalir.setBounds(418, 312, 77, 37);
		panel_1.add(btnSalir);

		JLabel lblAoell = new JLabel("Apellido :");
		lblAoell.setFont(new Font("Arial", Font.BOLD, 12));
		lblAoell.setBounds(10, 132, 66, 22);
		panel_1.add(lblAoell);

		textApellido = new JTextField();
		textApellido.setFont(new Font("Arial", Font.BOLD, 12));
		textApellido.setBackground(new Color(204, 204, 204));
		textApellido.setEditable(false);
		textApellido.setColumns(10);
		textApellido.setBounds(97, 132, 205, 22);
		textApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = textApellido.getText();
				Integer limitadorDeCaracteres = Utils.limitadorDeCaracteres(caracteres,25);
				if (limitadorDeCaracteres == 0) {
					e.consume();
				}
			}
		});
		panel_1.add(textApellido);

		JLabel lblFechadena = new JLabel("Fecha de Nacimiento :");
		lblFechadena.setFont(new Font("Arial", Font.BOLD, 12));
		lblFechadena.setBounds(10, 201, 148, 22);
		panel_1.add(lblFechadena);

		dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooser.setBounds(187, 201, 115, 22);
		dateChooser.setEnabled(false);
		panel_1.add(dateChooser);

		comboBoxEstado = new JComboBox();
		comboBoxEstado.setFont(new Font("Arial", Font.BOLD, 12));
		comboBoxEstado.setModel(new DefaultComboBoxModel(new String[] { "Activo", "En Baja" }));
		comboBoxEstado.setEnabled(false);
		comboBoxEstado.setBounds(97, 270, 106, 22);
		panel_1.add(comboBoxEstado);

		JLabel lblNewLabel_3_1 = new JLabel("Estado :");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3_1.setBounds(10, 270, 77, 22);
		panel_1.add(lblNewLabel_3_1);

		JLabel lblNewLabel_1 = new JLabel("REGISTRAR PERSONAL");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 22));
		lblNewLabel_1.setBounds(267, 11, 317, 32);
		frame.getContentPane().add(lblNewLabel_1);

		mostrarPersonal();
		
		comboBoxBuscador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String combo = comboBoxBuscador.getSelectedItem().toString();
				DefaultTableModel modelo = Utils.mostrarBuscadorPersonal(combo, listaPersonal);
				table.setModel(modelo);
			}
		});

		textBuscador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textBuscador.setEditable(true);
			}
		});

		textBuscador.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String combo = comboBoxBuscador.getSelectedItem().toString();
				String busqueda = textBuscador.getText();
				buscadorEnLaTabla(combo,busqueda);
			}
		});

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				Personal personalSeleccionado = listaPersonal.get(row);
				textCodigo.setText(personalSeleccionado.getCodigo().toString());
				textDni.setText(personalSeleccionado.getDni().toString());
				textNombre.setText(personalSeleccionado.getNombre());
				textDireccion.setText(personalSeleccionado.getDireccion());
				textTelefono.setText(personalSeleccionado.getTelefono().toString());
				textApellido.setText(personalSeleccionado.getApellido());
				dateChooser.setDate(personalSeleccionado.getFechaDeNacimiento());
				btnGuardar.setEnabled(true);
				btnNuevo.setEnabled(false);
				btnModificar.setEnabled(true);
			}
		});

		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				permitirIngresoDatos(true);
				btnGuardar.setEnabled(true);
				limpiarCajas();
			}
		});

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresarPersonal();
				btnNuevo.setEnabled(true);
			}
		});

		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				permitirIngresoDatos(true);
				btnGuardar.setEnabled(true);
			}
		});

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				permitirIngresoDatos(false);
				limpiarCajas();
				btnGuardar.setEnabled(false);
				btnNuevo.setEnabled(true);
				btnModificar.setEnabled(false);
			}
		});

		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
	}

	// ***********METODOS*************
	public void buscadorEnLaTabla(String combo, String busqueda) {
		switch (combo) {
		case "Codigo":
			for (Personal personal : listaPersonal) {
				String codigo = personal.getCodigo().toString();
				if (busqueda.equalsIgnoreCase(codigo)) {
					DefaultTableModel modelo = mostrarBuscadorPersonal(combo, personal);
					table.setModel(modelo);
				}
			}
			break;
		case "DNI":
			for (Personal personal : listaPersonal) {
				String dni = personal.getDni().toString();
				if (busqueda.equalsIgnoreCase(dni)) {
					DefaultTableModel modelo = mostrarBuscadorPersonal(combo, personal);
					table.setModel(modelo);
				}
			}
			break;
		case "Nombre":
			for (Personal personal : listaPersonal) {
				String nombre = personal.getNombre();
				if (busqueda.equalsIgnoreCase(nombre)) {
					DefaultTableModel modelo = mostrarBuscadorPersonal(combo, personal);
					table.setModel(modelo);
				}
			}
			break;
		default:
			break;
		}
	}

	public static DefaultTableModel mostrarBuscadorPersonal(String combo, Personal personal) {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn(combo);
		modelo.addColumn("Apellido");
		if (combo.equals("Nombre")) {
			modelo.addRow(new String[] { personal.getNombre(), personal.getApellido(), personal.getCodigo().toString(),
					personal.getDni().toString(), personal.getDireccion(), personal.getTipoDeTelefono(),
					personal.getTelefono().toString() });
		} else if (combo.equals("DNI")) {
			modelo.addRow(new String[] { personal.getDni().toString(), personal.getApellido(),
					personal.getCodigo().toString(), personal.getNombre(), personal.getDireccion(),
					personal.getTipoDeTelefono(), personal.getTelefono().toString() });
		} else {
			modelo.addRow(new String[] { personal.getCodigo().toString(), personal.getApellido(),
					personal.getDni().toString(), personal.getNombre(), personal.getDireccion(),
					personal.getTipoDeTelefono(), personal.getTelefono().toString() });
		}
		return modelo;
	}

	public void permitirIngresoDatos(boolean bolean) {
		textCodigo.setEditable(bolean);
		textDni.setEditable(bolean);
		textNombre.setEditable(bolean);
		textDireccion.setEditable(bolean);
		textTelefono.setEditable(bolean);
		textApellido.setEditable(bolean);
		dateChooser.setEnabled(bolean);
		comboBoxTipoDTelefono.setEnabled(bolean);
		comboBoxEstado.setEnabled(bolean);
	}

	public void limpiarCajas() {
		textCodigo.setText("");
		textDni.setText("");
		textNombre.setText("");
		textDireccion.setText("");
		textTelefono.setText("");
		textApellido.setText("");
	}

	public void ingresarPersonal() {
		String codigo = textCodigo.getText();
		String dni = textDni.getText();
		String telefono = textTelefono.getText();
		String nombre = textNombre.getText();
		String apellido = textApellido.getText();
		String direccion = textDireccion.getText();
		String tipoDeTelefono = comboBoxTipoDTelefono.getSelectedItem().toString();
		String estadoString = comboBoxEstado.getSelectedItem().toString();
		Date fechaDeNacimiento = dateChooser.getDate();
		boolean productoRepetido = true;
		boolean confirmacion = confirmarCajasNoVacias(codigo, dni, telefono, nombre, apellido, direccion);
		if (confirmacion) {
			for (Personal personal : listaPersonal) {
				if (codigo.equals(personal.getCodigo().toString()) && dni.equals(personal.getDni().toString())) {
					personal.setTelefono(Integer.parseInt(telefono));
					personal.setNombre(nombre);
					personal.setApellido(apellido);
					personal.setDireccion(direccion);
					personal.setTipoDeTelefono(tipoDeTelefono);
					personal.setEstado(estadoString);
					personal.setFechaDeNacimiento(fechaDeNacimiento);
					ArchivoTexto.crearArchivoPersonal(listaPersonal);
					productoRepetido = true;
					JOptionPane.showMessageDialog(null, "Personal Modificado");
				}
			}
			if (!productoRepetido) {
				Personal personal = new Personal(Integer.parseInt(codigo), Integer.parseInt(dni),
						Integer.parseInt(telefono), nombre, apellido, direccion, tipoDeTelefono, estadoString,
						fechaDeNacimiento);
				listaPersonal.add(personal);
				ArchivoTexto.crearArchivoPersonal(listaPersonal);
				JOptionPane.showMessageDialog(null, "Nuevo Personal Guardado");
			}
			limpiarCajas();
		}
		mostrarPersonal();
		permitirIngresoDatos(false);
		btnGuardar.setEnabled(false);
		btnModificar.setEnabled(false);
	}

	public boolean confirmarCajasNoVacias(String codigo, String dni, String telefono, String nombre, String apellido,
			String direccion) {
		boolean confirmar = false;
		if (codigo.equals("")) {
			JOptionPane.showMessageDialog(null, "Codigo ingresado incorrecto");
		} else if (dni.equals("")) {
			JOptionPane.showMessageDialog(null, "DNI ingresado incorrecto");
		} else if (telefono.equals("")) {
			JOptionPane.showMessageDialog(null, "Telefono ingresado incorrecto");
		} else if (nombre.equals("")) {
			JOptionPane.showMessageDialog(null, "Nombre ingresado incorrecto");
		} else if (apellido.equals("")) {
			JOptionPane.showMessageDialog(null, "Apellido ingresado incorrecto");
		} else if (direccion.equals("")) {
			JOptionPane.showMessageDialog(null, "Direccion ingresada incorrecto");
		} else {
			confirmar = true;
		}
		return confirmar;
	}
	public void mostrarPersonal() {
		String combo = comboBoxBuscador.getSelectedItem().toString();
		DefaultTableModel modelo = Utils.mostrarBuscadorPersonal(combo, listaPersonal);
		table.setModel(modelo);
	}
}
