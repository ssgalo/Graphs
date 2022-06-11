package grafo;

import java.util.Arrays;

public class MatrizGrafo extends Grafo{
	
	protected int[][] grafo;
	
	public MatrizGrafo(int tam) {
		grafo = new int [tam][tam];
		
		for (int i = 0; i < grafo.length; i++) {
			for (int j = 0; j < grafo.length; j++) {
				grafo[i][j] = -1;
			}
		}
	}
	
	public void mostrarMatriz() {
		for (int i = 0; i < grafo.length; i++) {
			System.out.println(Arrays.toString(grafo[i]));
		}
	}
	
	@Override
	public void setArista(int desde, int hasta, int costo) {
		this.grafo[desde][hasta] = costo;
		this.grafo[hasta][desde] = costo;
	}

	@Override
	public int getNodos() {
		return grafo.length;
	}

	@Override
	public int getArista(int desde, int hasta) {
		return grafo[desde][hasta];
	}
}
