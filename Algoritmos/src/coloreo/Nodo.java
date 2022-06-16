package coloreo;


public class Nodo implements Comparable<Nodo> {
	public int id;
	public int grado;

	public Nodo(int id, int costo) {
		this.id = id;
		this.grado = costo;
	}

	@Override
	public String toString() {
		return "(" + id + "," + grado + ")";
	}

	@Override
	public int compareTo(Nodo o) {
		return this.grado - o.grado;
	}
}
