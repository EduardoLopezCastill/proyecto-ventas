package projectVentasUtils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.swing.table.DefaultTableModel;

import projectVentasClases.Cliente;
import projectVentasClases.ConfigBoleta;
import projectVentasClases.Personal;
import projectVentasClases.Producto;
import projectVentasClases.ProductoDeVenta;
import projectVentasClases.Usuarios;

public class Utils {

	public static void main(String ddd[]) {
		/* ---------------- */
	}
	public static int limitadorDeCaracteres(String caracteres,Integer maximoLenght ) {
		int cantidad=maximoLenght-caracteres.length();
		return cantidad;
	}
	
	public static String agregarFormatoDoule(Double decimal) {
		DecimalFormat df2 = new DecimalFormat("#.##");
		return df2.format(decimal);
	}
	//*********METODO PRUEBA***********
	public static int generarCodigosProducto() {
		int numeroAleatorio = (int) (Math.random() * 999 + 99);
		return numeroAleatorio;
	}

	public static void verificarCodigosProductoNoIguales(ArrayList<Producto> listaProducto) {
		boolean booleanCorrecto=false;
		 Integer nuevoCodigo;
		 
		for(Producto producto:listaProducto) {
			Integer codigoExistente=producto.getCodigo();
		 do {
			 nuevoCodigo=generarCodigosProducto();
		 }while(nuevoCodigo!=codigoExistente);
		}
		
		for(Producto producto:listaProducto) {
			nuevoCodigo=generarCodigosProducto();
			Integer codigoExistente=producto.getCodigo();
			if(nuevoCodigo!=codigoExistente) {
				booleanCorrecto=true;
			}
		}
	}
	//***********************
	public static String generarContraseñaAleatoria() {
		String asciiUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String asciiLowerCase = asciiUpperCase.toLowerCase();
		String digits = "1234567890";
		String asciiChars = asciiUpperCase + asciiLowerCase + digits;
		int length = 5;
		String randomString = generateRandomString(length, asciiChars);
		return randomString;
	}

	private static String generateRandomString(int length, String seedChars) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		Random rand = new Random();
		while (i < length) {
			sb.append(seedChars.charAt(rand.nextInt(seedChars.length())));
			i++;
		}
		return sb.toString();
	}

	public static boolean ingresoCorreoCorrecto(String algo) {
		if (algo.length() > 10) {
			String continuacion = algo.substring(algo.length() - 10, algo.length());
			if (continuacion.equalsIgnoreCase("@gmail.com")) {
				return true;
			}
		}
		return false;
	}

	// ****************************************************

	public static DefaultTableModel mostrarTablaProductos(ArrayList<Producto> listaProducto, String combo) {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn(combo);
		modelo.addColumn("nombre");
		if (combo.equals("Codigo")) {
			for (Producto producto : listaProducto) {
				modelo.addRow(new String[] { producto.getCodigo().toString(), producto.getNombre() });
			}
		} else if (combo.equals("Cantidad")) {
			for (Producto producto : listaProducto) {
				modelo.addRow(new String[] { producto.getStock().toString(), producto.getNombre() });
			}
		} else {
			for (Producto producto : listaProducto) {
				modelo.addRow(
						new String[] { producto.getCategoria().getDescripcion().toString(), producto.getNombre() });
			}
		}
		return modelo;
	}

	// ****************************************************

	public static DefaultTableModel buscadorMostrarDatos(ArrayList<Producto> listaProducto) {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Descripcion");
		modelo.addColumn("Precio Venta");
		modelo.addColumn("Stock");

		for (Producto producto : listaProducto) {
			modelo.addRow(
					new String[] { producto.getCodigo().toString(), producto.getNombre(), producto.getDescripcion(),
							producto.getPrecioDeVenta().toString(), producto.getStock().toString() });
		}
		return modelo;
	}

	// ****************************************************

	public static DefaultTableModel mostrarBuscadorClientes(String combo, ArrayList<Cliente> listaCliente) {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("User");
		modelo.addColumn(combo);
		if (combo.equals("Nombre")) {
			for (Cliente cliente : listaCliente) {
				modelo.addRow(new String[] { cliente.getUsuario(), cliente.getNombre(), cliente.getClave(),
						cliente.getApellido(), cliente.getCorreo(), cliente.getTipoDeTelefono(),
						cliente.getTelefono().toString() });
			}
		} else {
			for (Cliente cliente : listaCliente) {
				modelo.addRow(new String[] { cliente.getUsuario(), cliente.getApellido(), cliente.getNombre(),
						cliente.getClave(), cliente.getCorreo(), cliente.getTipoDeTelefono(),
						cliente.getTelefono().toString() });
			}
		}
		return modelo;
	}

	public static DefaultTableModel mostrarBuscadorPersonal(String combo, ArrayList<Personal> listaPersonal) {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn(combo);
		modelo.addColumn("Apellido");
		if (combo.equals("Codigo")) {
			for (Personal personal : listaPersonal) {
				modelo.addRow(new String[] { personal.getCodigo().toString(), personal.getApellido(), });
			}
		} else if (combo.equals("DNI")) {
			for (Personal personal : listaPersonal) {
				modelo.addRow(new String[] { personal.getDni().toString(), personal.getApellido(), });
			}
		} else {
			for (Personal personal : listaPersonal) {
				modelo.addRow(new String[] { personal.getNombre(), personal.getApellido(), });
			}
		}
		return modelo;
	}

	public static DefaultTableModel asignacionMostrarUsuarios(ArrayList<Usuarios> listaUsuario) {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("User");

		for (Usuarios usuario : listaUsuario) {
			modelo.addRow(new String[] { usuario.getCodigo().toString(), usuario.getUsuario(), usuario.getClave(),
					usuario.getEstado() });
		}
		return modelo;
	}

	public static DefaultTableModel asignacionMostrarPersonal(ArrayList<Personal> listaPersonal) {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");

		for (Personal personal : listaPersonal) {
			modelo.addRow(new String[] { personal.getCodigo().toString(), personal.getNombre(),
					personal.getDni().toString(), personal.getTelefono().toString(), personal.getApellido(),
					personal.getDireccion(), personal.getTipoDeTelefono(), personal.getEstado(),
					convertirDeDateAString(personal.getFechaDeNacimiento()) });
		}
		return modelo;
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

	public static String escribirProducto(ProductoDeVenta producto) {
		StringBuilder cadenaProductos = new StringBuilder();
		cadenaProductos.append(producto.getNombre() + " , " + producto.getPrecio() + " , " + producto.getCantidad()
				+ " , " + agregarFormatoDoule(producto.getImporteTotal()));

		return cadenaProductos.toString();
	}

	public static DefaultTableModel mostrarUsuarios(ArrayList<Usuarios> listaUsuario, String combo) {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn(combo);
		modelo.addColumn("User");
		if (combo.equalsIgnoreCase("Codigo")) {
			for (Usuarios usuario : listaUsuario) {
				modelo.addRow(new String[] { usuario.getCodigo().toString(), usuario.getUsuario(), usuario.getClave(),
						usuario.getEstado() });
			}
		} else {
			for (Usuarios usuario : listaUsuario) {
				modelo.addRow(new String[] { usuario.getEstado(), usuario.getUsuario(), usuario.getClave(),
						usuario.getCodigo().toString() });
			}
		}
		return modelo;
	}

	public static DefaultTableModel mostrarClientes(ArrayList<Cliente> listaCliente) {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Usuario");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Telefono");
		for (Cliente cliente : listaCliente) {
			modelo.addRow(new String[] { cliente.getUsuario(), cliente.getNombre(), cliente.getApellido(),
					cliente.getTelefono().toString(), cliente.getClave(), cliente.getCorreo(),
					cliente.getTipoDeTelefono() });
		}

		return modelo;
	}

	public static ConfigBoleta logicaNumeroBoleta(ConfigBoleta configBoleta) {
		String numeracionCadena = configBoleta.getNumeracion();
		Integer numeracion = Integer.parseInt(numeracionCadena) + 1;
		String numeracionDevolver = "000000" + String.valueOf(numeracion);
		configBoleta.setNumeracion(
				numeracionDevolver.substring(numeracionDevolver.length() - 5, numeracionDevolver.length()));
		return configBoleta;
	}

}
