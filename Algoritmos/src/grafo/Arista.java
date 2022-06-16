package grafo;

public class Arista implements Comparable<Arista> {
	public int desde;
	public int hasta;
	public int costo;

	public Arista(int desde, int hasta, int costo) {
		this.desde = desde;
		this.hasta = hasta;
		this.costo = costo;
	}
	
	public int getDesde() {
		return desde;
	}

	public void setDesde(int origen) {
		this.desde = origen;
	}

	public int getHasta() {
		return hasta;
	}

	public void setDestino(int destino) {
		this.hasta = destino;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}


	@Override
	public int compareTo(Arista o) {
		return this.costo - o.costo;
	}

	@Override
	public String toString() {
		return "[" + (desde + 1) + ", " + (hasta + 1) + "]";
	}
}
