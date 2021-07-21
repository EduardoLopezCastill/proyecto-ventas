package projectVentasUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import projectVentasClases.Comprobante;
import projectVentasClases.ProductoDeVenta;

public class ConexionBd {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection con = null;

		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_edu?characterEncoding=utf8", "root",
				"12345678");

		return con;
	}

	public static ArrayList<Comprobante> leerBoleta() throws SQLException {
		ArrayList<Comprobante> listaComprobantes = new ArrayList<>();
		Comprobante comprobante=null;
		try {
			Connection con = ConexionBd.getConnection();
			PreparedStatement pstm = con.prepareStatement("SELECT fecha,nombreCliente,nombrePersonal,codigo,tipoDeComprobante,"
					+ "tipoDePago,numeroDeCuotas, montoTotal, igv ,totalAPagar,montoPorCuota FROM BOLETA");

			ResultSet rst = pstm.executeQuery();

			while (rst.next()) {
				 comprobante=new Comprobante(null,null,null,null,null,null,null,null,null,null,null,null);
				comprobante.setFecha(Utils.covertirDeStringADate(rst.getString("fecha")));
				comprobante.setNombreCliente(rst.getString("nombreCliente"));
				comprobante.setNombrePersonal(rst.getString("nombrePersonal"));
				comprobante.setConfigBoleta(rst.getString("codigo"));
				comprobante.setTipoDeComprobante(rst.getString("tipoDeComprobante"));
				comprobante.setTipoDePago(rst.getString("tipoDePago"));
				comprobante.setNumeroDeCuotas(rst.getInt("numeroDeCuotas"));
				comprobante.setProductos(LeerProductos(rst.getString("codigo")));
				comprobante.setMontoTotal(rst.getDouble("montoTotal"));
				comprobante.setIgv(rst.getDouble("igv"));
				comprobante.setTotalAPagar(rst.getDouble("totalAPagar"));
				comprobante.setMontoPorCuota(rst.getDouble("montoPorCuota"));
				listaComprobantes.add(comprobante);
			}
			pstm.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaComprobantes;
	}

	public static ArrayList<ProductoDeVenta>  LeerProductos(String codigo) throws SQLException{
		ArrayList<ProductoDeVenta> listaProductosSeleccionados = new ArrayList<>();
		try {
			Connection con = ConexionBd.getConnection();
			PreparedStatement pstm = con.prepareStatement("SELECT codigoBoleta, idProducto,nombreProducto , descripcion,precio,cantidad,subtotal  FROM DETALLA_BOLETA"); 

			ResultSet rst = pstm.executeQuery();

			while (rst.next()) {
				if(codigo.equalsIgnoreCase(rst.getString("codigoBoleta"))) {
					Integer codigoProducto=rst.getInt("idProducto");
					String nombre=rst.getString("nombreProducto");
					String descripcion=rst.getString("descripcion");
					Double precio=rst.getDouble("precio");
					Integer cantidad=rst.getInt("cantidad");
					Double importeTotal=rst.getDouble("subtotal");
					ProductoDeVenta producto=new ProductoDeVenta(codigoProducto,nombre,precio,descripcion,cantidad,importeTotal);
					listaProductosSeleccionados.add(producto);
				}
			}
			pstm.close();
			con.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return listaProductosSeleccionados;
	}
	
	
	public static void insertarBoleta(String fecha,String nombreCliente,String nombrePersonal,String codigoBoleta,String tipoDeComprobanmte,String tipoDePago,Integer numeroCuotas,
			Double montoTotal,Double igv,Double totalAPagar,Double montoPorCuota) {
    	 try{
             Connection conexion = getConnection();
             
             Statement st = conexion.createStatement();
             String sql = "INSERT INTO BOLETA (fecha,nombreCliente,nombrePersonal,codigo,tipoDeComprobante,tipoDePago,numeroDeCuotas, montoTotal, igv ,totalAPagar,montoPorCuota) "
             		+ "VALUES(\""+fecha+"\" ,"+"\""+nombreCliente+"\" ,"+"\""+nombrePersonal+"\" ,"+" \""+codigoBoleta+"\" ,"+"\""+tipoDeComprobanmte+"\" ,"+"\""+tipoDePago+"\" ,"
            		 +numeroCuotas+","+ montoTotal+","+ igv+","+totalAPagar+","+montoPorCuota+")";
             st.execute(sql);
             conexion.close();
             st.close();

         }catch(Exception ex){
        	 ex.printStackTrace();
         }
    }

	public static void insertarDetallaBoleta(ArrayList<ProductoDeVenta>listaProductos,String codigoBoleta) {
			String sql="";
		 try{
             Connection conexion = getConnection();
             
             Statement st = conexion.createStatement();
             for(ProductoDeVenta producto:listaProductos) {
            	 Integer idProducto=producto.getCodigo();
            	 String nombre=producto.getNombre();
            	 String descripcion=producto.getDescripcion();
            	 Double precio=producto.getPrecio();
            	 Integer cantidad=producto.getCantidad();
            	 Double subtotal=producto.getImporteTotal();
            	 sql = "INSERT INTO DETALLA_BOLETA (codigoBoleta, idProducto,nombreProducto, descripcion,precio,cantidad,subtotal) "
            	 		+ "VALUES( \""+codigoBoleta+"\" ,"+ idProducto+", \""+nombre+"\" ,"+"\""+descripcion+"\" , "+precio+","+cantidad+","+subtotal+")";
            	 st.execute(sql);
             }
             conexion.close();
             st.close();

         }catch(Exception ex){
        	 ex.printStackTrace();
         }
	}
	
	
	public static void main(String[] args) throws SQLException {
		System.out.println("hola mundo ");
	}

}
