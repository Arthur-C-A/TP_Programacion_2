package org.uade.impl;

import org.uade.api.ConjuntoTDA;

public class ConjuntoUniversoAcotado implements ConjuntoTDA {
    private boolean[] universo; // Representación de presencia de elementos
    private static final int N = 100; // Universo de [0, N)

    @Override
    public void inicializarConjunto() {
        universo = new boolean[N];
        for (int i = 0; i < N; i++) {
            universo[i] = false;
        }
    }

    @Override
    public void agregar(int x) {
        if (x >= 0 && x < N) {
            universo[x] = true;
        }
    }

    @Override
    public void sacar(int x) {
        if (x >= 0 && x < N) {
            universo[x] = false;
        }
    }

    @Override
    public int elegir() {
        for (int i = 0; i < N; i++) {
            if (universo[i]) {
                return i;
            }
        }
        throw new RuntimeException("Conjunto vacío");
    }

    @Override
    public boolean pertenece(int x) {
        return x >= 0 && x < N && universo[x];
    }

    @Override
    public boolean conjuntoVacio() {
        for (int i = 0; i < N; i++) {
            if (universo[i]) {
                return false;
            }
        }
        return true;
    }
}
