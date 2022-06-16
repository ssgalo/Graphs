package resolucion;

import java.util.Arrays;

import grafo.MatrizGrafo;

public class Ciudad {
	private int islas;
	private int tuneles;
	private int puentes;
	private int costoMinimo;
	private final int INFINITO = 500;
	
	private MatrizGrafo grafoDeIslas;
	
	public Ciudad(int islas, int tuneles, int puentes) {
		this.islas = islas;
		this.tuneles = tuneles;
		this.puentes = puentes;
		
		this.grafoDeIslas = new MatrizGrafo(islas);
	}
	
	
	public void agregarTunel(int desde, int hasta) {
		grafoDeIslas.setArista(desde, hasta, 0);
	}
	
	public void agregarPuente(int desde, int hasta) {
		grafoDeIslas.setArista(desde, hasta, 1);
	}
	
	public void calcularPuentesMinimos() {
		
		//Por algoritmo de Prim
		boolean visitadas[] = new boolean[grafoDeIslas.getNodos()];
		Arrays.fill(visitadas, false);
		
		visitadas[0] = true;
		int recorridas = 1;
		
		while(recorridas < grafoDeIslas.getNodos()) {
			
			
			int fila = 0, columna = 0;
			int minimo = INFINITO;
			
			for (int i = 0; i < grafoDeIslas.getNodos(); i++) {
				
				if(visitadas[i]) {
					for (int j = 0; j < grafoDeIslas.getNodos(); j++) {
						if(!visitadas[j] && grafoDeIslas.getArista(i, j) != -1) {
							int valor = grafoDeIslas.getArista(i, j);
							minimo = valor < minimo ? valor : minimo;
							fila = i;
							columna = j;
						}
					}
				}	
			}
				
			this.costoMinimo += minimo;				
		
			visitadas[columna] = true;
			recorridas++;
		}
	}
	
	public int getCosoMinimo() {
		return this.costoMinimo;
	}
	
	public void mostrarConexiones() {
		this.grafoDeIslas.mostrarMatriz();
	}
}
