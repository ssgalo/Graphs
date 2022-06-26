package grafo;

import java.util.ArrayList;

public class App {
	public static void main(String[] args) {
		Grafo grafo = new Grafo(5);
		Grafo grafoElectrificada = new Grafo(4);
		Grafo grafoARecorrer = new Grafo(5);

		grafo.agregarArista(1 - 1, 2 - 1, 4);
		grafo.agregarArista(1 - 1, 5 - 1, 7);
		grafo.agregarArista(1 - 1, 3 - 1, 1);
		grafo.agregarArista(2 - 1, 4 - 1, 3);
		grafo.agregarArista(2 - 1, 3 - 1, 2);
		grafo.agregarArista(3 - 1, 4 - 1, 7);
		grafo.agregarArista(4 - 1, 5 - 1, 2);

		grafo.agregarAristaSimetrica(1 - 1, 2 - 1, 4);
		grafo.agregarAristaSimetrica(1 - 1, 5 - 1, 7);
		grafo.agregarAristaSimetrica(1 - 1, 3 - 1, 1);
		grafo.agregarAristaSimetrica(2 - 1, 4 - 1, 3);
		grafo.agregarAristaSimetrica(2 - 1, 3 - 1, 2);
		grafo.agregarAristaSimetrica(3 - 1, 4 - 1, 7);
		grafo.agregarAristaSimetrica(4 - 1, 5 - 1, 2);

		grafoElectrificada.agregarAristaSimetrica(1 - 1, 2 - 1, 2);
		grafoElectrificada.agregarAristaSimetrica(1 - 1, 3 - 1, 4);
		grafoElectrificada.agregarAristaSimetrica(1 - 1, 4 - 1, 3);
		grafoElectrificada.agregarAristaSimetrica(2 - 1, 3 - 1, 5);
		grafoElectrificada.agregarAristaSimetrica(2 - 1, 4 - 1, 2);
		grafoElectrificada.agregarAristaSimetrica(3 - 1, 4 - 1, 1);

		grafoARecorrer.agregarAristaSimetrica(1 - 1, 2 - 1, 0);
		grafoARecorrer.agregarAristaSimetrica(1 - 1, 3 - 1, 0);
		grafoARecorrer.agregarAristaSimetrica(1 - 1, 4 - 1, 0);
		grafoARecorrer.agregarAristaSimetrica(2 - 1, 3 - 1, 0);
		grafoARecorrer.agregarAristaSimetrica(2 - 1, 4 - 1, 0);
		grafoARecorrer.agregarAristaSimetrica(4 - 1, 5 - 1, 0);

		int costo = grafo.kruskal();
		ArrayList<Nodo> mst = grafo.getMst();

		System.out.println("Kruskal");
		System.out.println();
		System.out.println(costo);

		System.out.println();

		for (Nodo nodo : mst)
			System.out.println(nodo.getId() + 1);

		System.out.println();

		grafoARecorrer.dfs(1 - 1);

//		int costo = grafo.primCuadratico(1 - 1);
//		
//		System.out.println("Prim cuadratico");
//		System.out.println(costo);
//		System.out.println();
//		
//		ArrayList<Nodo>mst = grafo.getMst();
//		
//		for (Nodo nodo : mst)
//			System.out.println(nodo.getId() + 1);

	}
}