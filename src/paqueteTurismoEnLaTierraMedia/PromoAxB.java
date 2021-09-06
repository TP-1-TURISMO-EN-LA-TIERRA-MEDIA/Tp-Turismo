package paqueteTurismoEnLaTierraMedia;

public class PromoAxB extends Promocion {
	// public String atraccionGratis;

	public PromoAxB(String tipoPromo, String tipoAtraccion, String[] atraccionesPromo, String[] atraccionesGratis) {
		super(tipoPromo, tipoAtraccion, atraccionesPromo);
		setAtraccionGratis(atraccionesGratis);
	}

	public String[] getAtraccionesGratis() {
		return super.getAtraccionesGratis();
	}

	public void setAtraccionGratis(String[] atraccionGratis) {
		super.setAtraccionesGratis(atraccionGratis); 
	}

	@Override
	protected int getDescuento() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compareTo(Promocion o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
