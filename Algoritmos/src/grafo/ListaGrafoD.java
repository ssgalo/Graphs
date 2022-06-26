package grafo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListaGrafoD extends Grafo {
	private int cantNodos;
	private ArrayList<LinkedList<Nodo>> grafo;

	public ListaGrafoD(int size) {
		this.cantNodos = size;
		grafo = new ArrayList<LinkedList<Nodo>>(size);

		for (int i = 0; i < size; i++) {
			this.grafo.add(new LinkedList<Nodo>());
		}
	}

	@Override
	public void setArista(int desde, int hasta, int costo) {
		
		Nodo nodo = new Nodo(hasta - 1, costo);
		
		this.grafo.get(desde - 1).add(nodo);
		
	}

	@Override
	public int getNodos() {
		return cantNodos;
	}

	@Override
	public Integer getArista(int desde, int hasta) {
		for (Nodo actual : grafo.get(desde)) {
			if (actual.getID() == hasta) {
				return actual.getID();
			}
		}

		return null;
	}

}
