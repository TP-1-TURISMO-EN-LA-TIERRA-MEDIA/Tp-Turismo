package paqueteTurismoEnLaTierraMedia;

import java.util.Arrays;

public class Ofertas {

	Promocion[] sugeridas = new Promocion[30];
	final int MAXIMO_OFERTAS = 30;

	public Ofertas(Usuario usuario, Atracciones atraccionesParque, Promociones promocionesParque) {
		// sugeridas = new Promocion[30];
		int contadorSugeridas = 0;
		double costoPromo = 0;
		// buscar las promos que tengan el tipo preferido del usuario las guarda en
		// sugeridas

		for (int i = 0; i < promocionesParque.getPromociones().length; i++) {
			if (promocionesParque.getPromociones()[i].getTipoAtraccion().equals(usuario.getAtraccionPreferida())) {
				this.sugeridas[contadorSugeridas] = promocionesParque.getPromociones()[i];

				// esta saliendo mal el costo de la promo
				for (int j = 0; j < this.sugeridas[contadorSugeridas].getAtraccionesDeLaPromo().length; j++) {
					System.out.print(this.sugeridas[contadorSugeridas].getAtraccionesDeLaPromo()[j].toString());
					System.out.print(" - ");

				}
				costoPromo = costoPromocion(this.sugeridas[contadorSugeridas], atraccionesParque.getAtracciones());
				System.out.println("costo de la promo:  " + costoPromo);
				System.out.println();
				contadorSugeridas++;
			}

		}

		System.out.println();
		ordenarPorCosto(this.sugeridas, contadorSugeridas);

	}

	// implementar el comparator para ordenar
	private Promocion[] ordenarPorCosto(Promocion[] sugeridas, int contadorSugeridas) {
		// filtrar el costo segun el tipo de promo

		for (int i = 0; i < (contadorSugeridas - 1); i++) {
			for (int j = i + 1; j < contadorSugeridas; j++) {
				if (this.sugeridas[i].getCosto() > this.sugeridas[j].getCosto()) {
					Promocion aux = this.sugeridas[i];
					this.sugeridas[i] = (this.sugeridas[j]);
					this.sugeridas[j] = aux;
				}
			}
		}
		return sugeridas;

	}

	public double costoPromocion(Promocion unaPromo, Atraccion[] atracciones) {
		// este metodo busca denro del arreglo de las promocioes y saca el costo del
		// arreglo donde estan las atracciones
		System.out.println("Tipo Promo: " + unaPromo.getTipoPromo());
		if (unaPromo.getTipoPromo().equals("Absoluta") ) {
			
			return unaPromo.getCosto();
		} else {
			double precio = 0;
			for (int i = 0; i < unaPromo.getAtraccionesDeLaPromo().length; i++) {
				for (int j = 0; j < atracciones.length; j++) {
					if (atracciones[j].getNombre().equals(unaPromo.getAtraccionesDeLaPromo()[i])) {
						precio += atracciones[j].getCosto();
					}
				}
			}
			if (unaPromo.getTipoPromo().equals("Porcentual") ) {
				return (precio = precio - (precio * unaPromo.getDescuento() / 100));

			} else
				return precio;

		}

	}
}
