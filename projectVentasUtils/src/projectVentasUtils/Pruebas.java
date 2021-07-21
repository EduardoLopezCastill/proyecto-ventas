package projectVentasUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class Pruebas {

	public static void main(String[] args) {
		
		String seleccion = JOptionPane.showInputDialog(null,"Ingrese codigo de trabajor",JOptionPane.QUESTION_MESSAGE); 
		
		//ingresoCorreoCorrecto("ab@gmail.com");
		
		
		/*	String numeroCadena="00009";
		Integer numero=Integer.valueOf(numeroCadena)+1;
		String prueba="00000"+String.valueOf(numero);
		System.out.println(prueba.substring(prueba.length()-5, prueba.length()));	
		
		Date date=new Date();
		String fecha=convertirDeDateAString(date);
		System.out.println(fecha);
		System.out.println(covertirDeStringADate(fecha));*/
		
		
	}
	public static String convertirDeDateAString(Date date) {
		SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd-MM-yyyy");
		String dateEnString = formatoDeFecha.format(date);
		return dateEnString;
	}

	public static Date covertirDeStringADate(String dateEnString) {
		SimpleDateFormat formatoDeFecha = new SimpleDateFormat("dd-MM-yyyy");
		Date date;
		try {
			date = formatoDeFecha.parse(dateEnString);
		} catch (ParseException e) {
			date = null;
		}
		return date;
	}
	
	public static boolean ingresoCorreoCorrecto(String algo) {
		boolean respuesta=false;
		// @hotmail.com  @outlook.com @gmail.com
 		String continuacion=algo.substring(algo.length()-10, algo.length());
 		if(continuacion.equalsIgnoreCase("@gmail.com")) {
 			System.out.println(continuacion);
 			respuesta=true;
 		}
 		return respuesta;
	}
	
	
}
