package paqueteTurismoEnLaTierraMedia;

public class Usuario {
	public String nombre;
	public double presupuesto;
	public double tiempo;
	public String atraccionPreferida;
	public double saldo;
	

	

	public Usuario(String nombre, double presupuesto, double tiempo, String atraccionPreferida) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempo = tiempo;
		this.atraccionPreferida = atraccionPreferida;
		this.setSaldo(0);

	}

	private void setSaldo(double unSaldoInicial) {
		this.saldo = unSaldoInicial;
	}

}
