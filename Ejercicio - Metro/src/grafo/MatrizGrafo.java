package grafo;

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
	
	@Override
	public void setArista(int desde, int hasta, int costo) {
		grafo[desde][hasta] = costo;
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