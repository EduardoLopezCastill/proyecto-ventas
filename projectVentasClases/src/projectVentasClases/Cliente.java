package projectVentasClases;

import java.util.Date;

public class Cliente {
	private String usuario;
	private String clave;
	private String nombre;
	private String apellido;
	private String correo;
	private Date fechaDeNacimiento;
	private String tipoDeTelefono;
	private Integer telefono;

	public Cliente(String usuario, String clave, String nombre, String apellido, String correo, Date fechaDeNacimiento,
			String tipoDeTelefono, Integer telefono) {
		this.usuario = usuario;
		this.clave = clave;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.tipoDeTelefono = tipoDeTelefono;
		this.telefono = telefono;
	}

	public String getUsuario() {
		return this.usuario;
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getFechaDeNacimiento() {
		return this.fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getTipoDeTelefono() {
		return this.tipoDeTelefono;
	}

	public void setTipoDeTelefono(String tipoDeTelefono) {
		this.tipoDeTelefono = tipoDeTelefono;
	}

	public Integer getTelefono() {
		return this.telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Cliente [usuario=" + usuario + ", clave=" + clave + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", correo=" + correo + ", fechaDeNacimiento=" + fechaDeNacimiento + ", tipoDeTelefono="
				+ tipoDeTelefono + ", telefono=" + telefono + "]";
	}

}
