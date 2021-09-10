package paqueteTurismoEnLaTierraMedia;

public class Atraccion implements Comparable <Atraccion>{

	private String nombre;
	private double costo;
	private double tiempo;
	private int cupo;
	private String tipo;

	public Atraccion(String nombre, double costo, double tiempo, int cupo, String tipo) {
		this.nombre = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public double getTiempo() {
		return tiempo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	public int getCupo() {
		return cupo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public int compareTo(Atraccion o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
