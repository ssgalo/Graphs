package archivo;

import java.io.FileWriter;
import java.io.PrintWriter;

public class EscritorDeArchivo {
	private String nombre;

	public EscritorDeArchivo(String nombre) {
		this.nombre = nombre;
	}

	public void escribirArchivo(String respuesta) {
		FileWriter fw = null;
		PrintWriter pw = null;

		try {
			fw = new FileWriter("src/out/" + this.nombre + ".out");
			pw = new PrintWriter(fw);

			pw.println(respuesta);
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
