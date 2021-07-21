package projectVentasClases;

public class ConfigBoleta {

	private String serie;
	private String numeracion;

	public ConfigBoleta(String numeracion) {
		this.serie="B001";
		this.numeracion=numeracion;
	}

	public String getSerie() {
		return this.serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getNumeracion() {
		return this.numeracion;
	}

	public void setNumeracion(String numeracion) {
		this.numeracion = numeracion;
	}

	@Override
	public String toString() {
		return serie+" - "+ numeracion;
	}

	
}
