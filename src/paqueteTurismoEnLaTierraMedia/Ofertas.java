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
		
		this.ordenarPorMayorCosto();
		System.out.println("cantidad sugeridas::::" + contadorSugeridas);
		// REVISAR QUE ALGO SALE MAL
		for (int i = 0; i <  contadorSugeridas; i++) {
			for (int j = 0; j < this.sugeridas[i].getAtraccionesDeLaPromo().length; j++) {
				System.out.print(this.sugeridas[i].getAtraccionesDeLaPromo()[j].toString());
				System.out.print(" - " );
				costoPromo = costoPromocion(this.sugeridas[i], atraccionesParque.getAtracciones());
				System.out.println("costo de la promo:  " + costoPromo);
			}
			
			System.out.println();
		}

	}

	public void ordenarPorMayorCosto() {
		Arrays.sort(this.sugeridas, 0, contadorSugeridas - 1, new comparadorPorMayorCosto());
	}

	// implementar el comparator para ordenar
//	private void ordenarPorCosto(int contadorSugeridas) {
//		// filtrar el costo segun el tipo de promo
//
//		for (int i = 0; i < (contadorSugeridas - 1); i++) {
//			for (int j = i + 1; j < contadorSugeridas; j++) {
//				if (this.sugeridas[i].getCosto() > this.sugeridas[j].getCosto()) {
//					Promocion aux = this.sugeridas[i];
//					this.sugeridas[i] = (this.sugeridas[j]);
//					this.sugeridas[j] = aux;
//
//				}
//			}
//		}
//
//	}

	public double costoPromocion(Promocion unaPromo, Atraccion[] atracciones) {
		// este metodo busca denro del arreglo de las promocioes y saca el costo del
		// arreglo donde estan las atracciones
		System.out.println("Tipo Promo: " + unaPromo.getTipoPromo());
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
