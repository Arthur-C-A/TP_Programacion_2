package org.uade.impl;

import org.uade.api.ConjuntoTDA;
import org.uade.api.DiccionarioSimpleTDA;

public class DiccionarioSimpleDinamico implements DiccionarioSimpleTDA {
    private Nodo inicio;

    // O(1)
    @Override
    public void inicializarDiccionario() {
        inicio = null;
    }

    // O(n)
    @Override
    public void agregar(int clave, int valor) {
        Nodo actual = inicio;
        while (actual != null && actual.dato != clave) {
            actual = actual.siguiente;
        }
        if (actual == null) {
            Nodo nuevoNodo = new Nodo(clave);
            nuevoNodo.dato = valor;
            nuevoNodo.siguiente = inicio;
            inicio = nuevoNodo;
        } else {
            actual.dato = valor;
        }
    }

    // O(n)
    @Override
    public void eliminar(int clave) {
        if (inicio != null) {
            if (inicio.dato == clave) {
                inicio = inicio.siguiente;
            } else {
                Nodo actual = inicio;
                while (actual.siguiente != null && actual.siguiente.dato != clave) {
                    actual = actual.siguiente;
                }
                if (actual.siguiente != null) {
                    actual.siguiente = actual.siguiente.siguiente;
                }
            }
        }
    }

    // O(n)
    @Override
    public int recuperar(int clave) {
        Nodo actual = inicio;
        while (actual != null && actual.dato != clave) {
            actual = actual.siguiente;
        }
        return actual != null ? actual.dato : -1;
    }

    // O(n)
    @Override
    public ConjuntoTDA claves() {
        ConjuntoTDA conjuntoClaves = new ConjuntoEstatico();
        conjuntoClaves.inicializarConjunto();
        Nodo actual = inicio;
        while (actual != null) {
            conjuntoClaves.agregar(actual.dato);
            actual = actual.siguiente;
        }
        return conjuntoClaves;
    }
}
