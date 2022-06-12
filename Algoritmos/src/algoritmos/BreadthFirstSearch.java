package algoritmos;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import grafo.MatrizGrafoD;
import grafo.MatrizGrafoND;
import grafo.Nodo;

public class BreadthFirstSearch {
	private MatrizGrafoND grafo;
	
	
	public BreadthFirstSearch(MatrizGrafoND grafo) {
		this.grafo = grafo;
	}
	
	public void resolver(int primero) {
		
		boolean[] visitados = new boolean[grafo.getNodos()];
		Queue<Integer> cola = new LinkedList<Integer>();
		
		cola.add(primero - 1);
		visitados[primero - 1] = true;
		
		while(!cola.isEmpty()) {
			int visitado = cola.poll();
			System.out.println(visitado + 1);
			
			for (int i = 0; i < grafo.getNodos(); i++) {
				if(grafo.getArista(visitado, i) != -1 && !visitados[i]) {
					visitados[i] = true;
					cola.add(i);
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
		
		BreadthFirstSearch bfs = new BreadthFirstSearch(grafo);
			
		bfs.resolver(1);
	}
	
}
