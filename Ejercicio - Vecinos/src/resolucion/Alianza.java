package resolucion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

import grafo.MatrizGrafoND;
import grafo.Nodo;

public class Alianza {
	
	private int cantidadVecinos;
	private int cantidadLazos;
	private int primerOponente;
	private int segundoOponente;
	
	private ArrayList<Integer> costosPrimerOponente;
	private ArrayList<Integer> costosSegundoOponente;
	
	private int aliadosDelPrimero;
	private int aliadosDelSegundo;
	
	private MatrizGrafoND grafo;
	
	public Alianza(int vecinos, int lazos, int pOp, int sOp) {
		this.cantidadVecinos = vecinos;
		this.cantidadLazos = lazos;
		this.primerOponente = pOp;
		this.segundoOponente = sOp;
		
		grafo = new MatrizGrafoND(vecinos);
	}
	
	public void agregarAlianza(int desde, int hasta, int costo) {
		grafo.setArista(desde, hasta, costo);
	}
	
	private ArrayList<Integer> generarAlianzas(int primero) {
		
		//En base a un algoritmo de Dijkstra modificado
		
		boolean[] visitados = new boolean[cantidadVecinos];
		int[] predecesores = new int[cantidadVecinos];
		ArrayList<Integer> costos = new ArrayList<Integer>();
		PriorityQueue<Nodo> pq = new PriorityQueue<Nodo>(Collections.reverseOrder());
		
		for(int i = 0; i < cantidadVecinos; i++) {
			costos.add(grafo.INFINITO);
			predecesores[i] = primero;
		}
		
		costos.set(primero, 0);
		visitados[primero] = true;
		pq.add(new Nodo(primero, 0));
		
		int cantVisitados = 1;
		
		while(!pq.isEmpty()) {
			
			Nodo actual = pq.remove();
			visitados[actual.getID()] = true;
			
			for (int i = 0; i < cantidadVecinos; i++) {
				
				if(grafo.getArista(actual.getID(), i) != grafo.INFINITO && !visitados[i]) {
					int valor = grafo.getArista(actual.getID(), i);
					int costo = costos.get(actual.getID());
					int menor;
					//asigno el menor entre la arista actual y el ultimo costo del nodo
					if(costo != grafo.INFINITO) {
						menor = valor < costo ? valor : costo;
					} else {
						menor = valor;
					}
					
					int mayor;
					
					if(costos.get(i) != grafo.INFINITO) {
						mayor =  costos.get(i) > menor ? costos.get(i) : menor;
					} else {
						mayor = menor;
					}
					
					costos.set(i, mayor);
					pq.add(new Nodo(i, mayor));
					predecesores[i] = actual.getID();
				}
				
			}
		}
		
		return costos;
	}
	
	public void generarAlianzas() {
		
		this.costosPrimerOponente = new ArrayList<Integer>();
		this.costosSegundoOponente = new ArrayList<Integer>();
		
		this.costosPrimerOponente = this.generarAlianzas(primerOponente);
		this.costosSegundoOponente = this.generarAlianzas(segundoOponente);	
		
		for(int i = 0; i < cantidadVecinos; i++) {
			int costoPrimero = this.costosPrimerOponente.get(i);
			int costoSegundo = this.costosSegundoOponente.get(i);
			
			if(costoPrimero != grafo.INFINITO && costoSegundo == grafo.INFINITO) {
				aliadosDelPrimero++;
			} else if (costoSegundo != grafo.INFINITO && costoPrimero == grafo.INFINITO) {
				aliadosDelSegundo++;
			} else if(costoPrimero > costoSegundo) {
				aliadosDelPrimero++;
			} else if(costoSegundo > costoPrimero) {
				aliadosDelSegundo++;
			}
		}
	}
	
	public int getAliadosDelPrimero() {
		return this.aliadosDelPrimero;
	}
	
	public int getAliadosDelSegundo() {
		return this.aliadosDelSegundo;
	}
	
	public ArrayList<Integer> getCostoPrimerOp(){
		return this.costosPrimerOponente;
	}
	
	public ArrayList<Integer> getCostoSegundoOp(){
		return this.costosSegundoOponente;
	}
}
