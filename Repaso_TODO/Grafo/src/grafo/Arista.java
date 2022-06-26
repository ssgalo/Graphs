package grafo;

public class Arista implements Comparable<Arista> {
	private int nodoA;
	private int nodoB;
	private int peso;

	public Arista(int nodoA, int nodoB, int peso) {
		this.nodoA = nodoA;
		this.nodoB = nodoB;
		this.peso = peso;
	}

	public int getNodoA() {
		return nodoA;
	}

	public int getNodoB() {
		return nodoB;
	}

	public int getPeso() {
		return peso;
	}

	@Override
	public int compareTo(Arista o) {
		return Integer.compare(this.peso, o.peso);
	}
}