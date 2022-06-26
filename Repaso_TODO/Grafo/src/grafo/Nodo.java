package grafo;

import java.util.Objects;

public class Nodo implements Comparable<Nodo> {
	private int id;
	private int costo;
	private int grado;

	public Nodo(int id, int costo) {
		this.id = id;
		this.costo = costo;
	}

	public void setGrado(int grado) {
		this.grado = grado;
	}

	public int getId() {
		return id;
	}

	public int getCosto() {
		return costo;
	}

	public int getGrado() {
		return grado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (getClass() != obj.getClass())
			return false;

		Nodo other = (Nodo) obj;

		return id == other.id;
	}

	@Override
	public int compareTo(Nodo o) {
		return Integer.compare(this.costo, o.costo);
	}
}