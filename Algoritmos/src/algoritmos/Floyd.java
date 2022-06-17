package algoritmos;

import java.util.Arrays;

import grafo.MatrizGrafoD;

public class Floyd {
	private MatrizGrafoD grafo;
	private int[][] distancias;

	public Floyd(MatrizGrafoD grafo) {
		this.grafo = grafo;
		distancias = new int[grafo.getNodos()][grafo.getNodos()];
	}
	
	public void resolver() {
		//Copiamos la matriz
		this.llenarMatriz();
		
		for (int k = 0; k < grafo.getNodos(); k++) {
			for (int i = 0; i < grafo.getNodos(); i++) {
				for (int j = 0; j < grafo.getNodos(); j++) {
					if(i != k && j != k && i != j) {
						if(distancias[i][j] > distancias[i][k] + distancias[k][j]) {
							distancias[i][j] = distancias[i][k] + distancias[k][j];
						}
					}
				}
			}
		}
	}
	
	private void llenarMatriz() {
		for (int i = 0; i < grafo.getNodos(); i++) {
			for (int j = 0; j < grafo.getNodos(); j++) {
				if(i == j)
					distancias[i][j] = 0;
				else
					distancias[i][j] = grafo.getArista(i, j);
			}
		}
	}
	
	public int[][] getDistancias(){
		return this.distancias;
	}
	
	public static void main(String[] args) {
		MatrizGrafoD grafo = new MatrizGrafoD(3);
		
		grafo.setArista(1, 2, 8);
		grafo.setArista(1, 3, 5);
		grafo.setArista(2, 1, 3);
		grafo.setArista(3, 2, 2);
		
		Floyd algoritmoFloyd = new Floyd(grafo);
		
		algoritmoFloyd.resolver();
		
		int[][] distancias = algoritmoFloyd.getDistancias();
		
		for (int i = 0; i < distancias.length; i++) {
			System.out.println(Arrays.toString(distancias[i]));
		}
		
	}
	
}



