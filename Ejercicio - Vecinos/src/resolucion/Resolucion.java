package resolucion;

import java.util.ArrayList;

import archivo.LectorDeArchivo;

public class Resolucion {
	
	private Alianza amistad;
	
	public Resolucion() {}
	
	public void leer() {
		LectorDeArchivo archivo = new LectorDeArchivo("vecinos");
		this.amistad = archivo.leer();
	}

	public void escribir() {

	}

	public void resolver() {
		this.amistad.generarAlianzas();
		ArrayList<Integer> costoPrimero = this.amistad.getCostoPrimerOp();
		
		for (Integer integer : costoPrimero) {
			System.out.print(integer + " ");
		}
	}
	
	public static void main(String[] args) {
		Resolucion resolucion = new Resolucion();
		
		resolucion.leer();
		resolucion.resolver();
	
	}
}
