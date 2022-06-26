package archivo;

import java.io.File;
import java.util.Scanner;

import resolucion.Alianza;

public class LectorDeArchivo {

	private String nombre;

	public LectorDeArchivo(String nombre) {
		this.nombre = nombre;
	}

	public Alianza leer() {
		Alianza amistad = null;
		Scanner scanner = null;
		File file = null;

		try {
			file = new File("src/in/" + this.nombre + ".in");
			scanner = new Scanner(file);

			int vecinos = scanner.nextInt(), lazos = scanner.nextInt(), primerOp = scanner.nextInt(),
					segundoOp = scanner.nextInt();

			amistad = new Alianza(vecinos, lazos, primerOp, segundoOp);

			for (int i = 0; i < lazos; i++) {
				amistad.agregarAlianza(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}

		return amistad;
	}

}
