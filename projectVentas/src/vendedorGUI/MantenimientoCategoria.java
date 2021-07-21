package vendedorGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import projectVentasClases.Categoria;
import projectVentasUtils.ArchivoTexto;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class MantenimientoCategoria {

	public JFrame frame;
	private JTextField textBuscador;
	private JTextField textCodigo;
	private JTextField textDescripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantenimientoCategoria window = new MantenimientoCategoria();
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
	public MantenimientoCategoria() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 255, 240));
		frame.setTitle("Categoria");
		frame.setBounds(100, 100, 656, 370);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(10, 11, 620, 69);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Buscar :");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(26, 22, 61, 24);
		panel.add(lblNewLabel);

		textBuscador = new JTextField();
		textBuscador.setBackground(new Color(204, 204, 204));
		textBuscador.setFont(new Font("Arial", Font.BOLD, 12));
		textBuscador.setEditable(false);
		textBuscador.setBounds(86, 23, 244, 24);
		panel.add(textBuscador);
		textBuscador.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(204, 204, 204));
		comboBox.setFont(new Font("Arial", Font.BOLD, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Seleccionar..", "Codigo", "Descripcion" }));
		comboBox.setBounds(340, 22, 133, 24);
		panel.add(comboBox);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(204, 204, 204));
		btnBuscar.setFont(new Font("Arial", Font.BOLD, 14));
		btnBuscar.setBounds(483, 23, 89, 23);
		panel.add(btnBuscar);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 255, 240));
		panel_1.setBounds(10, 91, 620, 229);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("REGISTRAR CATEGORIA");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 22));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(125, 11, 361, 35);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Codigo :");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblNewLabel_2.setBounds(85, 69, 96, 27);
		panel_1.add(lblNewLabel_2);

		textCodigo = new JTextField();
		textCodigo.setBackground(new Color(204, 204, 204));
		textCodigo.setFont(new Font("Arial", Font.BOLD, 13));
		textCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b' /* corresponde a BACK_SPACE */)) {
					e.consume();
				}
			}
		});
		textCodigo.setEditable(false);
		textCodigo.setBounds(191, 69, 99, 27);
		panel_1.add(textCodigo);
		textCodigo.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Descripcion :");
		lblNewLabel_2_1.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(85, 117, 96, 27);
		panel_1.add(lblNewLabel_2_1);

		textDescripcion = new JTextField();
		textDescripcion.setBackground(new Color(204, 204, 204));
		textDescripcion.setFont(new Font("Arial", Font.BOLD, 13));
		textDescripcion.setEditable(false);
		textDescripcion.setBounds(189, 118, 266, 27);
		panel_1.add(textDescripcion);
		textDescripcion.setColumns(10);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBackground(new Color(204, 204, 204));
		btnNuevo.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnNuevo.setBounds(28, 181, 82, 37);
		panel_1.add(btnNuevo);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(new Color(204, 204, 204));
		btnGuardar.setEnabled(false);
		btnGuardar.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnGuardar.setBounds(134, 181, 96, 37);
		panel_1.add(btnGuardar);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBackground(new Color(204, 204, 204));
		btnModificar.setEnabled(false);
		btnModificar.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnModificar.setBounds(250, 181, 115, 37);
		panel_1.add(btnModificar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(204, 204, 204));
		btnCancelar.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnCancelar.setBounds(387, 181, 115, 37);
		panel_1.add(btnCancelar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(new Color(204, 204, 204));
		btnSalir.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnSalir.setBounds(517, 181, 82, 37);
		panel_1.add(btnSalir);

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String combo = comboBox.getSelectedItem().toString();
				if (combo.equals("Codigo")) {
					textBuscador.setEditable(true);
					limpiarCajasText();
				} else if (combo.equals("Descripcion")) {
					textBuscador.setEditable(true);
					limpiarCajasText();
				} else {
					textBuscador.setEditable(false);
					limpiarCajasText();
				}
			}
		});

		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String buscar = textBuscador.getText();
				String combo = comboBox.getSelectedItem().toString();
				ArrayList<Categoria> listaCategoria = ArchivoTexto.leerArchivoCategoria();
				if (!buscar.equals("") && combo.equals("Codigo")) {
					for (Categoria categoria : listaCategoria) {
						Integer codigoCategoria = categoria.getCodigo();
						if (Integer.parseInt(buscar) == codigoCategoria) {
							textDescripcion.setText(categoria.getDescripcion());
							textCodigo.setText(categoria.getCodigo().toString());
							btnModificar.setEnabled(true);
						}
					}
				} else if (!buscar.equals("") && combo.equals("Descripcion")) {
					for (Categoria categoria : listaCategoria) {
						String descripcionCategoria = categoria.getDescripcion();
						if (buscar.equalsIgnoreCase(descripcionCategoria)) {
							textDescripcion.setText(categoria.getDescripcion());
							textCodigo.setText(categoria.getCodigo().toString());
							btnModificar.setEnabled(true);
						}
					}
				} else {
					limpiarCajasText();
				}

			}
		});

		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarCajasText();
				permitirIngresarDatos(true);
				btnGuardar.setEnabled(true);
			}
		});

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Categoria categoriaNueva = null;
				ArrayList<Categoria> listaCategoria = ArchivoTexto.leerArchivoCategoria();
				boolean categoriaRepetida = false;
				String codigo = textCodigo.getText();
				String descripcion = textDescripcion.getText();
				if (!codigo.equals("") && !descripcion.equals("")) {
					for (Categoria categoria : listaCategoria) {
						if (codigo.equals(categoria.getCodigo().toString())
								|| descripcion.equals(categoria.getDescripcion())) {
							categoria.setCodigo(Integer.parseInt(codigo));
							categoria.setDescripcion(descripcion);
							ArchivoTexto.crearArchivoCategoria(listaCategoria);
							categoriaRepetida = true;
							JOptionPane.showMessageDialog(null, "Categoria Modificada");
						}
					}
					if (!categoriaRepetida) {
						categoriaNueva = new Categoria(Integer.parseInt(codigo), descripcion);
						listaCategoria.add(categoriaNueva);
						ArchivoTexto.crearArchivoCategoria(listaCategoria);
						JOptionPane.showMessageDialog(null, "Nueva Categoria Guardada");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Ingrese datos correctos");
				}
				limpiarCajasText();
				btnModificar.setEnabled(false);
				btnGuardar.setEnabled(false);
				permitirIngresarDatos(false);
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
				permitirIngresarDatos(false);
				textBuscador.setEditable(false);
				btnGuardar.setEnabled(false);
				limpiarCajasText();
			}
		});

		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});

	}

	public void permitirIngresarDatos(boolean bolean) {
		textCodigo.setEditable(bolean);
		textDescripcion.setEditable(bolean);
	}

	public void limpiarCajasText() {
		textBuscador.setText("");
		textCodigo.setText("");
		textDescripcion.setText("");
	}
}
