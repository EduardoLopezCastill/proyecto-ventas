package projectVentasClases;

public class Producto {
	
	private Integer codigo;
	private String nombre;
	private Categoria categoria;
	private Integer stock;
	private String proveedor;
	private String descripcion;
	private Double precioDeCompra;
	private Double precioDeVenta;
	
	public Producto(Integer codigo,String nombre,Categoria categoria,Integer stock,String proveedor,String descripcion, Double precioDeCompra) {
		this.codigo=codigo;
		this.nombre=nombre;
		this.categoria=categoria;
		this.stock=stock;
		this.proveedor=proveedor;
		this.descripcion=descripcion;
		this.precioDeCompra=precioDeCompra;
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

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Integer getStock() {
		return this.stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecioDeCompra() {
		return this.precioDeCompra;
	}

	public void setPrecioDeCompra(Double precioDeCompra) {
		this.precioDeCompra = precioDeCompra;
	}

	public Double getPrecioDeVenta() {
		Double precioDeVenta=(this.precioDeCompra*0.08)+this.precioDeCompra;
		return precioDeVenta;
	}

	public void setPrecioDeVenta(Double precioDeVenta) {
		this.precioDeVenta = precioDeVenta;
	}
	
	
}
