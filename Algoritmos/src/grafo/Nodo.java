package grafo;

public class Nodo implements Comparable<Nodo> {
	public int id;
	public double costo;

	public Nodo(int id, int costo) {
		this.id = id;
		this.costo = costo;
	}

	@Override
	public String toString() {
		return "(" + id + "," + costo + ")";
	}

	@Override
	public int compareTo(Nodo o) {
		return this.id - o.id;
	}
}