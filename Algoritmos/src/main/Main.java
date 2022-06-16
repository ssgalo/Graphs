package main;

import java.util.Arrays;

import algoritmos.Dijkstra;
import algoritmos.Kruskal;
import grafo.MatrizGrafoD;
import grafo.MatrizGrafoND;

public class Main {
	public static void main(String[] args) {
		MatrizGrafoD grafo = new MatrizGrafoD(7);

		grafo.setArista(1, 3, 4);
		grafo.setArista(1, 2, 6);
		grafo.setArista(1, 4, 1);
		grafo.setArista(2, 5, 3);
		grafo.setArista(2, 4, 2);
		grafo.setArista(3, 6, 5);
		grafo.setArista(4, 6, 8);
		grafo.setArista(4, 3, 5);
		grafo.setArista(4, 7, 2);
		grafo.setArista(5, 7, 3);
		grafo.setArista(5, 4, 1);
		grafo.setArista(7, 6, 9);
	

//		Kruskal kruskal = new Kruskal(grafo);
//
//		kruskal.resolver();
//
//		int costo = kruskal.getCosto();
//		System.out.println(costo);
//
//		kruskal.mostrarMST();
		
		Dijkstra dijsktra = new Dijkstra(grafo);
		
		int[] distancias = dijsktra.resolverDijsktra(1);
		System.out.println(Arrays.toString(distancias));
		System.out.println(dijsktra.getCamino(5));
	}
}
