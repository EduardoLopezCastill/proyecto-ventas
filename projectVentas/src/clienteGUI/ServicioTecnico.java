package clienteGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class ServicioTecnico {

	public JFrame frmServicioTecnico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServicioTecnico window = new ServicioTecnico();
					window.frmServicioTecnico.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ServicioTecnico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmServicioTecnico = new JFrame();
		frmServicioTecnico.setTitle("Servicio Tecnico");
		frmServicioTecnico.setBounds(100, 100, 564, 455);
		frmServicioTecnico.setLocationRelativeTo(null);
		frmServicioTecnico.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("En Mantenimiento ....");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 26));
		lblNewLabel.setBounds(44, 130, 328, 61);
		frmServicioTecnico.getContentPane().add(lblNewLabel);
	}
}
