package paqueteTurismoEnLaTierraMedia;

public abstract class Promocion {

	private String tipoAtraccion;
	private String tipoPromo;

	private int costo;
	private String[] atraccionesGratis;

	private String[] atraccionesDeLaPromo;

	public Promocion(String tipoPromo, String tipoAtraccion, String[] atraccionesPromo) {
		// String auxiliar = atraccionesPomocionadas.;

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

	
	public int getCosto() {
		return this.costo;
	}

	
	public void setCosto(int costo) {
		this.costo = costo;
	}

	
	protected abstract int getDescuento();

}
