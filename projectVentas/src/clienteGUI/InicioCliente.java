package clienteGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import projectVentas.InicioProjct;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class InicioCliente {

	public JFrame frmInicio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioCliente window = new InicioCliente();
					window.frmInicio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InicioCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmInicio = new JFrame();
		frmInicio.getContentPane().setBackground(new Color(204, 255, 255));
		frmInicio.setTitle("Inicio");
		frmInicio.setBounds(100, 100, 399, 296);
		frmInicio.getContentPane().setLayout(null);
		frmInicio.setLocationRelativeTo(null);
		
		JButton btnClienteNuevo = new JButton("REGISTRARME");
		btnClienteNuevo.setVerticalAlignment(SwingConstants.BOTTOM);
		btnClienteNuevo.setBackground(Color.LIGHT_GRAY);
		btnClienteNuevo.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\nota.png"));
		btnClienteNuevo.setFont(new Font("Arial Black", Font.PLAIN, 11));
		btnClienteNuevo.setBounds(37, 51, 139, 98);
		btnClienteNuevo.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnClienteNuevo.setHorizontalTextPosition(SwingConstants.CENTER);
		frmInicio.getContentPane().add(btnClienteNuevo);
		
		JButton btnClienteConCuenta = new JButton("LOGIN");
		btnClienteConCuenta.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnClienteConCuenta.setVerticalAlignment(SwingConstants.BOTTOM);
		btnClienteConCuenta.setBackground(Color.LIGHT_GRAY);
		btnClienteConCuenta.setFont(new Font("Arial Black", Font.PLAIN, 13));
		btnClienteConCuenta.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\usuario.png"));
		btnClienteConCuenta.setHorizontalTextPosition(SwingConstants.CENTER);
		btnClienteConCuenta.setBounds(216, 51, 139, 98);
		frmInicio.getContentPane().add(btnClienteConCuenta);
		
		JButton btnBack = new JButton("");
		btnBack.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\atras (1).png"));
		btnBack.setBounds(296, 185, 64, 61);
		btnBack.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnBack.setHorizontalTextPosition(SwingConstants.CENTER);
		frmInicio.getContentPane().add(btnBack);

		btnClienteNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteNuevoLogin principal=new ClienteNuevoLogin();
				principal.frmRegistrarse.setVisible(true);
				frmInicio.setVisible(false);
			}
		});

		btnClienteConCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginCliente principal=new LoginCliente();
				principal.frmLogin.setVisible(true);
				frmInicio.setVisible(false);
			}
		});
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InicioProjct principal=new InicioProjct();
				principal.frmFerreteria.setVisible(true);
				frmInicio.setVisible(false);
			}
		});
	}
}
