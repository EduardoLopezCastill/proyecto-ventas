package vendedorGUI;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import projectVentas.BuscadorClientes2;
import projectVentas.BuscadorDeProductos;
import projectVentasClases.Cliente;
import projectVentasClases.Comprobante;
import projectVentasClases.ConfigBoleta;
import projectVentasClases.Personal;
import projectVentasClases.Producto;
import projectVentasClases.ProductoDeVenta;
import projectVentasUtils.ArchivoTexto;
import projectVentasUtils.ConexionBd;
import projectVentasUtils.Utils;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.SwingConstants;

public class VentasVendedor2 extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFecha;
	private JTextField textVendedor;
	private JTextField textNumeroBoleta;
	private JTextField textClienteUser;
	private JTextField textClienteNombre;
	private JTextField textNumeroCuotas;
	private JTextField textMontoPorCuota;
	private JTextField textMontoTotal;
	private JTextField textIgv;
	private JTextField textTotalAPagar;
	private JTextField textProducto;
	private JTextField textStockProducto;
	private JTextField textCantidadProducto;
	private JComboBox comboComprobante ;
	private JComboBox comboTipoPago;
	private Personal personal;
	private Producto productoRecibido;
	private Cliente cliente;
	private JTable table;
	private Date date =new Date();
	private ConfigBoleta configBoleta=Utils.logicaNumeroBoleta(ArchivoTexto.leerArchivoConfigBoleta());
	private ArrayList<ProductoDeVenta> listaProductosSeleccionados = new ArrayList<>();
	private	ArrayList<Producto> listaProductoTemporal=ArchivoTexto.leerArchivoProducto();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public VentasVendedor2(Personal personal) {
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		getContentPane().setBackground(new Color(204, 255, 204));
		this.personal = personal;
		setClosable(true);
		setBounds(100, 100, 660, 612);
		getContentPane().setLayout(null);
		
		textFecha = new JTextField();
		textFecha.setFont(new Font("Arial", Font.BOLD, 11));
		textFecha.setEditable(false);
		textFecha.setColumns(10);
		textFecha.setBounds(106, 64, 86, 20);
		DateFormat format=new SimpleDateFormat("dd-MM-yyyy");
		textFecha.setText(format.format(date));
		getContentPane().add(textFecha);

		JLabel lblNewLabel = new JLabel("Fecha :");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(30, 66, 66, 17);
		getContentPane().add(lblNewLabel);

		JLabel lblVendedor = new JLabel("Vendedor :");
		lblVendedor.setFont(new Font("Arial", Font.BOLD, 12));
		lblVendedor.setBounds(30, 98, 66, 17);
		getContentPane().add(lblVendedor);
		

		textVendedor = new JTextField();
		textVendedor.setFont(new Font("Arial", Font.BOLD, 11));
		textVendedor.setEditable(false);
		textVendedor.setColumns(10);
		textVendedor.setBounds(106, 96, 200, 22);
		String nombreVendedor=this.personal.getNombre() + " " + this.personal.getApellido();
		textVendedor.setText(nombreVendedor);
		getContentPane().add(textVendedor);

		JLabel lblNewLabel_1 = new JLabel("Nro de Boleta:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(354, 64, 86, 20);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Comprobante :");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(354, 99, 95, 17);
		getContentPane().add(lblNewLabel_2);

		textNumeroBoleta = new JTextField();
		textNumeroBoleta.setFont(new Font("Arial", Font.BOLD, 11));
		textNumeroBoleta.setEditable(false);
		textNumeroBoleta.setColumns(10);
		textNumeroBoleta.setBounds(450, 64, 86, 20);
		textNumeroBoleta.setText(this.configBoleta.getSerie()+" - "+this.configBoleta.getNumeracion());
		getContentPane().add(textNumeroBoleta);

		comboComprobante= new JComboBox();
		comboComprobante.setFont(new Font("Arial", Font.BOLD, 11));
		comboComprobante.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboComprobante.setModel(new DefaultComboBoxModel(new String[] { "Boleta", "Factura" }));
		comboComprobante.setBounds(450, 96, 100, 22);
		getContentPane().add(comboComprobante);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 240));
		panel.setLayout(null);
		panel.setBounds(20, 129, 577, 145);
		getContentPane().add(panel);

		JButton btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\buscando.png"));
		btnBuscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscar.setBounds(167, 24, 43, 23);
		panel.add(btnBuscar);

		JLabel lblCliente = new JLabel("Cliente :");
		lblCliente.setFont(new Font("Arial", Font.BOLD, 12));
		lblCliente.setBounds(10, 24, 54, 23);
		panel.add(lblCliente);

		textClienteUser = new JTextField();
		textClienteUser.setFont(new Font("Arial", Font.BOLD, 11));
		textClienteUser.setEditable(false);
		textClienteUser.setColumns(10);
		textClienteUser.setBounds(64, 24, 93, 23);
		panel.add(textClienteUser);

		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 12));
		lblNombre.setBounds(10, 58, 54, 23);
		panel.add(lblNombre);

		textClienteNombre = new JTextField();
		textClienteNombre.setFont(new Font("Arial", Font.BOLD, 11));
		textClienteNombre.setEditable(false);
		textClienteNombre.setColumns(10);
		textClienteNombre.setBounds(64, 58, 308, 23);
		panel.add(textClienteNombre);

		JLabel lblNewLabel_3 = new JLabel("Tipo de Pago");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 102, 73, 23);
		panel.add(lblNewLabel_3);

		comboTipoPago = new JComboBox();
		comboTipoPago.setFont(new Font("Arial", Font.BOLD, 11));
		comboTipoPago.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboTipoPago.setModel(new DefaultComboBoxModel(new String[] { "Contado", "Credito" }));
		comboTipoPago.setBounds(93, 102, 89, 23);
		panel.add(comboTipoPago);

		JLabel lblNewLabel_4 = new JLabel("Nro De Cuotas :");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_4.setBounds(210, 102, 95, 23);
		panel.add(lblNewLabel_4);

		textNumeroCuotas = new JTextField();
		textNumeroCuotas.setFont(new Font("Arial", Font.BOLD, 11));
		textNumeroCuotas.setEditable(false);
		textNumeroCuotas.setColumns(10);
		textNumeroCuotas.setBounds(302, 102, 70, 22);
		panel.add(textNumeroCuotas);
		
		textNumeroCuotas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = textNumeroCuotas.getText();
				Integer limitadorDeCaracteres = Utils.limitadorDeCaracteres(caracteres, 5);
				if (limitadorDeCaracteres == 0) {
					e.consume();
				}
			}
		});

		textMontoPorCuota = new JTextField();
		textMontoPorCuota.setFont(new Font("Arial", Font.BOLD, 11));
		textMontoPorCuota.setEditable(false);
		textMontoPorCuota.setColumns(10);
		textMontoPorCuota.setBounds(497, 101, 70, 24);
		panel.add(textMontoPorCuota);

		JLabel lblNewLabel_5 = new JLabel("Monto por Cuota :");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_5.setBounds(386, 102, 107, 23);
		panel.add(lblNewLabel_5);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 319, 577, 123);
		getContentPane().add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		table.setSelectionBackground(new Color(224, 255, 255));
		table.setBackground(new Color(240, 255, 255));
		scrollPane.setViewportView(table);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 255, 240));
		panel_1.setLayout(null);
		panel_1.setBounds(20, 478, 577, 75);
		getContentPane().add(panel_1);

		JLabel lblNewLabel_6 = new JLabel("Monto Total :");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_6.setBounds(10, 11, 74, 23);
		panel_1.add(lblNewLabel_6);

		textMontoTotal = new JTextField();
		textMontoTotal.setFont(new Font("Arial", Font.BOLD, 11));
		textMontoTotal.setEditable(false);
		textMontoTotal.setColumns(10);
		textMontoTotal.setBounds(87, 11, 67, 22);
		panel_1.add(textMontoTotal);

		JLabel lblNewLabel_6_1 = new JLabel("IGV :");
		lblNewLabel_6_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_6_1.setBounds(10, 41, 59, 23);
		panel_1.add(lblNewLabel_6_1);

		textIgv = new JTextField();
		textIgv.setFont(new Font("Arial", Font.BOLD, 11));
		textIgv.setEditable(false);
		textIgv.setColumns(10);
		textIgv.setBounds(87, 42, 67, 22);
		panel_1.add(textIgv);

		JLabel lblNewLabel_7 = new JLabel("Total a Pagar :");
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_7.setBounds(245, 15, 100, 23);
		panel_1.add(lblNewLabel_7);

		textTotalAPagar = new JTextField();
		textTotalAPagar.setFont(new Font("Arial", Font.BOLD, 11));
		textTotalAPagar.setEditable(false);
		textTotalAPagar.setColumns(10);
		textTotalAPagar.setBounds(355, 16, 86, 20);
		panel_1.add(textTotalAPagar);

		JLabel lblProducto = new JLabel("Producto :");
		lblProducto.setFont(new Font("Arial", Font.BOLD, 12));
		lblProducto.setBounds(20, 285, 66, 23);
		getContentPane().add(lblProducto);

		textProducto = new JTextField();
		textProducto.setFont(new Font("Arial", Font.BOLD, 11));
		textProducto.setEditable(false);
		textProducto.setColumns(10);
		textProducto.setBounds(84, 285, 96, 23);
		getContentPane().add(textProducto);

		JButton btnBuscarProductos = new JButton("");
		btnBuscarProductos.setFont(new Font("Arial", Font.BOLD, 12));
		btnBuscarProductos.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBuscarProductos.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\buscando.png"));
		btnBuscarProductos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscarProductos.setBounds(190, 285, 43, 23);
		getContentPane().add(btnBuscarProductos);

		JLabel lblStock = new JLabel("Stock :");
		lblStock.setFont(new Font("Arial", Font.BOLD, 12));
		lblStock.setBounds(256, 285, 43, 23);
		getContentPane().add(lblStock);

		textStockProducto = new JTextField();
		textStockProducto.setFont(new Font("Arial", Font.BOLD, 11));
		textStockProducto.setEditable(false);
		textStockProducto.setColumns(10);
		textStockProducto.setBounds(302, 285, 53, 23);
		getContentPane().add(textStockProducto);

		JLabel lblCantidad = new JLabel("Cantidad :");
		lblCantidad.setFont(new Font("Arial", Font.BOLD, 12));
		lblCantidad.setBounds(372, 285, 65, 23);
		getContentPane().add(lblCantidad);

		textCantidadProducto = new JTextField();
		textCantidadProducto.setFont(new Font("Arial", Font.BOLD, 11));
		textCantidadProducto.setColumns(10);
		textCantidadProducto.setBounds(434, 285, 54, 23);
		getContentPane().add(textCantidadProducto);

		textCantidadProducto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String caracteres = textCantidadProducto.getText();
				Integer limitadorDeCaracteres = Utils.limitadorDeCaracteres(caracteres, 5);
				if (limitadorDeCaracteres == 0) {
					e.consume();
				}
			}
		});

		JButton btnAnadir = new JButton("A\u00F1adir");
		btnAnadir.setFont(new Font("Arial", Font.BOLD, 12));
		btnAnadir.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\mas.png"));
		btnAnadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAnadir.setBounds(498, 285, 99, 23);
		getContentPane().add(btnAnadir);

		JButton btnQuitarElemento = new JButton("Quitar");
		btnQuitarElemento.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\cancela2.png"));
		btnQuitarElemento.setFont(new Font("Arial", Font.BOLD, 12));
		btnQuitarElemento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQuitarElemento.setBounds(491, 447, 106, 22);
		getContentPane().add(btnQuitarElemento);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(240, 255, 240));
		panel_2.setBounds(20, 11, 587, 41);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnAnadirVenta = new JButton("A\u00F1adir Venta");
		btnAnadirVenta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAnadirVenta.setFont(new Font("Arial", Font.BOLD, 12));
		btnAnadirVenta.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\venta.png"));
		btnAnadirVenta.setBounds(69, 6, 148, 30);
		panel_2.add(btnAnadirVenta);
		
		JButton btnMostrarComprobante = new JButton("Mostrar Comprobante");
		btnMostrarComprobante.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMostrarComprobante.setFont(new Font("Arial", Font.BOLD, 12));
		btnMostrarComprobante.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\comprobar.png"));
		btnMostrarComprobante.setBounds(346, 6, 185, 30);
		panel_2.add(btnMostrarComprobante);

		textCantidadProducto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b' /* corresponde a BACK_SPACE */)) {
					e.consume();
				}
			}
		});
		
		textNumeroCuotas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b' /* corresponde a BACK_SPACE */)) {
					e.consume();
				}
			}
		});
		
		comboTipoPago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String combo = comboTipoPago.getSelectedItem().toString();
				if (combo.equalsIgnoreCase("contado")) {
					textNumeroCuotas.setEditable(false);
				} else {
					textNumeroCuotas.setEditable(true);
				}
			}
		});

		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Cliente> listacliente = new ArrayList<>();
				BuscadorClientes2 principal2 = new BuscadorClientes2(null, true, listacliente);
				principal2.setLocationRelativeTo(null);
				principal2.setVisible(true);
				if (listacliente.isEmpty()) {

				} else {
					cliente = listacliente.get(0);
					textClienteUser.setText(cliente.getUsuario());
					textClienteNombre.setText(cliente.getNombre() + " " + cliente.getNombre());
				}
			}
		});

		btnBuscarProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 *ACA SE DEBE ARREGLAR LOS PRODUCTOS, QUE SE ACTUALICE EL STOCK AL INSTANTE 
				 */
				ArrayList<Producto> listaProducto = new ArrayList<>();
				BuscadorDeProductos principal = new BuscadorDeProductos(null, true, listaProducto,listaProductoTemporal);
				principal.setLocationRelativeTo(null);
				principal.setVisible(true);
				if (listaProducto.isEmpty()) {
					textCantidadProducto.setEditable(false);
				} else {
					productoRecibido = listaProducto.get(0);
					textProducto.setText(productoRecibido.getNombre());
					textStockProducto.setText(productoRecibido.getStock().toString());
					textCantidadProducto.setEditable(true);
				}
			}
		});

		btnAnadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cantidadSeleccionada = textCantidadProducto.getText();
				if(cantidadSeleccionada.equals("")) {
					cantidadSeleccionada="1";
				}
				ProductoDeVenta productoDeVenta = obtenerProductoDeVenta(productoRecibido, Integer.parseInt(cantidadSeleccionada));
				ArrayList<ProductoDeVenta> listaTemporal=verificarProductosIguales(productoDeVenta);
				DefaultTableModel modelo = mostrarProductosAVender(listaTemporal);
				table.setModel(modelo);
				generarListaTemporal(Integer.parseInt(cantidadSeleccionada)); //aqui se genera el stock temporal para la vista de productos
				textProducto.setText("");
				textStockProducto.setText("");
				textCantidadProducto.setText("");
				calcularYMostrarImportes(listaTemporal);		
			}
		});

		btnQuitarElemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = table.getSelectedRow();
				if (index != -1) {
					Integer cantidad=listaProductosSeleccionados.get(index).getCantidad();
					Integer codigo=listaProductosSeleccionados.get(index).getCodigo();
					listaProductosSeleccionados.remove(index);
					DefaultTableModel modelo = mostrarProductosAVender(listaProductosSeleccionados);
					devolverStockAListaTemporal(codigo,cantidad);
					table.setModel(modelo);
					calcularYMostrarImportes(listaProductosSeleccionados);
					
				}
			}
		});
		
		btnAnadirVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date fecha=date;
				String nombreCliente=cliente.getNombre()+" "+cliente.getApellido();
				String nombrePersonal=personal.getNombre()+" "+personal.getApellido();
				String numeroBoleta=textNumeroBoleta.getText();
				String tipoComprobante=comboComprobante.getSelectedItem().toString();
				String tipoDePago=comboTipoPago.getSelectedItem().toString();
				Integer numeroDeCuotas;
				Double montoPorcuota;
				Double montoTotal =Double.valueOf(textMontoTotal.getText());
				Double igv=Double.valueOf(textIgv.getText());
				Double totalAPagar=Double.valueOf(textTotalAPagar.getText());
				if(tipoDePago.equalsIgnoreCase("credito")) {
					numeroDeCuotas=Integer.valueOf(textNumeroCuotas.getText());
					montoPorcuota=Double.valueOf(textMontoPorCuota.getText());
				}else {
					numeroDeCuotas=0;
					montoPorcuota=0.0;
				}
				Comprobante comprobante=new Comprobante(fecha, nombreCliente, nombrePersonal,numeroBoleta , tipoComprobante, tipoDePago, numeroDeCuotas, 
					listaProductosSeleccionados, montoTotal,igv,totalAPagar,montoPorcuota);
				enviarBaseDatos(comprobante);
				mandarProductosADescontar(listaProductosSeleccionados);
				ArchivoTexto.crearArchivoConfigBoleta(configBoleta);
				limpiarCajasText();
			}					
		});

		
		
		btnMostrarComprobante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Comprobante> listaComprobantes=null;
				try {
					listaComprobantes = ConexionBd.leerBoleta();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				String boleta=textNumeroBoleta.getText();
				for(Comprobante comprobante:listaComprobantes) {
					if(boleta.equalsIgnoreCase(comprobante.getConfigBoleta())) {
						ComprobantVista principal=new ComprobantVista(null, true, comprobante);
						principal.setVisible(true);
					}
				}				
			}
		});
	}
	
	//***********************METODOS***************
	
	public ArrayList<ProductoDeVenta> verificarProductosIguales(ProductoDeVenta productoDeVenta) {
		Integer codigoProductoARevisar = productoDeVenta.getCodigo();
		boolean agregar=true;
		if(listaProductosSeleccionados.size()==0) {
			listaProductosSeleccionados.add(productoDeVenta);
		}else {
			for (int i = 0 ; i < listaProductosSeleccionados.size(); i++) {
				Integer codigoProductoTemporal = listaProductosSeleccionados.get(i).getCodigo();
				if (codigoProductoARevisar.equals(codigoProductoTemporal)) {
					Integer nuevaCantidad =listaProductosSeleccionados.get(i).getCantidad() + productoDeVenta.getCantidad();
					listaProductosSeleccionados.get(i).setCantidad(nuevaCantidad);
					agregar=false;
				}
			}
			if(agregar) {
				listaProductosSeleccionados.add(productoDeVenta);
			}
		}
		return listaProductosSeleccionados;
	}

	public ProductoDeVenta obtenerProductoDeVenta(Producto producto, Integer cantidad) {
		Integer codigo = producto.getCodigo();
		String nombre = producto.getNombre();
		Double precio = producto.getPrecioDeVenta();
		String descripcion = producto.getDescripcion();
		Integer cantidadProducto = cantidad;
		Double importeTotal = precio * cantidad;
		ProductoDeVenta productoDeVenta = new ProductoDeVenta(codigo, nombre, precio, descripcion, cantidadProducto,
				importeTotal);
		return productoDeVenta;
	}

	public static DefaultTableModel mostrarProductosAVender(ArrayList<ProductoDeVenta> listaProducto) {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("CODIGO");
		modelo.addColumn("PRODUCTO");
		modelo.addColumn("DESCRIPCION");
		modelo.addColumn("CANTIDAD");
		modelo.addColumn("PRECIO UNITARIO");
		modelo.addColumn("IMPORTE");
		for (ProductoDeVenta producto : listaProducto) {
			Double importe = producto.getCantidad() * producto.getPrecio();
			modelo.addRow(new String[] { producto.getCodigo().toString(), producto.getNombre(),
					producto.getDescripcion(), producto.getCantidad().toString(), producto.getPrecio().toString(),
					Utils.agregarFormatoDoule(importe) });
		}
		return modelo;
	}

	public void calcularYMostrarImportes(ArrayList<ProductoDeVenta> listaProductosSeleccionados) {
		Double importeTotal = calcularImporteTotalDeVenta(listaProductosSeleccionados);
		Double igv = calcularIgv(importeTotal);
		Double totalAPagar = calcularTotalAPagar(importeTotal, igv);
		textMontoTotal.setText(Utils.agregarFormatoDoule(importeTotal));
		textIgv.setText(Utils.agregarFormatoDoule(igv));
		textTotalAPagar.setText(Utils.agregarFormatoDoule(totalAPagar));
	}

	public Double calcularImporteTotalDeVenta(ArrayList<ProductoDeVenta> listaProductosSeleccionados) {
		Double importeTotal = 0.0;
		for (ProductoDeVenta productoDeVenta : listaProductosSeleccionados) {
			Double importe = productoDeVenta.getCantidad() * productoDeVenta.getPrecio();
			importeTotal += importe;
		}
		return importeTotal;
	}

	public Double calcularIgv(Double importeTotal) {
		return importeTotal * 0.18;
	}

	public Double calcularTotalAPagar(Double importeTotal, Double igv) {
		return importeTotal + igv;
	}
	
	public void limpiarCajasText() {
		textClienteUser.setText("");
		textClienteNombre.setText("");
		textNumeroCuotas.setText("");
		textMontoPorCuota.setText("");
		textProducto.setText("");
		textStockProducto.setText("");
		textCantidadProducto.setText("");
		textMontoTotal.setText("");
		textIgv.setText("");
		textTotalAPagar.setText("");
		textNumeroBoleta.setText(this.configBoleta.getSerie()+" - "+this.configBoleta.getNumeracion());
	}
	
	public void enviarBaseDatos(Comprobante comprobante) {
		String fecha=Utils.convertirDeDateAString(comprobante.getFecha());
		String nombreCliente=comprobante.getNombreCliente();
		String nombrePersonal=comprobante.getNombrePersonal();
		String codigoBoleta=comprobante.getConfigBoleta();
		String tipoDeComprobanmte=comprobante.getTipoDeComprobante();
		String tipoDePago=comprobante.getTipoDePago();
		Integer numeroCuotas=comprobante.getNumeroDeCuotas();
		Double montoTotal=comprobante.getMontoTotal();
		Double igv=comprobante.getIgv();
		Double totalAPagar=comprobante.getTotalAPagar();
		Double montoPorCuota=comprobante.getMontoPorCuota();
		ArrayList<ProductoDeVenta> listaProductos=comprobante.getProductos();
		ConexionBd.insertarDetallaBoleta(listaProductos,codigoBoleta);  
		ConexionBd.insertarBoleta(fecha,nombreCliente,nombrePersonal,codigoBoleta,tipoDeComprobanmte,tipoDePago,numeroCuotas,montoTotal,igv,totalAPagar,montoPorCuota);
	}
	
	public void mandarProductosADescontar(ArrayList<ProductoDeVenta> listaProductos) {
		for(ProductoDeVenta producto:listaProductos) {
			descontarProductos(producto);
		}
	}
	
	public void descontarProductos(ProductoDeVenta producto) {
		String nombreProducto=producto.getNombre();
		Integer cantidadEnVenta=producto.getCantidad();
		ArrayList<Producto> listaArchivoProductos=ArchivoTexto.leerArchivoProducto();
		for(int i=0;i<listaArchivoProductos.size();i++) {
			String productoAlmacen=listaArchivoProductos.get(i).getNombre();
			Integer stock=listaArchivoProductos.get(i).getStock();
			if(nombreProducto.equalsIgnoreCase(productoAlmacen)) {
				Integer nuevoStock=stock-cantidadEnVenta;
				listaArchivoProductos.get(i).setStock(nuevoStock);
			}
		}
		ArchivoTexto.crearArchivoProducto(listaArchivoProductos);
	}
	
	public void generarListaTemporal(Integer cantidadSeleccionada) {
		for(Producto producto:listaProductoTemporal) {
			if(producto.getCodigo()==productoRecibido.getCodigo()) {
				producto.setStock(productoRecibido.getStock()-cantidadSeleccionada);
			}
		}
	}
	public void devolverStockAListaTemporal(Integer codigo,Integer cantidad) {
		for(Producto producto:listaProductoTemporal) {
			if(producto.getCodigo()==codigo) {
				Integer nuevoStock=producto.getStock()+cantidad;
				producto.setStock(nuevoStock);
			}
		}
	}
}