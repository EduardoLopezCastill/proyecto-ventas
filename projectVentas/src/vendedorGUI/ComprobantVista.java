package vendedorGUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import projectVentasClases.Comprobante;
import projectVentasClases.ProductoDeVenta;
import projectVentasUtils.Utils;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import java.awt.Color;

public class ComprobantVista extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFecha;
	private JTextField textVendedor;
	private JTextField textComprobante;
	private JTextField textNumeroBoleta;
	private JTextField textCliente;
	private JTable table;
	private JTextField textMontoTotal;
	private JTextField textIgv;
	private JTextField textTotalAPagar;
	private JTextField textTipoDePago;
	private JTextField textNumeroCoutas;
	private JTextField textMontoPorCuotas;
	private Comprobante comprobante;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public ComprobantVista(java.awt.Frame parent, boolean modal,Comprobante comprobante) {
		super(parent, modal);
		this.comprobante=comprobante;
		
		setBounds(100, 100, 568, 519);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(175, 238, 238));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 240, 230));
		panel.setBounds(10, 11, 532, 84);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		
		textFecha = new JTextField();
		textFecha.setBackground(new Color(204, 204, 204));
		textFecha.setFont(new Font("Arial", Font.BOLD, 12));
		textFecha.setEditable(false);
		textFecha.setColumns(10);
		textFecha.setBounds(86, 11, 86, 20);
		textFecha.setText(Utils.convertirDeDateAString(comprobante.getFecha()));
		panel.add(textFecha);
		
		JLabel lblNewLabel = new JLabel("Fecha :");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 13, 66, 17);
		panel.add(lblNewLabel);
		
		JLabel lblVendedor = new JLabel("Vendedor :");
		lblVendedor.setFont(new Font("Arial", Font.BOLD, 12));
		lblVendedor.setBounds(10, 44, 66, 17);
		panel.add(lblVendedor);
		
		textVendedor = new JTextField();
		textVendedor.setBackground(new Color(204, 204, 204));
		textVendedor.setFont(new Font("Arial", Font.BOLD, 12));
		textVendedor.setEditable(false);
		textVendedor.setColumns(10);
		textVendedor.setBounds(86, 42, 200, 22);
		textVendedor.setText(comprobante.getNombrePersonal());
		panel.add(textVendedor);
		
		JLabel lblNewLabel_2 = new JLabel("Comprobante :");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(334, 46, 95, 17);
		panel.add(lblNewLabel_2);
		
		textComprobante = new JTextField();
		textComprobante.setBackground(new Color(204, 204, 204));
		textComprobante.setFont(new Font("Arial", Font.BOLD, 12));
		textComprobante.setEditable(false);
		textComprobante.setColumns(10);
		textComprobante.setBounds(421, 43, 95, 20);
		textComprobante.setText(comprobante.getTipoDeComprobante());
		panel.add(textComprobante);
		
		textNumeroBoleta = new JTextField();
		textNumeroBoleta.setBackground(new Color(204, 204, 204));
		textNumeroBoleta.setFont(new Font("Arial", Font.BOLD, 12));
		textNumeroBoleta.setEditable(false);
		textNumeroBoleta.setColumns(10);
		textNumeroBoleta.setBounds(421, 11, 95, 20);
		textNumeroBoleta.setText(comprobante.getConfigBoleta());
		panel.add(textNumeroBoleta);
		
		JLabel lblNewLabel_1 = new JLabel("Nro de Boleta:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_1.setBounds(334, 11, 86, 20);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(250, 240, 230));
		panel_1.setBounds(10, 106, 532, 108);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente :");
		lblCliente.setFont(new Font("Arial", Font.BOLD, 12));
		lblCliente.setBounds(10, 21, 54, 23);
		panel_1.add(lblCliente);
		
		textCliente = new JTextField();
		textCliente.setBackground(new Color(204, 204, 204));
		textCliente.setFont(new Font("Arial", Font.BOLD, 12));
		textCliente.setEditable(false);
		textCliente.setColumns(10);
		textCliente.setBounds(75, 21, 308, 23);
		textCliente.setText(comprobante.getNombreCliente());
		panel_1.add(textCliente);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo de Pago :");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 68, 86, 23);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nro De Cuotas :");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_4.setBounds(189, 68, 95, 23);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Monto por Cuota :");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_5.setBounds(343, 68, 107, 23);
		panel_1.add(lblNewLabel_5);
		
		textTipoDePago = new JTextField();
		textTipoDePago.setBackground(new Color(204, 204, 204));
		textTipoDePago.setFont(new Font("Arial", Font.BOLD, 12));
		textTipoDePago.setEditable(false);
		textTipoDePago.setBounds(93, 69, 86, 22);
		textTipoDePago.setText(comprobante.getTipoDePago());
		panel_1.add(textTipoDePago);
		textTipoDePago.setColumns(10);
		
		textNumeroCoutas = new JTextField();
		textNumeroCoutas.setBackground(new Color(204, 204, 204));
		textNumeroCoutas.setFont(new Font("Arial", Font.BOLD, 12));
		textNumeroCoutas.setEditable(false);
		textNumeroCoutas.setColumns(10);
		textNumeroCoutas.setBounds(279, 68, 54, 22);
		textNumeroCoutas.setText(comprobante.getNumeroDeCuotas().toString());
		panel_1.add(textNumeroCoutas);
		
		textMontoPorCuotas = new JTextField();
		textMontoPorCuotas.setBackground(new Color(204, 204, 204));
		textMontoPorCuotas.setFont(new Font("Arial", Font.BOLD, 12));
		textMontoPorCuotas.setEditable(false);
		textMontoPorCuotas.setColumns(10);
		textMontoPorCuotas.setBounds(449, 69, 73, 22);
		textMontoPorCuotas.setText(comprobante.getMontoPorCuota().toString());
		panel_1.add(textMontoPorCuotas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 230, 532, 123);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table.setFont(new Font("Arial", Font.BOLD, 11));
		table.setBackground(new Color(204, 255, 255));
		
		scrollPane.setViewportView(table);
		DefaultTableModel modelo=mostrarProductos(comprobante.getProductos());
		table.setModel(modelo);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(35);
		table.getColumnModel().getColumn(3).setPreferredWidth(35);
		table.getColumnModel().getColumn(5).setPreferredWidth(35);
		for(int i=0;i<6;i++) {
			table.getColumnModel().getColumn(i).setResizable(false);
		}
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(250, 240, 230));
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(10, 364, 532, 75);
		contentPanel.add(panel_1_1);
		
		JLabel lblNewLabel_6 = new JLabel("Monto Total :");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_6.setBounds(10, 11, 76, 23);
		panel_1_1.add(lblNewLabel_6);
		
		textMontoTotal = new JTextField();
		textMontoTotal.setBackground(new Color(204, 204, 204));
		textMontoTotal.setFont(new Font("Arial", Font.BOLD, 12));
		textMontoTotal.setEditable(false);
		textMontoTotal.setColumns(10);
		textMontoTotal.setBounds(96, 11, 67, 22);
		textMontoTotal.setText(comprobante.getMontoTotal().toString());
		panel_1_1.add(textMontoTotal);
		
		JLabel lblNewLabel_6_1 = new JLabel("IGV :");
		lblNewLabel_6_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_6_1.setBounds(10, 41, 67, 23);
		panel_1_1.add(lblNewLabel_6_1);
		
		textIgv = new JTextField();
		textIgv.setBackground(new Color(204, 204, 204));
		textIgv.setFont(new Font("Arial", Font.BOLD, 12));
		textIgv.setEditable(false);
		textIgv.setColumns(10);
		textIgv.setBounds(96, 42, 67, 22);
		textIgv.setText(comprobante.getIgv().toString());
		panel_1_1.add(textIgv);
		
		JLabel lblNewLabel_7 = new JLabel("Total a Pagar :");
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_7.setBounds(245, 15, 86, 23);
		panel_1_1.add(lblNewLabel_7);
		
		textTotalAPagar = new JTextField();
		textTotalAPagar.setBackground(new Color(204, 204, 204));
		textTotalAPagar.setFont(new Font("Arial", Font.BOLD, 12));
		textTotalAPagar.setEditable(false);
		textTotalAPagar.setColumns(10);
		textTotalAPagar.setBounds(340, 15, 86, 22);
		textTotalAPagar.setText(comprobante.getTotalAPagar().toString());
		panel_1_1.add(textTotalAPagar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(new Color(204, 204, 204));
		btnSalir.setVerticalAlignment(SwingConstants.BOTTOM);
		btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalir.setFont(new Font("Arial", Font.BOLD, 13));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();	  
			}
		});
		btnSalir.setBounds(453, 450, 89, 23);
		contentPanel.add(btnSalir);
	}
	
	public static DefaultTableModel mostrarProductos(ArrayList<ProductoDeVenta> listaProducto) {
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

}
