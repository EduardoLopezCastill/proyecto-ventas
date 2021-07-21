package vendedorGUI;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import projectVentasClases.Comprobante;
import projectVentasClases.Personal;
import projectVentasClases.Producto;
import projectVentasClases.ProductoDeVenta;
import projectVentasUtils.ArchivoTexto;
import projectVentasUtils.ConexionBd;
import projectVentasUtils.Utils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.SwingConstants;

public class AnularVentasVendedor {

	public JFrame frame;
	private JTable table;
	private Personal personal;
	private Comprobante comprobante;
	private ArrayList<Comprobante> listComprobantes;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 * 
	 * @throws SQLException
	 */
	public AnularVentasVendedor(Personal personal) throws SQLException {
		this.personal = personal;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws SQLException
	 */
	private void initialize() throws SQLException {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 204));
		frame.setBounds(100, 100, 543, 387);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 27, 510, 258);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table.setSelectionBackground(new Color(153, 204, 204));
		table.setBackground(new Color(204, 255, 255));
		scrollPane.setViewportView(table);

		actualizarTabla(); // actualiza tabla de comprobantes

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comprobante = listComprobantes.get(table.getSelectedRow());
			}
		});
		
		JButton btnAnular = new JButton("ANULAR");
		btnAnular.setBackground(new Color(204, 204, 204));
		btnAnular.setHorizontalAlignment(SwingConstants.LEFT);
		btnAnular.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAnular.setFont(new Font("Arial", Font.BOLD, 12));
		btnAnular.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\elimina.png"));
		btnAnular.setBounds(381, 296, 124, 41);
		frame.getContentPane().add(btnAnular);
		frame.setLocationRelativeTo(null);

		btnAnular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<ProductoDeVenta> listaArchivoProductos=comprobante.getProductos();
				for(ProductoDeVenta productoDeVenta:listaArchivoProductos) {
					devolverProductos(productoDeVenta);//devuelve cantidad de productos, uno a uno
				}	
				eliminarDatosDeComprobanteEnBD(comprobante.getConfigBoleta());
				listComprobantes.remove(comprobante);
				table.setModel(mostrarComprobantes(listComprobantes));
			}
		});

	}

	// *****METODOS*****

	public DefaultTableModel mostrarComprobantes(ArrayList<Comprobante> listComprobantesDelVendedor) {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Fecha");
		modelo.addColumn("Nro Boleta");
		modelo.addColumn("Nombre de Cliente");
		modelo.addColumn("Total a Pagar");
		for (Comprobante comprobante : listComprobantesDelVendedor) {
			modelo.addRow(
					new String[] { Utils.convertirDeDateAString(comprobante.getFecha()), comprobante.getConfigBoleta(),
							comprobante.getNombreCliente(), comprobante.getTotalAPagar().toString() });
		}
		return modelo;
	}

	public ArrayList<Comprobante> obtenerComprobantesDelVendedor(ArrayList<Comprobante> listComprobantes,
			String vendedor) {
		ArrayList<Comprobante> listComprobantesDelVendedor = new ArrayList<>();
		for (Comprobante comprobante : listComprobantes) {
			String nombreVendedor = comprobante.getNombrePersonal();
			if (nombreVendedor.equals(vendedor)) {
				listComprobantesDelVendedor.add(comprobante);
			}
		}
		return listComprobantesDelVendedor;
	}

	public String obtenerNombreEnCadena(Personal personal) {
		return personal.getNombre() + " " + personal.getApellido();
	}

	public void actualizarTabla() throws SQLException {
		listComprobantes = ConexionBd.leerBoleta();
		String nombreVendedor = obtenerNombreEnCadena(personal);
		ArrayList<Comprobante> listComprobantesDelVendedor = obtenerComprobantesDelVendedor(listComprobantes,
				nombreVendedor);
		table.setModel(mostrarComprobantes(listComprobantesDelVendedor));
	}
	
	public void devolverProductos(ProductoDeVenta producto) {
		String nombreProducto=producto.getNombre();
		Integer cantidadDevuelta=producto.getCantidad();
		ArrayList<Producto> listaArchivoProductos=ArchivoTexto.leerArchivoProducto();
		for(int i=0;i<listaArchivoProductos.size();i++) {
			String productoAlmacen=listaArchivoProductos.get(i).getNombre();
			Integer stock=listaArchivoProductos.get(i).getStock();
			if(nombreProducto.equalsIgnoreCase(productoAlmacen)) {
				Integer nuevoStock=stock+cantidadDevuelta;
				listaArchivoProductos.get(i).setStock(nuevoStock);
			}
		}
		ArchivoTexto.crearArchivoProducto(listaArchivoProductos);
	}
	
	/*
	public void descontarBoletaAnulada(ConfigBoleta configBoleta) {
		String numeracionCadena = configBoleta.getNumeracion();
		Integer numeracion = Integer.valueOf(numeracionCadena) - 1;
		String numeracionDevolver = "000000" + String.valueOf(numeracion);
		configBoleta.setNumeracion(
				numeracionDevolver.substring(numeracionDevolver.length() - 5, numeracionDevolver.length()));
		ArchivoTexto.crearArchivoConfigBoleta(configBoleta);
	}*/
	
	public void eliminarDatosDeComprobanteEnBD(String codigoBoleta) {
		try {
			Connection con = ConexionBd.getConnection();
			Statement st = con.createStatement();
			String boleta="DELETE  FROM BOLETA  WHERE codigo="+"\""+codigoBoleta+"\"";
			String detalle="DELETE  FROM DETALLA_BOLETA  WHERE codigoBoleta="+"\""+codigoBoleta+"\"";
			st.execute(boleta);
			st.execute(detalle);
			con.close();
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
}
