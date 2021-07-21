package projectVentasClases;

import java.util.Date;

public class Personal {
	private Integer codigo;
	private Integer dni;
	private Integer telefono;
	private String nombre;
	private String apellido;
	private String direccion;
	private String tipoDeTelefono;
	private String estado;
	private Date fechaDeNacimiento;

	public Personal(Integer codigo,Integer dni,Integer telefono,String nombre,String apellido,String direccion,String tipoDeTelefono,String estado,Date fechaDeNacimiento) {
		this.codigo=codigo;
		this.dni=dni;
		this.telefono=telefono;
		this.nombre=nombre;
		this.apellido=apellido;
		this.direccion=direccion;
		this.tipoDeTelefono=tipoDeTelefono;
		this.estado=estado;
		this.fechaDeNacimiento=fechaDeNacimiento;
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getDni() {
		return this.dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public Integer getTelefono() {
		return this.telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
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

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getTipoDeTelefono() {
		return this.tipoDeTelefono;
	}

	public void setTipoDeTelefono(String tipoDeTelefono) {
		this.tipoDeTelefono = tipoDeTelefono;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaDeNacimiento() {
		return this.fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	@Override
	public String toString() {
		return "Personal [codigo=" + codigo + ", dni=" + dni + ", telefono=" + telefono + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", direccion=" + direccion + ", tipoDeTelefono=" + tipoDeTelefono
				+ ", estado=" + estado + ", fechaDeNacimiento=" + fechaDeNacimiento + "]";
	}
	
	
}
