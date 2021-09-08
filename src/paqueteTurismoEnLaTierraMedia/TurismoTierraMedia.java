package paqueteTurismoEnLaTierraMedia;


public class TurismoTierraMedia {
	private static Usuarios usuariosParque;
	private static Atracciones atraccionesParque;
	private static Promociones promocionesParque;
	Ofertas ofertas ;
	
	public TurismoTierraMedia(String listadoUsuarios,
			String listadoAtracciones, String listadoPromociones) {
		usuariosParque = new Usuarios(listadoUsuarios);
		atraccionesParque = new Atracciones(listadoAtracciones);
		promocionesParque = new Promociones(listadoPromociones, atraccionesParque);
		
		//Ofrecer promociones a los usuarios
		for (int i = 0; i < usuariosParque.usuarios.length; i++) {
			System.out.println("Usuario: " + usuariosParque.usuarios[i].getNombre() );
			ofertas = new Ofertas(usuariosParque.usuarios[i], atraccionesParque, promocionesParque);
			
			//System.out.println();
		}
		
	}
	
	
	
}
