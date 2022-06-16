package resolucion;

import java.util.ArrayList;
import java.util.PriorityQueue;

import grafo.Arista;
import grafo.MatrizGrafo;

public class Electrificador {
	private MatrizGrafo grafo;
	private int[] centrales;
	private int costo;
	private ArrayList<int[]> caminos;
	private final int MINIMO = 5000;

	public Electrificador(int[][] matriz, int[] centrales) {
		this.grafo = new MatrizGrafo(matriz);
		this.centrales = centrales;
		this.caminos = new ArrayList<int[]>();
	}

	public void crearConexionesElectricas() {
		boolean[] visitados = new boolean[this.grafo.getNodos()];
		
		for (int i = 0; i < this.centrales.length; i++) {			
			visitados[this.centrales[i] - 1] = true;
		}

		int electrificadas = this.centrales.length;
		
		while (electrificadas < this.grafo.getNodos()) {
			int fila = 0, columna = 0, minimo = MINIMO;

			for (int i = 1; i < this.grafo.getNodos(); i++) {
				if (visitados[i]) {
					for (int j = 0; j < i; j++) {
						if (!visitados[j]) {
							int peso = this.grafo.getArista(i, j);

							minimo = peso < minimo ? peso : minimo;
							fila = i;
							columna = j;
						}
					}
				}
			}

			int[] camino = { columna + 1, fila + 1 };

			visitados[columna] = true;
			electrificadas++;
			this.caminos.add(camino);
			this.costo += minimo;
		}
	}
	
	
	//FORMA CON MENOS COMPLEJIDAD (CREO) 
	// sería a . log(n)
	
//	public void crearConexionesElectricas_forma1() {
//		boolean[] visitados = new boolean[this.grafo.getNodos()];
//		
//		PriorityQueue<Arista> pq = new PriorityQueue<Arista>();
//		
//		for (int i = 0; i < this.centrales.length; i++) {			
//			visitados[this.centrales[i] - 1] = true;
//			agregarAristasAdyacentes(pq, this.centrales[i] - 1);
//		}
//
//		int electrificadas = this.centrales.length;
//		
//		while (!pq.isEmpty() && electrificadas < this.grafo.getNodos()) {
//			Arista arista = pq.remove();
//			
//			if(!visitados[arista.hasta]) {
//				visitados[arista.hasta] = true;
//				costo += arista.costo;
//				
//				int[] camino = { arista.hasta + 1, arista.desde + 1 };
//				this.caminos.add(camino);
//				agregarAristasAdyacentes(pq, arista.hasta);
//				electrificadas++;
//			}
//		}
//	}

//	private void agregarAristasAdyacentes(PriorityQueue<Arista> pq, int nodo) {
//		for(int i = 0; i < grafo.getNodos(); i++) {
//			if(grafo.getArista(nodo, i) != 0) {
//				pq.add(new Arista(nodo, i, grafo.getArista(nodo, i)));
//			}
//		}
//	}
	
	public int getCosto() {
		return costo;
	}

	public ArrayList<int[]> getCaminos() {
		return caminos;
	}

}	
