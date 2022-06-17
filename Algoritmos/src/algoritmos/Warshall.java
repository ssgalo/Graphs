package algoritmos;

import java.util.Arrays;

import grafo.MatrizGrafoD;

public class Warshall {
	private MatrizGrafoD grafo;
	private boolean[][] mct;

	public Warshall(MatrizGrafoD grafo) {
		this.grafo = grafo;
		mct = new boolean[grafo.getNodos()][grafo.getNodos()];
	}

	public void resolver() {

		// Llenamos la matriz
		this.llenarMatriz();

		for (int k = 0; k < grafo.getNodos(); k++) {

			for (int i = 0; i < grafo.getNodos(); i++) {
				for (int j = 0; j < grafo.getNodos(); j++) {
					if (i != k && j != k && i != j) {
						mct[i][j] = mct[i][j] || (mct[i][k] && mct[k][j]);
					}
				}
			}

		}

	}
	
	private void llenarMatriz() {
		for (int i = 0; i < grafo.getNodos(); i++) {
			for (int j = 0; j < grafo.getNodos(); j++) {
				if (grafo.getArista(i, j) != grafo.INFINITO) {
					mct[i][j] = true;
				}
			}
		}
	}
	
	public boolean[][] getMct(){
		return this.mct;
	}
	
	public static void main(String[] args) {
		MatrizGrafoD grafo = new MatrizGrafoD(3);
		
		grafo.setArista(1, 2, 0);
		grafo.setArista(1, 3, 0);
		grafo.setArista(2, 1, 0);
		grafo.setArista(3, 2, 0);
		
		Warshall algoritmoWarshall = new Warshall(grafo);
	
		algoritmoWarshall.resolver();
		boolean[][] mct = algoritmoWarshall.getMct();
		
		for (int i = 0; i < mct.length; i++) {
			System.out.println(Arrays.toString(mct[i]));
		}
	}
	
}
