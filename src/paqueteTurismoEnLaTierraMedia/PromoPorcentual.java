package paqueteTurismoEnLaTierraMedia;

public class PromoPorcentual extends Promocion {
	private int descuento;
	
	public PromoPorcentual(String tipoPromo, String tipoAtraccion, String atraccion1, String atraccion2, int oferta) {
		
		super(tipoPromo, tipoAtraccion, atraccion1, atraccion2);
		this.setDescuento(oferta);
		
	}

	
	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		//super.costo= descuento;
		this.descuento = descuento;
	}

	
		
		public void setCosto(int costoTotal) {
			super.costo = costoTotal;
		}
		
		
}
