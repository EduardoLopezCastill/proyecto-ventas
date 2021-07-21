package clienteGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;

import projectVentasUtils.Utils;

public class Calculadora {

	public JFrame frmCalculadora;
	private JTextField txtMostrarAquiDatos;
	private Double numero, resultado;
	private JLabel lblNumeroAnterior;
	private Integer opcion = 0;
	private JButton btnpunto;
	private JButton btnPor;
	private JButton btnMenos;
	private JButton btnEntre;
	private JButton btnMas;
	private JButton btn0 ;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora window = new Calculadora();
					window.frmCalculadora.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculadora() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculadora = new JFrame();
		frmCalculadora.getContentPane().setBackground(new Color(204, 255, 255));
		frmCalculadora.setTitle("Calculadora");
		frmCalculadora.setBounds(100, 100, 304, 382);
		frmCalculadora.getContentPane().setLayout(null);
		frmCalculadora.setLocationRelativeTo(null);

		JButton btn1 = new JButton("1");
		btn1.setBackground(new Color(255, 204, 204));
		btn1.setFont(new Font("Arial Black", Font.BOLD, 20));
		btn1.setBounds(16, 241, 58, 40);
		frmCalculadora.getContentPane().add(btn1);

		JButton btn2 = new JButton("2");
		btn2.setBackground(new Color(255, 204, 204));
		btn2.setFont(new Font("Arial Black", Font.BOLD, 20));
		btn2.setBounds(84, 241, 58, 40);
		frmCalculadora.getContentPane().add(btn2);

		JButton btn3 = new JButton("3");
		btn3.setBackground(new Color(255, 204, 204));
		btn3.setFont(new Font("Arial Black", Font.BOLD, 20));
		btn3.setBounds(152, 241, 58, 40);
		frmCalculadora.getContentPane().add(btn3);

		JButton btn4 = new JButton("4");
		btn4.setBackground(new Color(255, 204, 204));
		btn4.setFont(new Font("Arial Black", Font.BOLD, 20));
		btn4.setBounds(16, 190, 58, 40);
		frmCalculadora.getContentPane().add(btn4);

		txtMostrarAquiDatos = new JTextField();
		txtMostrarAquiDatos.setBackground(new Color(204, 204, 204));
		txtMostrarAquiDatos.setForeground(new Color(0, 0, 0));
		txtMostrarAquiDatos.setEditable(false);
		txtMostrarAquiDatos.setHorizontalAlignment(SwingConstants.TRAILING);
		txtMostrarAquiDatos.setFont(new Font("Arial Black", Font.PLAIN, 18));
		txtMostrarAquiDatos.setBounds(44, 36, 234, 40);
		frmCalculadora.getContentPane().add(txtMostrarAquiDatos);
		txtMostrarAquiDatos.setColumns(10);

		btn0= new JButton("0");
		btn0.setBackground(new Color(255, 204, 204));
		btn0.setEnabled(false);
		btn0.setFont(new Font("Arial Black", Font.BOLD, 20));
		btn0.setBounds(16, 292, 58, 40);
		frmCalculadora.getContentPane().add(btn0);

		btnpunto = new JButton(".");
		btnpunto.setBackground(new Color(255, 204, 204));
		btnpunto.setFont(new Font("Arial Black", Font.BOLD, 20));
		btnpunto.setBounds(84, 292, 58, 40);
		frmCalculadora.getContentPane().add(btnpunto);

		JButton btn5 = new JButton("5");
		btn5.setBackground(new Color(255, 204, 204));
		btn5.setFont(new Font("Arial Black", Font.BOLD, 20));
		btn5.setBounds(84, 190, 58, 40);
		frmCalculadora.getContentPane().add(btn5);

		JButton btn6 = new JButton("6");
		btn6.setBackground(new Color(255, 204, 204));
		btn6.setFont(new Font("Arial Black", Font.BOLD, 20));
		btn6.setBounds(152, 190, 58, 40);
		frmCalculadora.getContentPane().add(btn6);

		JButton btn7 = new JButton("7");
		btn7.setBackground(new Color(255, 204, 204));
		btn7.setFont(new Font("Arial Black", Font.BOLD, 20));
		btn7.setBounds(16, 139, 58, 40);
		frmCalculadora.getContentPane().add(btn7);

		JButton btn8 = new JButton("8");
		btn8.setBackground(new Color(255, 204, 204));
		btn8.setFont(new Font("Arial Black", Font.BOLD, 20));
		btn8.setBounds(84, 139, 58, 40);
		frmCalculadora.getContentPane().add(btn8);

		JButton btn9 = new JButton("9");
		btn9.setBackground(new Color(255, 204, 204));
		btn9.setFont(new Font("Arial Black", Font.BOLD, 20));
		btn9.setBounds(152, 139, 58, 40);
		frmCalculadora.getContentPane().add(btn9);

		JButton btnIgual = new JButton("=");
		btnIgual.setBackground(new Color(255, 204, 204));
		btnIgual.setFont(new Font("Arial Black", Font.BOLD, 20));
		btnIgual.setBounds(152, 292, 126, 40);
		frmCalculadora.getContentPane().add(btnIgual);

		btnMas = new JButton("+");
		btnMas.setBackground(new Color(255, 204, 204));
		btnMas.setEnabled(false);
		btnMas.setFont(new Font("Arial Black", Font.BOLD, 20));
		btnMas.setBounds(220, 240, 58, 40);
		frmCalculadora.getContentPane().add(btnMas);

		btnMenos = new JButton("-");
		btnMenos.setBackground(new Color(255, 204, 204));
		btnMenos.setEnabled(false);
		btnMenos.setFont(new Font("Arial Black", Font.BOLD, 20));
		btnMenos.setBounds(220, 189, 58, 40);
		frmCalculadora.getContentPane().add(btnMenos);

		btnPor= new JButton("*");
		btnPor.setBackground(new Color(255, 204, 204));
		btnPor.setEnabled(false);
		btnPor.setFont(new Font("Arial Black", Font.BOLD, 20));
		btnPor.setBounds(220, 138, 58, 40);
		frmCalculadora.getContentPane().add(btnPor);

		btnEntre = new JButton("/");
		btnEntre.setBackground(new Color(255, 204, 204));
		btnEntre.setEnabled(false);
		btnEntre.setFont(new Font("Arial Black", Font.BOLD, 20));
		btnEntre.setBounds(220, 87, 58, 40);
		frmCalculadora.getContentPane().add(btnEntre);

		JButton btnClear = new JButton("C");
		btnClear.setBackground(new Color(255, 204, 204));
		btnClear.setFont(new Font("Arial Black", Font.BOLD, 20));
		btnClear.setBounds(152, 88, 58, 40);
		frmCalculadora.getContentPane().add(btnClear);

		JButton btnBorrarUno = new JButton("\u2190");
		btnBorrarUno.setBackground(new Color(255, 204, 204));
		btnBorrarUno.setVerticalAlignment(SwingConstants.BOTTOM);
		btnBorrarUno.setFont(new Font("Arial Black", Font.PLAIN, 23));
		btnBorrarUno.setBounds(84, 87, 58, 40);
		frmCalculadora.getContentPane().add(btnBorrarUno);

		lblNumeroAnterior = new JLabel("");
		lblNumeroAnterior.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNumeroAnterior.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNumeroAnterior.setBounds(172, 11, 106, 22);
		frmCalculadora.getContentPane().add(lblNumeroAnterior);

		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtMostrarAquiDatos.setText(txtMostrarAquiDatos.getText() + "0");
			}
		});

		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtMostrarAquiDatos.setText(txtMostrarAquiDatos.getText() + "1");
				desbloqueaOperaciones(true);
			}
		});

		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtMostrarAquiDatos.setText(txtMostrarAquiDatos.getText() + "2");
				desbloqueaOperaciones(true);
			}
		});

		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtMostrarAquiDatos.setText(txtMostrarAquiDatos.getText() + "3");
				desbloqueaOperaciones(true);
			}
		});

		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtMostrarAquiDatos.setText(txtMostrarAquiDatos.getText() + "4");
				desbloqueaOperaciones(true);
			}
		});

		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtMostrarAquiDatos.setText(txtMostrarAquiDatos.getText() + "5");
				desbloqueaOperaciones(true);
			}
		});

		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtMostrarAquiDatos.setText(txtMostrarAquiDatos.getText() + "6");
				desbloqueaOperaciones(true);
			}
		});

		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtMostrarAquiDatos.setText(txtMostrarAquiDatos.getText() + "7");
				desbloqueaOperaciones(true);
			}
		});

		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtMostrarAquiDatos.setText(txtMostrarAquiDatos.getText() + "8");
				desbloqueaOperaciones(true);
			}
		});

		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtMostrarAquiDatos.setText(txtMostrarAquiDatos.getText() + "9");
				desbloqueaOperaciones(true);
			}
		});

		btnpunto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtMostrarAquiDatos.setText(txtMostrarAquiDatos.getText() + ".");
				desbloqueaOperaciones(true);
				verificarUnSoloPunto();
			}
		});

		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtMostrarAquiDatos.setText("");
				lblNumeroAnterior.setText("");
				btnpunto.setEnabled(true);
				desbloqueaOperaciones(false);
			}
		});

		btnBorrarUno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int totalCadena = txtMostrarAquiDatos.getText().length();
				int unoMenos = txtMostrarAquiDatos.getText().length() - 1;
				if (totalCadena > 0) {
					StringBuilder borraUno = new StringBuilder(txtMostrarAquiDatos.getText());
					borraUno.deleteCharAt(unoMenos);
					txtMostrarAquiDatos.setText(borraUno.toString());
				}
				verificarUnSoloPunto();
			}
		});

		btnMas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numero = Double.parseDouble(txtMostrarAquiDatos.getText());
				opcion = 1;
				txtMostrarAquiDatos.setText("");
				lblNumeroAnterior.setText(numero + " +");
				verificarUnSoloPunto();
				desbloqueaOperaciones(false);
			}
		});

		btnMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numero = Double.parseDouble(txtMostrarAquiDatos.getText());
				opcion = 2;
				txtMostrarAquiDatos.setText("");
				lblNumeroAnterior.setText(numero + " -");
				verificarUnSoloPunto();
				desbloqueaOperaciones(false);
			}
		});

		btnPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numero = Double.parseDouble(txtMostrarAquiDatos.getText());
				opcion = 3;
				txtMostrarAquiDatos.setText("");
				lblNumeroAnterior.setText(numero + " *");
				verificarUnSoloPunto();
				desbloqueaOperaciones(false);
			}
		});

		btnEntre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numero = Double.parseDouble(txtMostrarAquiDatos.getText());
				opcion = 4;
				txtMostrarAquiDatos.setText("");
				lblNumeroAnterior.setText(numero + " /");
				verificarUnSoloPunto();
				desbloqueaOperaciones(false);
			}
		});

		btnIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				operaciones(opcion);
				verificarUnSoloPunto();
				desbloqueaOperaciones(false);
			}
		});
	}

	public void operaciones(Integer opcion) {
		if(!txtMostrarAquiDatos.getText().equals("")) {		
			if(verificarCajaDeTexto()) {
				switch (opcion) {
				case 1: // suma
					resultado = numero + Double.parseDouble(txtMostrarAquiDatos.getText());
					Utils.agregarFormatoDoule(resultado);
					txtMostrarAquiDatos.setText("="+Utils.agregarFormatoDoule(resultado).toString());
					break;
				case 2: // resta
					resultado = numero - Double.parseDouble(txtMostrarAquiDatos.getText());
					Utils.agregarFormatoDoule(resultado);
					txtMostrarAquiDatos.setText("="+Utils.agregarFormatoDoule(resultado).toString());
					break;
				case 3: // multiplicacion
					resultado = numero * Double.parseDouble(txtMostrarAquiDatos.getText());
					Utils.agregarFormatoDoule(resultado);
					txtMostrarAquiDatos.setText("="+Utils.agregarFormatoDoule(resultado).toString());
					break;
				case 4: // division
					resultado = numero / Double.parseDouble(txtMostrarAquiDatos.getText());
					Utils.agregarFormatoDoule(resultado);
					txtMostrarAquiDatos.setText("="+Utils.agregarFormatoDoule(resultado).toString());
					break;
				default:
					break;
				}
			}else {
				JOptionPane.showMessageDialog(null, "Valor ingresado incorrecto"); 
			}
			
		}else {
			JOptionPane.showMessageDialog(null, "Valor ingresado incorrecto"); 
		}
		
	}
	
	public boolean verificarCajaDeTexto() {
		String cadena=txtMostrarAquiDatos.getText();
		boolean todocorrecto=false;
		for(int i=0;i<cadena.length();i++) {
			char caracter = cadena.charAt(i);
			if (((Integer.valueOf(caracter) >= 0) || (Integer.valueOf(caracter) <=9)) && (!String.valueOf(caracter).equals("\n")) && (!String.valueOf(caracter).equals("="))) {
				todocorrecto=true;
			}else {
				todocorrecto=false;
				break;
			}
		}
		return todocorrecto;
	}

	public void verificarUnSoloPunto() {
		String datosIngresados = txtMostrarAquiDatos.getText();
		boolean puntoExiste = false;
		for (int i = 0; i < datosIngresados.length(); i++) {
			String valor = String.valueOf(datosIngresados.charAt(i));
			if (valor.equals(".")) {
				puntoExiste = true;
			}
		}
		if (puntoExiste) {
			btnpunto.setEnabled(false);
		} else {
			btnpunto.setEnabled(true);
		}
	}
	public void desbloqueaOperaciones(boolean opcion) {
		btnEntre.setEnabled(opcion);
		btnPor.setEnabled(opcion);
		btnMenos.setEnabled(opcion);
		btnMas.setEnabled(opcion);
		btn0.setEnabled(opcion);
	}
}
