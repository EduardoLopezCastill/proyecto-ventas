package projectVentasClases;

public class Usuarios {
	private Integer codigo;
	private String usuario;
	private String clave;
	private String estado;
	
	public Usuarios(Integer codigo,String usuario,String clave,String estado) {
		this.codigo=codigo;
		this.usuario=usuario;
		this.clave=clave;
		this.estado=estado;
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


		
}
