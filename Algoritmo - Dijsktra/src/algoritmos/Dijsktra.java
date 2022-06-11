package algoritmos;

import java.util.PriorityQueue;

import grafo.MatrizGrafoD;
import grafo.Nodo;

public class Dijsktra {
	private MatrizGrafoD grafo;

	public Dijsktra(int size) {
		grafo = new MatrizGrafoD(size);
	}

	public void resolverDijsktra() {

		boolean[] visitados = new boolean[grafo.getNodos()];
		int[] distancias = new int[grafo.getNodos()];
		PriorityQueue<Nodo> pq = new PriorityQueue<Nodo>();

	}

}
