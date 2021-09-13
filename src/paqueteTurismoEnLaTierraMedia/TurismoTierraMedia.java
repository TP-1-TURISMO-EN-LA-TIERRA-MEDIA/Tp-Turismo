package paqueteTurismoEnLaTierraMedia;

import java.io.IOException;

public class TurismoTierraMedia {
	private static Usuarios usuariosParque;
	private static Atracciones atraccionesParque;
	private static Promociones promocionesParque;
	Ofertable ofertas ;
	
	
	public TurismoTierraMedia(String listadoUsuarios,
			String listadoAtracciones, String listadoPromociones) throws IOException  {
		usuariosParque = new Usuarios(listadoUsuarios);
		atraccionesParque = new Atracciones(listadoAtracciones);
		promocionesParque = new Promociones(listadoPromociones, atraccionesParque);
		
		//Ofrecer promociones a los usuarios
		for (int i = 0; i < usuariosParque.usuarios.length; i++) {
			System.out.println("######################################################################################################");
			System.out.println( "Usuario: " + usuariosParque.usuarios[i].getNombre() + "\n");
			ofertas = new Ofertable(usuariosParque.usuarios[i], atraccionesParque, promocionesParque);
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			usuariosParque.usuarios[i].mostrarItinerario();	
			usuariosParque.usuarios[i].generarArchivoItinerario();
		}	
	}
}
