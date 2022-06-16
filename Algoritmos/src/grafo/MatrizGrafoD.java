package grafo;

import java.util.Arrays;

public class MatrizGrafoD extends Grafo {
	private int[][] matriz;
	public final int INFINITO = 3000;
	
	public MatrizGrafoD(int size) {
		this.matriz = new int[size][size];
		for (int i = 0; i < size; i++) {
			Arrays.fill(this.matriz[i], INFINITO);
		}
	}

	@Override
	public int getNodos() {
		return this.matriz.length;
	}

	@Override
	public Integer getArista(int desde, int hasta) {
		return this.matriz[desde][hasta];
	}

	@Override
	public void setArista(int desde, int hasta, int costo) {
		this.matriz[desde - 1][hasta - 1] = costo;
	}
}
