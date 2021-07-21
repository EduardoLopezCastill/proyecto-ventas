package projectVentas;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import projectVentasClases.Producto;
import projectVentasUtils.ArchivoTexto;
import projectVentasUtils.Utils;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

public class BuscadorDeProductos  extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private ArrayList<Producto> productoSeleccionado;
	private JTable table;
	private ArrayList<Producto> listaProductosAmostrar;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	/**
	 * Initialize the contents of the frame.
	 */
	 public BuscadorDeProductos(java.awt.Frame parent, boolean modal, ArrayList<Producto> listaProductoRecibe,ArrayList<Producto> listaProductosAMostrar) {
		 super(parent, modal);
		 productoSeleccionado=listaProductoRecibe;
		 this.listaProductosAmostrar=listaProductosAMostrar;
		
		setBounds(100, 100, 609, 420);
		getContentPane().setLayout(null);
	
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 255));
		panel.setBounds(10, 11, 573, 359);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(204, 204, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.add(panel);
		contentPanel.setLayout(null);
		panel.setLayout(null);

		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Arial", Font.BOLD, 14));
		btnSalir.setBackground(new Color(204, 204, 204));
		btnSalir.setBounds(467, 317, 75, 31);
		panel.add(btnSalir);

		JLabel lblNewLabel = new JLabel("PRODUCTOS");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.LEADING);
		lblNewLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 11, 156, 33);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Buscar :");
		lblNewLabel_1.setBackground(new Color(204, 204, 204));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(35, 48, 68, 31);
		panel.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.BOLD, 14));
		textField.setBackground(new Color(204, 204, 204));
		textField.setEditable(false);
		textField.setBounds(113, 48, 212, 31);
		panel.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 86, 538, 220);
		scrollPane.setFont(new Font("Arial Black", Font.PLAIN, 14));
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(204, 255, 255));
		table.setRowHeight(18);
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table.setSelectionBackground(new Color(204, 204, 153));
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setViewportView(table);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(204, 204, 204));
		comboBox.setFont(new Font("Arial", Font.BOLD, 14));
		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "Codigo", "Nombre", "Descripcion", "Precio Venta", "Stock" }));
		comboBox.setBounds(335, 48, 133, 31);
		panel.add(comboBox);

		DefaultTableModel modelo = Utils.buscadorMostrarDatos(listaProductosAmostrar);
		table.setModel(modelo);
		
		/*
		for(int i=0;i<modelo.getRowCount();i++) {
			if(modelo.getValueAt(i, 4).toString().equals("0")) {
				table.setBackground(Color.red);
			}
		}*/
		
		scrollPane.setViewportView(table);
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setPreferredWidth(40);
		table.getColumnModel().getColumn(4).setPreferredWidth(40);
		for(int i=0;i<=4;i++) {
			table.getColumnModel().getColumn(i).setResizable(false);
		}
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String opcionCombo=comboBox.getSelectedItem().toString();
				mostrarOrden(opcionCombo);
			}
		});
		
		getRootPane().setDefaultButton(btnSalir);
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index =table.getSelectedRow();
				if(index!=-1) {
					Producto producto=listaProductosAmostrar.get(index);
					productoSeleccionado.add(producto);
				}
				dispose();		
			}
		});
	}
	 
	 //******METODOS******
	 
	 public void mostrarOrden(String opcion) {		
		 switch (opcion) {
		case "Codigo":
			ordenCodigo();
			break;
		case "Nombre":
			ordenNombre();
			break;
		case "Descripcion":
			ordenDescripcion();
			break;
		case "Precio Venta":
			ordenPrecioVenta();
			break;
		case "Stock":
			ordenStock();
			break;
		default:
			break;
		}
	 }
	 
	 public void ordenCodigo() {
		 ArrayList<Producto> listaProducto=ArchivoTexto.leerArchivoProducto();
		 DefaultTableModel modelo = new DefaultTableModel();
		 	modelo.addColumn("Codigo");
			modelo.addColumn("Nombre");
			modelo.addColumn("Descripcion");
			modelo.addColumn("Precio Venta");
			modelo.addColumn("Stock");

			for (Producto producto : listaProducto) {
				modelo.addRow(
						new String[] { producto.getCodigo().toString(), producto.getNombre(), producto.getDescripcion(),
								producto.getPrecioDeVenta().toString(), producto.getStock().toString() });
			}
			table.setModel(modelo);
	 }
	 
	 public void ordenNombre() {
		 ArrayList<Producto> listaProducto=ArchivoTexto.leerArchivoProducto();
		 DefaultTableModel modelo = new DefaultTableModel();
			modelo.addColumn("Nombre");
			modelo.addColumn("Codigo");
			modelo.addColumn("Descripcion");
			modelo.addColumn("Precio Venta");
			modelo.addColumn("Stock");

			for (Producto producto : listaProducto) {
				modelo.addRow(
						new String[] {  producto.getNombre(),producto.getCodigo().toString(), producto.getDescripcion(),
								producto.getPrecioDeVenta().toString(), producto.getStock().toString() });
			}
			table.setModel(modelo);
	 }
	 
	 public void ordenDescripcion() {
		 ArrayList<Producto> listaProducto=ArchivoTexto.leerArchivoProducto();
		 DefaultTableModel modelo = new DefaultTableModel();
		 	modelo.addColumn("Descripcion");
			modelo.addColumn("Codigo");
			modelo.addColumn("Nombre");
			modelo.addColumn("Precio Venta");
			modelo.addColumn("Stock");

			for (Producto producto : listaProducto) {
				modelo.addRow(
						new String[] {  producto.getDescripcion() ,producto.getCodigo().toString(),producto.getNombre() ,
								producto.getPrecioDeVenta().toString(), producto.getStock().toString() });
			}
			table.setModel(modelo);
	 }
	 
	 public void ordenPrecioVenta() {
		 ArrayList<Producto> listaProducto=ArchivoTexto.leerArchivoProducto();
		 DefaultTableModel modelo = new DefaultTableModel();
			modelo.addColumn("Precio Venta");
		 	modelo.addColumn("Codigo");
			modelo.addColumn("Nombre");
			modelo.addColumn("Descripcion");
			modelo.addColumn("Stock");

			for (Producto producto : listaProducto) {
				modelo.addRow(
						new String[] { producto.getPrecioDeVenta().toString() , producto.getNombre(), producto.getDescripcion(),
								producto.getCodigo().toString(), producto.getStock().toString() });
			}
			table.setModel(modelo);
	 }
	 
	 public void ordenStock() {
		 ArrayList<Producto> listaProducto=ArchivoTexto.leerArchivoProducto();
		 DefaultTableModel modelo = new DefaultTableModel();
		 	modelo.addColumn("Stock");
		 	modelo.addColumn("Codigo");
			modelo.addColumn("Nombre");
			modelo.addColumn("Descripcion");
			modelo.addColumn("Precio Venta");
			

			for (Producto producto : listaProducto) {
				modelo.addRow(
						new String[] { producto.getStock().toString(),producto.getCodigo().toString(), producto.getNombre(), producto.getDescripcion(),
								producto.getPrecioDeVenta().toString()  });
			}
			table.setModel(modelo);
	 }
}
