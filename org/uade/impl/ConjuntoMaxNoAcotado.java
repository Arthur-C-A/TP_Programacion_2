package org.uade.impl;

import org.uade.api.ConjuntoTDA;

public class ConjuntoMaxNoAcotado implements ConjuntoTDA {
    private Nodo inicio;
    // O(1)
    @Override
    public void inicializarConjunto() {
        inicio = null;
    }

    // O(1)
    @Override
    public void agregar(int x) {
        if (!pertenece(x)) {
            Nodo nuevoNodo = new Nodo(x);
            nuevoNodo.siguiente = inicio;
            inicio = nuevoNodo;
        }
    }
    // O(1)
    @Override
    public int elegir() {
        if (!conjuntoVacio()) {
            return inicio.dato;
        }
        return -1;
    }
    // O(1)
    @Override
    public void sacar(int x) {
        Nodo actual = inicio;
        Nodo anterior = null;

        while (actual != null && actual.dato != x) {
            anterior = actual;
            actual = actual.siguiente;
        }

        if (actual != null) {
            if (anterior == null) {
                inicio = actual.siguiente;
            } else {
                anterior.siguiente = actual.siguiente;
            }
        }
    }

    @Override
    public boolean pertenece(int x) {
        Nodo actual = inicio;
        while (actual != null) {
            if (actual.dato == x) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    @Override
    public boolean conjuntoVacio() {
        return inicio == null;
    }
}
