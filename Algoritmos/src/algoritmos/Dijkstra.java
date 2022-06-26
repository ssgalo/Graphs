package algoritmos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

import grafo.ListaGrafoD;
import grafo.MatrizGrafoD;
import grafo.Nodo;

public class Dijkstra {
	private MatrizGrafoD grafo;
	private static int INFINITO = 500;
	private int[] predecesores;
	private int nodoInicial;
	
	public Dijkstra(MatrizGrafoD grafo) {
		this.grafo = grafo;
		this.predecesores = new int[grafo.getNodos()];
	}

	public int[] resolverDijsktra(int desde) {

		boolean[] visitados = new boolean[grafo.getNodos()];
		Arrays.fill(visitados, false);
		
		//supongo que me pasan el nodo como uno más, por eso lo resto.
		this.nodoInicial = desde - 1;
		int cantVisitados = 1;
		
		int[] distancias = new int[grafo.getNodos()];

		for (int i = 0; i < grafo.getNodos(); i++) {
			distancias[i] = Dijkstra.INFINITO;
			predecesores[i] = this.nodoInicial;
		}

		distancias[this.nodoInicial] = 0;

		PriorityQueue<Nodo> pq = new PriorityQueue<Nodo>();
		pq.add(new Nodo(this.nodoInicial, distancias[this.nodoInicial]));

		while (cantVisitados < grafo.getNodos()) {

			Nodo actual = pq.remove();
			visitados[actual.getID()] = true;

			for (int i = 0; i < grafo.getNodos(); i++) {
				int valor = grafo.getArista(actual.getID(), i);
				if (valor != grafo.INFINITO && !visitados[i] && distancias[i] > valor + distancias[actual.getID()]) {
					distancias[i] = valor + distancias[actual.getID()];
					this.predecesores[i] = actual.getID();
					pq.add(new Nodo(i, distancias[i]));
				}
			}

			cantVisitados++;
		}
		
		return distancias;
	}
	
	public ArrayList<Integer> getCamino(int nodoHasta){
		//Supongo que me mandan el nodo con el numero no indexado
		int i = nodoHasta - 1;
		ArrayList<Integer> camino = new ArrayList<Integer>();
		
		camino.add(i);
		
		while(i != nodoInicial) {
			i = predecesores[i];
			camino.add(i);
		}
		
		return camino;
	}

}
