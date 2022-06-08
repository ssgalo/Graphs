package archivo;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import resolucion.Ciudad;

public class Archivo {
	private String nombre;

	public Archivo(String nombre) {
		this.nombre = nombre;
	}

	public Ciudad leerArchivo() {
		File file = null;
		Scanner sc = null;
		Ciudad ciudad = null;
		try {
			file = new File("src/in/" + this.nombre + ".in");
			sc = new Scanner(file);
			int islas = sc.nextInt();
			int tuneles = sc.nextInt();
			int puentes = sc.nextInt();
			
			ciudad = new Ciudad(islas, tuneles, puentes);
			
			for (int i = 0; i < tuneles; i++) {
				ciudad.agregarTunel(sc.nextInt() - 1, sc.nextInt() - 1);
			}		
			
			for (int i = 0; i < puentes; i++) {
				ciudad.agregarPuente(sc.nextInt() - 1, sc.nextInt() - 1);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
		
		return ciudad;
	}

	public void escribirArchivo(Ciudad ciudad) {
		FileWriter fw = null;
		PrintWriter pw = null;

		try {
			fw = new FileWriter("src/out/" + this.nombre + ".out");
			pw = new PrintWriter(fw);
			
			pw.println(ciudad.getCosoMinimo());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
