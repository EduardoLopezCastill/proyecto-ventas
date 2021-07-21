package projectVentasClases;

public class ProductoDeVenta {
	private Integer codigo;
	private String nombre;
	private Double precio;
	private String descripcion;
	private Integer cantidad;
	private Double importeTotal;

	public ProductoDeVenta(Integer codigo,String nombre, Double precio,String descripcion, Integer cantidad, Double importeTotal) {
		this.codigo=codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.cantidad = cantidad;
		this.importeTotal = importeTotal;
	}
	
	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return this.precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getImporteTotal() {
		return this.importeTotal;
	}

	public void setImporteTotal(Double importeTotal) {
		this.importeTotal = importeTotal;
	}

	@Override
	public String toString() {
		return "ProductoDeVenta [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", descripcion="
				+ descripcion + ", cantidad=" + cantidad + ", importeTotal=" + importeTotal + "]";
	}
	
	
}
