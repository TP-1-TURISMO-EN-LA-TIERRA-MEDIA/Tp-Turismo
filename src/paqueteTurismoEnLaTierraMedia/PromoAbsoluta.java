package paqueteTurismoEnLaTierraMedia;

public class PromoAbsoluta extends Promocion {
	
	
	public PromoAbsoluta(String tipoPromo, String tipoAtraccion, String[] atraccionesPromo /*String atraccion1, String atraccion2*/, int oferta) {
		super(tipoPromo,tipoAtraccion, atraccionesPromo/*traccion1, atraccion2*/);
		setCosto(oferta);
		
	}

	public int getCosto() {
		return super.costo;
	}

	public void setCosto(int costo) {
		super.costo = costo;
	}

	@Override
	protected int getDescuento() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
