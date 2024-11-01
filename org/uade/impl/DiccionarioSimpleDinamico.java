package org.uade.impl;

import org.uade.api.ConjuntoTDA;
import org.uade.api.DiccionarioSimpleTDA;

public class DiccionarioSimpleDinamico implements DiccionarioSimpleTDA {
    private Nodo inicio;

    @Override
    public void inicializarDiccionario() {
        inicio = null;
    }

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

    @Override
    public int recuperar(int clave) {
        Nodo actual = inicio;
        while (actual != null && actual.dato != clave) {
            actual = actual.siguiente;
        }
        return actual != null ? actual.dato : -1; // Devuelve -1 si la clave no se encuentra
    }

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
