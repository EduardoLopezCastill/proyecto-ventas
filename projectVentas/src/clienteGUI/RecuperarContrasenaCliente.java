package clienteGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

import projectVentasClases.Cliente;
import projectVentasClases.Usuarios;
import projectVentasMail.CorreoJava;
import projectVentasUtils.ArchivoTexto;
import projectVentasUtils.Utils;
import java.awt.Color;

public class RecuperarContrasenaCliente {

	public JFrame frame;
	private JTextField textCodigo;
	private JTextField textNuevaClave;
	private JTextField textConfirmar;
	private JButton btnValidarCodigo;
	private String aleatorio;
	private JTextField textCorreo;
	private JLabel lblNuevaClave;
	private JLabel lblConfirmar;
	private JButton btnOkConfirmar;
	private Cliente cliente;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public RecuperarContrasenaCliente(Cliente cliente) {
		this.cliente=cliente;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("RecuperarContrase\u00F1a");
		frame.setBounds(100, 100, 492, 339);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		JButton btnAtras = new JButton("");
		btnAtras.setBounds(375, 209, 65, 64);
		btnAtras.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\atras (1).png"));
		frame.getContentPane().add(btnAtras);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(280, 28, 186, 95);
		panel_1.setLayout(null);
		panel_1.setBackground(SystemColor.menu);
		frame.getContentPane().add(panel_1);

		textCodigo = new JTextField();
		textCodigo.setEditable(false);
		textCodigo.setColumns(10);
		textCodigo.setBounds(40, 11, 121, 29);
		panel_1.add(textCodigo);

		btnValidarCodigo = new JButton("VALIDAR CODIGO");
		btnValidarCodigo.setFont(new Font("Arial Black", Font.PLAIN, 9));
		btnValidarCodigo.setEnabled(false);
		btnValidarCodigo.setBounds(10, 45, 167, 37);
		panel_1.add(btnValidarCodigo);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(25, 161, 278, 128);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);

		lblNuevaClave = new JLabel("Nueva Clave :");
		lblNuevaClave.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNuevaClave.setBounds(10, 14, 79, 27);
		lblNuevaClave.setVisible(false);
		panel_2.add(lblNuevaClave);

		lblConfirmar = new JLabel("Confirmar :");
		lblConfirmar.setFont(new Font("Arial", Font.PLAIN, 12));
		lblConfirmar.setBounds(10, 58, 79, 27);
		lblConfirmar.setVisible(false);
		panel_2.add(lblConfirmar);

		textNuevaClave = new JTextField();
		textNuevaClave.setFont(new Font("Arial", Font.PLAIN, 12));
		textNuevaClave.setBounds(117, 14, 138, 27);
		panel_2.add(textNuevaClave);
		textNuevaClave.setVisible(false);
		textNuevaClave.setColumns(10);

		textConfirmar = new JTextField();
		textConfirmar.setFont(new Font("Arial", Font.PLAIN, 12));
		textConfirmar.setColumns(10);
		textConfirmar.setBounds(117, 58, 138, 27);
		textConfirmar.setVisible(false);
		panel_2.add(textConfirmar);

		btnOkConfirmar = new JButton("OK");
		btnOkConfirmar.setBounds(195, 96, 73, 23);
		btnOkConfirmar.setVisible(false);
		panel_2.add(btnOkConfirmar);

		JPanel panel = new JPanel();
		panel.setBounds(10, 22, 260, 128);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.setEnabled(false);
		btnEnviar.setBounds(160, 22, 90, 90);
		panel.add(btnEnviar);
		btnEnviar.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\enviarcorreo.png"));
		btnEnviar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnEnviar.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnEnviar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnEnviar.setFont(new Font("Arial Black", Font.PLAIN, 12));

		JLabel lblCorreoInvalido = new JLabel("Correo Invalido");
		lblCorreoInvalido.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblCorreoInvalido.setForeground(new Color(255, 0, 0));
		lblCorreoInvalido.setBounds(24, 86, 116, 28);
		lblCorreoInvalido.setVisible(false);
		panel.add(lblCorreoInvalido);

		textCorreo = new JTextField();
		textCorreo.setFont(new Font("Arial", Font.PLAIN, 12));
		textCorreo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				boolean boleancorreo=VerificarCorreo(textCorreo.getText());
				if(!boleancorreo) {
					lblCorreoInvalido.setVisible(true);
					btnEnviar.setEnabled(false);
				}else {
					lblCorreoInvalido.setVisible(false);
					btnEnviar.setEnabled(true);
				}
			}
		});
		textCorreo.setBounds(10, 47, 140, 28);
		panel.add(textCorreo);
		textCorreo.setColumns(10);
		
		JLabel lblAviso = new JLabel("Ingrese Correo ");
		lblAviso.setFont(new Font("Arial", Font.BOLD, 16));
		lblAviso.setBounds(10, 22, 140, 20);
		panel.add(lblAviso);

		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				aleatorio = Utils.generarContraseñaAleatoria();
				String correo=textCorreo.getText();
				CorreoJava.EnviarCorreo(correo, aleatorio);
				// edulo1528@gmail.com
				textCodigo.setEditable(true);
				btnValidarCodigo.setEnabled(true); 
				mostrarCajasDeTexto(false); 
				textCodigo.setText("");
				boton30segundos();
			}
		});

		btnValidarCodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String codigo=textCodigo.getText();
				 if(codigo.equals(aleatorio)) {
					 mostrarCajasDeTexto(true);
					 btnValidarCodigo.setEnabled(false); 
					 textCodigo.setEditable(false);
				 }
			}
		});

		btnOkConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String contrasena=lblNuevaClave.getText();
				String confirmar=textConfirmar.getText();
				if(contrasena.equals(confirmar)) {
					cliente.setClave(contrasena);
					JOptionPane.showMessageDialog(null,"Nueva contraseña guardada con exito");
					guardarNuevaContrasena(cliente);
				}else {
					JOptionPane.showMessageDialog(null,"Contraseñas no coinciden");
					textConfirmar.setText("");
				}
			}
		});
		
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginCliente principal = new LoginCliente();
				principal.frmLogin.setVisible(true);
				frame.setVisible(false);
			}
		});
	}
	
	public void mostrarCajasDeTexto(boolean eleccion) {
		textNuevaClave.setVisible(eleccion);
		lblNuevaClave.setVisible(eleccion);
		textConfirmar.setVisible(eleccion);
		lblConfirmar.setVisible(eleccion);
		btnOkConfirmar.setVisible(eleccion);
	}
	
	public boolean VerificarCorreo(String correo) {
		boolean boleancorreo = Utils.ingresoCorreoCorrecto(correo);
		return boleancorreo;
	}

	public void boton30segundos() {
		btnValidarCodigo.setEnabled(true); // El botón está inicialmente deshabilitado //
		Timer buttonTimer = new Timer();
		buttonTimer.schedule(new TimerTask() {
			@Override
			public void run() {
				try {
					btnValidarCodigo.setEnabled(false);
					textCodigo.setEditable(false);
				} catch (Exception x) {
					System.out.println("error");
				}
			}
		}, 10000); // Establezca su período de tiempo aquí //
	}
	
    public void guardarNuevaContrasena(Cliente cliente) {
    	ArrayList<Cliente> listaClientes=ArchivoTexto.leerArchivoCliente();
    	for(int i=0;i<listaClientes.size();i++) {
    		String usuario=listaClientes.get(i).getUsuario();
    		if(usuario.equals(cliente.getUsuario())) {
    	    	listaClientes.set(i, cliente);
    		}
    	}
    	ArchivoTexto.crearArchivoCliente(listaClientes);    	
    	textNuevaClave.setText("");
		textConfirmar.setText("");
    }
}
