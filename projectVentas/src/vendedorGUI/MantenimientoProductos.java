package vendedorGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import projectVentasClases.Categoria;
import projectVentasClases.Producto;
import projectVentasUtils.ArchivoTexto;
import projectVentasUtils.Utils;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Cursor;


public class MantenimientoProductos {

	public JFrame frame;
	private JTextField textField;
	private JTable table;
	private JTextField textNombre;
	private JTextField textCodigo;
	private JTextField textCantidad;
	private JTextField textDescripcion;
	private JTextField textPrecioDeCompra;
	private JTextField textPrecioDeVenta;
	private JTextField textProveedor;
	private JComboBox comboBoxCategoria;
	private ArrayList<Producto> listaProducto;
	private JButton btnGuardar;
	private JButton btnModificar;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantenimientoProductos window = new MantenimientoProductos();
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
	public MantenimientoProductos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 255, 240));
		frame.setTitle("Productos");
		frame.setBounds(100, 100, 967, 534);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 240));
		panel.setBounds(10, 11, 317, 471);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("BUSCAR PRODUCTO");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 218, 29);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBackground(new Color(220, 220, 220));
		textField.setFont(new Font("Arial", Font.BOLD, 12));
		textField.setEditable(false);
		textField.setBounds(10, 43, 165, 29);
		panel.add(textField);
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 104, 295, 356);
		panel.add(scrollPane);

		table = new JTable();
		table.setSelectionBackground(new Color(30, 144, 255));
		table.setBackground(new Color(224, 255, 255));
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table.setFont(new Font("Arial", Font.BOLD, 12));
		
		scrollPane.setViewportView(table);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(220, 220, 220));
		comboBox.setFont(new Font("Arial", Font.BOLD, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Codigo", "Cantidad", "Categoria"}));
		comboBox.setBounds(185, 46, 122, 26);
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 255, 240));
		panel_1.setBounds(337, 11, 602, 471);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblRegistrarProducto = new JLabel("REGISTRAR PRODUCTO");
		lblRegistrarProducto.setBounds(0, 0, 255, 41);
		panel_1.add(lblRegistrarProducto);
		lblRegistrarProducto.setFont(new Font("Arial Black", Font.BOLD, 18));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 240, 245));
		panel_2.setBounds(10, 38, 478, 232);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Caracteristicas");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(0, 0, 122, 24);
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Codigo :");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 35, 54, 24);
		panel_2.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Nombre :");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(10, 70, 54, 24);
		panel_2.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Categoria :");
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_1_1.setBounds(10, 102, 77, 24);
		panel_2.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Cantidad :");
		lblNewLabel_2_1_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_1_1_1.setBounds(10, 141, 68, 24);
		panel_2.add(lblNewLabel_2_1_1_1);

		textNombre = new JTextField();
		textNombre.setBackground(new Color(220, 220, 220));
		textNombre.setFont(new Font("Arial", Font.BOLD, 12));
		textNombre.setEditable(false);
		textNombre.setColumns(10);
		textNombre.setBounds(84, 70, 142, 24);
		panel_2.add(textNombre);

		textCodigo = new JTextField();
		textCodigo.setBackground(new Color(220, 220, 220));
		textCodigo.setFont(new Font("Arial", Font.BOLD, 12));
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
		textCodigo.setColumns(10);
		textCodigo.setBounds(84, 35, 110, 24);
		panel_2.add(textCodigo);

		textCantidad = new JTextField();
		textCantidad.setBackground(new Color(220, 220, 220));
		textCantidad.setFont(new Font("Arial", Font.BOLD, 12));
		textCantidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b' /* corresponde a BACK_SPACE */)) {
					e.consume();
				}
			}
		});
		textCantidad.setEditable(false);
		textCantidad.setColumns(10);
		textCantidad.setBounds(84, 141, 110, 24);
		panel_2.add(textCantidad);

		JLabel lblNewLabel_1_1 = new JLabel("Descripcion del Producto :");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(249, 5, 161, 24);
		panel_2.add(lblNewLabel_1_1);

		textDescripcion = new JTextField();
		textDescripcion.setFont(new Font("Arial", Font.BOLD, 12));
		textDescripcion.setBackground(new Color(220, 220, 220));
		textDescripcion.setEditable(false);
		textDescripcion.setBounds(249, 26, 200, 97);
		panel_2.add(textDescripcion);
		textDescripcion.setColumns(10);

		JLabel lblNewLabel_2_1_2 = new JLabel("Proveedor :");
		lblNewLabel_2_1_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_1_2.setBounds(10, 176, 77, 24);
		panel_2.add(lblNewLabel_2_1_2);

		textProveedor = new JTextField();
		textProveedor.setBackground(new Color(220, 220, 220));
		textProveedor.setFont(new Font("Arial", Font.BOLD, 12));
		textProveedor.setEditable(false);
		textProveedor.setColumns(10);
		textProveedor.setBounds(84, 176, 110, 24);
		panel_2.add(textProveedor);
		
		comboBoxCategoria = new JComboBox();
		comboBoxCategoria.setBackground(new Color(220, 220, 220));
		comboBoxCategoria.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboBoxCategoria.setFont(new Font("Arial", Font.BOLD, 12));
		comboBoxCategoria.setEnabled(false);
		comboBoxCategoria.setBounds(84, 103, 142, 24);
		panel_2.add(comboBoxCategoria);
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		ArrayList<Categoria>listaCategoria=ArchivoTexto.leerArchivoCategoria();
		for(Categoria categoria:listaCategoria) {
			model.addElement(categoria.getDescripcion());			
		}
		comboBoxCategoria.setModel(model);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 240, 245));
		panel_3.setBounds(10, 284, 578, 99);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_1_1_1 = new JLabel("Detalles de Precio");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(10, 0, 148, 24);
		panel_3.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_3 = new JLabel("Precio de Compra :");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setBounds(30, 36, 118, 24);
		panel_3.add(lblNewLabel_3);

		textPrecioDeCompra = new JTextField();
		textPrecioDeCompra.setBackground(new Color(220, 220, 220));
		textPrecioDeCompra.setFont(new Font("Arial", Font.BOLD, 12));
		textPrecioDeCompra.setEditable(false);
		textPrecioDeCompra.setColumns(10);
		textPrecioDeCompra.setBounds(146, 36, 86, 24);
		panel_3.add(textPrecioDeCompra);

		JLabel lblNewLabel_3_1 = new JLabel("Precio de Venta :");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3_1.setBounds(283, 36, 97, 24);
		panel_3.add(lblNewLabel_3_1);

		textPrecioDeVenta = new JTextField();
		textPrecioDeVenta.setBackground(new Color(220, 220, 220));
		textPrecioDeVenta.setFont(new Font("Arial", Font.BOLD, 12));
		textPrecioDeVenta.setEditable(false);
		textPrecioDeVenta.setColumns(10);
		textPrecioDeVenta.setBounds(384, 36, 86, 24);
		panel_3.add(textPrecioDeVenta);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBackground(new Color(220, 220, 220));
		btnNuevo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNuevo.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnNuevo.setBounds(25, 408, 89, 41);
		panel_1.add(btnNuevo);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(new Color(220, 220, 220));
		btnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGuardar.setFont(new Font("Arial", Font.BOLD, 13));
		btnGuardar.setEnabled(false);
		btnGuardar.setBounds(134, 408, 89, 41);
		panel_1.add(btnGuardar);

		btnModificar = new JButton("Modificar");
		btnModificar.setBackground(new Color(220, 220, 220));
		btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnModificar.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnModificar.setEnabled(false);
		btnModificar.setBounds(246, 408, 115, 41);
		panel_1.add(btnModificar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(220, 220, 220));
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnCancelar.setBounds(373, 408, 115, 41);
		panel_1.add(btnCancelar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(new Color(220, 220, 220));
		btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalir.setFont(new Font("Arial Black", Font.BOLD, 13));
		btnSalir.setBounds(499, 408, 89, 41);
		panel_1.add(btnSalir);
		
		mostrarProductos();
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String combo=comboBox.getSelectedItem().toString();
				DefaultTableModel modelo=Utils.mostrarTablaProductos(listaProducto, combo);
				table.setModel(modelo);
			}
		});

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Producto producto=listaProducto.get(table.getSelectedRow());
				textNombre.setText(producto.getNombre());
				textCodigo.setText(producto.getCodigo().toString());
				textCantidad.setText(producto.getStock().toString());
				textDescripcion.setText(producto.getDescripcion());
				textPrecioDeCompra.setText(producto.getPrecioDeCompra().toString());
				textPrecioDeVenta.setText(producto.getPrecioDeVenta().toString());
				textProveedor.setText(producto.getProveedor());
				comboBoxCategoria.setSelectedItem(producto.getCategoria().getDescripcion());
				permitirIngresarDatos(false);
				btnNuevo.setEnabled(false);
				btnGuardar.setEnabled(false);
				btnModificar.setEnabled(true);
			}
		});
		
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				permitirIngresarDatos(true);
				limpiarCajasText();
				btnGuardar.setEnabled(true);
			}
		});

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String descripcionCombo=comboBoxCategoria.getSelectedItem().toString();
				Integer codigoCategoria=null;
				String descripcionCategoria="";
				for(Categoria categoria:listaCategoria) {
					String descripcionArchivo=categoria.getDescripcion();
					if(descripcionArchivo.equalsIgnoreCase(descripcionCombo)) {
						descripcionCategoria=categoria.getDescripcion();
						codigoCategoria=categoria.getCodigo();
						break;
					}
				}
				Categoria categoria=new Categoria(codigoCategoria,descripcionCategoria);
				modificarOGuardarNuevo(categoria);
				btnModificar.setEnabled(false);
				btnGuardar.setEnabled(false);
				permitirIngresarDatos(false);
			}
		});

		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnGuardar.setEnabled(true);
				permitirIngresarDatos(true);
			}
		});

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarCajasText();
				permitirIngresarDatos(false);
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
	
	/***********METODOS*************
	Opcion de guardar, sin que se agregue uno nuevo y que se reemplaze los mismos productos, o se adicionen
	LISTO.
	*/
	
	public void modificarOGuardarNuevo(Categoria categoria) {	
		ArrayList<Producto> listaProducto=ArchivoTexto.leerArchivoProducto();
		String codigo = textCodigo.getText();
		String nombre=textNombre.getText();
		String cantidad =textCantidad.getText();
		String proveedor=textProveedor.getText();
		String descripcion=textDescripcion.getText();
		String precioDeCompra= textPrecioDeCompra.getText();
		if(descripcion.equals("")) {
			descripcion=" ";
		}
		boolean productoRepetido = false;
		boolean confirmacion=confirmarCajasNoVacias(codigo,nombre,cantidad,proveedor,precioDeCompra);
		if(confirmacion) {
			for(Producto producto:listaProducto) {
				if(codigo.equals(producto.getCodigo().toString())||nombre.equals(producto.getNombre())) {
					producto.setCodigo(Integer.parseInt(codigo));
					producto.setNombre(nombre);
					producto.setCategoria(categoria);
					producto.setStock(Integer.parseInt(cantidad));
					producto.setProveedor(proveedor);
					producto.setDescripcion(descripcion);
					producto.setPrecioDeCompra(Double.parseDouble(precioDeCompra));
					ArchivoTexto.crearArchivoProducto(listaProducto);
					productoRepetido = true;
					JOptionPane.showMessageDialog(null, "Producto Modificado");
				}
			}
			if(!productoRepetido) {
				Producto productoNuevo=new Producto(Integer.parseInt(codigo), nombre, categoria, Integer.parseInt(cantidad), proveedor, descripcion,Double.parseDouble(precioDeCompra));
				listaProducto.add(productoNuevo);
				ArchivoTexto.crearArchivoProducto(listaProducto);
				JOptionPane.showMessageDialog(null, "Nuevo Producto Guardado");
			}
			mostrarProductos();
			limpiarCajasText();
		}
	}
	
	public boolean confirmarCajasNoVacias(String codigo,String nombre,String cantidad,String proveedor,String precioDeCompra) {
		boolean confirmar=false;
		if(codigo.equals("")) {
			JOptionPane.showMessageDialog(null, "Codigo valor ingresado incorrecto"); 
		}else if(nombre.equals("")) {
			JOptionPane.showMessageDialog(null, "Nombre valor ingresado incorrecto");
		}else if(cantidad.equals("")) {
			JOptionPane.showMessageDialog(null, "Cantidad valor ingresado incorrecto");
		}else if(proveedor.equals("")) {
			JOptionPane.showMessageDialog(null, "Proveedor valor ingresado incorrecto");
		}else if(precioDeCompra.equals("")){
			JOptionPane.showMessageDialog(null, "Precio de Compra valor ingresado incorrecto");
		}else{
			confirmar=true;
		}
		return confirmar;
	}
	
	public void mostrarProductos() {
		listaProducto=ArchivoTexto.leerArchivoProducto();
		DefaultTableModel modelo=Utils.mostrarTablaProductos(listaProducto, "Codigo");
		table.setModel(modelo);
	}
	
	public void permitirIngresarDatos(boolean bolean) {
		textNombre.setEditable(bolean);
		textCodigo.setEditable(bolean);
		textCantidad.setEditable(bolean);
		textDescripcion.setEditable(bolean);
		textPrecioDeCompra.setEditable(bolean);
		textProveedor.setEditable(bolean);
		comboBoxCategoria.setEnabled(bolean);
	}
	
	public void limpiarCajasText() {
		textNombre.setText("");
		textCodigo.setText("");
		textCantidad.setText("");
		textDescripcion.setText("");
		textPrecioDeCompra.setText("");
		textPrecioDeVenta.setText("");
		textProveedor.setText("");
	}
}
