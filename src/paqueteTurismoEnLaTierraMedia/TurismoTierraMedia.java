package paqueteTurismoEnLaTierraMedia;


public class TurismoTierraMedia {
	public static Usuarios usuariosParque;
	public static Atracciones atraccionesParque;
	public static Promociones promocionesParque;
	
	public TurismoTierraMedia(String listadoUsuarios,
			String listadoAtracciones, String listadoPromociones) {
		usuariosParque = new Usuarios(listadoUsuarios);
		atraccionesParque = new Atracciones(listadoAtracciones);
		promocionesParque = new Promociones(listadoPromociones);
		Ofertas ofrecerOfertas = new Ofertas(usuariosParque, atraccionesParque, promocionesParque);
	}
	
	
	
}
