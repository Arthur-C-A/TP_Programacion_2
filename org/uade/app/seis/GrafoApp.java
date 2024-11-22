package org.uade.app.seis;

import org.uade.api.GrafoTDA;
import org.uade.api.ConjuntoTDA;
import org.uade.impl.ConjuntoMaxAcotado;
import org.uade.impl.Grafo;

public class GrafoApp {

    public static void main(String[] args) {
        GrafoTDA grafo = new Grafo();
        grafo.inicializarGrafo();

        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);

        grafo.agregarArista(1, 2, 5);
        grafo.agregarArista(2, 3, 10);
        grafo.agregarArista(3, 4, 15);

        // Adyacentes Dobles
        System.out.println("Adyacentes dobles de 1:");
        ConjuntoTDA adyacentesDobles = adyacentesDobles(grafo, 1);
        while (!adyacentesDobles.conjuntoVacio()) {
            int vertice = adyacentesDobles.elegir();
            adyacentesDobles.sacar(vertice);
            System.out.println(vertice);
        }
    }

    // Calc el conjunto de vértices adyacentes dobles de un vértice v
    public static ConjuntoTDA adyacentesDobles(GrafoTDA grafo, int v) {
        ConjuntoTDA adyacentesDobles = new ConjuntoMaxAcotado();
        adyacentesDobles.inicializarConjunto();
        ConjuntoTDA vertices = grafo.vertices();

        while (!vertices.conjuntoVacio()) {
            int x = vertices.elegir();
            vertices.sacar(x);

            if (grafo.ExisteArista(v, x)) { // Si hay arista de v a x
                ConjuntoTDA verticesInternos = grafo.vertices();
                while (!verticesInternos.conjuntoVacio()) {
                    int w = verticesInternos.elegir();
                    verticesInternos.sacar(w);
                    if (grafo.ExisteArista(x, w)) { // Si hay arista de x a w
                        adyacentesDobles.agregar(w);
                    }
                }
            }
        }
        return adyacentesDobles;
    }

    //Calcular el mayor costo de las aristas salientes de un vértice v
    public static int mayorCostoSaliente(GrafoTDA grafo, int v) {
        int maxCosto = Integer.MIN_VALUE;
        ConjuntoTDA vertices = grafo.vertices();

        while (!vertices.conjuntoVacio()) {
            int destino = vertices.elegir();
            vertices.sacar(destino);

            if (grafo.ExisteArista(v, destino)) {
                int peso = grafo.pesoArista(v, destino);
                if (peso > maxCosto) {
                    maxCosto = peso;
                }
            }
        }
        return maxCosto == Integer.MIN_VALUE ? 0 : maxCosto; // Si no hay aristas, retorna 0
    }

    // Obtener los predecesores de un vértice v
    public static ConjuntoTDA predecesores(GrafoTDA grafo, int v) {
        ConjuntoTDA predecesores = new ConjuntoMaxAcotado();
        predecesores.inicializarConjunto();
        ConjuntoTDA vertices = grafo.vertices();

        while (!vertices.conjuntoVacio()) {
            int origen = vertices.elegir();
            vertices.sacar(origen);

            if (grafo.ExisteArista(origen, v)) { // Si hay arista de origen a v
                predecesores.agregar(origen);
            }
        }
        return predecesores;
    }

    //  Obtener los vértices aislados en un grafox
    public static ConjuntoTDA verticesAislados(GrafoTDA grafo) {
        ConjuntoTDA aislados = new ConjuntoMaxAcotado();
        aislados.inicializarConjunto();
        ConjuntoTDA vertices = grafo.vertices();

        while (!vertices.conjuntoVacio()) {
            int v = vertices.elegir();
            vertices.sacar(v);

            boolean tieneAristas = false;
            ConjuntoTDA internos = grafo.vertices();
            while (!internos.conjuntoVacio()) {
                int w = internos.elegir();
                internos.sacar(w);

                if (grafo.ExisteArista(v, w) || grafo.ExisteArista(w, v)) {
                    tieneAristas = true;
                    break;
                }
            }

            if (!tieneAristas) {
                aislados.agregar(v);
            }
        }
        return aislados;
    }

    // Obtener los vertices puente entre v1, v2
    public static ConjuntoTDA verticesPuente(GrafoTDA grafo, int v1, int v2) {
        ConjuntoTDA puentes = new ConjuntoMaxAcotado();
        puentes.inicializarConjunto();
        ConjuntoTDA vertices = grafo.vertices();

        while (!vertices.conjuntoVacio()) {
            int p = vertices.elegir();
            vertices.sacar(p);

            if (grafo.ExisteArista(v1, p) && grafo.ExisteArista(p, v2)) {
                puentes.agregar(p);
            }
        }
        return puentes;
    }

    // 9. Calcular el grado de un vértice v
    public static int gradoVertice(GrafoTDA grafo, int v) {
        int salientes = 0;
        int entrantes = 0;
        ConjuntoTDA vertices = grafo.vertices();

        while (!vertices.conjuntoVacio()) {
            int x = vertices.elegir();
            vertices.sacar(x);

            if (grafo.ExisteArista(v, x)) { // Contar aristas salientes
                salientes++;
            }
            if (grafo.ExisteArista(x, v)) { // Contar aristas entrantes
                entrantes++;
            }
        }
        return salientes - entrantes; // Grado = aristas salientes - aristas entrantes
    }

}
