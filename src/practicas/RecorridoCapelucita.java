package practicas;

import listas.ListaEnlazadaGenerica;
import listas.ListaGenerica;
import grafos.Arista;
import grafos.AristaImpl;
import grafos.GrafoImplListAdy;
import grafos.VerticeImplListAdy;

public class RecorridoCapelucita {

	private static GrafoImplListAdy<String> bosque;

	public static void dfs() {
		boolean[] marcados = new boolean[bosque.listaDeVertices().tamanio()];
		for (int i = 0; i < marcados.length; i++) {
			marcados[i] = false;
		}

		for (int i = 0; i < bosque.listaDeVertices().tamanio(); i++) {
			if (!(marcados[i])) {
				dfs(i, marcados);

			}

		}

	}

	public static void dfs(int posicion, boolean[] marcados) {
		marcados[posicion] = true;
		VerticeImplListAdy<String> v = (VerticeImplListAdy<String>) bosque
				.listaDeVertices().elemento(posicion + 1);

		System.out.println("Vertice : " + v.dato());

		ListaGenerica<Arista<String>> ady = bosque.listaDeAdyacentes(v);
		ady.comenzar();

		while (!(ady.fin())) {
			int j = ady.proximo().verticeDestino().posicion() - 1;
			dfs(j, marcados);

		}

	}

	public static void main(String[] args) {

		bosque = new GrafoImplListAdy<String>();
		VerticeImplListAdy<String> v1 = new VerticeImplListAdy<String>(
				"Casa de Capelucita");
		VerticeImplListAdy<String> v2 = new VerticeImplListAdy<String>(
				"Claro 3");
		VerticeImplListAdy<String> v3 = new VerticeImplListAdy<String>(
				"Claro 1");
		VerticeImplListAdy<String> v4 = new VerticeImplListAdy<String>(
				"Claro 2");

		VerticeImplListAdy<String> v5 = new VerticeImplListAdy<String>(
				"Claro 5");
		VerticeImplListAdy<String> v6 = new VerticeImplListAdy<String>(
				"Claro 4");
		VerticeImplListAdy<String> v7 = new VerticeImplListAdy<String>(
				"Casa de la Abuela");

		// Agregamos los vertices al grafo, para despues poder hacer las
		// conexiones.
		bosque.agregarVertice(v1);
		bosque.agregarVertice(v2);
		bosque.agregarVertice(v3);
		bosque.agregarVertice(v4);
		bosque.agregarVertice(v5);
		bosque.agregarVertice(v6);
		bosque.agregarVertice(v7);

		// Conexion casa de capelcuita.
		bosque.conectar(v1, v2, 4);
		bosque.conectar(v1, v3, 3);
		bosque.conectar(v1, v4, 4);

		// conexion de claro 3.
		bosque.conectar(v2, v5, 15);

		// conexion de claro 1
		bosque.conectar(v3, v5, 3);
		bosque.conectar(v3, v4, 4);

		// conexion de claro 2.
		bosque.conectar(v4, v5, 11);
		bosque.conectar(v4, v6, 10);

		// conexion de claro 5.
		bosque.conectar(v5, v7, 4);

		// conexion de claro 4.
		bosque.conectar(v6, v7, 9);

		RecorridoCapelucita.dfs();

	}

}
