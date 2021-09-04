package paqueteTurismoEnLaTierraMedia;

public class Usuario {
	private String nombre;
	private double presupuesto;
	private double tiempo;
	private String atraccionPreferida;
	private double saldo;
	private Itinerario itinerario;
	

	

	public Usuario(String nombre, double presupuesto, double tiempo, String atraccionPreferida) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempo = tiempo;
		this.atraccionPreferida = atraccionPreferida;
		this.setSaldo(0);
		
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	private void setSaldo(double unSaldoInicial) {
		this.saldo = unSaldoInicial;
	}

	public Itinerario getItinerario() {
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
