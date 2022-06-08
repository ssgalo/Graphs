package archivo;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import resolucion.Electrificador;

public class Archivo {

	private String nombre;

	public Archivo(String nombre) {
		this.nombre = nombre;
	}

	public Electrificador leerArchivo() {
		File file = null;
		Scanner sc = null;
		Electrificador electrificador = null;

		try {
			file = new File("src/in/" + this.nombre + ".in");
			sc = new Scanner(file);

			int n = sc.nextInt(), k = sc.nextInt();
			int[] centrales = new int[k];
			int[][] matriz = new int[n][n];

			for (int i = 0; i < k; i++)
				centrales[i] = sc.nextInt();

			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					matriz[i][j] = sc.nextInt();

			electrificador = new Electrificador(matriz, centrales);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}

		return electrificador;
	}

	public void escribirArchivo(Electrificador electrificador) {
		FileWriter fw = null;
		PrintWriter pw = null;

		try {
			fw = new FileWriter("src/out/" + this.nombre + ".out");
			pw = new PrintWriter(fw);

			pw.println(electrificador.getCosto());

			for (int[] camino : electrificador.getCaminos())
				pw.println(camino[0] + " " + camino[1]);

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
