package resolucion;

import archivo.Archivo;

public class Resolucion {
	private Archivo archivo;
	private Ciudad ciudad;
	
	public Resolucion() {
		archivo = new Archivo("metro");
	}
	
	public void leer() {
		this.ciudad = archivo.leerArchivo();
	}
	
	public void escribir() {
		this.archivo.escribirArchivo(this.ciudad);
	}
	
	public void resolver() {
		this.ciudad.calcularPuentesMinimos();
	}
	
	public int getCostoMinimo() {
		return this.ciudad.getCosoMinimo();
	}
}
