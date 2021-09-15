package paqueteMain;

import java.io.IOException;

import paqueteTurismoEnLaTierraMedia.TurismoTierraMedia;

public class Main {
	
	public static TurismoTierraMedia unParqueUsuarios;
	
	public static void main(String[] args) throws IOException {
		//usuariosParque= new Usuarios("C:\\Users\\Sinred\\Desktop\\PRACTICAS JAVA\\Turismo en tierra media\\usuarios.txt");
		// COMO ESTA EN LA MISMA CARPETA SOLO PONGO EL NOMBRE DEL ARCHIVO	
		unParqueUsuarios = new TurismoTierraMedia("C:\\Users\\Sinred\\eclipse-workspace\\TurismoEnLaTierraMedia\\Entrada\\usuarios.txt",
				"C:\\Users\\Sinred\\eclipse-workspace\\TurismoEnLaTierraMedia\\Entrada\\atracciones.txt",
				"C:\\Users\\Sinred\\eclipse-workspace\\TurismoEnLaTierraMedia\\Entrada\\promociones.txt");		
}
}
