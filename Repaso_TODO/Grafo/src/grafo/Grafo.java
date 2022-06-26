package grafo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Grafo {
	private int nodos;
	private ArrayList<LinkedList<Nodo>> lista = new ArrayList<LinkedList<Nodo>>();
	private ArrayList<Arista> aristas = new ArrayList<Arista>();
	private ArrayList<Nodo> mst = new ArrayList<Nodo>();
	private ArrayList<int[]> solucionElectrificada = new ArrayList<int[]>();
	private int[] referentes;

	public Grafo(int nodos) {
		this.nodos = nodos;
		this.referentes = new int[nodos];

		for (int i = 0; i < nodos; i++) {
			this.lista.add(new LinkedList<Nodo>());
			this.referentes[i] = i;
		}
	}

	public void agregarAristaSimetrica(int nodoA, int nodoB, int peso) {
		Nodo adA = new Nodo(nodoB, peso), adB = new Nodo(nodoA, peso);

		this.lista.get(nodoA).add(adA);
		this.lista.get(nodoB).add(adB);
	}

	public void agregarArista(int nodoA, int nodoB, int peso) {
		this.aristas.add(new Arista(nodoA, nodoB, peso));
	}

	public int primCubico(int raiz) {
		int costo = 0, nodosVisitados = 0;
		boolean[] visitados = new boolean[this.nodos];

		visitados[0] = true;
		visitados[3] = true;
		nodosVisitados = 2;
		this.mst.add(new Nodo(0, 0));
		this.mst.add(new Nodo(3, 0));

		while (nodosVisitados < this.nodos) {
			int minimo = (int) 10e9, elegido = -1, u = -1;

			for (Nodo referencia : this.mst) {
				for (Nodo adyacente : this.lista.get(referencia.getId())) {
					if (!visitados[adyacente.getId()]) {
						if (adyacente.getCosto() < minimo) {
							minimo = adyacente.getCosto();
							elegido = adyacente.getId();
							u = referencia.getId();
						}
					}
				}
			}

			if (elegido != -1) {
				int[] solucion = { u + 1, elegido + 1 };
				Nodo nodo = new Nodo(elegido, minimo);

				this.mst.add(nodo);
				this.solucionElectrificada.add(solucion);
				visitados[nodo.getId()] = true;
				costo += minimo;
			}

			nodosVisitados++;
		}

		return costo;
	}

	private int menorNodo(int[] costos, boolean[] visitados) {
		int min = (int) 10e9, indice = -1;

		for (int i = 0; i < this.nodos; i++) {
			if (!visitados[i] && costos[i] < min) {
				min = costos[i];
				indice = i;
			}
		}

		return indice;
	}

	public int primCuadratico(int raiz) {
		int costo = 0;
		int[] costos = new int[this.nodos], antecesores = new int[this.nodos];
		boolean[] visitados = new boolean[this.nodos];

		for (int i = 0; i < this.nodos; i++)
			costos[i] = (int) 10e9;

		costos[0] = 0;
		costos[3] = 0;
		antecesores[0] = -1;
		antecesores[3] = -1;

		for (int i = 0; i < this.nodos; i++) {
			int u = this.menorNodo(costos, visitados);
			int[] solucion = new int[2];

			if (antecesores[u] != -1) {
				solucion[0] = u + 1;
				solucion[1] = antecesores[u] + 1;
				this.solucionElectrificada.add(solucion);
			}

			visitados[u] = true;
			this.mst.add(new Nodo(u, costos[u]));
			costo += costos[u];

			for (Nodo adyacente : this.lista.get(u)) {
				int v = adyacente.getId();
				if (!visitados[v])
					if (costos[v] > adyacente.getCosto()) {
						costos[v] = adyacente.getCosto();
						antecesores[v] = u;
					}
			}
		}

		return costo;
	}

	private int find(int nodo) {
		if (this.referentes[nodo] != nodo)
			return this.find(this.referentes[nodo]);
		else
			return nodo;
	}

	private boolean union(int nodoA, int nodoB) {
		int a = this.find(nodoA), b = this.find(nodoB);
		boolean union = a != b;

		if (union)
			this.referentes[b] = a;

		return union;
	}

	// O(E log V)
	public int kruskal() {
		int aristasVisitadas = 0, indice = 0, costo = 0;
		ArrayList<Arista> copia = new ArrayList<Arista>(this.aristas);

		Collections.sort(copia);

		while (indice < copia.size() && aristasVisitadas < this.nodos) {
			Arista arista = copia.get(indice);

			if (union(arista.getNodoA(), arista.getNodoB())) {
				costo += arista.getPeso();
				mst.add(new Nodo(arista.getNodoA(), arista.getPeso()));
				mst.add(new Nodo(arista.getNodoB(), arista.getPeso()));
				aristasVisitadas++;
			}

			indice++;
		}

		return costo;
	}

	public int[] dijkstraCuadratico(int raiz) {
		int[] costos = new int[this.nodos], antecesores = new int[this.nodos];
		boolean[] visitados = new boolean[this.nodos];

		for (int i = 0; i < this.nodos; i++) {
			costos[i] = (int) 10e9;
			antecesores[i] = -1;
		}

		for (Nodo adyacente : this.lista.get(raiz))
			costos[adyacente.getId()] = adyacente.getCosto();

		costos[raiz] = 0;
		visitados[raiz] = true;

		for (int i = 0; i < this.nodos - 1; i++) {
			int u = this.menorNodo(costos, visitados);

			visitados[u] = true;

			for (Nodo adyacente : this.lista.get(u)) {
				int v = adyacente.getId();

				if (!visitados[v] && costos[v] > costos[u] + adyacente.getCosto()) {
					costos[v] = costos[u] + adyacente.getCosto();
					antecesores[v] = u;
				}
			}
		}

		return costos;
	}

	public int[] dijkstraELogV(int raiz) {
		int[] costos = new int[this.nodos], antecesores = new int[this.nodos];
		boolean[] visitados = new boolean[this.nodos];
		PriorityQueue<Nodo> pq = new PriorityQueue<Nodo>();

		for (int i = 0; i < this.nodos; i++) {
			costos[i] = (int) 10e9;
			antecesores[i] = -1;
		}

		costos[raiz] = 0;
		pq.offer(new Nodo(raiz, costos[raiz]));

		while (!pq.isEmpty()) {
			Nodo u = pq.poll();

			visitados[u.getId()] = true;

			for (Nodo adyacente : this.lista.get(u.getId())) {
				int v = adyacente.getId();

				if (!visitados[v] && costos[v] > costos[u.getId()] + adyacente.getCosto()) {
					costos[v] = costos[u.getId()] + adyacente.getCosto();
					antecesores[v] = u.getId();
					pq.add(new Nodo(v, costos[v]));
				}
			}
		}

		return costos;
	}

	public void bfs(int raiz) {
		boolean[] visitados = new boolean[this.nodos];
		Queue<Nodo> q = new LinkedList<Nodo>();

		q.add(new Nodo(raiz, 0));

		while (!q.isEmpty()) {
			Nodo u = q.poll();

			if (!visitados[u.getId()]) {
				System.out.println(u.getId() + 1);
				visitados[u.getId()] = true;

				for (Nodo adyacente : this.lista.get(u.getId())) {
					int v = adyacente.getId();

					if (!visitados[v])
						q.offer(new Nodo(v, 0));
				}
			}
		}
	}

	public void dfs(int raiz) {
		boolean[] visitados = new boolean[this.nodos];
		Stack<Nodo> q = new Stack<Nodo>();

		q.add(new Nodo(raiz, 0));

		while (!q.isEmpty()) {
			Nodo u = q.pop();

			if (!visitados[u.getId()]) {
				System.out.println(u.getId() + 1);

				visitados[u.getId()] = true;

				for (Nodo adyacente : this.lista.get(u.getId())) {
					int v = adyacente.getId();

					if (!visitados[v])
						q.add(new Nodo(v, 0));
				}
			}
		}
	}

	public int[][] floyd() {
		int[][] aux = new int[this.nodos][this.nodos];

		for (int i = 0; i < this.nodos; i++) {
			for (int j = 0; j < this.nodos; j++)
				if (i != j)
					aux[i][j] = (int) 10e6;

			for (Nodo adyacencia : this.lista.get(i))
				aux[i][adyacencia.getId()] = adyacencia.getCosto();
		}

		for (int k = 0; k < this.nodos; k++) {
			for (int i = 0; i < this.nodos; i++)
				if (i != k)
					for (int j = 0; j < this.nodos; j++)
						if (i != j && j != k)
							if (aux[i][k] + aux[k][j] < aux[i][j])
								aux[i][j] = aux[i][k] + aux[k][j];
		}

		return aux;
	}

	public boolean[][] warshall() {
		boolean[][] aux = new boolean[this.nodos][this.nodos];

		for (int i = 0; i < this.nodos; i++) {
			for (int j = 0; j < this.nodos; j++)
				aux[i][j] = false;

			for (Nodo adyacencia : this.lista.get(i))
				aux[i][adyacencia.getId()] = true;
		}

		for (int k = 0; k < this.nodos; k++) {
			for (int i = 0; i < this.nodos; i++)
				if (i != k)
					for (int j = 0; j < this.nodos; j++)
						if (i != j && j != k)
							aux[i][j] = aux[i][j] || (aux[i][k] && aux[k][j]);
		}

		return aux;
	}

	private boolean adyacencia(int nodoA, Nodo nodoB) {
		return this.lista.get(nodoA).contains(nodoB);
	}

	public int welshPowell() {
		int indice = 0;
		HashMap<Integer, ArrayList<Nodo>> colores = new HashMap<Integer, ArrayList<Nodo>>();
		ArrayList<Nodo> grados = new ArrayList<Nodo>();

		for (LinkedList<Nodo> adyacentes : this.lista) {
			Nodo nodo = new Nodo(indice, 0);

			nodo.setGrado(adyacentes.size());
			grados.add(nodo);
			indice++;
		}

		Collections.sort(grados, new Comparator<Nodo>() {
			@Override
			public int compare(Nodo nodoA, Nodo nodoB) {
				return nodoB.getGrado() - nodoA.getGrado();
			}
		});

		ArrayList<Nodo> base = new ArrayList<Nodo>();

		base.add(grados.get(0));
		colores.put(1, base);

		for (int i = 1; i < this.nodos; i++) {
			Nodo nodo = grados.get(i);
			int ultimoColor = 0;
			boolean adyacente = false, coloreo = false;

			for (int j = 1; j <= colores.keySet().size() && !coloreo; j++) {
				for (int k = 0; k < colores.get(j).size() && !adyacente; k++)
					adyacente = this.adyacencia(nodo.getId(), colores.get(j).get(k));

				if (!adyacente)
					coloreo = true;

				ultimoColor = j;
			}

			if (coloreo) {
				colores.get(ultimoColor).add(nodo);
				colores.put(ultimoColor, colores.get(ultimoColor));
			} else {
				ArrayList<Nodo> nuevoColor = new ArrayList<Nodo>();

				nuevoColor.add(nodo);
				colores.put(ultimoColor + 1, nuevoColor);
			}
		}

		return colores.keySet().size();
	}

	public int welshPowell2() {
		int indice = 0, cantidadPintados = 0;
		int[] nodosColoreados = new int[this.nodos];
		ArrayList<Nodo> grados = new ArrayList<Nodo>();

		for (LinkedList<Nodo> adyacentes : this.lista) {
			Nodo nodo = new Nodo(indice, 0);

			nodo.setGrado(adyacentes.size());
			grados.add(nodo);
			indice++;
		}

		Collections.sort(grados, new Comparator<Nodo>() {
			@Override
			public int compare(Nodo nodoA, Nodo nodoB) {
				return nodoB.getGrado() - nodoA.getGrado();
			}
		});

		int colorActual = 1;

		while (cantidadPintados < this.nodos) {
			for (Nodo nodo : grados) {
				boolean tieneElColor = false;

				for (int i = 0; i < this.lista.get(nodo.getId()).size() && !tieneElColor; i++) {
					Nodo adyacente = this.lista.get(nodo.getId()).get(i);

					if (nodosColoreados[adyacente.getId()] == colorActual)
						tieneElColor = true;
				}

				if (!tieneElColor) {
					nodosColoreados[nodo.getId()] = colorActual;
					cantidadPintados++;
				}
			}

			colorActual++;
		}

		return colorActual - 1;
	}

	public int getNodos() {
		return nodos;
	}

	public ArrayList<LinkedList<Nodo>> getLista() {
		return lista;
	}

	public ArrayList<Nodo> getMst() {
		return mst;
	}

	public ArrayList<int[]> getSolucionE() {
		return this.solucionElectrificada;
	}
}