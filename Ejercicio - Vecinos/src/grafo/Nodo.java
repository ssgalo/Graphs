package grafo;

public class Nodo implements Comparable<Nodo>{
	private int id;
	private int costo;
	
	public Nodo(int id, int costo) {
		this.id = id;
		this.costo = costo;
	}
	
	public int getID() {
		return this.id;
	}
	
	public int getCosto() {
		return this.costo;
	}

	@Override
	public int compareTo(Nodo o) {
		return this.id - o.id;
	}
}
