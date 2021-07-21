package projectVentas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import clienteGUI.InicioCliente;
import vendedorGUI.LoginVendedor;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Cursor;

public class InicioProjct {

	public JFrame frmFerreteria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioProjct window = new InicioProjct();
					window.frmFerreteria.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InicioProjct() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFerreteria = new JFrame();
		frmFerreteria.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		frmFerreteria.setTitle("Ferreteria");
		frmFerreteria.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Eduardo Lopez\\Downloads\\fond.jpg"));
		frmFerreteria.setBounds(100, 100, 635, 501);
		frmFerreteria.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmFerreteria.getContentPane().setLayout(null);
		frmFerreteria.setLocationRelativeTo(null);

		JButton btnCliente = new JButton("CLIENTE");
		btnCliente.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\consumidor.png"));
		btnCliente.setVerticalAlignment(SwingConstants.BOTTOM);
		btnCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCliente.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnCliente.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCliente.setForeground(Color.BLACK);
		btnCliente.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnCliente.setBounds(255, 107, 138, 110);
		frmFerreteria.getContentPane().add(btnCliente);
		
		JButton btnBack = new JButton("");
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\atras (1).png"));
		btnBack.setBounds(60, 308, 66, 67);
		frmFerreteria.getContentPane().add(btnBack);
		
		JButton btnVendedor = new JButton("VENDEDOR");
		btnVendedor.setVerticalAlignment(SwingConstants.BOTTOM);
		btnVendedor.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnVendedor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVendedor.setHorizontalTextPosition(SwingConstants.CENTER);
		btnVendedor.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\vendedr.png"));
		btnVendedor.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnVendedor.setBounds(60, 107, 138, 110);
		frmFerreteria.getContentPane().add(btnVendedor);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\fond.jpg"));
		lblNewLabel.setBounds(0, 0, 626, 469);
		frmFerreteria.getContentPane().add(lblNewLabel);
		
		JLabel lblTitulo = new JLabel("New label");
		lblTitulo.setBounds(30, 25, 488, 56);
		frmFerreteria.getContentPane().add(lblTitulo);
		
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InicioCliente principal=new InicioCliente();
				principal.frmInicio.setVisible(true);
				frmFerreteria.setVisible(false);
			}
		});

		btnVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginVendedor principal=new LoginVendedor();
				principal.frmLogin.setVisible(true);
				frmFerreteria.setVisible(false);
			}
		});
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmFerreteria.setVisible(false);
			}
		});
	}
}
