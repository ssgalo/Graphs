package algoritmos;

import java.util.Arrays;
import java.util.PriorityQueue;

import grafo.ListaGrafoD;
import grafo.MatrizGrafoD;
import grafo.Nodo;

public class Dijkstra {
	private MatrizGrafoD grafo;
	private static int INFINITO = 500;
	
	public Dijkstra(MatrizGrafoD grafo) {
		this.grafo = grafo;
	}

	public int[] resolverDijsktra(int desde) {

		boolean[] visitados = new boolean[grafo.getNodos()];
		Arrays.fill(visitados, false);

		int cantVisitados = 1;
		int[] distancias = new int[grafo.getNodos()];

		for (int i = 0; i < grafo.getNodos(); i++) {
			distancias[i] = Dijkstra.INFINITO;
		}

		distancias[desde] = 0;

		PriorityQueue<Nodo> pq = new PriorityQueue<Nodo>();
		pq.add(new Nodo(desde, distancias[desde]));

		while (cantVisitados < grafo.getNodos()) {

			Nodo actual = pq.remove();
			visitados[actual.id] = true;

			for (int i = 0; i < grafo.getNodos(); i++) {
				int valor = grafo.getArista(actual.id, i);
				if (valor != 0 && !visitados[i] && distancias[i] > valor + distancias[actual.id]) {
					distancias[i] = valor + distancias[actual.id];
					pq.add(new Nodo(i, distancias[i]));
				}
			}

			cantVisitados++;
		}
		
		return distancias;
	}

}
