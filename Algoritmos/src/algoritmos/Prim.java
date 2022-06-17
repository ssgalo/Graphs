package algoritmos;

import java.util.ArrayList;
import java.util.Arrays;

import grafo.Arista;
import grafo.MatrizGrafoND;

public class Prim {
	private MatrizGrafoND grafo;
	private ArrayList<Arista> mst;
	private final int INFINITO = 5000;
	private int costo;
	
	public Prim(MatrizGrafoND grafo) {
		this.grafo = grafo;
		mst = new ArrayList<Arista>();
	}
	
	public void resolver() {
		boolean visitadas[] = new boolean[grafo.getNodos()];
		Arrays.fill(visitadas, false);
		
		visitadas[0] = true;
		int recorridas = 1;
		
		while(recorridas < grafo.getNodos()) {
			int fila = 0, columna = 0;
			int minimo = INFINITO;
			
			for (int i = 0; i < grafo.getNodos(); i++) {
				
				if(visitadas[i]) {
					for (int j = 0; j < grafo.getNodos(); j++) {
						int valor = grafo.getArista(i, j);
						if(!visitadas[j] && valor != -1 && valor < minimo) {
							minimo = valor;
							fila = i;
							columna = j;
						}
					}
				}	
			}
				
			this.costo += minimo;				
		
			visitadas[columna] = true;
			recorridas++;
		}
	}
}
