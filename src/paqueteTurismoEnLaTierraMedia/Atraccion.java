package paqueteTurismoEnLaTierraMedia;

public class Atraccion {

	public String nombre;
	public double costo;
	public double tiempo;
	public int cupo;
	public String tipo;

	public Atraccion(String nombre, double costo, double tiempo, int cupo, String tipo) {
		this.nombre = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.tipo = tipo;
	}

}
