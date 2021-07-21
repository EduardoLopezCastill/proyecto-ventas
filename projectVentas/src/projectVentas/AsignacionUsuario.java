package projectVentas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import projectVentasClases.Asignacion;
import projectVentasClases.Personal;
import projectVentasClases.Usuarios;
import projectVentasUtils.ArchivoTexto;
import projectVentasUtils.Utils;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseMotionAdapter;

public class AsignacionUsuario {

	public JFrame frame;
	private JTable tableUsuario;
	private JTable tablePersonl;
	private JTextField textUsuario;
	private JTextField textPersonal;
	private JTextField textBuscarUsuario;
	private JTextField textBuscarPersonal;
	private Usuarios usuario=null;
	private Personal personal=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AsignacionUsuario window = new AsignacionUsuario();
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
	public AsignacionUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 204));
		frame.setBounds(100, 100, 766, 394);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 204));
		panel.setLayout(null);
		panel.setBounds(10, 11, 230, 333);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Seleccione Usuario");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 210, 28);
		panel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 95, 210, 227);
		panel.add(scrollPane);
		
		tableUsuario = new JTable();
		tableUsuario.setSelectionBackground(new Color(204, 153, 0));
		tableUsuario.setGridColor(new Color(153, 153, 153));
		tableUsuario.setFont(new Font("Arial", Font.PLAIN, 13));
		tableUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tableUsuario.setBackground(new Color(255, 255, 153));
		scrollPane.setViewportView(tableUsuario);
		
		JLabel lblNewLabel_2 = new JLabel("Buscar :");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 50, 73, 21);
		panel.add(lblNewLabel_2);
		
		textBuscarUsuario = new JTextField();
		textBuscarUsuario.setEnabled(false);
		textBuscarUsuario.setBackground(new Color(204, 204, 204));
		textBuscarUsuario.setBounds(85, 50, 135, 21);
		panel.add(textBuscarUsuario);
		textBuscarUsuario.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 255, 204));
		panel_1.setLayout(null);
		panel_1.setBounds(250, 11, 230, 333);
		frame.getContentPane().add(panel_1);
		
		JLabel lblSeleccionePersonal = new JLabel("Seleccione Personal");
		lblSeleccionePersonal.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionePersonal.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblSeleccionePersonal.setBounds(10, 11, 210, 28);
		panel_1.add(lblSeleccionePersonal);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 95, 210, 227);
		panel_1.add(scrollPane_1);
		
		tablePersonl = new JTable();
		tablePersonl.setSelectionBackground(new Color(204, 153, 0));
		tablePersonl.setGridColor(new Color(153, 153, 153));
		tablePersonl.setFont(new Font("Arial", Font.PLAIN, 13));
		tablePersonl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tablePersonl.setBackground(new Color(255, 255, 153));
		
		scrollPane_1.setViewportView(tablePersonl);
		
		textBuscarPersonal = new JTextField();
		textBuscarPersonal.setEnabled(false);
		textBuscarPersonal.setBackground(new Color(204, 204, 204));
		textBuscarPersonal.setColumns(10);
		textBuscarPersonal.setBounds(85, 50, 135, 21);
		panel_1.add(textBuscarPersonal);
		
		JLabel lblNewLabel_2_1 = new JLabel("Buscar :");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 12));
		lblNewLabel_2_1.setBounds(10, 50, 73, 21);
		panel_1.add(lblNewLabel_2_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 204, 153));
		panel_2.setBounds(490, 86, 244, 152);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		textUsuario = new JTextField();
		textUsuario.setBackground(new Color(204, 204, 204));
		textUsuario.setEditable(false);
		textUsuario.setBounds(117, 22, 117, 25);
		panel_2.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario :");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 21, 86, 27);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Personal :");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 58, 86, 27);
		panel_2.add(lblNewLabel_1_1);
		
		textPersonal = new JTextField();
		textPersonal.setBackground(new Color(204, 204, 204));
		textPersonal.setEditable(false);
		textPersonal.setColumns(10);
		textPersonal.setBounds(117, 59, 117, 25);
		panel_2.add(textPersonal);
		
		JButton btnAsignar = new JButton("ASIGNAR");
		btnAsignar.setEnabled(false);
		btnAsignar.setForeground(new Color(0, 0, 0));
		btnAsignar.setBackground(new Color(204, 204, 204));
		btnAsignar.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnAsignar.setBounds(65, 110, 104, 25);
		panel_2.add(btnAsignar);
		ArrayList<Personal> listaPersonal=ArchivoTexto.leerArchivoPersonal();
		ArrayList<Usuarios> listaUsuarios=ArchivoTexto.leerArchivoUsuario();
		DefaultTableModel modeloUsuario=Utils.asignacionMostrarUsuarios(listaUsuarios);
		DefaultTableModel modeloPersonal=Utils.asignacionMostrarPersonal(listaPersonal);
		tableUsuario.setModel(modeloUsuario);
		tablePersonl.setModel(modeloPersonal);

		tableUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			int rowUsuario=tableUsuario.getSelectedRow();	
			usuario=listaUsuarios.get(rowUsuario);
			textUsuario.setText(usuario.getUsuario());
			}
		});
		
		tablePersonl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowPersonal=tablePersonl.getSelectedRow();
				personal=listaPersonal.get(rowPersonal);
				textPersonal.setText(personal.getNombre());
			}
		});

		btnAsignar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(usuario!=null&&personal!=null) {
					btnAsignar.setEnabled(true);
				}
			}
		});
		
		btnAsignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<Asignacion> listaAsignacion=ArchivoTexto.leerArchivoAsignacion();
				boolean asignacionExiste=false;
				for(Asignacion asignacion:listaAsignacion) {
					Integer codigoUsuario=asignacion.getCodUsuario();
					Integer codigoPersonal=asignacion.getCodPersonal();
					if(codigoUsuario==usuario.getCodigo()||codigoPersonal==personal.getCodigo()) {
						asignacionExiste=true;
					}
				}
				if(!asignacionExiste) {
					Asignacion asignacion=new Asignacion(usuario.getCodigo(),personal.getCodigo(),personal.getEstado());
					listaAsignacion.add(asignacion);
					ArchivoTexto.crearArchivoAsignacion(listaAsignacion);
					textUsuario.setText("");
					textPersonal.setText("");
					JOptionPane.showMessageDialog(null, "Asignacion agregada");
				}else {
					JOptionPane.showMessageDialog(null, "La asignacion ya existe");
					textUsuario.setText("");
					textPersonal.setText("");
				}
			}
		});
	}
}
