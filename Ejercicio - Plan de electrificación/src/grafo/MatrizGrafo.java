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

	@Override
	public void setArista(int desde, int hasta, int costo) {
		this.matriz[desde][hasta] = costo;
		this.matriz[hasta][desde] = costo;
	}
}
