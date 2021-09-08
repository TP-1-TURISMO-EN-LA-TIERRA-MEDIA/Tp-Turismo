package paqueteTurismoEnLaTierraMedia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Promociones {

	private Promocion[] promociones;

	public Promociones(String archivoPromociones, Atracciones atracciones) {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(archivoPromociones);
			br = new BufferedReader(fr);

			String linea = br.readLine(); // lee primera linea donde esta la dimension del arreglo
			String[] unaPromocion = linea.split(";");// hay cuatro separaciones.
														// la posicion 0 para el tipo de promo.
														// la posicion 1 para el tipo de atraccion
														// la posicion 2 para las atracciones ofertadas (es otro String
														// con n actracciones)
														// la posicion 3 para la oferta , descuento o n atracciones
														// gratis

			int dimensionArray = Integer.parseInt(unaPromocion[0]);

			promociones = new Promocion[dimensionArray];
			// promociones es el array donde se guardan todas las promociones

			linea = br.readLine();

			for (int i = 0; i < dimensionArray; i++) {
				try {
					unaPromocion = linea.split(";");
					String tipoPromo = unaPromocion[0];
					String tipoAtraccion = unaPromocion[1];
					String[] atraccionesPromo = unaPromocion[2].split(",");
					
					if (tipoPromo.equals("Porcentual")) {
						int oferta = Integer.parseInt(unaPromocion[3]);
						this.promociones[i] = new PromoPorcentual(tipoPromo, tipoAtraccion, atraccionesPromo, oferta);
					}
					if (tipoPromo.equals("Absoluta")) {
						int oferta = Integer.parseInt(unaPromocion[3]);
						this.promociones[i] = new PromoAbsoluta(tipoPromo, tipoAtraccion, atraccionesPromo, oferta);
					}
					if (tipoPromo.equals("AxB")) {
						// el codigo de impresion hay que borrarlo es solo para ver si hacia bien el metodo

						String[] atraccionesGratis = unaPromocion[unaPromocion.length - 1].split(",");

						this.promociones[i] = new PromoAxB(tipoPromo, tipoAtraccion, atraccionesPromo,
								atraccionesGratis);
					}
					linea = br.readLine();
					this.costoPromocion(this.promociones[i], atracciones.getAtracciones());
					this.setTiempoPromocion(this.promociones[i], atracciones.getAtracciones());
				} catch (Exception x) {
					System.out.println("Error en la lectura del archivo!!");
					x.printStackTrace();
				}
			}
		} catch (IOException e) {
			System.out.println("Error en la apertura del archivo");
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	
	public int getCosto(Promocion unaPromo) {
		
		return 0;
	}

	
	public Promocion[] getPromociones() {
		return promociones;
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
	
	public void setTiempoPromocion(Promocion unaPromo, Atraccion[] atracciones) {
		int tiempo = 0;
		for (int i = 0; i < unaPromo.getAtraccionesDeLaPromo().length; i++) {
			for (int j = 0; j < atracciones.length; j++) {
				if (atracciones[j].getNombre().equals(unaPromo.getAtraccionesDeLaPromo()[i])) {
					tiempo += atracciones[j].getTiempo();
					unaPromo.setTiempoPromo(tiempo);
				}
			}
		}
	}

}