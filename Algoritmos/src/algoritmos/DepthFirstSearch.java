package algoritmos;

import java.util.ArrayDeque;
import java.util.Deque;

import grafo.MatrizGrafoND;

public class DepthFirstSearch {
	private MatrizGrafoND grafo;

	public DepthFirstSearch(MatrizGrafoND grafo) {
		this.grafo = grafo;
	}

	public void resolver(int primero) {

		boolean[] visitados = new boolean[grafo.getNodos()];
		Deque<Integer> pila = new ArrayDeque<Integer>();

		pila.push(primero - 1);
		visitados[primero - 1] = true;

		while (!pila.isEmpty()) {
			int visitado = pila.pop();
			System.out.println(visitado + 1);

			for (int i = 0; i < grafo.getNodos(); i++) {
				if (grafo.getArista(visitado, i) != -1 && !visitados[i]) {
					visitados[i] = true;
					pila.push(i);
				}
			}
		}
	}

	public static void main(String[] args) {
		MatrizGrafoND grafo = new MatrizGrafoND(5);

		grafo.setArista(1, 2, 1);
		grafo.setArista(1, 3, 1);
		grafo.setArista(2, 5, 1);
		grafo.setArista(3, 4, 1);

		DepthFirstSearch dfs = new DepthFirstSearch(grafo);

		dfs.resolver(1);
	}
}
