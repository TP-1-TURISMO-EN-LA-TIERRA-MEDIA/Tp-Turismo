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
			String[] unaPromocion = linea.split(";");// hay cuatro separaciones. 
													 //la posicion 0 para el tipo de promo. 
													 //la posicion 1 para el tipo de atraccion
													 //la posicion 2 para las atracciones ofertadas (es otro String con n actracciones)
													 //la posicion 3 para la oferta , descuento o n atracciones gratis

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

					if (tipoPromo.equals("Porcentual")) {
						int oferta = Integer.parseInt(unaPromocion[4]);
						this.promociones[i] = new PromoPorcentual(tipoPromo, tipoAtraccion, atraccion1, atraccion2,
								oferta);	
						System.out.println("Promo: " + this.promociones[i].tipoPromo.toString()
								  + " " + this.promociones[i].tipoAtraccion.toString() +
								  " " + this.promociones[i].atraccion1.toString() +
								  " " + this.promociones[i].atraccion2.toString() +
								  " " + this.promociones[i].getDescuento());
					
					}
					
					if (tipoPromo.equals("Absoluta")) {
						int oferta = Integer.parseInt(unaPromocion[4]);
						this.promociones[i] = new PromoAbsoluta(tipoPromo, tipoAtraccion, atraccion1, atraccion2,
								oferta);
						
						  System.out.println("Promo: " + this.promociones[i].tipoPromo.toString()
						  + " " + this.promociones[i].tipoAtraccion.toString() +
						  " " + this.promociones[i].atraccion1.toString() +
						  " " + this.promociones[i].atraccion2.toString() +
						  " " + this.promociones[i].costo);
						 
					}
					
					if (tipoPromo.equals("AxB")) {
					//	List <Atraccion> juegosGratis = new ArrayList<Atraccion>();
						
						String atraccionGratis = unaPromocion[unaPromocion.length-1]; 
						
						this.promociones[i] = new PromoAxB(tipoPromo, tipoAtraccion, atraccion1, atraccion2, atraccionGratis);
						System.out.println("Promo: " + this.promociones[i].tipoPromo.toString()
								  + " " + this.promociones[i].tipoAtraccion.toString() +
								  " " + this.promociones[i].atraccion1.toString() +
								  " " + this.promociones[i].atraccion2.toString() +
								  " " + this.promociones[i].atraccionGratis);
						
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
}