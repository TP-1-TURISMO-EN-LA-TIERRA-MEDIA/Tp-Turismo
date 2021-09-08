package paqueteTurismoEnLaTierraMedia;

import java.util.Comparator;

public class comparadorPorMayorCosto implements Comparator<Promocion> {

	@Override
	public int compare(Promocion promo1, Promocion promo2) {
		return -Double.compare(promo1.getCosto(), promo2.getCosto());
	}

}

//Comparator<Persona> comparador =  new Comparator<Persona>() {
//    public int compare( Persona a, Persona b ) {
//        int resultado = Integer.compare( a.edad(), b.edad());
//        if ( resultado != 0 ) { return resultado; }
//       
//        //resultado = comparaPrioridad( a.prioridad(), b.prioridad() );
//        //if ( resultado != 0 ) { return resultado; }
//       
//        resultado = a.pais().compareTo(b.pais());
//        if ( resultado != 0 ) { return resultado; }
//       
//        resultado = a.ciudad().compareTo(b.ciudad());
//        if ( resultado != 0 ) { return resultado; }
//       
//        resultado = a.nombre().compareTo(b.nombre());
//        return resultado;
//    }