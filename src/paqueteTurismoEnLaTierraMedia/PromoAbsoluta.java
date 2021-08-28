package paqueteTurismoEnLaTierraMedia;

public class PromoAbsoluta extends Promocion {
	private int costo;
	
	public PromoAbsoluta(String tipoPromo, String tipoAtraccion, String atraccion1, String atraccion2, int oferta) {
		super(tipoPromo,tipoAtraccion, atraccion1, atraccion2);
		setCosto(oferta);
		
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = oferta;
	}

	
}
