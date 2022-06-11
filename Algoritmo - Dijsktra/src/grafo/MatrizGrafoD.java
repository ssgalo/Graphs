package grafo;

public class MatrizGrafoD extends Grafo {
	private int[][] matriz;

	public MatrizGrafoD(int size) {
		this.matriz = new int[size][size];
	}

	@Override
	public int getNodos() {
		return this.matriz.length;
	}

	@Override
	public int getArista(int desde, int hasta) {
		return this.matriz[desde][hasta];
	}

	@Override
	public void setArista(int desde, int hasta, int costo) {
		this.matriz[desde][hasta] = costo;
	}
}
