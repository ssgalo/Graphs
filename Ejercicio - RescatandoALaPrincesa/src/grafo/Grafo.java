package grafo;

import java.util.ArrayList;

public class Grafo {
	private int nodos;
	private ArrayList<ArrayList<Adyacencia>> lista = new ArrayList<ArrayList<Adyacencia>>();

	public Grafo(int nodos) {
		this.nodos = nodos;

		for (int i = 0; i < this.nodos; i++)
			this.lista.add(new ArrayList<Adyacencia>());
	}

	public void agregarArista(int nodoA, int nodoB, int peso) {
		Adyacencia adA = new Adyacencia(nodoA - 1, peso), adB = new Adyacencia(nodoB - 1, peso);

		this.lista.get(nodoA - 1).add(adB);
		this.lista.get(nodoB - 1).add(adA);
	}

	public int getNodos() {
		return this.nodos;
	}

	public ArrayList<ArrayList<Adyacencia>> getLista() {
		return this.lista;
	}
}
