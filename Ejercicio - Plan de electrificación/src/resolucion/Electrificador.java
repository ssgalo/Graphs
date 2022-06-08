package resolucion;

import java.util.ArrayList;

import grafo.MatrizGrafo;

public class Electrificador {
	private MatrizGrafo grafo;
	private int[] centrales;
	private int costo;
	private ArrayList<int[]> caminos;

	public Electrificador(int[][] matriz, int[] centrales) {
		this.grafo = new MatrizGrafo(matriz);
		this.centrales = centrales;
		this.caminos = new ArrayList<int[]>();
	}

	public void crearConexionesElectricas() {
		boolean[] s = new boolean[this.grafo.getNodos()];

		for (int i = 0; i < this.centrales.length; i++)
			s[this.centrales[i] - 1] = true;

		int electrificadas = this.centrales.length;

		while (electrificadas < this.grafo.getNodos()) {
			int fila = 0, columna = 0, minimo = (int) 10e9;

			for (int i = 1; i < this.grafo.getNodos(); i++) {
				if (s[i]) {
					for (int j = 0; j < i; j++) {
						if (!s[j]) {
							int peso = this.grafo.getArista(i, j);

							minimo = peso < minimo ? peso : minimo;
							fila = i;
							columna = j;
						}
					}
				}
			}

			int[] camino = { columna + 1, fila + 1 };

			s[columna] = true;
			electrificadas++;
			this.caminos.add(camino);
			this.costo += minimo;
		}
	}

	public int getCosto() {
		return costo;
	}

	public ArrayList<int[]> getCaminos() {
		return caminos;
	}

}	
