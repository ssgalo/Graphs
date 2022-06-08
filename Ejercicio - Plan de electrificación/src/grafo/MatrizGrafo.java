package grafo;

public class MatrizGrafo extends Grafo {
	private int[][] matriz;

	public MatrizGrafo(int[][] matrizDeAdyacencia) {
		this.matriz = matrizDeAdyacencia;
	}

	public int getNodos() {
		return this.matriz.length;
	}

	public int getArista(int desde, int hasta) {
		return this.matriz[desde][hasta];
	}
}
