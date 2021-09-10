package paqueteTurismoEnLaTierraMedia;

import java.util.Comparator;

public class comparadorPorMayorCosto implements Comparator<Promocion> {

//	@Override
//	public int compare(Promocion promo1, Promocion promo2) {
//		return -Double.compare(promo1.getCosto(), promo2.getCosto());
//	}

	@Override
	public int compare(Promocion promo1, Promocion promo2) {
		int diferenciaCosto = (int) -(promo1.getCosto()-promo2.getCosto());
		if (diferenciaCosto!= 0) {
			return diferenciaCosto > 0 ? 1: (diferenciaCosto<0 ?-1:0);
		}
		int diferenciaTiempo = -(promo1.getTiempoPromo()-promo2.getTiempoPromo());
		if (diferenciaTiempo!= 0) {
			return diferenciaTiempo > 0 ? 1: (diferenciaTiempo<0 ?-1:0);
		}
		return diferenciaTiempo;
	}
}


