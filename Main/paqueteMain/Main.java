package paqueteMain;

import paqueteTurismoEnLaTierraMedia.TurismoTierraMedia;

public class Main {
	
	public static TurismoTierraMedia unParqueUsuarios;
	
	public static void main(String[] args) {
		//usuariosParque= new Usuarios("C:\\Users\\Sinred\\Desktop\\PRACTICAS JAVA\\Turismo en tierra media\\usuarios.txt");
		// COMO ESTA EN LA MISMA CARPETA SOLO PONGO EL NOMBRE DEL ARCHIVO	
		unParqueUsuarios = new TurismoTierraMedia("usuarios.txt", "atracciones.txt", "promociones.txt");		
}
}
