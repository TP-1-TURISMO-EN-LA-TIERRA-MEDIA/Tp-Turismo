package paqueteTurismoEnLaTierraMedia;

public class Usuario {
	private String nombre;
	private double presupuesto;
	private double tiempo;
	private String atraccionPreferida;
	private double saldo;
	private Atraccion[] itinerario;
	private int contadorItinerario = 0;

	public Usuario(String nombre, double presupuesto, double tiempo, String atraccionPreferida) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempo = tiempo;
		this.atraccionPreferida = atraccionPreferida;
		this.saldo = presupuesto;
		itinerario = new Atraccion[50];

	}

	public void generarArchivoItinerario() {
		
	}
	
	
	public void mostrarItinerario() {
		System.out.println("El itinerario del usuario es el siguiente: ");
		for (int i =0; i < contadorItinerario; i++) {
			System.out.println(this.getItinerario()[i].getNombre());
		}
	}
	
	public void addAtraccionAlItinerario(Atraccion unaAtraccion) {
		this.itinerario[contadorItinerario]=unaAtraccion;
		contadorItinerario++;
		
	}

	public Atraccion[] getItinerario() {
		return itinerario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPresupuesto() {
		return presupuesto;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}

	public double getTiempo() {
		return tiempo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	public String getAtraccionPreferida() {
		return atraccionPreferida;
	}

	public void setAtraccionPreferida(String atraccionPreferida) {
		this.atraccionPreferida = atraccionPreferida;
	}

}
