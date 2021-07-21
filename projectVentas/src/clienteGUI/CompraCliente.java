package clienteGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import projectVentas.BuscadorDeProductos;
import projectVentasClases.Cliente;
import projectVentasClases.Comprobante;
import projectVentasClases.ConfigBoleta;
import projectVentasClases.Producto;
import projectVentasClases.ProductoDeVenta;
import projectVentasUtils.ArchivoTexto;
import projectVentasUtils.ConexionBd;
import projectVentasUtils.Utils;
import vendedorGUI.ComprobantVista;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class CompraCliente extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	public JFrame frame;
	private JTextField textNombre;
	private JTextField textNumeroDeCuotas;
	private JTextField textMontoPorCuotas;
	private JTextField textProducto;
	private JTextField textStockProducto;
	private JTextField textCantidadProducto;
	private JTable table;
	private JTextField textMontoTotal;
	private JTextField textIgv;
	private JTextField textTotalAPagar;
	private JTextField textNumeroBoleta;
	private JTextField textFecha;
	private JTextField textCliente;
	private Date date=new Date();
	private Cliente cliente;
	private Producto productoRecibido;
	private ConfigBoleta configBoleta = Utils.logicaNumeroBoleta(ArchivoTexto.leerArchivoConfigBoleta());
	private ArrayList<ProductoDeVenta> listaProductosSeleccionados = new ArrayList<>();
	private	ArrayList<Producto> listaProductoTemporal=ArchivoTexto.leerArchivoProducto();
	
	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public CompraCliente(Cliente cliente) {
		this.cliente = cliente;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		getContentPane().setBackground(new Color(204, 255, 204));
		setClosable(true);
		setBounds(100, 100, 660, 612);
		getContentPane().setLayout(null);

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(153, 255, 153));
		frame.setTitle("A\u00F1adir Compra");
		frame.setBounds(100, 100, 620, 601);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JButton btnBuscarProductos = new JButton("");
		btnBuscarProductos.setHorizontalAlignment(SwingConstants.LEADING);
		btnBuscarProductos.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\buscando.png"));
		btnBuscarProductos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscarProductos.setBounds(183, 281, 54, 24);
		frame.getContentPane().add(btnBuscarProductos);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 204));
		panel.setBounds(40, 11, 500, 66);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnMostrarComprobante = new JButton("Mostrar Comprobante");
		btnMostrarComprobante.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMostrarComprobante.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\comprobar.png"));
		btnMostrarComprobante.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnMostrarComprobante.setBounds(238, 18, 206, 30);
		panel.add(btnMostrarComprobante);
		
		JButton btnAnadirVenta = new JButton("A\u00F1adir Venta");
		btnAnadirVenta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAnadirVenta.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\venta.png"));
		btnAnadirVenta.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnAnadirVenta.setBounds(29, 18, 156, 30);
		panel.add(btnAnadirVenta);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 255, 204));
		panel_1.setLayout(null);
		panel_1.setBounds(15, 88, 577, 183);
		frame.getContentPane().add(panel_1);

		JLabel lblCliente = new JLabel("Usuario :");
		lblCliente.setFont(new Font("Arial", Font.BOLD, 12));
		lblCliente.setBounds(10, 48, 54, 23);
		panel_1.add(lblCliente);

		textCliente = new JTextField();
		textCliente.setFont(new Font("Arial", Font.PLAIN, 14));
		textCliente.setEditable(false);
		textCliente.setColumns(10);
		textCliente.setBounds(64, 48, 99, 23);
		textCliente.setText(cliente.getUsuario());
		panel_1.add(textCliente);

		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 12));
		lblNombre.setBounds(10, 89, 54, 23);
		panel_1.add(lblNombre);

		textNombre = new JTextField();
		textNombre.setFont(new Font("Arial", Font.PLAIN, 14));
		textNombre.setEditable(false);
		textNombre.setColumns(10);
		textNombre.setBounds(64, 89, 308, 23);
		textNombre.setText(cliente.getNombre() + " " + cliente.getApellido());
		panel_1.add(textNombre);

		JLabel lblNewLabel_3 = new JLabel("Tipo de Pago");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 136, 73, 23);
		panel_1.add(lblNewLabel_3);

		JComboBox comboTipoPago = new JComboBox();
		comboTipoPago.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboTipoPago.setModel(new DefaultComboBoxModel(new String[] { "Contado", "Credito" }));
		comboTipoPago.setBounds(97, 136, 89, 23);
		panel_1.add(comboTipoPago);

		JLabel lblNewLabel_4 = new JLabel("Nro De Cuotas :");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_4.setBounds(207, 135, 89, 26);
		panel_1.add(lblNewLabel_4);

		textNumeroDeCuotas = new JTextField();
		textNumeroDeCuotas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b' /* corresponde a BACK_SPACE */)) {
					e.consume();
				}
				String caracteres = textNumeroDeCuotas.getText();
				Integer limitadorDeCaracteres = Utils.limitadorDeCaracteres(caracteres, 5);
				if (limitadorDeCaracteres == 0) {
					e.consume();
				}
			}
		});
		textNumeroDeCuotas.setEditable(false);
		textNumeroDeCuotas.setColumns(10);
		textNumeroDeCuotas.setBounds(296, 137, 64, 22);
		panel_1.add(textNumeroDeCuotas);

		textMontoPorCuotas = new JTextField();
		textMontoPorCuotas.setFont(new Font("Arial", Font.PLAIN, 14));
		textMontoPorCuotas.setEditable(false);
		textMontoPorCuotas.setColumns(10);
		textMontoPorCuotas.setBounds(489, 136, 64, 24);
		panel_1.add(textMontoPorCuotas);

		JLabel lblNewLabel_5 = new JLabel("Monto por Cuota :");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_5.setBounds(390, 135, 99, 26);
		panel_1.add(lblNewLabel_5);

		JLabel lblNewLabel_1 = new JLabel("Nro de Boleta:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(351, 14, 90, 20);
		panel_1.add(lblNewLabel_1);

		textNumeroBoleta = new JTextField();
		textNumeroBoleta.setFont(new Font("Arial", Font.PLAIN, 14));
		textNumeroBoleta.setEditable(false);
		textNumeroBoleta.setColumns(10);
		textNumeroBoleta.setText(this.configBoleta.getSerie()+" - "+this.configBoleta.getNumeracion());
		textNumeroBoleta.setBounds(450, 14, 103, 20);
		panel_1.add(textNumeroBoleta);

		JLabel lblNewLabel_2 = new JLabel("Comprobante :");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(351, 45, 99, 23);
		panel_1.add(lblNewLabel_2);

		JComboBox comboComprobante = new JComboBox();
		comboComprobante.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboComprobante.setToolTipText("Seleccione");
		comboComprobante.setModel(new DefaultComboBoxModel(new String[] {"Boleta", "Factura"}));
		comboComprobante.setBounds(448, 45, 103, 23);
		panel_1.add(comboComprobante);

		JLabel lblNewLabel = new JLabel("Fecha :");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 13, 54, 17);
		panel_1.add(lblNewLabel);

		textFecha = new JTextField();
		textFecha.setFont(new Font("Arial", Font.PLAIN, 14));
		textFecha.setEditable(false);
		textFecha.setColumns(10);
		textFecha.setBounds(64, 11, 99, 20);
		DateFormat format=new SimpleDateFormat("dd-MM-yyyy");
		textFecha.setText(format.format(date));
		panel_1.add(textFecha);

		JLabel lblProducto = new JLabel("Producto :");
		lblProducto.setFont(new Font("Arial", Font.BOLD, 12));
		lblProducto.setBounds(25, 282, 54, 23);
		frame.getContentPane().add(lblProducto);

		textProducto = new JTextField();
		textProducto.setFont(new Font("Arial", Font.PLAIN, 14));
		textProducto.setEditable(false);
		textProducto.setColumns(10);
		textProducto.setBounds(85, 282, 88, 23);
		frame.getContentPane().add(textProducto);

		JLabel lblStock = new JLabel("Stock :");
		lblStock.setFont(new Font("Arial", Font.BOLD, 12));
		lblStock.setBounds(263, 282, 43, 23);
		frame.getContentPane().add(lblStock);

		textStockProducto = new JTextField();
		textStockProducto.setFont(new Font("Arial", Font.PLAIN, 14));
		textStockProducto.setEditable(false);
		textStockProducto.setColumns(10);
		textStockProducto.setBounds(304, 281, 49, 23);
		frame.getContentPane().add(textStockProducto);

		textCantidadProducto = new JTextField();
		textCantidadProducto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if (((caracter < '0') || (caracter > '9')) && (caracter != '\b' /* corresponde a BACK_SPACE */)) {
					e.consume();
				}
				String caracteres = textCantidadProducto.getText();
				Integer limitadorDeCaracteres = Utils.limitadorDeCaracteres(caracteres, 5);
				if (limitadorDeCaracteres == 0) {
					e.consume();
				}
			}
		});
		textCantidadProducto.setColumns(10);
		textCantidadProducto.setBounds(434, 283, 47, 23);
		frame.getContentPane().add(textCantidadProducto);

		JLabel lblCantidad = new JLabel("Cantidad :");
		lblCantidad.setFont(new Font("Arial", Font.BOLD, 12));
		lblCantidad.setBounds(363, 282, 61, 23);
		frame.getContentPane().add(lblCantidad);

		JButton btnAnadir = new JButton("A\u00F1adir");
		btnAnadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAnadir.setHorizontalAlignment(SwingConstants.LEADING);
		btnAnadir.setFont(new Font("Arial", Font.BOLD, 11));
		btnAnadir.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\mas.png"));
		btnAnadir.setBounds(491, 282, 101, 23);
		frame.getContentPane().add(btnAnadir);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 315, 582, 124);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(255, 255, 204));
		scrollPane.setViewportView(table);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(204, 255, 204));
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(10, 477, 582, 75);
		frame.getContentPane().add(panel_1_1);

		JLabel lblNewLabel_6 = new JLabel("Monto Total :");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_6.setBounds(10, 11, 79, 23);
		panel_1_1.add(lblNewLabel_6);

		textMontoTotal = new JTextField();
		textMontoTotal.setFont(new Font("Arial", Font.PLAIN, 14));
		textMontoTotal.setEditable(false);
		textMontoTotal.setColumns(10);
		textMontoTotal.setBounds(91, 11, 67, 22);
		panel_1_1.add(textMontoTotal);

		JLabel lblNewLabel_6_1 = new JLabel("IGV :");
		lblNewLabel_6_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_6_1.setBounds(10, 41, 59, 23);
		panel_1_1.add(lblNewLabel_6_1);

		textIgv = new JTextField();
		textIgv.setFont(new Font("Arial", Font.PLAIN, 14));
		textIgv.setEditable(false);
		textIgv.setColumns(10);
		textIgv.setBounds(91, 42, 67, 22);
		panel_1_1.add(textIgv);

		JLabel lblNewLabel_7 = new JLabel("Total a Pagar :");
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_7.setBounds(245, 15, 86, 23);
		panel_1_1.add(lblNewLabel_7);

		textTotalAPagar = new JTextField();
		textTotalAPagar.setFont(new Font("Arial", Font.PLAIN, 14));
		textTotalAPagar.setEditable(false);
		textTotalAPagar.setColumns(10);
		textTotalAPagar.setBounds(329, 16, 86, 20);
		panel_1_1.add(textTotalAPagar);
		
		JButton btnQuitarElemento = new JButton("Quitar");
		btnQuitarElemento.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnQuitarElemento.setHorizontalAlignment(SwingConstants.LEADING);
		btnQuitarElemento.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\cancela2.png"));
		btnQuitarElemento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQuitarElemento.setBounds(491, 443, 100, 30);
		frame.getContentPane().add(btnQuitarElemento);
		
		comboTipoPago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String combo = comboTipoPago.getSelectedItem().toString();
				if (combo.equalsIgnoreCase("contado")) {
					textNumeroDeCuotas.setEditable(false);
				} else {
					textNumeroDeCuotas.setEditable(true);
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
				String nombrePersonal="No vendedor";
				String numeroBoleta=textNumeroBoleta.getText();
				String tipoComprobante=comboComprobante.getSelectedItem().toString();
				String tipoDePago=comboTipoPago.getSelectedItem().toString();
				Integer numeroDeCuotas;
				Double montoPorcuota;
				Double montoTotal =Double.valueOf(textMontoTotal.getText());
				Double igv=Double.valueOf(textIgv.getText());
				Double totalAPagar=Double.valueOf(textTotalAPagar.getText());
				if(tipoDePago.equalsIgnoreCase("credito")) {
					numeroDeCuotas=Integer.valueOf(textNumeroDeCuotas.getText());
					montoPorcuota=Double.valueOf(textMontoPorCuotas.getText());
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
		textNumeroDeCuotas.setText("");
		textMontoPorCuotas.setText("");
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
