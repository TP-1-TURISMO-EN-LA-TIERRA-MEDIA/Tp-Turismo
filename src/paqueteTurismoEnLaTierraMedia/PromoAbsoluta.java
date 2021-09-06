package paqueteTurismoEnLaTierraMedia;

public class PromoAbsoluta extends Promocion {
	
	
	public PromoAbsoluta(String tipoPromo, String tipoAtraccion, String[] atraccionesPromo , int oferta) {
		super(tipoPromo,tipoAtraccion, atraccionesPromo/*traccion1, atraccion2*/);
		setCosto(oferta);
		
	}

	public int getCosto() {
		return super.getCosto();
	}

	public void setCosto(int costo) {
		super.setCosto(costo);
	}

	@Override
	protected int getDescuento() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void mostrarPromoEnPantalla() {
		System.out.print("Pack " + super.getTipoAtraccion() + ":" );
		for (int i = 0; i < super.getAtraccionesDeLaPromo().length; i++) {
			System.out.print(super.getAtraccionesDeLaPromo()[i].toString() + " ");							
		}
		System.out.println(super.getCosto() + " si se compran juntas");
		System.out.println(super.getCosto() + "             " /* + super.getTiempoPromo()*/);
		
	}

	@Override
	public int compareTo(Promocion o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
