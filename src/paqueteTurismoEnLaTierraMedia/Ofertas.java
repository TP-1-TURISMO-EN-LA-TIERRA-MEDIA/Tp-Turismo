package paqueteTurismoEnLaTierraMedia;

import java.util.Arrays;

public class Ofertas {

	final int MAXIMO_OFERTAS = 30;
	Promocion[] sugeridas = new Promocion[MAXIMO_OFERTAS];
	private int contadorSugeridas = 0;

	public Ofertas(Usuario usuario, Atracciones atraccionesParque, Promociones promocionesParque) {
		// sugeridas = new Promocion[30];

		double costoPromo = 0;
		// buscar las promos que tengan el tipo preferido del usuario las guarda en
		// sugeridas

		for (int i = 0; i < promocionesParque.getPromociones().length; i++) {
			if (promocionesParque.getPromociones()[i].getTipoAtraccion().equals(usuario.getAtraccionPreferida())) {
				this.sugeridas[contadorSugeridas] = promocionesParque.getPromociones()[i];

//				for (int j = 0; j < this.sugeridas[contadorSugeridas].getAtraccionesDeLaPromo().length; j++) {
//					System.out.print(this.sugeridas[contadorSugeridas].getAtraccionesDeLaPromo()[j].toString());
//					System.out.print(" - ");
//				}
				costoPromo = costoPromocion(this.sugeridas[contadorSugeridas], atraccionesParque.getAtracciones());
//				System.out.println("costo de la promo:  " + costoPromo);
				// System.out.println();
				contadorSugeridas++;
			}

		}
		//System.out.println();

		this.ordenarPorMayorCosto();

		System.out.println("Promociones sugeridas: " + contadorSugeridas + " ");

		for (int i = 0; i < contadorSugeridas; i++) {
			System.out.print(i+1 + ") ");
			this.mostrarPromo(this.sugeridas[i]);
			costoPromo = costoPromocion(this.sugeridas[i], atraccionesParque.getAtracciones());
			System.out.println("costo de la promo:  " + costoPromo);
		}

		System.out.println();
	}

	private void mostrarPromo(Promocion promocion) {
		for (int i = 0; i < promocion.getAtraccionesDeLaPromo().length; i++) {
			System.out.print(promocion.getAtraccionesDeLaPromo()[i].toString());
			System.out.print(" - ");

		}

	}

	public void ordenarPorMayorCosto() {
		Arrays.sort(this.sugeridas, 0, contadorSugeridas, new comparadorPorMayorCosto());
	}

	public double costoPromocion(Promocion unaPromo, Atraccion[] atracciones) {
		// este metodo busca denro del arreglo de las promocioes y saca el costo del
		// arreglo donde estan las atracciones
		// System.out.println("Tipo Promo: " + unaPromo.getTipoPromo());
		if (unaPromo.getTipoPromo().equals("Absoluta")) {

			return unaPromo.getCosto();
		} else {
			double precio = 0;
			for (int i = 0; i < unaPromo.getAtraccionesDeLaPromo().length; i++) {
				for (int j = 0; j < atracciones.length; j++) {
					if (atracciones[j].getNombre().equals(unaPromo.getAtraccionesDeLaPromo()[i])) {
						precio += atracciones[j].getCosto();
						unaPromo.setCosto(precio);
					}
				}
			}
			if (unaPromo.getTipoPromo().equals("Porcentual")) {
				precio = precio - (precio * unaPromo.getDescuento() / 100);
				unaPromo.setCosto(precio);
				return precio;

			} else {
				unaPromo.setCosto(precio);
				return precio;
			}
		}
	}
}
