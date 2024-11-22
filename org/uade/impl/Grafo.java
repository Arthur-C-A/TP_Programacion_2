package org.uade.impl;

import org.uade.api.GrafoTDA;
import org.uade.api.ConjuntoTDA;

public class Grafo implements GrafoTDA {
    private int[][] matrizAdyacencia; // Matriz de adyacencia
    private int[] vertices;          // Arreglo para guardar los vértices
    private int cantidadVertices;    // Cantidad actual de vértices
    private static final int MAX_VERTICES = 100; // Tamaño máximo de la matriz

    public void inicializarGrafo() {
        matrizAdyacencia = new int[MAX_VERTICES][MAX_VERTICES];
        vertices = new int[MAX_VERTICES];
        cantidadVertices = 0;
    }

    public void agregarVertice(int v) {
        if (!existeVertice(v)) {
            vertices[cantidadVertices] = v;
            cantidadVertices++;
        }
    }

    public void eliminarVertice(int v) {
        int indice = obtenerIndiceVertice(v);
        if (indice != -1) {
            // Eliminar el vértice de la lista
            for (int i = indice; i < cantidadVertices - 1; i++) {
                vertices[i] = vertices[i + 1];
            }
            cantidadVertices--;

            // Eliminar las aristas asociadas en la matriz
            for (int i = indice; i < cantidadVertices; i++) {
                for (int j = 0; j < MAX_VERTICES; j++) {
                    matrizAdyacencia[i][j] = matrizAdyacencia[i + 1][j];
                }
            }
            for (int j = indice; j < cantidadVertices; j++) {
                for (int i = 0; i < MAX_VERTICES; i++) {
                    matrizAdyacencia[i][j] = matrizAdyacencia[i][j + 1];
                }
            }
        }
    }

    public void agregarArista(int v1, int v2, int peso) {
        int i = obtenerIndiceVertice(v1);
        int j = obtenerIndiceVertice(v2);
        if (i != -1 && j != -1) {
            matrizAdyacencia[i][j] = peso;
        }
    }

    public void eliminarArista(int v1, int v2) {
        int i = obtenerIndiceVertice(v1);
        int j = obtenerIndiceVertice(v2);
        if (i != -1 && j != -1) {
            matrizAdyacencia[i][j] = 0; // Peso 0 implica ausencia de arista
        }
    }

    public boolean ExisteArista(int v1, int v2) {
        int i = obtenerIndiceVertice(v1);
        int j = obtenerIndiceVertice(v2);
        return i != -1 && j != -1 && matrizAdyacencia[i][j] != 0;
    }

    public int pesoArista(int v1, int v2) {
        int i = obtenerIndiceVertice(v1);
        int j = obtenerIndiceVertice(v2);
        if (i != -1 && j != -1) {
            return matrizAdyacencia[i][j];
        }
        return 0; // Si no existe la arista, el peso es 0
    }

    public ConjuntoTDA vertices() {
        ConjuntoTDA conjuntoVertices = new ConjuntoMaxAcotado();
        conjuntoVertices.inicializarConjunto();
        for (int i = 0; i < cantidadVertices; i++) {
            conjuntoVertices.agregar(vertices[i]);
        }
        return conjuntoVertices;
    }

    // Métodos auxiliares
    private boolean existeVertice(int v) {
        return obtenerIndiceVertice(v) != -1;
    }

    private int obtenerIndiceVertice(int v) {
        for (int i = 0; i < cantidadVertices; i++) {
            if (vertices[i] == v) {
                return i;
            }
        }
        return -1;
    }
}
