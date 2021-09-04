package paqueteTurismoEnLaTierraMedia;

public class Ofertas {

	Promocion[] sugerencias;
	final int MAXIMO_OFERTAS = 30;

	public Ofertas(Usuarios usuariosParque, Atracciones atraccionesParque, Promociones promocionesParque) {
		sugerencias = new Promocion[MAXIMO_OFERTAS];
		Promocion[] deInteresUsuario = new Promocion[30];
		for (int i = 0; i < usuariosParque.usuarios.length; i++) {
			System.out.println("Usuario: " + usuariosParque.usuarios[i].getNombre());
			deInteresUsuario = buscarSugerencias(usuariosParque.usuarios[i], atraccionesParque, promocionesParque);
		}

	}

	
	private Promocion[] buscarSugerencias(Usuario usuario, Atracciones atracionesParque,
			Promociones promocionesParque) {
		Promocion[] sugeridas = new Promocion[30];
		int contadorSugeridas = 0;

		for (int i = 0; i < promocionesParque.promociones.length; i++) {
			if (promocionesParque.promociones[i].getTipoAtraccion().equals(usuario.getAtraccionPreferida())) {
				sugeridas[contadorSugeridas] = promocionesParque.promociones[i];
				contadorSugeridas++;
				System.out.println("promo sugerida por el usuario: " + sugeridas[0].getAtraccionesDeLaPromo()[0]);		
			}
		}	
		return sugeridas;
	}
	
	
	public double costoPromocion(Promocion unaPromo, Atraccion[] atracciones) {
		// este metodo busca denro del arreglo de las promocioes y saca el costo del arreglo donde estan las atracciones
		double precio=0;
		for (int i=0; i< unaPromo.getAtraccionesDeLaPromo().length; i++) {
			for (int j=0; j< atracciones.length; j++) {
				if (atracciones[j].getNombre().equals(unaPromo.getAtraccionesDeLaPromo()[i])) {
					precio = atracciones[j].getCosto();
				}
			}
		}
		return precio;
	}
}
