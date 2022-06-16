package algoritmos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

import grafo.Arista;
import grafo.MatrizGrafoND;

public class Kruskal {
	
	private MatrizGrafoND grafo;
	private int[] parent;
	private int costo;
	private ArrayList<Arista> mst;
	
	
	public Kruskal(MatrizGrafoND grafo) {
		this.grafo = grafo;
		mst = new ArrayList<Arista>();
	}
	
	public int find(int x) {
		if(parent[x] == x) {
			return x;
		} else {
			return find(parent[x]);
		}
	}
	
	public void union(int x, int y) {
		parent[find(y)] = parent[x];
	}
	
	public void resolver() {
		
		PriorityQueue<Arista> ordenadas = new PriorityQueue<Arista>();
		
		for (int i = 1; i < grafo.getNodos(); i++) {
			for (int j = 0; j < i; j++) {
				if(grafo.getArista(i, j) != -1)
					ordenadas.add(new Arista(i, j, grafo.getArista(i, j)));
			}
		}
		
		this.parent = new int[grafo.getNodos()];
		
		for (int i = 0; i < grafo.getNodos(); i++) {
			parent[i] = i;
		}
		
		while(!ordenadas.isEmpty()) {
			Arista arista = ordenadas.remove();
	
			if(find(arista.desde) != find(arista.hasta)) {
				union(arista.desde, arista.hasta);
				mst.add(arista);
				costo += arista.costo;
			}
		}
	}
	
	public void mostrarMST() {
		for (Arista arista : mst) {
			System.out.println(arista);
		}
	}
	
	public int getCosto() {
		return this.costo;
	}
}
