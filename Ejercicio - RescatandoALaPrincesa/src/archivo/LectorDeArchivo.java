package archivo;

import java.io.File;
import java.util.Scanner;

import grafo.Grafo;
import resolucion.Rescate;


public class LectorDeArchivo {
	private String nombre;

	public LectorDeArchivo(String nombre) {
		this.nombre = nombre;
	}

	public Rescate leerArchivo() {
		File file = null;
		Scanner sc = null;
		Rescate rescate = null;

		try {
			file = new File("src/in/" + this.nombre + ".in");
			sc = new Scanner(file);

			int cantClaros = sc.nextInt(), cantSenderos = sc.nextInt(), cantDragones = sc.nextInt(),
					princesa = sc.nextInt(), principe = sc.nextInt();
			int[] dragones = new int[cantDragones];
			Grafo grafo = new Grafo(cantClaros);

			for (int i = 0; i < cantDragones; i++)
				dragones[i] = sc.nextInt();

			for (int i = 0; i < cantSenderos; i++)
				grafo.agregarArista(sc.nextInt(), sc.nextInt(), sc.nextInt());

			rescate = new Rescate(grafo, principe, princesa, dragones);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}

		return rescate;
	}
}
