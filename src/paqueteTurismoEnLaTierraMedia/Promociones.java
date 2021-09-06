package paqueteTurismoEnLaTierraMedia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Promociones {

	private Promocion[] promociones;

	public Promociones(String archivoPromociones) {
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

						System.out.println("Promo: " + this.promociones[i].getTipoPromo().toString() + " "
								+ this.promociones[i].getTipoAtraccion().toString() + " "
								+ this.promociones[i].getAtraccionesDeLaPromo()[0] + " "
								+ this.promociones[i].getDescuento());

					}

					if (tipoPromo.equals("Absoluta")) {
						int oferta = Integer.parseInt(unaPromocion[3]);
						this.promociones[i] = new PromoAbsoluta(tipoPromo, tipoAtraccion, atraccionesPromo, oferta);

						System.out.println("Promo: " + this.promociones[i].getTipoPromo().toString() + " "
								+ this.promociones[i].getTipoAtraccion().toString() + " "
								+ this.promociones[i].getAtraccionesDeLaPromo()[0] + " " + this.promociones[i].getCosto());

					}

					if (tipoPromo.equals("AxB")) {
						// el codigo de impresion hay que borrarlo es solo para ver si hacia bien el metodo

						String[] atraccionesGratis = unaPromocion[unaPromocion.length - 1].split(",");

						this.promociones[i] = new PromoAxB(tipoPromo, tipoAtraccion, atraccionesPromo,
								atraccionesGratis);
						System.out.println("Promo: " + this.promociones[i].getTipoPromo().toString());
						System.out.println("Tipo: " + this.promociones[i].getTipoAtraccion().toString());
						System.out.print("Atracciones Ofrecidas: ");
						for (int j = 0; j < this.promociones[i].getAtraccionesDeLaPromo().length; j++) {
							System.out.print(this.promociones[i].getAtraccionesDeLaPromo()[j].toString() + " - ");							
						}
						System.out.println();
						System.out.print("Atracciones gratis comprando la promo: ");
						for (int k = 0; k < this.promociones[i].getAtraccionesGratis().length; k++) {
							System.out.print(this.promociones[i].getAtraccionesGratis()[k].toString() + " - ");							
						}
						System.out.println();
						System.out.println();
					}

					linea = br.readLine();

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

	
	
}