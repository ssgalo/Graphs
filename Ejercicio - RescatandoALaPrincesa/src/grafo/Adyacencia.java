package grafo;

public class Adyacencia {
	private int nodo;
	private int peso;

	public Adyacencia(int nodo, int peso) {
		this.nodo = nodo;
		this.peso = peso;
	}

	public int getNodo() {
		return this.nodo;
	}

	public int getPeso() {
		return this.peso;
	}
}
