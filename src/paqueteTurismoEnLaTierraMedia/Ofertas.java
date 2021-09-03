package paqueteTurismoEnLaTierraMedia;

public class Ofertas {

	Promocion[] sugerencias;
	final int MAXIMO_OFERTAS = 30;

	public Ofertas(Usuarios usuariosParque, Atracciones atraccionesParque, Promociones promocionesParque) {
		sugerencias = new Promocion[MAXIMO_OFERTAS];
		Promocion[] deInteresUsuario = new Promocion[30];
		for (int i = 0; i < usuariosParque.usuarios.length; i++) {
			System.out.println("Usuario: " + usuariosParque.usuarios[i].nombre);
			deInteresUsuario = buscarSugerencias(usuariosParque.usuarios[i], atraccionesParque, promocionesParque);
		}

	}

	
	private Promocion[] buscarSugerencias(Usuario usuario, Atracciones atracionesParque,
			Promociones promocionesParque) {
		Promocion[] sugeridas = new Promocion[30];
		int contadorSugeridas = 0;

		for (int i = 0; i < promocionesParque.promociones.length; i++) {
			if (promocionesParque.promociones[i].tipoAtraccion.equals(usuario.atraccionPreferida)) {
				sugeridas[contadorSugeridas] = promocionesParque.promociones[i];
				contadorSugeridas++;
				System.out.println("promo sugerida por el usuario: " + sugeridas[0].getAtraccionesDeLaPromo()[0]);
			}
		}
		
		return sugeridas;
	}
}
