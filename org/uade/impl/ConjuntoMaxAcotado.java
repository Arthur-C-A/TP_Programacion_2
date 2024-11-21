package org.uade.impl;

import org.uade.api.ConjuntoTDA;

public class ConjuntoMaxAcotado implements ConjuntoTDA {
    // Variables
    private final int MAX_SIZE = 100;
    private int[] elementos;
    private int cantidad;

    // O(1)
    @Override
    public void inicializarConjunto() {
        elementos = new int[MAX_SIZE];
        cantidad = 0;
    }

    // O(n)
    @Override
    public void agregar(int x) {
        if (!pertenece(x) && cantidad < MAX_SIZE) {
            elementos[cantidad] = x;
            cantidad++;
        }
    }

    // O(1)
    @Override
    public int elegir() {
        if (!conjuntoVacio()) {
            return elementos[cantidad - 1];
        }
        return -1; //
    }

    // O(n)
    @Override
    public void sacar(int x) {
        for (int i = 0; i < cantidad; i++) {
            if (elementos[i] == x) {
                elementos[i] = elementos[cantidad - 1];
                cantidad--;
                break;
            }
        }
    }

    // O(n)
    @Override
    public boolean pertenece(int x) {
        for (int i = 0; i < cantidad; i++) {
            if (elementos[i] == x) {
                return true;
            }
        }
        return false;
    }

    // O(1)
    @Override
    public boolean conjuntoVacio() {
        return cantidad == 0;
    }
}
