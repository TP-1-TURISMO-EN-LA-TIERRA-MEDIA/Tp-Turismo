package paqueteTurismoEnLaTierraMedia;

import java.util.Arrays;
import java.util.Scanner;

//import jdk.internal.misc.FileSystemOption;

public class Ofertable {

	final int MAXIMO_OFERTAS = 50;
	Promocion[] sugeridas = new Promocion[MAXIMO_OFERTAS];
	private int contadorSugeridas = 0;

	public Ofertable(Usuario usuario, Atracciones atraccionesParque, Promociones promocionesParque) {
		Scanner in = new Scanner(System.in);
//		double costoPromo = 0;
		// buscar las promos que tengan el tipo preferido del usuario las guarda en
		// sugeridas
		for (int i = 0; i < promocionesParque.getPromociones().length; i++) {
			if (promocionesParque.getPromociones()[i].getTipoAtraccion().equals(usuario.getAtraccionPreferida())) {
				this.sugeridas[contadorSugeridas] = promocionesParque.getPromociones()[i];
				contadorSugeridas++;
			}
		}
		ofrecerPromociones(usuario, atraccionesParque, in);
		ofrecerAtracciones(usuario, atraccionesParque);
		System.out.println();
	}

	private void ofrecerAtracciones(Usuario usuario, Atracciones atraccionesParque) {
		int cant=atraccionesParque.cantidadAtracciones;	
		Arrays.sort(atraccionesParque.getAtracciones(), 0, cant, new comparadorAtraccionesPorMayorCosto());
		
	}

	private void ofrecerPromociones(Usuario usuario, Atracciones atraccionesParque, Scanner in) {
		this.ordenarSugerencias();// se ordena por mayor costo de promociones

		for (int i = 0; i < contadorSugeridas; i++) {
			if (!estaEnSugeridas(this.sugeridas[i], usuario)) {
// ACA HAY QUE CONSIDERAR MOSTRAR SOLO LAS QUE NO SE REPITEN Y QUE NO HAYA COMPRADO 			
				this.ofrecerPromo(this.sugeridas[i]);
				System.out.println();
				mostrarSaldoYTiempoUsuario(usuario);
				mostrarCostoYTiempoPromo(i);
				System.out.println("Desea comprar la Promo? S/N: ");
				String entradaConsola = in.nextLine();
				String respuesta = entradaConsola.toUpperCase();
				if (respuesta.equals("S")) {
					this.comprarPromo(usuario, this.sugeridas[i], atraccionesParque);
					System.out.println("\n\n");

				} else {
					System.out.println("No se compro la promo." + "\n\n");

				}
			}
		}
	}

	private void mostrarCostoYTiempoPromo(int i) {
		System.out.println("Costo de la promocion:           " + this.sugeridas[i].getCosto() + " M.O."
				+ "                Tiempo de la Promo:            " + this.sugeridas[i].getTiempoPromo()
				+ "   hs" + "\n");
	}

	private void mostrarSaldoYTiempoUsuario(Usuario usuario) {
		System.out.print("Saldo del monedero del Usuario: " + usuario.getSaldo() + " M.O." + "             "
				+ "   Tiempo disponible del Usuario: " + usuario.getTiempo() + " hs" + "\n");
	}

	private boolean estaEnSugeridas(Promocion promocion, Usuario usuario) {
		if (usuario.getItinerario() != null) {
			for (int i = 0; i < promocion.getAtraccionesDeLaPromo().length; i++) {
				for (int j = 0; j < usuario.getContadorItinerario(); j++) {
					String nombreAtraccionPromocion = promocion.getAtraccionesDeLaPromo()[i].toString();
					String nombreAtraccionItinerario = usuario.getItinerario()[j].getNombre();
					if (nombreAtraccionPromocion.equals(nombreAtraccionItinerario)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private void comprarPromo(Usuario usuario, Promocion promocion, Atracciones atraccionesParque) {
		if (lasAtraccionesDeLaPromoTienenCupo(promocion.getAtraccionesDeLaPromo(), atraccionesParque)) {
			restarCupoDeLasAtraccionesPromocion(promocion.getAtraccionesDeLaPromo(), atraccionesParque);
			usuario.setSaldo(usuario.getSaldo() - promocion.getCosto());
			usuario.setTiempo(usuario.getTiempo() - promocion.getTiempoPromo());
			agregarPromoAlItinerario(usuario, promocion, atraccionesParque);
			if (promocion.getTipoPromo().equals("AxB")) {
				agregarAtraccionesGratisAlItinerario(usuario, promocion.getAtraccionesGratis(),
						atraccionesParque);
			}
			System.out.println("PROMOCION COMPRADA CON EXITO!");
		}
	}

	private void agregarPromoAlItinerario(Usuario usuario, Promocion promocion, Atracciones atraccionesParque) {
		for (int i = 0; i < promocion.getAtraccionesDeLaPromo().length; i++) {
			for (int j = 0; j < atraccionesParque.getAtracciones().length; j++) {
				if (promocion.getAtraccionesDeLaPromo()[i].equals(atraccionesParque.getAtracciones()[j].getNombre())) {
					usuario.addAtraccionAlItinerario(atraccionesParque.getAtracciones()[j]);
					
				}
			}
		}
	}

	private void agregarAtraccionesGratisAlItinerario(Usuario usuario, String[] atraccionesGratis,
			Atracciones atraccionesParque) {
		for (int i = 0; i < atraccionesGratis.length; i++) {
			for (int j = 0; j < atraccionesParque.getAtracciones().length; j++) {
				if (atraccionesGratis[i].equals(atraccionesParque.getAtracciones()[j].getNombre())) {
					usuario.addAtraccionAlItinerario(atraccionesParque.getAtracciones()[j]);

				}
			}
		}

	}

//	private double tiempoDeLaPromo(String[] atraccionesDeLaPromo, Atracciones atraccionesParque) {
//
//		return 0;
//	}

	private void restarCupoDeLasAtraccionesPromocion(String[] atraccionesDeLaPromo, Atracciones atraccionesParque) {
		for (int i = 0; i < atraccionesDeLaPromo.length; i++) {
			for (int j = 0; j < atraccionesParque.getAtracciones().length; j++) {
				if (atraccionesDeLaPromo[i].equals(atraccionesParque.getAtracciones()[j].getNombre())) {
					atraccionesParque.getAtracciones()[j].setCupo(atraccionesParque.getAtracciones()[j].getCupo() - 1);
				}
			}
		}
	}

	private boolean lasAtraccionesDeLaPromoTienenCupo(String[] atraccionesDeLaPromo, Atracciones atraccionesParque) {
		boolean hayCupo = true;
		for (int i = 0; i < atraccionesDeLaPromo.length; i++) {
			for (int j = 0; j < atraccionesParque.getAtracciones().length; j++) {
				if (atraccionesDeLaPromo[i].equals(atraccionesParque.getAtracciones()[j].getNombre())) {
					if (atraccionesParque.getAtracciones()[j].getCupo() < 1) {
						System.out.println("La atraccion " + atraccionesParque.getAtracciones()[j].getNombre()
								+ " no tiene mas cupo." + "\n" + "No es posible comprar la promocion.");
						hayCupo = false;
					}
				}
			}
		}
		return hayCupo;
	}

	private void restarCupoAtraccion(String atraccion, Atracciones atraccionesParque) {
		int i = 0;
		boolean encontrado = false;
		while (i < atraccionesParque.getAtracciones().length && !encontrado) {
			if (atraccionesParque.getAtracciones()[i].equals(atraccion)) {
				atraccionesParque.getAtracciones()[i].setCupo(atraccionesParque.getAtracciones()[i].getCupo() - 1);
				encontrado = true;
			}
			i++;
		}

	}

	private void comprarAtraccion(Usuario usuario, Promocion promocion, Atracciones atraccionesParque) {
		double saldo = 0;
		usuario.setSaldo(usuario.getSaldo() - promocion.getCosto());

		// usuario.agregarAlItinerario(promocion.)

	}

	private boolean tieneTiempo(Usuario usuario, Promocion promocion) {
		return usuario.getTiempo() >= promocion.getTiempoPromo();
	}

	private boolean tieneSaldo(Usuario usuario, Promocion promocion) {
		return usuario.getSaldo() >= promocion.getCosto();
	}

	private void ofrecerPromo(Promocion promocion) {
		System.out.print("Pack " + promocion.getTipoAtraccion() + ": ");
		for (int i = 0; i < promocion.getAtraccionesDeLaPromo().length; i++) {
			System.out.print(promocion.getAtraccionesDeLaPromo()[i].toString());
			System.out.print(" - ");

		}
		System.out.println(this.mostrarDescuento(promocion));

	}

	public void ordenarSugerencias() {
		Arrays.sort(this.sugeridas, 0, contadorSugeridas, new comparadorPorMayorCosto());
	}

	public String mostrarDescuento(Promocion unaPromo) {
		if (unaPromo.getTipoPromo().equals("Porcentual")) {
			return ("Tiene un " + unaPromo.getDescuento() + "% de descuento");
		} else {
			if (unaPromo.getTipoPromo().equals("Absoluta")) {
				return ("Tiene un costo total de: " + unaPromo.getCosto() + " Monedas de Oro.");
			} else {
				String atraccionesGratis = "";
				for (int i = 0; i < unaPromo.getAtraccionesGratis().length; i++) {
					atraccionesGratis += unaPromo.getAtraccionesGratis()[i].toString();
					atraccionesGratis += " - ";
				}
				return ("Comprando las atracciones de la promo tiene gratis: " + atraccionesGratis);
			}
		}
	}

}
