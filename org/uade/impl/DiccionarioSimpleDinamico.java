package org.uade.impl;

import org.uade.api.ConjuntoTDA;
import org.uade.api.DiccionarioSimpleTDA;

public class DiccionarioSimpleDinamico implements DiccionarioSimpleTDA {
    private NodoDiccionario inicio;

    @Override
    public void inicializarDiccionario() {
        inicio = null;
    }

    @Override
    public void agregar(int clave, int valor) {
        NodoDiccionario actual = inicio;
        while (actual != null) {
            if (actual.clave == clave) {
                actual.valor = valor;
                return;
            }
            actual = actual.siguiente;
        }
        NodoDiccionario nuevo = new NodoDiccionario(clave, valor);
        nuevo.siguiente = inicio;
        inicio = nuevo;
    }

    @Override
    public void eliminar(int clave) {
        NodoDiccionario actual = inicio, anterior = null;
        while (actual != null && actual.clave != clave) {
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
    public int recuperar(int clave) {
        NodoDiccionario actual = inicio;
        while (actual != null) {
            if (actual.clave == clave) {
                return actual.valor;
            }
            actual = actual.siguiente;
        }
        throw new RuntimeException("Clave no encontrada");
    }

    @Override
    public ConjuntoTDA claves() {
        ConjuntoTDA conjunto = new ConjuntoMaxNoAcotado();
        conjunto.inicializarConjunto();
        NodoDiccionario actual = inicio;
        while (actual != null) {
            conjunto.agregar(actual.clave);
            actual = actual.siguiente;
        }
        return conjunto;
    }
}

class NodoDiccionario {
    int clave;
    int valor;
    NodoDiccionario siguiente;

    public NodoDiccionario(int clave, int valor) {
        this.clave = clave;
        this.valor = valor;
        this.siguiente = null;
    }
}
