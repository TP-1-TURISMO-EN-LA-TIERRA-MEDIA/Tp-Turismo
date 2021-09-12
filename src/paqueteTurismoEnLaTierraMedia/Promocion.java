package paqueteTurismoEnLaTierraMedia;

public abstract class Promocion implements Comparable <Promocion>{

	private String tipoAtraccion;
	private String tipoPromo;

	private double costo;
	private String[] atraccionesGratis;

	private String[] atraccionesDeLaPromo;
	private int tiempoPromo;
	

	public Promocion(String tipoPromo, String tipoAtraccion, String[] atraccionesPromo) {
		this.tipoPromo = tipoPromo;
		this.tipoAtraccion = tipoAtraccion;
		atraccionesDeLaPromo = atraccionesPromo;
	}


	
	public String[] getAtraccionesDeLaPromo() {
		return atraccionesDeLaPromo;
	}

	
	public String getTipoAtraccion() {
		return tipoAtraccion;
	}


	public int getTiempoPromo() {
		return tiempoPromo;
	}



	public void setTiempoPromo(int tiempoPromo) {
		this.tiempoPromo = tiempoPromo;
	}



	public void setTipoAtraccion(String tipoAtraccion) {
		this.tipoAtraccion = tipoAtraccion;
	}


	public String getTipoPromo() {
		return tipoPromo;
	}


	public void setTipoPromo(String tipoPromo) {
		this.tipoPromo = tipoPromo;
	}


	public String[] getAtraccionesGratis() {
		return atraccionesGratis;
	}

	
	public void setAtraccionesGratis(String[] atraccionesGratis) {
		this.atraccionesGratis = atraccionesGratis;
	}

	
	public void setAtraccionesDeLaPromo(String[] atraccionesDeLaPromo) {
		this.atraccionesDeLaPromo = atraccionesDeLaPromo;
	}

	
	public double getCosto() {
		return this.costo;
	}

	
	public void setCosto(double costo) {
		this.costo = costo;
	}

	
	protected abstract int getDescuento();


	
}
