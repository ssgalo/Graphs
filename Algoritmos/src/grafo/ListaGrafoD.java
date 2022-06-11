package grafo;

import java.util.LinkedList;
import java.util.List;

public class ListaGrafoD extends Grafo{
	
	private List<Nodo>[] grafo;

	@SuppressWarnings("unchecked")
	public ListaGrafoD(int size) {
		grafo = new List[size];
		
		for (int i = 0; i < size; i++) {
			grafo[i] = new LinkedList<Nodo>();
		}
	}
	
	@Override
	public void setArista(int desde, int hasta, int costo) {
		
		for (Nodo nodo : grafo[desde]) {
			if(nodo.id == hasta) {
				nodo.costo = costo;
				return;
			}
		}
		
		grafo[desde].add(new Nodo(hasta, costo));
		
	}

	@Override
	public int getNodos() {
		return grafo.length;
	}

	@Override
	public Integer getArista(int desde, int hasta) {
		for(Nodo actual : grafo[desde]) {
			if(actual.id == hasta) {
				return actual.id;
			}
		}
		
		return null;
	}

}
