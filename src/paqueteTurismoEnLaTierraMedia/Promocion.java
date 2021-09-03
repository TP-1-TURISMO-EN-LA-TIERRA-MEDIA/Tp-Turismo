package paqueteTurismoEnLaTierraMedia;

public abstract class Promocion {
	
	public String tipoAtraccion;
	public String tipoPromo;

	public int costo;
	private String[] atraccionesGratis;
	



	private String[] atraccionesDeLaPromo;
		
	public Promocion(String tipoPromo, String tipoAtraccion,  String[] atraccionesPromo) {
		//String auxiliar = atraccionesPomocionadas.;
		
		this.tipoPromo = tipoPromo;
		this.tipoAtraccion = tipoAtraccion;
		atraccionesDeLaPromo= atraccionesPromo;
		
		
		
	}
	public String[] getAtraccionesDeLaPromo() {
		return atraccionesDeLaPromo;
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
