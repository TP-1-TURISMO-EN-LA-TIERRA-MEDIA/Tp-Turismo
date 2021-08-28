package paqueteTurismoEnLaTierraMedia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Promociones {
	Promocion[] promociones;

	public Promociones(String archivoPromociones) {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(archivoPromociones);
			br = new BufferedReader(fr);
			String linea = br.readLine(); // lee primera linea donde esta la dimension del arreglo
			String[] unaPromocion = linea.split(";");
			int dimensionArray = Integer.parseInt(unaPromocion[0]);

			promociones = new Promocion[dimensionArray];
			// promociones es el array donde se guardan todas las promociones

			linea = br.readLine();

			for (int i = 0; i < dimensionArray; i++) {
				try {

					unaPromocion = linea.split(";");
					String tipoPromo = unaPromocion[0];
					String tipoAtraccion = unaPromocion[1];
					String atraccion1 = unaPromocion[2];
					String atraccion2 = unaPromocion[3];
					// int oferta = Integer.parseInt(unaPromocion[4]);
					if (tipoPromo == "Porcentual") {
						int oferta = Integer.parseInt(unaPromocion[4]);
						this.promociones[i] = new PromoPorcentual(tipoPromo, tipoAtraccion, atraccion1, atraccion2,
								oferta);
					}
					if (tipoPromo == "Absoluta") {
						int oferta = Integer.parseInt(unaPromocion[4]);
						this.promociones[i] = new PromoAbsoluta(tipoPromo, tipoAtraccion, atraccion1, atraccion2,
								oferta);
					}
					if (tipoPromo == "AxB") {
						String oferta = unaPromocion[4];
						this.promociones[i] = new PromoAxB(tipoPromo, tipoAtraccion, atraccion1, atraccion2, oferta);
					}

					linea = br.readLine();
					System.out.println(this.promociones[i].atraccion1);
					/*
					 * System.out.println("Tipo Promo: " + this.promociones[i].tipoPromo +
					 * " Tipo Atraccion: " + this.promociones[i].tipoAtraccion + " Atraccion 1 : " +
					 * this.promociones[i].atraccion1 + " Atraccion 2: " +
					 * this.promociones[i].atraccion2 + " Descuento/precio: " +
					 * this.promociones[i].oferta);
					 */
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
}