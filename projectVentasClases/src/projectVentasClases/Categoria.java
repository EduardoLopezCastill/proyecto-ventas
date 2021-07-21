package projectVentasClases;

public class Categoria {
	
	private Integer codigo;
	private String descripcion;
	
	public Categoria(Integer codigo,String descripcion) {
		this.codigo=codigo;
		this.descripcion=descripcion;
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Categoria [codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}
	
	
}
