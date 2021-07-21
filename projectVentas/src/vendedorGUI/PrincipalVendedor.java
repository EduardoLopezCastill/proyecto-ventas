package vendedorGUI;

import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import projectVentasClases.Personal;

import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class PrincipalVendedor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JFrame frmPrincipal;
	private Personal personal;
	private JTextField textFecha;
	private JTextField textVendedor;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public PrincipalVendedor(Personal personal) {
		this.personal=personal;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frmPrincipal = new JFrame();
		frmPrincipal.setTitle("PRINCIPAL");
		frmPrincipal.setBounds(100, 100, 674, 581);
		frmPrincipal.setSize(new Dimension(857, 593));
		frmPrincipal.setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(102, 153, 153));
		frmPrincipal.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("VENTAS");
		mnNewMenu.setVerticalTextPosition(SwingConstants.BOTTOM);
		mnNewMenu.setForeground(Color.BLACK);
		mnNewMenu.setFont(new Font("Arial Black", Font.BOLD, 16));
		mnNewMenu.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\biene.png"));
		mnNewMenu.setHorizontalTextPosition(SwingConstants.CENTER);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmGenerarVent = new JMenuItem("Generar venta");
		mntmGenerarVent.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\venta.png"));
		mntmGenerarVent.setFont(new Font("Arial", Font.BOLD, 14));
		mnNewMenu.add(mntmGenerarVent);
		
		JMenuItem mntmAnularVentas = new JMenuItem("Anular Ventas");
		mntmAnularVentas.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\tarjeta-de-credito.png"));
		mntmAnularVentas.setFont(new Font("Arial", Font.BOLD, 14));
		mnNewMenu.add(mntmAnularVentas);
		
		JMenu mnNewMenu_1 = new JMenu("MANTENIMIENTO");
		mnNewMenu_1.setForeground(Color.BLACK);
		mnNewMenu_1.setFont(new Font("Arial Black", Font.BOLD, 16));
		mnNewMenu_1.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\apoyo-tecnico.png"));
		mnNewMenu_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		mnNewMenu_1.setHorizontalTextPosition(SwingConstants.CENTER);
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmMantProductos = new JMenuItem("Productos");
		mntmMantProductos.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\esta.png"));
		mntmMantProductos.setFont(new Font("Arial", Font.BOLD, 14));
		mnNewMenu_1.add(mntmMantProductos);
		
		JMenuItem mntmMantCategoria = new JMenuItem("Categoria");
		mntmMantCategoria.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\categorias.png"));
		mntmMantCategoria.setFont(new Font("Arial", Font.BOLD, 14));
		mnNewMenu_1.add(mntmMantCategoria);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setLayout(null);
		desktopPane.setBackground(new Color(224, 255, 255));
		frmPrincipal.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Bienvenido Al Sistema");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 44));
		lblNewLabel.setBounds(49, 62, 628, 85);
		desktopPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha Actual :");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2.setBounds(520, 351, 132, 27);
		desktopPane.add(lblNewLabel_2);
		
		textFecha = new JTextField();
		textFecha.setBackground(new Color(204, 204, 204));
		textFecha.setHorizontalAlignment(SwingConstants.CENTER);
		textFecha.setFont(new Font("Arial", Font.BOLD, 18));
		textFecha.setEditable(false);
		textFecha.setColumns(10);
		textFecha.setBounds(657, 351, 139, 27);
		SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
		textFecha.setText(formateador.format(new Date()));
		desktopPane.add(textFecha);
		
		JLabel lblNewLabel_1 = new JLabel("Vendedor :");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(26, 395, 108, 27);
		desktopPane.add(lblNewLabel_1);
		
		textVendedor = new JTextField();
		textVendedor.setBackground(new Color(204, 204, 204));
		textVendedor.setText("<dynamic> <dynamic>");
		textVendedor.setFont(new Font("Arial", Font.BOLD, 18));
		textVendedor.setEditable(false);
		textVendedor.setColumns(10);
		textVendedor.setBounds(159, 394, 230, 27);
		desktopPane.add(textVendedor);
		textVendedor.setText(personal.getNombre()+" "+personal.getApellido());
		
		JButton btnCERRARSESION = new JButton("CERRAR SESION");
		btnCERRARSESION.setBackground(new Color(204, 204, 204));
		btnCERRARSESION.setFont(new Font("Arial Black", Font.PLAIN, 18));
		btnCERRARSESION.setBounds(530, 399, 222, 51);
		desktopPane.add(btnCERRARSESION);
		
		
		mntmGenerarVent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentasVendedor2 principal=new VentasVendedor2(personal);
				desktopPane.add(principal);
				principal.setVisible(true);
			}
		});

		mntmMantProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MantenimientoProductos principal=new MantenimientoProductos();
				principal.frame.setVisible(true);
			}
		});

		mntmMantCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MantenimientoCategoria principal=new MantenimientoCategoria();
				principal.frame.setVisible(true);
			}
		});

		mntmAnularVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AnularVentasVendedor principal;
				try {
					principal = new AnularVentasVendedor(personal);
					principal.frame.setVisible(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		btnCERRARSESION.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmPrincipal.setVisible(false);
				LoginVendedor principal=new LoginVendedor();
				principal.frmLogin.setVisible(true);
			}
		});
	}
}
