package paqueteTurismoEnLaTierraMedia;

public abstract class Promocion {
	
	public String tipoAtraccion;
	public String atraccion1;
	public String atraccion2;
	public String tipoPromo;
	public int costo;
	public String atraccionGratis;
	private Atraccion[] atraccionesDeLaPromo;
		
	public Promocion(String tipoPromo, String tipoAtraccion, String atraccion1, String atraccion2) {
		//String auxiliar = atraccionesPomocionadas.;
		
		this.tipoPromo = tipoPromo;
		this.tipoAtraccion = tipoAtraccion;
		this.atraccion1 = atraccion1;
		this.atraccion2 = atraccion2;
		
		
		
	}



	public int getCosto() {
		return this.costo;
	}



	public void setCosto(int costo) {
		this.costo = costo;
	}



	protected abstract int getDescuento();
	
	
}
