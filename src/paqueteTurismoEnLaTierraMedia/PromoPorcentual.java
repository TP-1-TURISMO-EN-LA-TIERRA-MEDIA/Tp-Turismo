package paqueteTurismoEnLaTierraMedia;

public class PromoPorcentual extends Promocion {
	private int descuento;
	
	public PromoPorcentual(String tipoPromo, String tipoAtraccion, String[] atraccionesPromo, int descuento) {
		
		super(tipoPromo, tipoAtraccion, atraccionesPromo);
		this.setDescuento(descuento);
		
	}

	
	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	
		
		public void setCosto(int costoTotal) {
			
			super.setCosto(costoTotal);
		}


		@Override
		public int compareTo(Promocion o) {
			// TODO Auto-generated method stub
			return 0;
		}
		
		
}
