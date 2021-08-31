package paqueteTurismoEnLaTierraMedia;

public class PromoAxB extends Promocion {
	//public String atraccionGratis;
	
	public PromoAxB(String tipoPromo, String tipoAtraccion, String atraccion1, String atraccion2, String oferta) {
		super(tipoPromo, tipoAtraccion, atraccion1, atraccion2);
		setAtraccionGratis(oferta);
		}

	public String getAtraccionGratis() {
		return super.atraccionGratis;
	}

	public void setAtraccionGratis(String atraccionGratis) {
		super.atraccionGratis = atraccionGratis;
	}

}
