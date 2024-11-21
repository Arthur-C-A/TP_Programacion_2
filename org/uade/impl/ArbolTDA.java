package org.uade.impl;

import org.uade.api.ABBTDA;

public class ArbolTDA implements ABBTDA {

    // nodo especial del árbol
    private class Nodo {
        int valor;
        Nodo hijoIzq;
        Nodo hijoDer;

        Nodo(int valor) {
            this.valor = valor;
            this.hijoIzq = null;
            this.hijoDer = null;
        }
    }

    private Nodo raiz;

    @Override
    public void inicializarArbol() {
        // Inicializamos el árbol vacío
        raiz = null;
    }

    @Override
    public int raiz() {
        if (arbolVacio()) {
            throw new IllegalStateException("El árbol está vacío");
        }
        return raiz.valor;
    }

    @Override
    public ABBTDA hijoIzq() {
        if (arbolVacio()) {
            throw new IllegalStateException("El árbol está vacío");
        }
        ArbolTDA arbolHijoIzq = new ArbolTDA();
        arbolHijoIzq.raiz = raiz.hijoIzq;
        return arbolHijoIzq;
    }

    @Override
    public ABBTDA hijoDer() {
        if (arbolVacio()) {
            throw new IllegalStateException("El árbol está vacío");
        }
        ArbolTDA arbolHijoDer = new ArbolTDA();
        arbolHijoDer.raiz = raiz.hijoDer;
        return arbolHijoDer;
    }

    @Override
    public void agregar(int x) {
        raiz = agregarRecursivo(raiz, x);
    }

    private Nodo agregarRecursivo(Nodo nodo, int x) {
        // Si el árbol está vacío, creamos un nuevo nodo
        if (nodo == null) {
            return new Nodo(x);
        }

        // Si el valor a agregar es menor, lo agregamos al subárbol izquierdo
        if (x < nodo.valor) {
            nodo.hijoIzq = agregarRecursivo(nodo.hijoIzq, x);
        }
        // Si el valor a agregar es mayor, lo agregamos al subárbol derecho
        else if (x > nodo.valor) {
            nodo.hijoDer = agregarRecursivo(nodo.hijoDer, x);
        }
        // Si el valor es igual, no agregamos nada (suponemos sin duplicados)
        return nodo;
    }

    @Override
    public void eliminar(int x) {
        raiz = eliminarRecursivo(raiz, x);
    }

    private Nodo eliminarRecursivo(Nodo nodo, int x) {
        // Si el nodo es null, el valor no se encuentra en el árbol
        if (nodo == null) {
            return null;
        }

        // Buscamos el valor en el subárbol izquierdo o derecho
        if (x < nodo.valor) {
            nodo.hijoIzq = eliminarRecursivo(nodo.hijoIzq, x);
        } else if (x > nodo.valor) {
            nodo.hijoDer = eliminarRecursivo(nodo.hijoDer, x);
        } else {
            // Caso 1: Nodo sin hijos (hoja)
            if (nodo.hijoIzq == null && nodo.hijoDer == null) {
                return null;
            }
            // Caso 2: Nodo con un solo hijo
            if (nodo.hijoIzq == null) {
                return nodo.hijoDer;
            }
            if (nodo.hijoDer == null) {
                return nodo.hijoIzq;
            }
            // Caso 3: Nodo con dos hijos
            // Encontramos el valor mínimo en el subárbol derecho
            nodo.valor = minValue(nodo.hijoDer);
            // Eliminamos el nodo que contiene el valor mínimo en el subárbol derecho
            nodo.hijoDer = eliminarRecursivo(nodo.hijoDer, nodo.valor);
        }
        return nodo;
    }

    private int minValue(Nodo nodo) {
        int minValue = nodo.valor;
        while (nodo.hijoIzq != null) {
            minValue = nodo.hijoIzq.valor;
            nodo = nodo.hijoIzq;
        }
        return minValue;
    }

    @Override
    public boolean arbolVacio() {
        return raiz == null;
    }
}
