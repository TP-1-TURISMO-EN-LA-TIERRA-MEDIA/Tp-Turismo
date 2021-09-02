package paqueteTurismoEnLaTierraMedia;


public class Itinerario {

	private int contador;
	private Atraccion[] itinerario;
	
	public Itinerario() {
		contador = 0;
		setItinerario(new Atraccion[20]);			
	}

	public Atraccion[] getItinerario() {
		return itinerario;
	}

	public void setItinerario(Atraccion[] itinerario) {
		this.itinerario = itinerario;
	}
	
	
	public void addAtraccion(Atraccion atraccion) {
		itinerario[contador]= atraccion;
		contador++;
	}
}
