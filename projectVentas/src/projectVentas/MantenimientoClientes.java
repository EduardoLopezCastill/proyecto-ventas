package projectVentas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import projectVentasClases.Cliente;
import projectVentasClases.Producto;
import projectVentasUtils.ArchivoTexto;
import projectVentasUtils.Utils;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;

public class MantenimientoClientes {

	public JFrame frame;
	private JTextField textBuscador;
	private JTextField textCorreo;
	private JTextField textUsuario;
	private JTextField textTelefono;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textClave;
	private JTable table;
	private JDateChooser dateChooser;
	private JComboBox comboBoxTipoTelefono;
	private ArrayList<Cliente> listaCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantenimientoClientes window = new MantenimientoClientes();
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
	public MantenimientoClientes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 255, 240));
		frame.setBounds(100, 100, 808, 440);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 240));
		panel.setLayout(null);
		panel.setBounds(10, 11, 247, 379);
		frame.getContentPane().add(panel);

		JLabel lblBuscarCliente = new JLabel("BUSCAR CLIENTE :");
		lblBuscarCliente.setFont(new Font("Arial", Font.BOLD, 14));
		lblBuscarCliente.setBounds(10, 8, 133, 26);
		panel.add(lblBuscarCliente);

		textBuscador = new JTextField();
		textBuscador.setBackground(new Color(204, 204, 204));
		textBuscador.setFont(new Font("Arial", Font.PLAIN, 12));
		textBuscador.setColumns(10);
		textBuscador.setEditable(false);
		textBuscador.setBounds(10, 34, 133, 20);
		panel.add(textBuscador);

		JComboBox comboBoxCliente = new JComboBox();
		comboBoxCliente.setBackground(new Color(204, 204, 204));
		comboBoxCliente.setFont(new Font("Arial", Font.BOLD, 12));
		comboBoxCliente.setModel(new DefaultComboBoxModel(new String[] { "Nombre", "Apellido" }));
		comboBoxCliente.setBounds(153, 33, 84, 21);
		panel.add(comboBoxCliente);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 65, 227, 303);
		panel.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(255, 255, 204));
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPane.setViewportView(table);

		JLabel lblNewLabel_1 = new JLabel("REGISTRAR CLIENTE");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel_1.setBounds(267, 11, 317, 32);
		frame.getContentPane().add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 255, 240));
		panel_1.setLayout(null);
		panel_1.setBounds(267, 54, 515, 336);
		frame.getContentPane().add(panel_1);

		JLabel lblNewLabel_2 = new JLabel("Registrar datos del Cliente");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2.setBounds(0, 0, 183, 22);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Nombre :");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 33, 66, 22);
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("Apellido :");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3_1.setBounds(10, 67, 66, 22);
		panel_1.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_1_1 = new JLabel("Correo :");
		lblNewLabel_3_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3_1_1.setBounds(10, 100, 66, 22);
		panel_1.add(lblNewLabel_3_1_1);

		textCorreo = new JTextField();
		textCorreo.setBackground(new Color(204, 204, 204));
		textCorreo.setFont(new Font("Arial", Font.BOLD, 12));
		textCorreo.setColumns(10);
		textCorreo.setEditable(false);
		textCorreo.setBounds(97, 100, 246, 22);
		textCorreo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = textCorreo.getText();
				Integer limitadorDeCaracteres = Utils.limitadorDeCaracteres(caracteres,30);
				if (limitadorDeCaracteres == 0) {
					e.consume();
				}
			}
		});
		panel_1.add(textCorreo);

		textUsuario = new JTextField();
		textUsuario.setBackground(new Color(204, 204, 204));
		textUsuario.setFont(new Font("Arial", Font.BOLD, 12));
		textUsuario.setColumns(10);
		textUsuario.setEditable(false);
		textUsuario.setBounds(97, 133, 115, 22);
		textUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = textUsuario.getText();
				Integer limitadorDeCaracteres = Utils.limitadorDeCaracteres(caracteres,15);
				if (limitadorDeCaracteres == 0) {
					e.consume();
				}
			}
		});
		panel_1.add(textUsuario);

		JLabel lblNewLabel_3_1_1_1 = new JLabel("Usuario :");
		lblNewLabel_3_1_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3_1_1_1.setBounds(10, 133, 66, 22);
		panel_1.add(lblNewLabel_3_1_1_1);

		JLabel lblNewLabel_3_2 = new JLabel("Tipo Telefono");
		lblNewLabel_3_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3_2.setBounds(8, 245, 79, 22);
		panel_1.add(lblNewLabel_3_2);

		comboBoxTipoTelefono = new JComboBox();
		comboBoxTipoTelefono.setBackground(new Color(204, 204, 204));
		comboBoxTipoTelefono.setFont(new Font("Arial", Font.BOLD, 12));
		comboBoxTipoTelefono.setModel(new DefaultComboBoxModel(new String[] { "Celular", "Fijo" }));
		comboBoxTipoTelefono.setBounds(97, 245, 97, 22);
		comboBoxTipoTelefono.setEnabled(false);
		panel_1.add(comboBoxTipoTelefono);

		textTelefono = new JTextField();
		textTelefono.setBackground(new Color(204, 204, 204));
		textTelefono.setFont(new Font("Arial", Font.BOLD, 12));
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
		textTelefono.setBounds(228, 245, 115, 22);
		textTelefono.setEditable(false);
		panel_1.add(textTelefono);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBackground(new Color(204, 204, 204));
		btnNuevo.setFont(new Font("Arial", Font.BOLD, 12));
		btnNuevo.setBounds(10, 288, 89, 37);
		panel_1.add(btnNuevo);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(new Color(204, 204, 204));
		btnGuardar.setFont(new Font("Arial", Font.BOLD, 12));
		btnGuardar.setEnabled(false);
		btnGuardar.setBounds(109, 288, 89, 37);
		panel_1.add(btnGuardar);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBackground(new Color(204, 204, 204));
		btnModificar.setFont(new Font("Arial", Font.BOLD, 12));
		btnModificar.setEnabled(false);
		btnModificar.setBounds(208, 288, 89, 37);
		panel_1.add(btnModificar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(204, 204, 204));
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 12));
		btnCancelar.setBounds(307, 288, 89, 37);
		panel_1.add(btnCancelar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(new Color(204, 204, 204));
		btnSalir.setFont(new Font("Arial", Font.BOLD, 12));
		btnSalir.setBounds(406, 288, 89, 37);
		panel_1.add(btnSalir);

		textNombre = new JTextField();
		textNombre.setBackground(new Color(204, 204, 204));
		textNombre.setFont(new Font("Arial", Font.BOLD, 12));
		textNombre.setColumns(10);
		textNombre.setBounds(97, 33, 246, 22);
		textNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = textNombre.getText();
				Integer limitadorDeCaracteres = Utils.limitadorDeCaracteres(caracteres, 22);
				if (limitadorDeCaracteres == 0) {
					e.consume();
				}
			}
		});
		textNombre.setEditable(false);
		panel_1.add(textNombre);

		textApellido = new JTextField();
		textApellido.setBackground(new Color(204, 204, 204));
		textApellido.setFont(new Font("Arial", Font.BOLD, 12));
		textApellido.setColumns(10);
		textApellido.setBounds(97, 67, 246, 22);
		textApellido.setEditable(false);
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
		panel_1.add(textApellido);

		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Clave :");
		lblNewLabel_3_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3_1_1_1_1.setBounds(10, 166, 66, 22);
		panel_1.add(lblNewLabel_3_1_1_1_1);

		textClave = new JTextField();
		textClave.setBackground(new Color(204, 204, 204));
		textClave.setFont(new Font("Arial", Font.BOLD, 12));
		textClave.setColumns(10);
		textClave.setBounds(97, 166, 115, 22);
		textClave.setEditable(false);
		textClave.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = textClave.getText();
				Integer limitadorDeCaracteres = Utils.limitadorDeCaracteres(caracteres, 15);
				if (limitadorDeCaracteres == 0) {
					e.consume();
				}
			}
		});
		panel_1.add(textClave);

		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento :");
		lblFechaDeNacimiento.setFont(new Font("Arial", Font.BOLD, 12));
		lblFechaDeNacimiento.setBounds(10, 207, 128, 20);
		panel_1.add(lblFechaDeNacimiento);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(148, 207, 111, 20);
		dateChooser.setEnabled(false);
		panel_1.add(dateChooser);


		mostrarClientes();

		comboBoxCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String combo = comboBoxCliente.getSelectedItem().toString();
				DefaultTableModel modelo = Utils.mostrarBuscadorClientes(combo, listaCliente);
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
				String combo = comboBoxCliente.getSelectedItem().toString();
				String busqueda = textBuscador.getText();
				buscadorEnLaTabla(combo,busqueda);
			}
		});

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				Cliente clienteSeleccionado = listaCliente.get(row);
				textCorreo.setText(clienteSeleccionado.getCorreo());
				textUsuario.setText(clienteSeleccionado.getUsuario());
				textTelefono.setText(clienteSeleccionado.getTelefono().toString());
				textNombre.setText(clienteSeleccionado.getNombre());
				textApellido.setText(clienteSeleccionado.getApellido());
				textClave.setText(clienteSeleccionado.getClave());
				dateChooser.setDate(clienteSeleccionado.getFechaDeNacimiento());
				permitirIngresarDatos(false);
				btnModificar.setEnabled(true);
			}
		});

	
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				permitirIngresarDatos(true);
				limpiarCajasText();
				btnModificar.setEnabled(false);
				btnGuardar.setEnabled(true);
			}
		});

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Cliente> listaCliente = ArchivoTexto.leerArchivoCliente();
				String nombre = textNombre.getText();
				String apellido = textApellido.getText();
				String correo = textCorreo.getText();
				String usuario = textUsuario.getText();
				String clave = textClave.getText();
				String tipoDeTelefono = comboBoxTipoTelefono.getSelectedItem().toString();
				String telefono = textTelefono.getText();
				Date fechaNacimiento = dateChooser.getDate();
				boolean productoRepetido = false;
				boolean confirmacion=confirmarCajasNoVacias(nombre,apellido,correo,usuario,clave,telefono);
				if(confirmacion) {
					for(Cliente cliente:listaCliente) {
						String nombreCliente=cliente.getNombre();
						String apellidoCliente=cliente.getApellido();
						String usuarioCliente=cliente.getUsuario();
						if(nombreCliente.equalsIgnoreCase(nombre)&&apellidoCliente.equalsIgnoreCase(apellido)&&usuarioCliente.equalsIgnoreCase(usuario)) {
							cliente.setCorreo(correo);
							cliente.setClave(clave);
							cliente.setTipoDeTelefono(tipoDeTelefono);
							cliente.setTelefono(Integer.parseInt(telefono));
							cliente.setFechaDeNacimiento(fechaNacimiento);
							ArchivoTexto.crearArchivoCliente(listaCliente);
							productoRepetido = true;
							JOptionPane.showMessageDialog(null, "Cliente Modificado");
						}
					}
					if(!productoRepetido) {
						Cliente clienteNuevo = new Cliente(nombre, apellido, correo, usuario, clave, fechaNacimiento, tipoDeTelefono,Integer.parseInt(telefono));
						listaCliente.add(clienteNuevo);
						ArchivoTexto.crearArchivoCliente(listaCliente);
						JOptionPane.showMessageDialog(null, "Nuevo Cliente Guardado");
					}
					limpiarCajasText();
				}
				mostrarClientes();
				permitirIngresarDatos(false);
				btnModificar.setEnabled(false);
				btnGuardar.setEnabled(false);
			}
		});

		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				permitirIngresarDatos(true);
				btnGuardar.setEnabled(true);
			}
		});

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarCajasText();
				permitirIngresarDatos(false);
				btnModificar.setEnabled(false);
				btnGuardar.setEnabled(false);
			}
		});

		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
	}

	// ***********METODOS*************

	public void buscadorEnLaTabla(String combo ,String busqueda) {
		ArrayList<Cliente> listaCliente = ArchivoTexto.leerArchivoCliente();
		switch (combo) {
		case "Nombre":
			for (Cliente cliente : listaCliente) {
				String nombre=cliente.getNombre();
				if(busqueda.equalsIgnoreCase(nombre)) {
					DefaultTableModel modelo= mostrarBuscadorClientes(combo,cliente);
					table.setModel(modelo);
				}
			}
			break;
		case "Apellido":
			for (Cliente cliente : listaCliente) {
				String apellido=cliente.getApellido();
				if(busqueda.equalsIgnoreCase(apellido)) {
					DefaultTableModel modelo= mostrarBuscadorClientes(combo,cliente);
					table.setModel(modelo);
				}
			}
			break;
		default:
			break;
		}
	}
	public static DefaultTableModel mostrarBuscadorClientes(String combo,Cliente cliente) {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("User");
		modelo.addColumn(combo);
		if (combo.equals("Nombre")) {
				modelo.addRow(new String[] { cliente.getUsuario(), cliente.getNombre(), cliente.getClave(),
						cliente.getApellido(), cliente.getCorreo(), cliente.getTipoDeTelefono(),
						cliente.getTelefono().toString() });
		} else {
				modelo.addRow(new String[] { cliente.getUsuario(), cliente.getApellido(), cliente.getNombre(),
						cliente.getClave(), cliente.getCorreo(), cliente.getTipoDeTelefono(),
						cliente.getTelefono().toString() });
		   }
		return modelo;
	}
	
	public boolean confirmarCajasNoVacias(String nombre,String apellido,String correo,String usuario,String clave,String telefono) {
		boolean confirmar=false;
		if(nombre.equals("")) {
			JOptionPane.showMessageDialog(null, "Nombre ingresado incorrecto"); 
		}else if(apellido.equals("")) {
			JOptionPane.showMessageDialog(null, "Apellido ingresado incorrecto");
		}else if(correo.equals("")) {
			JOptionPane.showMessageDialog(null, "Correo ingresado incorrecto");
		}else if(usuario.equals("")) {
			JOptionPane.showMessageDialog(null, "Usuario ingresado incorrecto");
		}else if(clave.equals("")){
			JOptionPane.showMessageDialog(null, "Clave ingresada incorrecto");
		}else if(telefono.equals("")){
			JOptionPane.showMessageDialog(null, "Telefono ingresado incorrecto");
		}else{
			confirmar=true;
		}
		return confirmar;
	}
	
	public void mostrarClientes() {
		listaCliente = ArchivoTexto.leerArchivoCliente();
		DefaultTableModel modelo = Utils.mostrarBuscadorClientes("Nombre", listaCliente);
		table.setModel(modelo);
	}
	
	public void permitirIngresarDatos(boolean opcion) {
		textCorreo.setEditable(opcion);
		textUsuario.setEditable(opcion);
		textTelefono.setEditable(opcion);
		textNombre.setEditable(opcion);
		textApellido.setEditable(opcion);
		textClave.setEditable(opcion);
		dateChooser.setEnabled(opcion);
		comboBoxTipoTelefono.setEnabled(opcion);
	}

	public void limpiarCajasText() {
		textCorreo.setText("");
		textUsuario.setText("");
		textTelefono.setText("");
		textNombre.setText("");
		textApellido.setText("");
		textClave.setText("");
	}
}
