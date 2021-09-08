package paqueteTurismoEnLaTierraMedia;

import java.util.Comparator;

public class comparadorPorMayorCosto implements Comparator<Promocion> {

	@Override
	public int compare(Promocion promo1, Promocion promo2) {
	
		return -Double.compare(promo1.getCosto(), promo2.getCosto());
	}

}
