/*********************************************************************************************
 * Segunda Entrega  Grafos
Lunes 12/06
Un día, Caperucita Roja decide ir desde su casa hasta la de su abuelita, recolectando frutos del 
bosque del camino y tratando de hacer el paseo de la manera más segura posible. La casa de 
Caperucita está en un claro del extremo oeste del bosque, la casa de su abuelita en un claro del 
extremo este, y dentro del bosque entre ambas hay algunos otros claros. 
El bosque está representado por un grafo, donde los vértices representan los claros (identificados 
por un String) y las aristas los senderos que los unen. Cada arista informa la cantidad de árboles 
frutales que hay en el sendero.  Caperucita sabe que el lobo es muy goloso y le gustan mucho las 
frutas, entonces para no ser capturada por el lobo, desea encontrar 
todos 
los caminos que no 
pasen por los senderos con cantidad de frutales >= 5 y lleguen a la casa de la abuelita. 
Su tarea es definir una clase llamada 
BuscadorDeCaminos
, con una variable de instancia llamada 
“bosque”
 de tipo 
Grafo
, que representa el bosque descripto e implementar un método de 
instancia con la siguiente firma: 
public ListaGenerica < ListaGenerica <String>
>
 recorridosMasSeguro()
que devuelva un listado con TODOS los caminos que cumplen con las condiciones mencionadas 
anteriormente.
Nota: La casa de caperucita debe ser buscada antes de comenzar a buscar el recorrido.
 * 
 * 
 * Caminos 
a retornar
: 
1)
Casa Caperucita- Claro 1 -Claro 5-Casa Abuelita. 
2)
Casa Caperucita- Claro 2 – Claro 1 - Claro 5-Casa Abuelita.
 * 
 * */

package practicas;
import listas.ListaEnlazadaGenerica;
import listas.ListaGenerica;
import grafos.Arista;
import grafos.AristaImpl;
import grafos.GrafoImplListAdy;
import grafos.Vertice;
import grafos.VerticeImplListAdy;
public class RecorridoCapelucita {
	private static GrafoImplListAdy<String> bosque;
	public static ListaEnlazadaGenerica<ListaGenerica<String>> dfs() {
		ListaEnlazadaGenerica<ListaGenerica<String>> lis = new ListaEnlazadaGenerica<ListaGenerica<String>>();
		ListaGenerica<String> camino = new ListaEnlazadaGenerica<String>();
		lis.comenzar();
		camino.comenzar();
		boolean encontre = false;
		boolean[] marcados = new boolean[bosque.listaDeVertices().tamanio()];
		int pos = BuscarCasaCapelucita();
		if (pos != -1) {
			dfs(pos, marcados, lis, camino, encontre);
		}
		return lis;
	}
	
	public static void dfs(int posicion, boolean[] marcados,ListaGenerica<ListaGenerica<String>> lis,ListaGenerica<String> camino , boolean encontre) {
		marcados[posicion] = true;
		VerticeImplListAdy<String> v = (VerticeImplListAdy<String>) bosque.listaDeVertices().elemento(posicion + 1);
		camino.agregarFinal(v.dato());
		System.out.println("Vertice :  "+ v.dato());
		if (v.dato() == "Casa de la Abuela") {
			lis.agregarInicio(camino);
			encontre = true;
		
			
			
		}
		ListaGenerica<Arista<String>> ady = bosque.listaDeAdyacentes(v);
		ady.comenzar();
		while (!(ady.fin())&&!(encontre) ) {
			Arista<String> arista =  ady.proximo();
			int j = arista.verticeDestino().posicion() - 1;
		    int peso = arista.peso(); 	
			if (peso <= 5) {
				if ((!marcados[j])) {
					dfs(j, marcados, lis, camino , encontre);
				}
			}    
		}	
		// si no lo encontre .
		if (!(encontre)) {
			camino.eliminar(v.dato().toString());
			marcados[posicion] = false;
			//System.out.println( " Eliminando : " +v.dato());
			
		}else{
			// si lo encontre .
			marcados[posicion] = false;
			
		}
		
		
	}
	
	private static  int BuscarCasaCapelucita() {
		int pos = -1;
		ListaGenerica<Vertice<String>> listaDeVertices = bosque
				.listaDeVertices();
		int i = 1; // Iterador de mi lista de Vertices .
		while ((i < listaDeVertices.tamanio())) {
			if (listaDeVertices.elemento(i).dato() == "Casa de Capelucita") {
				pos = listaDeVertices.elemento(i).posicion() - 1;

			}
			i++;
		}
		return pos;

	}
	
	public static void main(String[] args) {
		
		bosque = new GrafoImplListAdy<String>();
		
		VerticeImplListAdy<String> casaCapelucita = new VerticeImplListAdy<String>("Casa de Capelucita");
		VerticeImplListAdy<String> claro3 = new VerticeImplListAdy<String>("Claro 3");
		VerticeImplListAdy<String> claro1 = new VerticeImplListAdy<String>("Claro 1");
		VerticeImplListAdy<String> claro2 = new VerticeImplListAdy<String>("Claro 2");
		VerticeImplListAdy<String> claro5 = new VerticeImplListAdy<String>("Claro 5");
		VerticeImplListAdy<String> claro4 = new VerticeImplListAdy<String>("Claro 4");
		VerticeImplListAdy<String> casaAbuela = new VerticeImplListAdy<String>("Casa de la Abuela");
		// Agregamos los vertices al grafo, para despues poder hacer las
		// conexiones.
		bosque.agregarVertice(casaCapelucita);
		bosque.agregarVertice(claro3);
		bosque.agregarVertice(claro1);
		bosque.agregarVertice(claro2);
		bosque.agregarVertice(claro5);
		bosque.agregarVertice(claro4);
		bosque.agregarVertice(casaAbuela);
		
		// Conexion casa de capelcuita.
		bosque.conectar(casaCapelucita, claro3, 4);
		bosque.conectar(casaCapelucita, claro1, 3);
		bosque.conectar(casaCapelucita, claro2, 4);
		
		bosque.conectar( claro3, casaCapelucita,4);
		bosque.conectar( claro1,casaCapelucita, 3);
		bosque.conectar( claro2,casaCapelucita, 4);
		
		// conexion de claro 3.
		bosque.conectar(claro3, claro5, 15);
		bosque.conectar(claro5,claro3,15);
		
		
		// conexion de claro 1
		bosque.conectar(claro1, claro5, 3);
		bosque.conectar(claro1, claro2, 4);
		
		bosque.conectar(claro5,claro1, 3);
		bosque.conectar(claro2,claro1,4);
		
		
		// conexion de claro 2.
		bosque.conectar(claro2, claro5, 11);
		bosque.conectar(claro2, claro4, 10);
		
		bosque.conectar(claro5,claro2,11);
		bosque.conectar(claro4,claro2,10);
		
		
		
		// conexion de claro 5.
		bosque.conectar(claro5, casaAbuela, 4);
		bosque.conectar(casaAbuela,claro5,4);
		
		// conexion de claro 4.
		bosque.conectar(claro4, casaAbuela, 9);
		bosque.conectar(casaAbuela,claro4,9);
		
		ListaEnlazadaGenerica<ListaGenerica<String>> lista = null;
		lista = RecorridoCapelucita.dfs();
		
	

		
	}

}
