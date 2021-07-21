package projectVentas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import projectVentasClases.Cliente;
import projectVentasUtils.ArchivoTexto;
import projectVentasUtils.Utils;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;


public class BuscadorClientes2 extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private ArrayList<Cliente> listaClienteSeleccionado;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public BuscadorClientes2(java.awt.Frame parent, boolean modal,ArrayList<Cliente> listaClienteSeleccionado) {
		 super(parent, modal);
		this.listaClienteSeleccionado=listaClienteSeleccionado;
		
		ArrayList<Cliente> listaCliente = ArchivoTexto.leerArchivoCliente();

		setBounds(100, 100, 489, 393);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(153, 204, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Buscador");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel.setBounds(28, 22, 126, 36);
		contentPanel.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Arial", Font.BOLD, 13));
		scrollPane.setBounds(10, 69, 447, 241);
		contentPanel.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(204, 255, 255));
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table.setSelectionBackground(new Color(204, 204, 153));
		table.setFont(new Font("Arial", Font.BOLD, 13));
		DefaultTableModel modelo = Utils.mostrarClientes(listaCliente);
		table.setModel(modelo);
		for(int i=0;i<=3;i++) {
			table.getColumnModel().getColumn(i).setResizable(false);
		}
		scrollPane.setViewportView(table);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(204, 204, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setBackground(new Color(204, 204, 204));
				okButton.setFont(new Font("Arial", Font.BOLD, 14));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);

				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int index =table.getSelectedRow();
						if(index!=-1) {
							Cliente cliente = listaCliente.get(index);
							listaClienteSeleccionado.add(cliente);
						}
						dispose();	  
					}
				});
			}

		}
		
	
	}
}
