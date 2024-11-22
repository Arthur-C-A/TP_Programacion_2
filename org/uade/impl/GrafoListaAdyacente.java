package org.uade.impl;

import org.uade.api.GrafoTDA;
import org.uade.api.ConjuntoTDA;

public class GrafoListaAdyacente implements GrafoTDA {
    private ConjuntoTDA vertices;
    private NodoAdyacencia[] adyacencias;

    @Override
    public void inicializarGrafo() {
        vertices = new ConjuntoMaxAcotado();
        vertices.inicializarConjunto();
        adyacencias = new NodoAdyacencia[0];
    }

    @Override
    public void agregarVertice(int vertice) {
        if (!vertices.pertenece(vertice)) {
            vertices.agregar(vertice);
            NodoAdyacencia[] nuevaAdyacencia = new NodoAdyacencia[contarElementos(vertices)];
            System.arraycopy(adyacencias, 0, nuevaAdyacencia, 0, adyacencias.length);
            nuevaAdyacencia[nuevaAdyacencia.length - 1] = null;
            adyacencias = nuevaAdyacencia;
        }
    }

    @Override
    public void eliminarVertice(int vertice) {
        if (vertices.pertenece(vertice)) {
            vertices.sacar(vertice);

            NodoAdyacencia[] nuevaAdyacencia = new NodoAdyacencia[contarElementos(vertices)];
            int iNueva = 0;

            for (int i = 0; i < adyacencias.length; i++) {
                if (!vertices.pertenece(i)) {
                    eliminarAdyacenciaEnVertice(i, vertice);
                } else {
                    nuevaAdyacencia[iNueva] = adyacencias[i];
                    iNueva++;
                }
            }

            adyacencias = nuevaAdyacencia;
        }
    }

    @Override
    public ConjuntoTDA vertices() {
        ConjuntoTDA copiaVertices = new ConjuntoMaxAcotado();
        copiaVertices.inicializarConjunto();

        ConjuntoTDA iterador = new ConjuntoMaxAcotado();
        iterador.inicializarConjunto();

        while (!vertices.conjuntoVacio()) {
            int elem = vertices.elegir();
            copiaVertices.agregar(elem);
            iterador.agregar(elem);
            vertices.sacar(elem);
        }

        while (!iterador.conjuntoVacio()) {
            int elem = iterador.elegir();
            vertices.agregar(elem);
            iterador.sacar(elem);
        }

        return copiaVertices;
    }

    @Override
    public void agregarArista(int v1, int v2, int peso) {
        if (vertices.pertenece(v1) && vertices.pertenece(v2)) {
            adyacencias[v1] = agregarAdyacente(adyacencias[v1], v2, peso);
            adyacencias[v2] = agregarAdyacente(adyacencias[v2], v1, peso);
        }
    }

    @Override
    public void eliminarArista(int v1, int v2) {
        if (vertices.pertenece(v1) && vertices.pertenece(v2)) {
            adyacencias[v1] = eliminarAdyacente(adyacencias[v1], v2);
            adyacencias[v2] = eliminarAdyacente(adyacencias[v2], v1);
        }
    }

    @Override
    public boolean ExisteArista(int v1, int v2) {
        return buscarAdyacente(adyacencias[v1], v2) != null;
    }

    @Override
    public int pesoArista(int v1, int v2) {
        NodoAdyacencia arista = buscarAdyacente(adyacencias[v1], v2);
        return arista != null ? arista.peso : -1;
    }

    private NodoAdyacencia agregarAdyacente(NodoAdyacencia lista, int destino, int peso) {
        NodoAdyacencia nuevo = new NodoAdyacencia(destino, peso);
        nuevo.siguiente = lista;
        return nuevo;
    }

    private NodoAdyacencia eliminarAdyacente(NodoAdyacencia lista, int destino) {
        if (lista == null) {
            return null;
        }
        if (lista.destino == destino) {
            return lista.siguiente;
        }
        lista.siguiente = eliminarAdyacente(lista.siguiente, destino);
        return lista;
    }

    private NodoAdyacencia buscarAdyacente(NodoAdyacencia lista, int destino) {
        while (lista != null) {
            if (lista.destino == destino) {
                return lista;
            }
            lista = lista.siguiente;
        }
        return null;
    }

    private void eliminarAdyacenciaEnVertice(int indice, int vertice) {
        adyacencias[indice] = eliminarAdyacente(adyacencias[indice], vertice);
    }

    private int contarElementos(ConjuntoTDA conjunto) {
        ConjuntoTDA copia = new ConjuntoMaxAcotado();
        copia.inicializarConjunto();
        int contador = 0;

        while (!conjunto.conjuntoVacio()) {
            int elem = conjunto.elegir();
            copia.agregar(elem);
            conjunto.sacar(elem);
            contador++;
        }

        while (!copia.conjuntoVacio()) {
            int elem = copia.elegir();
            conjunto.agregar(elem);
            copia.sacar(elem);
        }

        return contador;
    }

    private class NodoAdyacencia {
        int destino;
        int peso;
        NodoAdyacencia siguiente;

        public NodoAdyacencia(int destino, int peso) {
            this.destino = destino;
            this.peso = peso;
            this.siguiente = null;
        }
    }
}
