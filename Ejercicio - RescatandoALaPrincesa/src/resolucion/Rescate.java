package resolucion;

import grafo.Grafo;

public class Rescate {
	private Grafo grafo;
	private int principe;
	private int princesa;
	private int[] dragones;
	private String respuesta;

	public Rescate(Grafo grafo, int principe, int princesa, int[] dragones) {
		this.grafo = grafo;
		this.principe = principe;
		this.princesa = princesa;
		this.dragones = dragones;
	}
}
