package paqueteTurismoEnLaTierraMedia;

public abstract class Promocion implements Comparable <Promocion>{

	private String tipoAtraccion;
	private String tipoPromo;

	private int costo;
	private String[] atraccionesGratis;

	private String[] atraccionesDeLaPromo;
	private int tiempoPromo;

	public Promocion(String tipoPromo, String tipoAtraccion, String[] atraccionesPromo) {
		// String auxiliar = atraccionesPomocionadas.;

		this.tipoPromo = tipoPromo;
		this.tipoAtraccion = tipoAtraccion;
		atraccionesDeLaPromo = atraccionesPromo;

	}

	@Override
    public int compareTo(Promocion promo) {
        if (costo < promo.costo) {
            return -1;
        }
        if (costo > promo.costo) {
            return 1;
        }
        return 0;
    }
	
	public String[] getAtraccionesDeLaPromo() {
		return atraccionesDeLaPromo;//separadas por ","
	}

	
	public String getTipoAtraccion() {
		return tipoAtraccion;
	}


	public int getTiempoPromo() {
		return tiempoPromo;
	}



	public void setTiempoPromo(int tiempoPromo) {
		this.tiempoPromo = tiempoPromo;
	}



	public void setTipoAtraccion(String tipoAtraccion) {
		this.tipoAtraccion = tipoAtraccion;
	}


	public String getTipoPromo() {
		return tipoPromo;
	}


	public void setTipoPromo(String tipoPromo) {
		this.tipoPromo = tipoPromo;
	}


	public String[] getAtraccionesGratis() {
		return atraccionesGratis;
	}

	
	public void setAtraccionesGratis(String[] atraccionesGratis) {
		this.atraccionesGratis = atraccionesGratis;
	}

	
	public void setAtraccionesDeLaPromo(String[] atraccionesDeLaPromo) {
		this.atraccionesDeLaPromo = atraccionesDeLaPromo;
	}

	
	public int getCosto() {
		return this.costo;
	}

	
	public void setCosto(int costo) {
		this.costo = costo;
	}

	
	protected abstract int getDescuento();


	
}
