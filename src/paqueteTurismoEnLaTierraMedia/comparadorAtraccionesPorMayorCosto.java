package paqueteTurismoEnLaTierraMedia;

import java.util.Comparator;

public class comparadorAtraccionesPorMayorCosto implements Comparator {

	public int compare(Atraccion atraccion1, Atraccion atraccion2) {
		int diferenciaCosto = (int) -(atraccion1.getCosto()-atraccion2.getCosto());
		if (diferenciaCosto!= 0) {
			return diferenciaCosto > 0 ? 1: (diferenciaCosto<0 ?-1:0);
		}
		int diferenciaTiempo = (int) -(atraccion1.getTiempo()-atraccion2.getTiempo());
		if (diferenciaTiempo!= 0) {
			return diferenciaTiempo > 0 ? 1: (diferenciaTiempo<0 ?-1:0);
		}
		return diferenciaTiempo;
	
	}

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
