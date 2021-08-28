package paqueteTurismoEnLaTierraMedia;

public abstract class Promocion {
	
	public String tipoAtraccion;
	public String atraccion1;
	public String atraccion2;
	public String tipoPromo;
	public int oferta;
		
	public Promocion(String tipoPromo, String tipoAtraccion, String atraccion1, String atraccion2) {
		this.tipoPromo = tipoPromo;
		this.tipoAtraccion = tipoAtraccion;
		this.atraccion1 = atraccion1;
		this.atraccion2 = atraccion2;
		
		
	}
	
	
}
