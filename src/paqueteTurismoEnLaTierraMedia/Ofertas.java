package paqueteTurismoEnLaTierraMedia;

import java.util.Arrays;

public class Ofertas {

	Promocion[] sugeridas = new Promocion[30];
	final int MAXIMO_OFERTAS = 30;

	public Ofertas(Usuarios usuariosParque, Atracciones atraccionesParque, Promociones promocionesParque) {
		// sugerencias = new Promocion[MAXIMO_OFERTAS];
		// sugeridas = new Promocion[30];
		// Promocion[] deInteresUsuario = new Promocion[30];
		for (int i = 0; i < usuariosParque.usuarios.length; i++) {
			System.out.println("Usuario: " + usuariosParque.usuarios[i].getNombre() + " Ofertas sugeridas:");
			this.sugeridas = buscarSugerencias(usuariosParque.usuarios[i], atraccionesParque, promocionesParque);
			System.out.println();
		}

	}

	private Promocion[] buscarSugerencias(Usuario usuario, Atracciones atracionesParque,
			Promociones promocionesParque) {

		// sugeridas = new Promocion[30];
		int contadorSugeridas = 0;
		// buscar las promos que tengan el tipo preferido del usuario las guarda en
		// sugeridas
		for (int i = 0; i < promocionesParque.getPromociones().length; i++) {
			if (promocionesParque.getPromociones()[i].getTipoAtraccion().equals(usuario.getAtraccionPreferida())) {
				this.sugeridas[contadorSugeridas] = promocionesParque.getPromociones()[i];

				for (int j = 0; j < this.sugeridas[contadorSugeridas].getAtraccionesDeLaPromo().length; j++) {
					System.out.print(this.sugeridas[contadorSugeridas].getAtraccionesDeLaPromo()[j].toString());
					System.out.print(" - ");
				}
				contadorSugeridas++;
			}
		}
		mostrarPorPantalla(ordenarPorCosto(this.sugeridas, contadorSugeridas));
		return sugeridas;
	}

	private void mostrarPorPantalla(Object ordenarPorCosto) {
		// TODO Auto-generated method stub
		System.out.println("mostrar las sugerencias");
	}

	private Promocion[] ordenarPorCosto(Promocion[] sugeridas, int contadorSugeridas) {
		for (int i = 0; i < (contadorSugeridas - 1); i++) {
			for (int j = i + 1; j < contadorSugeridas; j++) {				
				if (this.sugeridas[i].getCosto() > this.sugeridas[j].getCosto()) {
					Promocion aux = this.sugeridas[i];
					this.sugeridas[i] = (this.sugeridas[j]);
					this.sugeridas[j] = aux;
				}
			}
		}
		return sugeridas;
		
	}

	public double costoPromocion(Promocion unaPromo, Atraccion[] atracciones) {
		// este metodo busca denro del arreglo de las promocioes y saca el costo del
		// arreglo donde estan las atracciones
		double precio = 0;
		for (int i = 0; i < unaPromo.getAtraccionesDeLaPromo().length; i++) {
			for (int j = 0; j < atracciones.length; j++) {
				if (atracciones[j].getNombre().equals(unaPromo.getAtraccionesDeLaPromo()[i])) {
					precio = atracciones[j].getCosto();
				}
			}
		}
		return precio;
	}
}
