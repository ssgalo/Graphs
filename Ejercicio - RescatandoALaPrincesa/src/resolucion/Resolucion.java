package resolucion;

import archivo.EscritorDeArchivo;
import archivo.LectorDeArchivo;

public class Resolucion {
	private Rescate rescate;
	
	public static void main(String[] args) {
		Resolucion main = new Resolucion();

		main.leer();
		main.resolver();
		main.escribir();
	}

	public void leer() {
		LectorDeArchivo lector = new LectorDeArchivo("caminoRectoAtajosAtascados");

		this.rescate = lector.leerArchivo();
	}

	public void resolver() {
		
	}

	public void escribir() {
		EscritorDeArchivo escritor = new EscritorDeArchivo("caminoRectoAtajosAtascados");

		
	}
}
