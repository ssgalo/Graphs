package coloreo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import grafo.MatrizGrafoND;

public class Coloreo {

	// Lista que tiene cada nodo con sus respectivos colores
	private int[] nodosColoreados;

	// Representa a los nodos, ya sean ordenados creciente, decreciente o al azar.
	private ArrayList<Nodo> nodos;
	private MatrizGrafoND grafo;

	public Coloreo(MatrizGrafoND grafo) {
		this.nodosColoreados = new int[grafo.getNodos()];
		this.nodos = new ArrayList<Nodo>();
		this.grafo = grafo;
	}

	// Retorna el numero cromático
	public int colorearPorWelshPowell() {
		
		this.ordenarNodosDecreciente();
//		5, 8, 4, 9, 6, 3, 7, 1, 0, 2
//		this.nodos.add(new Nodo(5, 5));
//		this.nodos.add(new Nodo(8, 5));
//		this.nodos.add(new Nodo(4, 5));
//		this.nodos.add(new Nodo(9, 5));
//		this.nodos.add(new Nodo(6, 5));
//		this.nodos.add(new Nodo(3, 5));
//		this.nodos.add(new Nodo(7, 5));
//		this.nodos.add(new Nodo(1, 5));
//		this.nodos.add(new Nodo(0, 5));
//		this.nodos.add(new Nodo(2, 5));
		
		int colorActual = 1;
		int cantPintados = 0;
		
		while (cantPintados < grafo.getNodos()) {
			for (Nodo nodoActual : nodos) {
				boolean tieneElColor = false;
				for (int i = 0; i < grafo.getNodos() && !tieneElColor; i++) {
					if (i != nodoActual.id && grafo.getArista(nodoActual.id, i) != -1
							&& nodosColoreados[i] == colorActual) {
						tieneElColor = true;
					}
				}

				if (!tieneElColor && nodosColoreados[nodoActual.id] == 0) {
					nodosColoreados[nodoActual.id] = colorActual;;
					cantPintados++;
				}
			}
			colorActual++;
		}

		return colorActual - 1;
	}
	
	public void mostrarNodosDecreciente() {
		for (Nodo nodo : nodos) {
			System.out.println(nodo.id);
		}
	}
	
	private void ordenarNodosDecreciente() {

		int grado;
		for (int i = 0; i < grafo.getNodos(); i++) {
			grado = 0;
			for (int j = 0; j < grafo.getNodos(); j++) {
				if (grafo.getArista(i, j) != -1) {
					grado++;
				}
			}

			this.nodos.add(new Nodo(i, grado));
		}

		Collections.sort(this.nodos, Collections.reverseOrder());
	}

	private void desordenar(ArrayList<Nodo> lista) {
		int indice1 = (int) Math.floor(Math.random() * lista.size());
		int indice2 = (int) Math.floor(Math.random() * lista.size());

		Collections.swap(lista, indice1, indice2);
	}
	
	public int[] getNodosColoreados() {
		return this.nodosColoreados;
	}
	
	public static void main(String[] args) {
		MatrizGrafoND grafo = new MatrizGrafoND(10);
		
		grafo.setArista(1, 2, 0);
		grafo.setArista(1, 6, 0);
		grafo.setArista(2, 5, 0);
		grafo.setArista(3, 6, 0);
		grafo.setArista(3, 7, 0);
		grafo.setArista(4, 5, 0);
		grafo.setArista(4, 8, 0);
		grafo.setArista(5, 9, 0);
		grafo.setArista(6, 7, 0);	
		grafo.setArista(6, 10, 0);	
		grafo.setArista(6, 9, 0);	
		grafo.setArista(7, 10, 0);	
		grafo.setArista(8, 9, 0);	
		grafo.setArista(9, 10, 0);	
		
		Coloreo coloreo = new Coloreo(grafo);
		int numeroCromatico = coloreo.colorearPorWelshPowell();
		System.out.println(numeroCromatico);
		
		System.out.println(Arrays.toString(coloreo.getNodosColoreados()));
	}
}
