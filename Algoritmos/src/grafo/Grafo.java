package grafo;

public abstract class Grafo {
	
	public abstract void setArista(int desde, int hasta, int costo);
	public abstract int getNodos();
	public abstract Integer getArista(int desde, int hasta);

}
