package clienteGUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import projectVentasClases.Cliente;
import projectVentasClases.Usuarios;
import projectVentasUtils.ArchivoTexto;
import projectVentasUtils.Utils;
import vendedorGUI.RecuperarContrasenaVendedor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Cursor;

public class LoginCliente {

	public JFrame frmLogin;
	private JPasswordField passwordField;
	private JTextField textUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginCliente window = new LoginCliente();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("LOGIN");
		frmLogin.setBounds(100, 100, 401, 308);
		frmLogin.getContentPane().setBackground(new Color(175, 238, 238));
		frmLogin.getContentPane().setLayout(null);
		frmLogin.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("\u00BFOlvido la contrase\u00F1a?");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 177, 164, 25);
		frmLogin.getContentPane().add(lblNewLabel);
		
		JButton btnContrasenaNueva = new JButton("");
		btnContrasenaNueva.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnContrasenaNueva.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnContrasenaNueva.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\candado.png"));
		btnContrasenaNueva.setBounds(35, 200, 65, 58);
		btnContrasenaNueva.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnContrasenaNueva.setHorizontalTextPosition(SwingConstants.CENTER);
		frmLogin.getContentPane().add(btnContrasenaNueva);
		
		JButton btnAtras = new JButton("");
		btnAtras.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAtras.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\atras (1).png"));
		btnAtras.setBounds(290, 195, 65, 63);
		frmLogin.getContentPane().add(btnAtras);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 240));
		panel.setBounds(39, 21, 316, 145);
		frmLogin.getContentPane().add(panel);
		panel.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent event) {
				String caracteres=passwordField.getText();
				Integer limitadorDeCaracteres=Utils.limitadorDeCaracteres(caracteres,15);
				if(limitadorDeCaracteres==0) {
					event.consume();
				}
			}
		});
		passwordField.setFont(new Font("Arial", Font.PLAIN, 16));
		passwordField.setBounds(127, 55, 160, 25);
		passwordField.setBackground(new Color(204, 204, 204));
		panel.add(passwordField);
		
		JLabel passwordLabel = new JLabel("PASSWORD :");
		passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		passwordLabel.setBackground(new Color(255, 255, 240));
		passwordLabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		passwordLabel.setBounds(0, 55, 117, 25);
		passwordLabel.setOpaque(true);
		panel.add(passwordLabel);
		
		JLabel userLabel = new JLabel("USUARIO :");
		userLabel.setHorizontalAlignment(SwingConstants.CENTER);
		userLabel.setBackground(new Color(255, 255, 240));
		userLabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		userLabel.setBounds(0, 21, 117, 25);
		userLabel.setOpaque(true);
		panel.add(userLabel);
		
		textUsuario = new JTextField(20);
		textUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent event) {
				String caracteres=textUsuario.getText();
				Integer limitadorDeCaracteres=Utils.limitadorDeCaracteres(caracteres,15);
				if(limitadorDeCaracteres==0) {
					event.consume();
				}
			}
		});
		textUsuario.setFont(new Font("Arial", Font.PLAIN, 16));
		textUsuario.setBounds(127, 21, 160, 25);
		textUsuario.setBackground(new Color(204, 204, 204));
		panel.add(textUsuario);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIngresar.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnIngresar.setBounds(162, 97, 128, 37);
		panel.add(btnIngresar);
	
		btnContrasenaNueva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Solicitar usuario de cliente
				String seleccion = JOptionPane.showInputDialog(null,"Ingrese usuario de cliente",JOptionPane.QUESTION_MESSAGE);
				ArrayList<Cliente> listaCliente = ArchivoTexto.leerArchivoCliente();
				boolean ingresoCodigo=false;
				for(Cliente cliente:listaCliente) {
					String usuario=cliente.getUsuario();
					if(seleccion!=null&&seleccion.equals(usuario.toString())) {
						RecuperarContrasenaCliente principal = new RecuperarContrasenaCliente(cliente);
						principal.frame.setVisible(true);
						ingresoCodigo=true;
					}
				}if(!ingresoCodigo) {
					JOptionPane.showMessageDialog(null, "Usuario no encontrado");
				}
			}
		});

		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InicioCliente principal=new InicioCliente();
				principal.frmInicio.setVisible(true);
				frmLogin.setVisible(false);
			}
		});
		

		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user=textUsuario.getText();
				String password=passwordField.getText();
				ArrayList<Cliente> listaCliente=ArchivoTexto.leerArchivoCliente();
				for(int i=0;i<listaCliente.size();i++) {
					String userArchivo=listaCliente.get(i).getUsuario();
					String passwordArchivo=listaCliente.get(i).getClave();
					if(userArchivo.equalsIgnoreCase(user)&&passwordArchivo.equals(password)) {
						PrincipalCliente principal=new PrincipalCliente(listaCliente.get(i));
						principal.frame.setVisible(true);
						frmLogin.setVisible(false);
					}
				}
				textUsuario.setText("");
				passwordField.setText("");
			}
		});
	}
}
