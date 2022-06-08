package resolucion;

import archivo.Archivo;

public class Resolucion {
	private Electrificador electrificador;
	private Archivo archivo;
	
	public Resolucion() {
		this.archivo = new Archivo("electricidad");
	}

	public void leer() {
		this.electrificador = archivo.leerArchivo();
	}

	public void resolver() {
		this.electrificador.crearConexionesElectricas();
	}

	public void escribir() {
		archivo.escribirArchivo(this.electrificador);
	}
}
