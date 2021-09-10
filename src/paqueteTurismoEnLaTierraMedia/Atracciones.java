package paqueteTurismoEnLaTierraMedia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Atracciones {
	
	Atraccion[] atracciones;
	int cantidadAtracciones = 0;
	
	public Atraccion[] getAtracciones() {
		return atracciones;
	}

	
	
	public Atracciones(String archivoAtracciones) {

			FileReader fr = null;
			BufferedReader br = null;

			try {
				fr = new FileReader(archivoAtracciones);
				br = new BufferedReader(fr);
				String linea = br.readLine(); // lee primera linea donde esta la dimension del arreglo
				String[] unaAtraccion = linea.split(";");
				int dimensionArray = Integer.parseInt(unaAtraccion[0]);
					this.cantidadAtracciones=dimensionArray;
				atracciones = new Atraccion[dimensionArray];
				// atracciones es el array donde se guardan todas las atracciones

				linea = br.readLine();

				for (int i = 0; i < dimensionArray; i++) {
					try {
						unaAtraccion = linea.split(";");
						String nombre = unaAtraccion[0];
						double costo = Double.parseDouble(unaAtraccion[1]);
						double tiempo = Double.parseDouble(unaAtraccion[2]);
						int cupo = Integer.parseInt(unaAtraccion[3]);
						String tipo = unaAtraccion[4];
						this.atracciones[i] = new Atraccion(nombre, costo, tiempo, cupo, tipo);
						linea = br.readLine();
//						System.out.println(atracciones[i].getNombre() + " costo: " +
//								atracciones[i].getCosto() + " Tiempo : " + atracciones[i].getTiempo() + 
//								" cupo: " + atracciones[i].getCupo() + " Tipo de Atraccion: " + atracciones[i].getTipo());
					} catch (Exception x) {
						System.out.println("Error en la lectura del archivo!!");
						x.printStackTrace();
					}
				}
			} catch (IOException e) {
				System.out.println("Error en la apertura del archivo");
				e.printStackTrace();
			}
			finally{
				try {
					if(fr != null) {
						fr.close();
					}
				}catch (Exception e2) {
					e2.printStackTrace();
				}
			}


	}

}
