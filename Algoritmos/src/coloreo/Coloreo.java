package coloreo;

import java.util.ArrayList;
import java.util.Collections;

import grafo.MatrizGrafoND;

public class Coloreo {

	//Lista que tiene los colores, representados por enteros
	private ArrayList<Integer> colores;
	
	private ArrayList<Nodo> nodosColoreados;
	private MatrizGrafoND grafo;
	
	public Coloreo(MatrizGrafoND grafo) {
		this.colores = new ArrayList<Integer>();
		this.nodosColoreados = new ArrayList<Nodo>();
		this.grafo = grafo;
	}
	
	//Retorna el numero cromático
	public int colorearPorWelshPowell() {
		
		this.ordenarNodosDecreciente();
		boolean[] coloreados = new boolean[grafo.getNodos()];
		
		int cantColoreados = 0;
		int colorActual = 1;
		
		for (Nodo nodoActual : nodosColoreados) {
			
			for (int i = 0; i < grafo.getNodos(); i++) {
				//Pensar como hacer para identificar que color tiene cada nodo.
			}
			
		}
		
		return 0;
	}
	
	private void ordenarNodosDecreciente(){
		
		int grado;
		for (int i = 0; i < grafo.getNodos(); i++) {
			grado = 0;
			for (int j = 0; j < grafo.getNodos(); j++) {
				if(grafo.getArista(i, j) != -1) {
					grado++;
				}
			}
			
			this.nodosColoreados.add(new Nodo(i, grado));
		}
		
		Collections.sort(this.nodosColoreados, Collections.reverseOrder());
	}
	
	private void desordenar(ArrayList<Nodo> lista) {
		int indice1 = (int) Math.floor(Math.random()*lista.size());
		int indice2 = (int) Math.floor(Math.random()*lista.size());
		
		Collections.swap(lista, indice1, indice2);
	}
}
