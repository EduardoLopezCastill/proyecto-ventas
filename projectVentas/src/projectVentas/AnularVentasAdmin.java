package projectVentas;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import projectVentasClases.Comprobante;
import projectVentasClases.Producto;
import projectVentasClases.ProductoDeVenta;
import projectVentasUtils.ArchivoTexto;
import projectVentasUtils.ConexionBd;
import projectVentasUtils.Utils;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.Font;

public class AnularVentasAdmin {

	public JFrame frame;
	private ArrayList<Comprobante> listComprobantes;
	private JTable table;
	private Comprobante comprobante;
	//private ConfigBoleta configBoleta=ArchivoTexto.leerArchivoConfigBoleta();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnularVentasAdmin window = new AnularVentasAdmin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws SQLException 
	 */
	public AnularVentasAdmin() throws SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize() throws SQLException {

		
		/* listComprobantes=ConexionBd.leerBoleta();
		public void descontarBoletaAnulada(ConfigBoleta configBoleta) {
			String numeracionCadena = configBoleta.getNumeracion();
			Integer numeracion = Integer.valueOf(numeracionCadena) - 1;
			String numeracionDevolver = "000000" + String.valueOf(numeracion);
			configBoleta.setNumeracion(
					numeracionDevolver.substring(numeracionDevolver.length() - 5, numeracionDevolver.length()));
			ArchivoTexto.crearArchivoConfigBoleta(configBoleta);
		}*/
		
		frame = new JFrame();
		frame.setBackground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(204, 255, 255));
		frame.setBounds(100, 100, 646, 473);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 610, 297);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table.setSelectionBackground(new Color(204, 204, 153));
		frame.setLocationRelativeTo(null);
		
		actualizarTabla(); //metodo actualiza tabla
		
		for(int i=0;i<=4;i++) {
			table.getColumnModel().getColumn(i).setResizable(false);
		}
		
		JButton btnAnular = new JButton("Anular");
		btnAnular.setBackground(new Color(153, 255, 204));
		btnAnular.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnAnular.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\elimina.png"));
		btnAnular.setBounds(457, 360, 152, 48);
		frame.getContentPane().add(btnAnular);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comprobante=listComprobantes.get(table.getSelectedRow());
			}
		});
		
		btnAnular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<ProductoDeVenta> listaArchivoProductos=comprobante.getProductos();
				for(ProductoDeVenta productoDeVenta:listaArchivoProductos) {
					devolverProductos(productoDeVenta);//devuelve cantidad de productos, uno a uno
				}	
				//descontarBoletaAnulada(configBoleta);//numero de boleta reducida
				eliminarDatosDeComprobanteEnBD(comprobante.getConfigBoleta());
				listComprobantes.remove(comprobante);
				table.setModel(mostrarComprobantes(listComprobantes));
			}
		});
	}

	public void actualizarTabla() throws SQLException {
		 ArrayList<Comprobante> listComprobantes=ConexionBd.leerBoleta();
		 table.setModel(mostrarComprobantes(listComprobantes));
		 this.listComprobantes=listComprobantes;
	}
	
	public ArrayList<Comprobante> obtenerComprobantesBD() throws SQLException {
		 ArrayList<Comprobante> listComprobantes=ConexionBd.leerBoleta();
		return listComprobantes;
	}
	
	public DefaultTableModel mostrarComprobantes(ArrayList<Comprobante> listComprobantes) {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Fecha");
		modelo.addColumn("Nro Boleta");
		modelo.addColumn("Nombre de Cliente");
		modelo.addColumn("Vendedor");
		modelo.addColumn("Total a Pagar");
		for (Comprobante comprobante : listComprobantes) {
			modelo.addRow(new String[] { Utils.convertirDeDateAString(comprobante.getFecha()),comprobante.getConfigBoleta(),
					comprobante.getNombreCliente(),comprobante.getNombrePersonal(),comprobante.getTotalAPagar().toString()							
			});
		}
		return modelo;
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
