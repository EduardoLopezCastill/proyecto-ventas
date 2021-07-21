package projectVentasClases;

public class Asignacion {
	private Integer codUsuario;
	private Integer codPersonal;
	private String estado;

	public Asignacion(Integer codUsuario,Integer codPersonal,String estado) {
		this.codUsuario=codUsuario;
		this.codPersonal=codPersonal;
		this.estado=estado;
	}

	public Integer getCodUsuario() {
		return this.codUsuario;
	}

	public void setCodUsuario(Integer codUsuario) {
		this.codUsuario = codUsuario;
	}

	public Integer getCodPersonal() {
		return this.codPersonal;
	}

	public void setCodPersonal(Integer codPersonal) {
		this.codPersonal = codPersonal;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
