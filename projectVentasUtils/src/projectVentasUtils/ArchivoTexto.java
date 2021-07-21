package projectVentasUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import projectVentasClases.Asignacion;
import projectVentasClases.Categoria;
import projectVentasClases.Cliente;
import projectVentasClases.Comprobante;
import projectVentasClases.ConfigBoleta;
import projectVentasClases.Personal;
import projectVentasClases.Producto;
import projectVentasClases.ProductoDeVenta;
import projectVentasClases.Usuarios;


public class ArchivoTexto {

	public static void crearArchivoUsuario(ArrayList<Usuarios> arrayUsuario) {

		FileWriter flwriter = null;
		try {
			flwriter = new FileWriter(Constants.RUTA_USUARIO);
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			for (int i = 0; i < arrayUsuario.size(); i++) {
				bfwriter.write(arrayUsuario.get(i).getCodigo()+ " , "+arrayUsuario.get(i).getUsuario()+ " , "+
							arrayUsuario.get(i).getClave()+" , "+arrayUsuario.get(i).getEstado()+"\n");
			}
			bfwriter.close();

		} catch (IOException error) {

		}
	}
	
	public static ArrayList<Usuarios> leerArchivoUsuario() {
		File file = new File(Constants.RUTA_USUARIO);
		ArrayList<Usuarios> listaUsuarios= new ArrayList<Usuarios>();
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				Scanner delimitar = new Scanner(linea);
				delimitar.useDelimiter("\\s*,\\s*");
				Usuarios usuario = new Usuarios(null, null,null,null);
				usuario.setCodigo(Integer.valueOf(delimitar.next()));
				usuario.setUsuario(delimitar.next());
				usuario.setClave(delimitar.next());
				usuario.setEstado(delimitar.next());
				listaUsuarios.add(usuario);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return listaUsuarios;
	}
	
	//************************************************************
	
	public static void crearArchivoCliente(ArrayList<Cliente> arrayCliente) {

		FileWriter flwriter = null;
		try {
			flwriter = new FileWriter(Constants.RUTA_CLIENTE);
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			for (int i = 0; i < arrayCliente.size(); i++) {
				String dateEnString=Utils.convertirDeDateAString(arrayCliente.get(i).getFechaDeNacimiento());
				bfwriter.write(arrayCliente.get(i).getUsuario()+ " , "+
						arrayCliente.get(i).getClave()+ " , "+
						arrayCliente.get(i).getNombre()+" , "+
						arrayCliente.get(i).getApellido()+" , "+
						arrayCliente.get(i).getCorreo()+" , "+
						dateEnString+" , "+
						arrayCliente.get(i).getTipoDeTelefono()+" , "+
						arrayCliente.get(i).getTelefono()+"\n");
			}
			bfwriter.close();

		} catch (IOException error) {

		}
	}
	
	public static ArrayList<Cliente> leerArchivoCliente() {
		File file = new File(Constants.RUTA_CLIENTE);
		ArrayList<Cliente> listaClientes= new ArrayList<Cliente>();
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				Scanner delimitar = new Scanner(linea);
				delimitar.useDelimiter("\\s*,\\s*");
				Cliente cliente = new Cliente(null, null,null,null,null,null,null,null);
				cliente.setUsuario(delimitar.next());
				cliente.setClave(delimitar.next());
				cliente.setNombre(delimitar.next());
				cliente.setApellido(delimitar.next());
				cliente.setCorreo(delimitar.next());
				Date date=Utils.covertirDeStringADate(delimitar.next());
				cliente.setFechaDeNacimiento(date);
				cliente.setTipoDeTelefono(delimitar.next());
				cliente.setTelefono(Integer.valueOf(delimitar.next()));
				listaClientes.add(cliente);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return listaClientes;
	}
	
	//************************************************************
	
	public static void crearArchivoProducto(ArrayList<Producto> arrayProducto) {

		FileWriter flwriter = null;
		try {
			flwriter = new FileWriter(Constants.RUTA_PRODUCTO);
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			for (int i = 0; i < arrayProducto.size(); i++) {
				bfwriter.write(arrayProducto.get(i).getCodigo()+ " , "+arrayProducto.get(i).getNombre()+ " , "+arrayProducto.get(i).getCategoria().getCodigo()+ " , "+
							arrayProducto.get(i).getCategoria().getDescripcion()+" , "+arrayProducto.get(i).getStock()+" , "+arrayProducto.get(i).getProveedor()+" , "+
							arrayProducto.get(i).getDescripcion()+" , "+arrayProducto.get(i).getPrecioDeCompra()+" , "+arrayProducto.get(i).getPrecioDeVenta()+"\n");
			}
			bfwriter.close();

		} catch (IOException error) {

		}
	}
	
	public static ArrayList<Producto> leerArchivoProducto() {
		File file = new File(Constants.RUTA_PRODUCTO);
		ArrayList<Producto> listaProductos= new ArrayList<Producto>();
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				Scanner delimitar = new Scanner(linea);
				delimitar.useDelimiter("\\s*,\\s*");
				Producto producto = new Producto(null,null,null,null,null,null,null);
				Categoria categoria=new Categoria(null, null);
				producto.setCodigo(Integer.valueOf(delimitar.next()));
				producto.setNombre(delimitar.next().toString());
				categoria.setCodigo(Integer.valueOf(delimitar.next()));
				categoria.setDescripcion(delimitar.next().toString());
				producto.setCategoria(categoria);
				producto.setStock(Integer.valueOf(delimitar.next()));
				producto.setProveedor(delimitar.next().toString());
				producto.setDescripcion(delimitar.next().toString());
				producto.setPrecioDeCompra(Double.valueOf(delimitar.next()));
				producto.setPrecioDeVenta(Double.valueOf(delimitar.next()));
				listaProductos.add(producto);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return listaProductos;
	}
	
	//************************************************************
	
	public static void crearArchivoCategoria(ArrayList<Categoria> arrayCategoria) {

		FileWriter flwriter = null;
		try {
			flwriter = new FileWriter(Constants.RUTA_CATEGORIA);
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			for (int i = 0; i < arrayCategoria.size(); i++) {
				bfwriter.write(arrayCategoria.get(i).getCodigo()+ " , "+arrayCategoria.get(i).getDescripcion()+"\n");
			}
			bfwriter.close();

		} catch (IOException error) {

		}
	}
	
	public static ArrayList<Categoria> leerArchivoCategoria() {
		File file = new File(Constants.RUTA_CATEGORIA);
		ArrayList<Categoria> listaCategoria= new ArrayList<Categoria>();
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				Scanner delimitar = new Scanner(linea);
				delimitar.useDelimiter("\\s*,\\s*");
				Categoria categoria = new Categoria(null, null);
				categoria.setCodigo(Integer.valueOf(delimitar.next()));
				categoria.setDescripcion(delimitar.next());
				listaCategoria.add(categoria);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return listaCategoria;
	}
	
	//************************************************************
	
	public static void crearArchivoPersonal(ArrayList<Personal> arrayPersonal) {

		FileWriter flwriter = null;
		try {
			flwriter = new FileWriter(Constants.RUTA_PERSONAL);
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			for (int i = 0; i < arrayPersonal.size(); i++) {
				String dateEnString=Utils.convertirDeDateAString(arrayPersonal.get(i).getFechaDeNacimiento());
				bfwriter.write(arrayPersonal.get(i).getCodigo()+ " , "+
						arrayPersonal.get(i).getDni()+ " , "+
						arrayPersonal.get(i).getTelefono()+" , "+
						arrayPersonal.get(i).getNombre()+" , "+
						arrayPersonal.get(i).getApellido()+" , "+
						arrayPersonal.get(i).getDireccion()+" , "+
						arrayPersonal.get(i).getTipoDeTelefono()+" , "+
						arrayPersonal.get(i).getEstado()+" , "+
						dateEnString+"\n");
			}
			bfwriter.close();

		} catch (IOException error) {

		}
	}
	
	public static ArrayList<Personal> leerArchivoPersonal() {
		File file = new File(Constants.RUTA_PERSONAL);
		ArrayList<Personal> listaPersonal= new ArrayList<Personal>();
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				Scanner delimitar = new Scanner(linea);
				delimitar.useDelimiter("\\s*,\\s*");
				Personal personal = new Personal(null, null,null,null,null,null,null,null,null);
				personal.setCodigo(Integer.valueOf(delimitar.next()));
				personal.setDni(Integer.valueOf(delimitar.next()));
				personal.setTelefono(Integer.valueOf(delimitar.next()));
				personal.setNombre(delimitar.next());
				personal.setApellido(delimitar.next());
				personal.setDireccion(delimitar.next());
				personal.setTipoDeTelefono(delimitar.next());
				personal.setEstado(delimitar.next());
				Date date=Utils.covertirDeStringADate(delimitar.next());
				personal.setFechaDeNacimiento(date);
				listaPersonal.add(personal);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return listaPersonal;
	}
		
	//************************************************************
	
	public static void crearArchivoAsignacion(ArrayList<Asignacion> arrayAsignacion) {

		FileWriter flwriter = null;
		try {
			flwriter = new FileWriter(Constants.RUTA_ASIGNACION);
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			for (int i = 0; i < arrayAsignacion.size(); i++) {
				bfwriter.write(arrayAsignacion.get(i).getCodUsuario()+ " , "+arrayAsignacion.get(i).getCodPersonal()+ " , "+arrayAsignacion.get(i).getEstado()+"\n");
			}
			bfwriter.close();

		} catch (IOException error) {

		}
	}
	
	public static ArrayList<Asignacion> leerArchivoAsignacion() {
		File file = new File(Constants.RUTA_ASIGNACION);
		ArrayList<Asignacion> listaAsignacion= new ArrayList<Asignacion>();
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				Scanner delimitar = new Scanner(linea);
				delimitar.useDelimiter("\\s*,\\s*");
				Asignacion asignacion = new Asignacion(null, null,null);
				asignacion.setCodUsuario(Integer.valueOf(delimitar.next()));
				asignacion.setCodPersonal(Integer.valueOf(delimitar.next()));
				asignacion.setEstado(delimitar.next());
				listaAsignacion.add(asignacion);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return listaAsignacion;
	}
	
	//************************************************************
	
	public static void crearArchivoConfigBoleta(ConfigBoleta configBoleta) {

		FileWriter flwriter = null;
		try {
			flwriter = new FileWriter(Constants.RUTA_NUMEROBOLETA);
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
				bfwriter.write(configBoleta.getSerie()+ " , "+configBoleta.getNumeracion()+"\n");
			bfwriter.close();
		} catch (IOException error) {

		}
	}
	
	
	public static ConfigBoleta leerArchivoConfigBoleta() {
		File file = new File(Constants.RUTA_NUMEROBOLETA);
		ConfigBoleta configBoleta= new ConfigBoleta(null);
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) { 
				String linea = scanner.nextLine();
				Scanner delimitar = new Scanner(linea);
				delimitar.useDelimiter("\\s*,\\s*");
				configBoleta.setSerie(delimitar.next());
				configBoleta.setNumeracion(delimitar.next());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return configBoleta;
	}
	
	//************************************************************	
	
	public static void crearArchivoProductosEnVenta(ArrayList<ProductoDeVenta> arrayProductosEnVenta) {

		FileWriter flwriter = null;
		try {
			flwriter = new FileWriter(Constants.RUTA_PRODUCTOSENVENTA);
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			for (int i = 0; i < arrayProductosEnVenta.size(); i++) {
				bfwriter.write(arrayProductosEnVenta.get(i)+ " , "+arrayProductosEnVenta.get(i)+"\n");
			}
			bfwriter.close();
		} catch (IOException error) {

		}
	}
	
	public static ArrayList<ProductoDeVenta> leerArchivoProductosEnVenta() {
		File file = new File(Constants.RUTA_PRODUCTOSENVENTA);
		ArrayList<ProductoDeVenta> listaProductosEnVenta= new ArrayList<ProductoDeVenta>();
		Scanner scanner;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) { 
				String linea = scanner.nextLine();
				Scanner delimitar = new Scanner(linea);
				delimitar.useDelimiter("\\s*,\\s*");
				ProductoDeVenta productosEnVenta = new ProductoDeVenta(null,null,null,null,null,null);
				productosEnVenta.setCantidad(Integer.valueOf(delimitar.next()));
				listaProductosEnVenta.add(productosEnVenta);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return listaProductosEnVenta;
	}
	
	//************************************************************	
	
	/*public static void crearArchivoComprobante(ArrayList<Comprobante> arrayComprobante) {

		FileWriter flwriter = null;
		try {
			flwriter = new FileWriter(Constants.RUTA_BOLETA);
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
			for (int i = 0; i < arrayComprobante.size(); i++) {
				String fechacomprobante=Utils.convertirDeDateAString(arrayComprobante.get(i).getFecha());
				String fechaNacimientoCliente=Utils.convertirDeDateAString(arrayComprobante.get(i).getCliente().getFechaDeNacimiento());
				String fechaNacimientoPersonal=Utils.convertirDeDateAString(arrayComprobante.get(i).getPersonal().getFechaDeNacimiento());
				ArrayList<ProductoDeVenta> listaProducto=arrayComprobante.get(i).getProductos();
				for (int j = 0; j < listaProducto.size(); j++) {
					bfwriter.write(fechacomprobante+ " , "+
							arrayComprobante.get(i).getCliente().getUsuario()+ " , "+
							arrayComprobante.get(i).getCliente().getClave()+ " , "+
							arrayComprobante.get(i).getCliente().getNombre()+ " , "+
							arrayComprobante.get(i).getCliente().getApellido()+ " , "+
							arrayComprobante.get(i).getCliente().getCorreo()+ " , "+
							fechaNacimientoCliente+ " , "+
							arrayComprobante.get(i).getCliente().getTipoDeTelefono()+ " , "+
							arrayComprobante.get(i).getCliente().getTelefono()+ " , "+
							arrayComprobante.get(i).getPersonal().getCodigo()+ " , "+
							arrayComprobante.get(i).getPersonal().getDni()+ " , "+
							arrayComprobante.get(i).getPersonal().getTelefono()+ " , "+
							arrayComprobante.get(i).getPersonal().getNombre()+ " , "+
							arrayComprobante.get(i).getPersonal().getApellido()+ " , "+
							arrayComprobante.get(i).getPersonal().getDireccion()+ " , "+
							arrayComprobante.get(i).getPersonal().getTipoDeTelefono()+ " , "+
							arrayComprobante.get(i).getPersonal().getEstado()+ " , "+
							fechaNacimientoPersonal+ " , "+
							arrayComprobante.get(i).getConfigBoleta().getSerie()+ " , "+
							arrayComprobante.get(i).getConfigBoleta().getNumeracion()+ " , "+
							arrayComprobante.get(i).getTipoDeComprobante()+ " , "+
							arrayComprobante.get(i).getTipoDePago()+ " , "+
							arrayComprobante.get(i).getNumeroDeCuotas()+ " , " +
							Utils.escribirProducto(listaProducto.get(j))+ " , "+
							arrayComprobante.get(i).getMontoTotal()+ " , "+
							arrayComprobante.get(i).getIgv()+ " , "+
							arrayComprobante.get(i).getTotalAPagar()+ " , "+
							arrayComprobante.get(i).getMontoPorCuota()+"\n");
				}
			}
			bfwriter.close();

		} catch (IOException error) {

		}
	}
	public static ArrayList<Comprobante> leerArchivoComprobante() {
		File file = new File(Constants.RUTA_BOLETA);
		ArrayList<Comprobante> listaComprobante = new ArrayList<Comprobante>();
		Scanner scanner;
		Integer numeracionAnterior = null;
		try {
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();
				Scanner delimitar = new Scanner(linea);
				delimitar.useDelimiter("\\s*,\\s*");
				ArrayList<ProductoDeVenta> listaProducto = new ArrayList<>();
				Cliente cliente = new Cliente(null, null, null, null, null, null, null, null);
				ProductoDeVenta producto = new ProductoDeVenta(null,null,null,null, null, null);
				Personal personal = new Personal(null, null, null, null, null, null,null, null, null);
				ConfigBoleta configBoleta = new ConfigBoleta(null);
				Categoria categoria = new Categoria(null, null);
				Comprobante comprobante = new Comprobante(null, null, null, null, null, null, null, null, null,null,null,null);
				Date fechaComprobante = Utils.covertirDeStringADate(delimitar.next());
				comprobante.setFecha(fechaComprobante);
				cliente.setUsuario(delimitar.next());
				cliente.setClave(delimitar.next());
				cliente.setNombre(delimitar.next());
				cliente.setApellido(delimitar.next());
				cliente.setCorreo(delimitar.next());
				Date fechaCliente = Utils.covertirDeStringADate(delimitar.next());
				cliente.setFechaDeNacimiento(fechaCliente);
				cliente.setTipoDeTelefono(delimitar.next());
				cliente.setTelefono(Integer.valueOf(delimitar.next()));
				comprobante.setCliente(cliente);
				personal.setCodigo(Integer.valueOf(delimitar.next()));
				personal.setDni(Integer.valueOf(delimitar.next()));
				personal.setTelefono(Integer.valueOf(delimitar.next()));
				personal.setNombre(delimitar.next());
				personal.setApellido(delimitar.next());
				personal.setDireccion(delimitar.next());
				personal.setTipoDeTelefono(delimitar.next());
				personal.setEstado(delimitar.next());
				Date fechaPersonal = Utils.covertirDeStringADate(delimitar.next());
				personal.setFechaDeNacimiento(fechaPersonal);
				comprobante.setPersonal(personal);
				configBoleta.setSerie(delimitar.next());
				configBoleta.setNumeracion(delimitar.next());
				comprobante.setConfigBoleta(configBoleta);
				comprobante.setTipoDeComprobante(delimitar.next());
				comprobante.setTipoDePago(delimitar.next());
				comprobante.setNumeroDeCuotas(Integer.valueOf(delimitar.next()));
				producto.setNombre(delimitar.next());
				producto.setPrecio(Double.valueOf(delimitar.next()));
				producto.setCantidad(Integer.valueOf(delimitar.next()));
				producto.setImporteTotal(Double.valueOf(delimitar.next()));
				listaProducto.add(producto);
				comprobante.setProductos(listaProducto);
				comprobante.setMontoTotal(Double.valueOf(delimitar.next()));
				comprobante.setIgv(Double.valueOf(delimitar.next()));
				comprobante.setTotalAPagar(Double.valueOf(delimitar.next()));
				comprobante.setMontoPorCuota(Double.valueOf(delimitar.next()));
				Integer numeracion = Integer.valueOf(comprobante.getConfigBoleta().getNumeracion());
				if (numeracionAnterior == null) {
					numeracionAnterior = numeracion;
					listaComprobante.add(comprobante);
				} else {
					if (numeracionAnterior == numeracion) {
						for (int i = 0; i < listaComprobante.size(); i++) {
							Integer numeracionBoleta =Integer.valueOf(listaComprobante.get(i).getConfigBoleta().getNumeracion());
							if (numeracionAnterior == numeracionBoleta) {
								listaComprobante.get(i).setProductos(listaProducto);
							}
						}
					} else {
						listaComprobante.add(comprobante);
					}
				}
			}
			scanner.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		return listaComprobante;
	}*/
}
