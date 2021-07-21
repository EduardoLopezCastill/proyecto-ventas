package vendedorGUI;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.UIManager;

import projectVentasClases.Usuarios;
import projectVentasMail.CorreoJava;
import projectVentasUtils.ArchivoTexto;
import projectVentasUtils.Utils;

import javax.swing.ImageIcon;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class RecuperarContrasenaVendedor extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	public JFrame frame;
	private JTextField textCodigo;
	private JTextField textNuevaContraseña;
	private JTextField textConfirmar;
	private JButton btnValidarCodigo;
	private JLabel lblNuevaClave;
	private JLabel lblConfirmar;
	private JButton btnGuardar;
	private String aleatorio;
	private JTextField textCorreo;
	private Usuarios usuario;
	private JLabel lblCorreoInvalido;

	public RecuperarContrasenaVendedor(Usuarios usuario) {
		initialize();
		this.usuario = usuario;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 255, 240));
		frame.setTitle("Recuperar Contrase\u00F1a");
		frame.setBounds(100, 100, 424, 342);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(158, 25, 240, 100);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		textCodigo = new JTextField();
		textCodigo.setFont(new Font("Arial", Font.BOLD, 12));
		textCodigo.setEditable(false);
		textCodigo.setBounds(58, 11, 121, 29);
		panel.add(textCodigo);
		textCodigo.setColumns(10);

		btnValidarCodigo = new JButton("VALIDAR CODIGO");
		btnValidarCodigo.setBounds(28, 45, 167, 37);
		panel.add(btnValidarCodigo);
		btnValidarCodigo.setEnabled(false);
		btnValidarCodigo.setFont(new Font("Arial Black", Font.BOLD, 13));

		JButton btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon("C:\\Users\\Eduardo Lopez\\Downloads\\atras (1).png"));
		btnAtras.setBounds(313, 202, 65, 63);
		frame.getContentPane().add(btnAtras);

		JButton btnEnviarCorreo = new JButton("Enviar correo");
		btnEnviarCorreo.setEnabled(false);
		btnEnviarCorreo.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnEnviarCorreo.setBounds(15, 102, 130, 23);
		frame.getContentPane().add(btnEnviarCorreo);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 255, 250));
		panel_1.setBounds(15, 146, 267, 146);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		lblNuevaClave = new JLabel("Nueva clave :");
		lblNuevaClave.setFont(new Font("Arial", Font.BOLD, 12));
		lblNuevaClave.setBounds(10, 24, 99, 23);
		lblNuevaClave.setVisible(false);
		panel_1.add(lblNuevaClave);

		textNuevaContraseña = new JTextField();
		textNuevaContraseña.setFont(new Font("Arial", Font.BOLD, 12));
		textNuevaContraseña.setBounds(105, 24, 126, 23);
		panel_1.add(textNuevaContraseña);
		textNuevaContraseña.setVisible(false);
		textNuevaContraseña.setColumns(10);

		lblConfirmar = new JLabel("Confirmar :");
		lblConfirmar.setFont(new Font("Arial", Font.BOLD, 12));
		lblConfirmar.setBounds(10, 71, 99, 23);
		lblConfirmar.setVisible(false);
		panel_1.add(lblConfirmar);

		textConfirmar = new JTextField();
		textConfirmar.setFont(new Font("Arial", Font.BOLD, 12));
		textConfirmar.setColumns(10);
		textConfirmar.setBounds(105, 71, 126, 23);
		textConfirmar.setVisible(false);
		panel_1.add(textConfirmar);

		btnGuardar = new JButton("Ok");
		btnGuardar.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnGuardar.setBounds(152, 112, 92, 23);
		btnGuardar.setVisible(false);
		panel_1.add(btnGuardar);

		textCorreo = new JTextField();
		textCorreo.setFont(new Font("Arial", Font.BOLD, 12));
		textCorreo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				boolean boleancorreo = VerificarCorreo(textCorreo.getText());
				if (!boleancorreo) {
					lblCorreoInvalido.setVisible(true);
					btnEnviarCorreo.setEnabled(false);
				} else {
					lblCorreoInvalido.setVisible(false);
					btnEnviarCorreo.setEnabled(true);
				}
			}
		});
		textCorreo.setBounds(15, 65, 133, 26);
		frame.getContentPane().add(textCorreo);
		textCorreo.setColumns(10);

		lblCorreoInvalido = new JLabel("Correo Invalido");
		lblCorreoInvalido.setFont(new Font("Arial Black", Font.BOLD, 12));
		lblCorreoInvalido.setForeground(Color.RED);
		lblCorreoInvalido.setBounds(15, 34, 130, 26);
		frame.getContentPane().add(lblCorreoInvalido);
		lblCorreoInvalido.setVisible(false);

		// **********************

		btnEnviarCorreo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String correo = textCorreo.getText();
				aleatorio = Utils.generarContraseñaAleatoria();
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
				String codigo = textCodigo.getText();
				if (codigo.equals(aleatorio)) {
					mostrarCajasDeTexto(true);
					btnValidarCodigo.setEnabled(false);
					textCodigo.setEditable(false);
				}
			}
		});

		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// aqui ya se guarda la nueva contraseña
				String contrasena = textNuevaContraseña.getText();
				String confirmar = textConfirmar.getText();
				if (contrasena.equals(confirmar)) {
					usuario.setClave(contrasena);
					mensajeDe("Nueva contraseña guardada con exito");
					guardarNuevaContrasena(usuario);
				} else {
					mensajeDe("Contraseña invalida");
					textNuevaContraseña.setText("");
					textConfirmar.setText("");
				}
			}
		});

		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
	}

	public void mostrarCajasDeTexto(boolean eleccion) {
		textNuevaContraseña.setVisible(eleccion);
		lblNuevaClave.setVisible(eleccion);
		textConfirmar.setVisible(eleccion);
		lblConfirmar.setVisible(eleccion);
		btnGuardar.setVisible(eleccion);
	}

	public void mensajeDe(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
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
		}, 30000); // Establezca su período de tiempo aquí //
	}

	public void guardarNuevaContrasena(Usuarios usuario) {
		ArrayList<Usuarios> listaUsuarios = ArchivoTexto.leerArchivoUsuario();
		for (int i = 0; i < listaUsuarios.size(); i++) {
			Integer codigo = listaUsuarios.get(i).getCodigo();
			if (codigo == usuario.getCodigo()) {
				listaUsuarios.set(i, usuario);
			}
		}
		ArchivoTexto.crearArchivoUsuario(listaUsuarios);
		textNuevaContraseña.setText("");
		textConfirmar.setText("");
	}

	public boolean VerificarCorreo(String correo) {
		boolean boleancorreo = Utils.ingresoCorreoCorrecto(correo);
		return boleancorreo;
	}
}
