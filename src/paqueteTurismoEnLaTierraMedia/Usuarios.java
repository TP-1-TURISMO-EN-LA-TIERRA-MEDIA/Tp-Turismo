package paqueteTurismoEnLaTierraMedia;

import java.io.*;

// en esta clase se almacena en una array todos los usuarios.

public class Usuarios {
	Usuario[] usuarios;

	public Usuarios(String archivoUsuarios) {

		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(archivoUsuarios);
			br = new BufferedReader(fr);
			String linea = br.readLine(); // lee primera linea donde esta la dimension del arreglo
			String[] unUsuario = linea.split(";");
			int dimensionArray = Integer.parseInt(unUsuario[0]);

			usuarios = new Usuario[dimensionArray];
			// usuarios es el array donde se guardan todos los usuarios

			linea = br.readLine();

			for (int i = 0; i < dimensionArray; i++) {
				try {
					unUsuario = linea.split(";");
					String nombre = unUsuario[0];
					double presupuesto = Double.parseDouble(unUsuario[1]);
					double tiempo = Double.parseDouble(unUsuario[2]);
					String tipo = unUsuario[3];
					this.usuarios[i] = new Usuario(nombre, presupuesto, tiempo, tipo);
					linea = br.readLine();
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
