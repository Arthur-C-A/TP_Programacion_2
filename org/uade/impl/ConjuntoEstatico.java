package org.uade.impl;

import org.uade.api.ConjuntoTDA;

public class ConjuntoEstatico implements ConjuntoTDA {
    // variables
    private final int MAX_SIZE = 100;
    private int[] elementos;
    private int cantidad;

    //Inician los metodos

    @Override
    public void inicializarConjunto() {
        elementos = new int[MAX_SIZE];
        cantidad = 0;
    }

    @Override
    public void agregar(int x) {
        if (!pertenece(x) && cantidad < MAX_SIZE) {
            elementos[cantidad] = x;
            cantidad++;
        }
    }

    @Override
    public int elegir() {
        if (!conjuntoVacio()) {
            return elementos[cantidad - 1];
        }
        return -1; // Indicador de conjunto vacío
    }

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

    @Override
    public boolean pertenece(int x) {
        for (int i = 0; i < cantidad; i++) {
            if (elementos[i] == x) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean conjuntoVacio() {
        return cantidad == 0;
    }
}
