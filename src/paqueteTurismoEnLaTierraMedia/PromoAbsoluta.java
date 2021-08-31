package paqueteTurismoEnLaTierraMedia;

public class PromoAbsoluta extends Promocion {
	
	
	public PromoAbsoluta(String tipoPromo, String tipoAtraccion, String atraccion1, String atraccion2, int oferta) {
		super(tipoPromo,tipoAtraccion, atraccion1, atraccion2);
		setCosto(oferta);
		
	}

	public double getCosto() {
		return super.oferta;
	}

	public void setCosto(int oferta) {
		super.oferta = oferta;
	}

	
}
