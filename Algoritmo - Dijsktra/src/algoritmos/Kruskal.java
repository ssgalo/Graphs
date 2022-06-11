package algoritmos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

import grafo.MatrizGrafoND;

public class Kruskal {

	private class Arista implements Comparable<Arista>{

		private int desde;
		private int hasta;
		private int costo;
		
		public Arista(int desde, int hasta, int costo) {
			this.desde = desde;
			this.hasta = hasta;
			this.costo = costo;
		}
		
		@Override
		public int compareTo(Arista o) {
			return this.costo - o.costo;
		}

		@Override
		public String toString() {
			return "[" + (desde + 1) + ", " + (hasta + 1) + "]";
		}
	}
	
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
	
	public static void main(String[] args) {
		MatrizGrafoND grafo = new MatrizGrafoND(6);
		
		grafo.setArista(1, 2, 7);
		grafo.setArista(1, 3, 3);
		grafo.setArista(2, 4, 6);
		grafo.setArista(2, 3, 1);
		grafo.setArista(4, 3, 3);
		grafo.setArista(3, 5, 8);
		grafo.setArista(5, 6, 8);
		grafo.setArista(4, 6, 2);
		grafo.setArista(5, 4, 2);
		
		Kruskal kruskal = new Kruskal(grafo);
		
		kruskal.resolver();
		
		int costo = kruskal.getCosto();
		System.out.println(costo);
		
		kruskal.mostrarMST();
	}
}
