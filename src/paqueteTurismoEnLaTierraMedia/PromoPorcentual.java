package paqueteTurismoEnLaTierraMedia;

public class PromoPorcentual extends Promocion {
	private int descuento;
	
	public PromoPorcentual(String tipoPromo, String tipoAtraccion, String[] atraccionesPromo, int oferta) {
		
		super(tipoPromo, tipoAtraccion, atraccionesPromo);
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
