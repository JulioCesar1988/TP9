package practicas;

import listas.ListaGenerica;
import grafos.*;

public class GrafosTest {

	/******************************
	 * Ejercic io 5 a. Implemente en JAVA una clase llamada Recorridos ubicada
	 * dentro del paquete ejercicio5 cumpliendo la siguiente especificación:
	 * dfs(Grafo<T> grafo): ListaGenerica <T> // Retorna una lista de vértices
	 * con el recorrido en profundidad del grafo r ecibido como parámetro.
	 * bfs(Grafo<T> grafo): ListaGenerica <T> // Retorna una lista de vértices
	 * con el recorrido en amplitud del grafo recibido como parámetro. b.
	 * Estimar los órdenes de ejecución de los métodos anteriores.
	 * 
	 * 
	 * 
	 * */

	public static void dfs(GrafoImplListAdy<String> g) {
		Boolean[] visitados = new Boolean[g.listaDeVertices().tamanio()];
		for (int i = 0; i < visitados.length; i++) {
			visitados[i] = false;
		}
		for (int i = 0; i < g.listaDeVertices().tamanio(); i++) {
			if (!(visitados[i])) {
				recorrrido(i, g, visitados);
			}
		}
	}

	public static void recorrrido(int posicion, GrafoImplListAdy<String> g,
			Boolean[] visitados) {
		visitados[posicion] = true;
		VerticeImplListAdy<String> v = (VerticeImplListAdy<String>) g
				.listaDeVertices().elemento(posicion + 1);
		System.out.println("Dato de vertice : " + v.dato() + " Posicion : "
				+ v.posicion() + " Cantidad de adyacentes : "
				+ g.listaDeAdyacentes(v).tamanio());
		ListaGenerica<Arista<String>> ady = g.listaDeAdyacentes(v);
		ady.comenzar();
		while (!(ady.fin())) {
			int j = ady.proximo().verticeDestino().posicion() - 1;
			recorrrido(j, g, visitados);
		}
	}

	/*****************
	 * El mét odo devolverCamino (String ciudad1, String ciudad2):
	 * ListaGenerica<String> // Retorna la lista de ciudades que se deben
	 * atravesar para ir de ciudad1 a ciudad2 en caso que se pueda llegar, si no
	 * retorna la lista vacía. (Sin tener en cuenta el combus tible).
	 * 
	 * 
	 * */

	public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2) {
		ListaGenerica<String> lista = null;

		return lista;
	}

	/****************
	 * El método devolverCaminoExceptuando (String ciudad1, String ciudad2,
	 * ListaGenerica<String> ciudades): ListaGenerica<String> // Retorna la
	 * lista de ciudades que forman un camino desde ciudad1 a ciudad2 , sin
	 * pasar por las ciudades que están contenida s en la lista ciudades pasada
	 * por parámetro, si no existe camino retorna la lista vacía. (Sin tener en
	 * cuenta el combustible).
	 * 
	 * 
	 * */

	/*****************
	 * El método caminoMasCorto(String ciudad1, String ciudad2):
	 * ListaGenerica<String> // Retorna la lista de ciudades que forman el cam
	 * ino más corto para llegar de ciudad1 a ciudad2 , si no existe camino
	 * retorna la lista vacía. (Las rutas poseen la distancia). (Sin tener en
	 * cuenta el combustible).
	 * 
	 * 
	 * */

	/**********************************
	 * El método caminoSinCargarCombustible(String ciudad1, String ciudad2, int
	 * tanqueAuto): ListaGe nerica<String> // Retorna la lista de ciudades que
	 * forman un camino para llegar de ciudad1 a ciudad2 . El auto no debe
	 * quedarse sin combustible y no puede cargar. Si no existe camino retorna
	 * la lista vacía.
	 * 
	 * */

	/************************************************************
	 * El método caminoConMenorCargaDeCombustible (String ciudad1, String
	 * ciudad2, int tanqueAuto): ListaGenerica<String> // Retorna la lista de
	 * ciudades que forman un camino para llegar de ciudad1 a ciudad2 teniendo
	 * en cuenta que el auto debe cargar la menor cantidad de veces. El auto no
	 * se debe quedar sin comb ustible en medio de una ruta, además puede
	 * completar su tanque al llegar a cualquier ciudad. Si no existe camino
	 * retorna la lista vacía.
	 * 
	 * */

	public static void main(String[] args) {
		VerticeImplListAdy<String> v1 = new VerticeImplListAdy<String>(
				"Buenos Aires");
		VerticeImplListAdy<String> v2 = new VerticeImplListAdy<String>(
				"Santiago del Estero");
		VerticeImplListAdy<String> v3 = new VerticeImplListAdy<String>(
				"Cordoba");
		VerticeImplListAdy<String> v4 = new VerticeImplListAdy<String>("Jujuy");
		VerticeImplListAdy<String> v5 = new VerticeImplListAdy<String>(
				"La pampa");
		VerticeImplListAdy<String> v6 = new VerticeImplListAdy<String>(
				"La Rioja");
		VerticeImplListAdy<String> v7 = new VerticeImplListAdy<String>(
				"Mendoza");

		GrafoImplListAdy<String> g = new GrafoImplListAdy<String>();
		g.agregarVertice(v1);
		g.agregarVertice(v2);
		g.agregarVertice(v3);
		g.agregarVertice(v4);

		g.agregarVertice(v5);
		g.agregarVertice(v6);
		g.agregarVertice(v7);

		g.conectar(v1, v2);
		g.conectar(v1, v3);
		g.conectar(v1, v4);

		g.conectar(v3, v5);
		g.conectar(v3, v6);
		g.conectar(v3, v7);

		System.out.println("Tamanio del grafo : "
				+ g.listaDeVertices().tamanio());

		dfs(g);

	}

}
