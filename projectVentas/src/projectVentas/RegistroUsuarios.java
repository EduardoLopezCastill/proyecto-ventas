package projectVentas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import projectVentasClases.Personal;
import projectVentasClases.Usuarios;
import projectVentasUtils.ArchivoTexto;
import projectVentasUtils.Utils;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class RegistroUsuarios {

	public JFrame frame;
	private JTextField textBuscador;
	private JTable table;
	private JTextField textCodigo;
	private JTextField textUsuario;
	private JTextField textClave;
	private JComboBox comboBoxEstado;
	private ArrayList<Usuarios> listaUsuario=ArchivoTexto.leerArchivoUsuario();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroUsuarios window = new RegistroUsuarios();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegistroUsuarios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 204));
		frame.setBounds(100, 100, 728, 400);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 204));
		panel.setBounds(10, 11, 282, 340);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BUSCAR USUARIO");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(29, 11, 183, 26);
		panel.add(lblNewLabel);
		
		textBuscador = new JTextField();
		textBuscador.setBackground(new Color(204, 204, 204));
		textBuscador.setFont(new Font("Arial", Font.BOLD, 12));
		textBuscador.setEditable(false);
		textBuscador.setBounds(10, 48, 155, 26);
		panel.add(textBuscador);
		textBuscador.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(204, 204, 204));
		comboBox.setFont(new Font("Arial", Font.BOLD, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Codigo", "Estado"}));
		comboBox.setBounds(175, 48, 97, 26);
		panel.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 98, 262, 224);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setSelectionBackground(new Color(153, 204, 255));
		table.setFont(new Font("Arial", Font.BOLD, 12));
		table.setBackground(new Color(204, 255, 255));
		scrollPane.setViewportView(table);
		
		JLabel lblRegistrarUsuario = new JLabel("REGISTRAR USUARIO");
		lblRegistrarUsuario.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblRegistrarUsuario.setBounds(302, 11, 260, 38);
		frame.getContentPane().add(lblRegistrarUsuario);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 255, 204));
		panel_1.setBounds(302, 60, 260, 290);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Dato de Usuarios");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 0, 139, 22);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Codigo :");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 60, 62, 22);
		panel_1.add(lblNewLabel_2);
		
		textCodigo = new JTextField();
		textCodigo.setBackground(new Color(204, 204, 204));
		textCodigo.setFont(new Font("Arial", Font.BOLD, 12));
		textCodigo.setEditable(false);
		textCodigo.setBounds(97, 61, 86, 21);
		panel_1.add(textCodigo);
		textCodigo.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Usuario :");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(10, 116, 62, 22);
		panel_1.add(lblNewLabel_2_1);
		
		textUsuario = new JTextField();
		textUsuario.setBackground(new Color(204, 204, 204));
		textUsuario.setFont(new Font("Arial", Font.BOLD, 12));
		textUsuario.setEditable(false);
		textUsuario.setColumns(10);
		textUsuario.setBounds(97, 117, 130, 21);
		panel_1.add(textUsuario);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Clave :");
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_1_1.setBounds(10, 171, 62, 22);
		panel_1.add(lblNewLabel_2_1_1);
		
		textClave = new JTextField();
		textClave.setBackground(new Color(204, 204, 204));
		textClave.setFont(new Font("Arial", Font.BOLD, 12));
		textClave.setEditable(false);
		textClave.setColumns(10);
		textClave.setBounds(97, 172, 130, 21);
		panel_1.add(textClave);
		
		comboBoxEstado = new JComboBox();
		comboBoxEstado.setBackground(new Color(204, 204, 204));
		comboBoxEstado.setFont(new Font("Arial", Font.BOLD, 12));
		comboBoxEstado.setEnabled(false);
		comboBoxEstado.setModel(new DefaultComboBoxModel(new String[] {"Activo", "En Baja"}));
		comboBoxEstado.setBounds(97, 228, 130, 22);
		panel_1.add(comboBoxEstado);
		
		JLabel lblNewLabel_3_1 = new JLabel("Estado :");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_3_1.setBounds(10, 228, 77, 22);
		panel_1.add(lblNewLabel_3_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 255, 204));
		panel_2.setBounds(572, 11, 127, 340);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBackground(new Color(204, 204, 204));
		btnNuevo.setFont(new Font("Arial", Font.BOLD, 13));
		btnNuevo.setBounds(15, 29, 99, 38);
		panel_2.add(btnNuevo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(new Color(204, 204, 204));
		btnGuardar.setFont(new Font("Arial", Font.BOLD, 13));
		btnGuardar.setEnabled(false);
		btnGuardar.setBounds(15, 89, 99, 38);
		panel_2.add(btnGuardar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBackground(new Color(204, 204, 204));
		btnModificar.setFont(new Font("Arial", Font.BOLD, 13));
		btnModificar.setEnabled(false);
		btnModificar.setBounds(15, 149, 99, 38);
		panel_2.add(btnModificar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(204, 204, 204));
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 13));
		btnCancelar.setBounds(15, 215, 99, 38);
		panel_2.add(btnCancelar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBackground(new Color(204, 204, 204));
		btnSalir.setFont(new Font("Arial", Font.BOLD, 13));
		btnSalir.setBounds(15, 275, 99, 38);
		panel_2.add(btnSalir);
		
		mostrarUsuarios();
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String combo=comboBox.getSelectedItem().toString();
				DefaultTableModel modelo=Utils.mostrarUsuarios(listaUsuario,combo);
				table.setModel(modelo);
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnNuevo.setEnabled(false);
				btnGuardar.setEnabled(false);
				btnModificar.setEnabled(true);
				Usuarios usuario=listaUsuario.get(table.getSelectedRow());
				textCodigo.setText(usuario.getCodigo().toString());
				textUsuario.setText(usuario.getUsuario());
				textClave.setText(usuario.getClave());
			}
		});

		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarCajasText();
				permitirIngresarDatos(true);
				btnGuardar.setEnabled(true);
			}
		});
		

		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnGuardar.setEnabled(true);
				permitirIngresarDatos(true);
			}
		});
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Y MODIFICAR AQUI
				ingresarUsuario();	
				btnGuardar.setEnabled(false);
				btnModificar.setEnabled(false);
			}
		});

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				permitirIngresarDatos(false);
				limpiarCajasText();
				btnModificar.setEnabled(false);
				btnGuardar.setEnabled(false);
				btnNuevo.setEnabled(true);
			}
		});
		

		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
	}
	
	public void permitirIngresarDatos(boolean bolean) {
		textCodigo.setEditable(bolean);
		textUsuario.setEditable(bolean);
		textClave.setEditable(bolean);
		comboBoxEstado.setEnabled(bolean);
	}
	
	public void limpiarCajasText() {
		textCodigo.setText("");
		textUsuario.setText("");
		textClave.setText("");
	}
	
	public void mostrarUsuarios() {
		DefaultTableModel modelo=Utils.mostrarUsuarios(listaUsuario,"Codigo");
		table.setModel(modelo);
	}
	
	public void ingresarUsuario() {
		String codigo=textCodigo.getText();
		String user=textUsuario.getText();
		String clave=textClave.getText();
		String estado=comboBoxEstado.getSelectedItem().toString();
		boolean confirmacion=confirmarCajasNoVacias(codigo,user,clave);
		boolean productoRepetido=false;
		if(confirmacion) {
			for(Usuarios usuarios:listaUsuario) {
				String codigoUsuario=usuarios.getCodigo().toString();
				String usuarioUsuario=usuarios.getUsuario();
				if(codigo.equals(codigoUsuario)&&user.equals(usuarioUsuario)) {
					usuarios.setClave(clave);
					usuarios.setEstado(estado);
					ArchivoTexto.crearArchivoUsuario(listaUsuario);
					productoRepetido = true;
					JOptionPane.showMessageDialog(null, "Usuario Modificado");
				}
			}
			if(!productoRepetido) {
				Usuarios usuario=new Usuarios(Integer.parseInt(codigo),user,clave,estado);
				listaUsuario.add(usuario);
				ArchivoTexto.crearArchivoUsuario(listaUsuario);
				JOptionPane.showMessageDialog(null, "Nuevo Usuario Guardado");
			}
		}
		mostrarUsuarios();		
		limpiarCajasText();
		permitirIngresarDatos(false);
	}
	
	public boolean confirmarCajasNoVacias(String codigo,String user,String clave) {
		boolean confirmar=false;
		if(codigo.equals("")) {
			JOptionPane.showMessageDialog(null, "Codigo ingresado incorrecto"); 
		}else if(user.equals("")){
			JOptionPane.showMessageDialog(null, "Usuario ingresado incorrecto"); 
		}else if(clave.equals("")){
			JOptionPane.showMessageDialog(null, "Clave ingresado incorrecto"); 
		}else {
			confirmar=true;
		}
		return confirmar;
	}
}
