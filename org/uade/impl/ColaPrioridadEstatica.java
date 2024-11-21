package org.uade.impl;

import org.uade.api.ColaPrioridadTDA;

public class ColaPrioridadEstatica implements ColaPrioridadTDA {

    private int[] valores;
    private int[] prioridades;
    private int cantidad; // Número de elementos en la cola
    private final int TAMANIO = 100; // Tamaño máximo de la cola

    // O(1)
    @Override
    public void inicializarCola() {
        valores = new int[TAMANIO];
        prioridades = new int[TAMANIO];
        cantidad = 0;
    }

    // O(n)
    @Override
    public void acolarPrioridad(int valor, int prioridad) {
        if (cantidad == TAMANIO) {
            throw new RuntimeException("La cola está llena");
        }

        int i = cantidad - 1;
        while (i >= 0 && prioridades[i] >= prioridad) {
            valores[i + 1] = valores[i];
            prioridades[i + 1] = prioridades[i];
            i--;
        }

        valores[i + 1] = valor;
        prioridades[i + 1] = prioridad;
        cantidad++;
    }

    // O(1)
    @Override
    public void desacolar() {
        if (cantidad > 0) {
            cantidad--;
        }
    }

    // O(1)
    @Override
    public int primero() {
        if (cantidad > 0) {
            return valores[0];
        }
        return -1; // Indicador de cola vacía
    }

    // O(1)
    @Override
    public int prioridad() {
        if (cantidad > 0) {
            return prioridades[0];
        }
        return -1; // Indicador de cola vacía
    }

    // O(1)
    @Override
    public boolean colaVacia() {
        return cantidad == 0;
    }
}
