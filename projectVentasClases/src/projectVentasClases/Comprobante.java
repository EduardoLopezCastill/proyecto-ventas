package projectVentasClases;

import java.util.ArrayList;
import java.util.Date;

public class Comprobante {
	
	private Date fecha;
	private String nombreCliente;
	private String nombrePersonal;
	private String configBoleta;
	private String tipoDeComprobante;
	private String tipoDePago;
	private Integer numeroDeCuotas;
	private Double montoPorCuota;
	private ArrayList<ProductoDeVenta> productos;
	private Double montoTotal;
	private Double igv;
	private Double totalAPagar;

	public Comprobante(Date fecha,String nombreCliente,String nombrePersonal,String configBoleta,
			String tipoDeComprobante,String tipoDePago,Integer numeroDeCuotas,ArrayList<ProductoDeVenta>productos,Double montoTotal,Double igv,Double totalAPagar, Double montoPorCuota) {		
		
		this.fecha=fecha;
		this.nombreCliente=nombreCliente;
		this.nombrePersonal=nombrePersonal;
		this.configBoleta=configBoleta;
		this.tipoDeComprobante=tipoDeComprobante;
		this.tipoDePago=tipoDePago;
		this.numeroDeCuotas=numeroDeCuotas;
		this.productos=productos;
		this.montoTotal=montoTotal;		
		this.igv=igv;
		this.totalAPagar=totalAPagar;
		this.montoPorCuota=montoPorCuota;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNombreCliente() {
		return this.nombreCliente;
	}
	
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	
	public String getNombrePersonal() {
		return this.nombrePersonal;
	}
	
	public void setNombrePersonal(String nombrePersonal) {
		this.nombrePersonal = nombrePersonal;
	}
	
	public String getTipoDeComprobante() {
		return tipoDeComprobante;
	}

	public void setTipoDeComprobante(String tipoDeComprobante) {
		this.tipoDeComprobante = tipoDeComprobante;
	}

	public String getTipoDePago() {
		return tipoDePago;
	}

	public void setTipoDePago(String tipoDePago) {
		this.tipoDePago = tipoDePago;
	}

	public Integer getNumeroDeCuotas() {
		return this.numeroDeCuotas;
	}

	public void setNumeroDeCuotas(Integer numeroDeCuotas) {
		this.numeroDeCuotas = numeroDeCuotas;
	}

	public ArrayList<ProductoDeVenta> getProductos() {
		return this.productos;
	}

	public void setProductos(ArrayList<ProductoDeVenta> productos) {
		this.productos = productos;
	}

	public Double getMontoTotal() {
		return this.montoTotal;
	}

	public void setMontoTotal(Double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public Double getIgv() {
		return this.igv;
	}

	public void setIgv(Double igv) {
		this.igv = igv;
	}

	public Double getTotalAPagar() {
		return this.totalAPagar;
	}

	public void setTotalAPagar(Double totalAPagar) {
		this.totalAPagar = totalAPagar;
	}

	public Double getMontoPorCuota() {
		return this.montoPorCuota;
	}

	public void setMontoPorCuota(Double montoPorCuota) {
		this.montoPorCuota = montoPorCuota;
	}

	public String getConfigBoleta() {
		return this.configBoleta;
	}

	public void setConfigBoleta(String configBoleta) {
		this.configBoleta = configBoleta;
	}

	@Override
	public String toString() {
		return "Comprobante [fecha=" + fecha + ", nombreCliente=" + nombreCliente + ", nombrePersonal=" + nombrePersonal
				+ ", configBoleta=" + configBoleta + ", tipoDeComprobante=" + tipoDeComprobante + ", tipoDePago="
				+ tipoDePago + ", numeroDeCuotas=" + numeroDeCuotas + ", productos=" + productos + ", montoTotal="
				+ montoTotal + ", igv=" + igv + ", totalAPagar=" + totalAPagar + ", montoPorCuota=" + montoPorCuota
				+ "]";
	}
	
		
	
}
