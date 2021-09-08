package paqueteTurismoEnLaTierraMedia;

import java.util.Arrays;

public class Ofertas {

	final int MAXIMO_OFERTAS = 30;
	Promocion[] sugeridas = new Promocion[MAXIMO_OFERTAS];
	private int contadorSugeridas = 0;

	
	public Ofertas(Usuario usuario, Atracciones atraccionesParque, Promociones promocionesParque) {
		
		double costoPromo = 0;
		// buscar las promos que tengan el tipo preferido del usuario las guarda en sugeridas

		for (int i = 0; i < promocionesParque.getPromociones().length; i++) {
			if (promocionesParque.getPromociones()[i].getTipoAtraccion().equals(usuario.getAtraccionPreferida())) {
				this.sugeridas[contadorSugeridas] = promocionesParque.getPromociones()[i];
				costoPromo=  this.sugeridas[contadorSugeridas].getCosto();				
				contadorSugeridas++;
			}
		}
		this.ordenarPorMayorCosto();

		System.out.println("Promociones sugeridas: " + contadorSugeridas + " ");
		for (int i = 0; i < contadorSugeridas; i++) {
			System.out.print(i + 1 + ") ");
			this.ofrecerPromo(this.sugeridas[i]);
			costoPromo= this.sugeridas[i].getCosto();
		
			System.out.println("Costo de la promocion:  " + costoPromo + " Monedas de Oro");
			System.out.println("Tiempo de la Promo: "
					+ this.sugeridas[i].getTiempoPromo());
			System.out.println();
		}
		System.out.println();
	}

	
	private void ofrecerPromo(Promocion promocion) {
		System.out.print("Pack " + promocion.getTipoAtraccion() + ": ");
		for (int i = 0; i < promocion.getAtraccionesDeLaPromo().length; i++) {
			System.out.print(promocion.getAtraccionesDeLaPromo()[i].toString());
			System.out.print(" - ");

		}
		System.out.println(this.mostrarDescuento(promocion));

	}

	public void ordenarPorMayorCosto() {
		Arrays.sort(this.sugeridas, 0, contadorSugeridas, new comparadorPorMayorCosto());
	}

	
	
	public String mostrarDescuento(Promocion unaPromo) {
		if (unaPromo.getTipoPromo().equals("Porcentual")) {
			return ("Tiene un " + unaPromo.getDescuento() + "% de descuento");
		} else {
			if (unaPromo.getTipoPromo().equals("Absoluta")) {
				return ("Tiene un costo total de: " + unaPromo.getCosto() + " Monedas de Oro.");
			} else {
				String atraccionesGratis= "";
				for (int i=0; i< unaPromo.getAtraccionesGratis().length; i++) {
					atraccionesGratis += unaPromo.getAtraccionesGratis()[i].toString();
					atraccionesGratis += " - ";
				}
				return ("Comprando las atracciones de la promo tiene gratis: "+ atraccionesGratis);
			}
		}
	}

}
