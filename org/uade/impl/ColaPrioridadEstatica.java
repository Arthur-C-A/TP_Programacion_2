package org.uade.impl;

import org.uade.api.ColaPrioridadTDA;

public class ColaPrioridadEstatica implements ColaPrioridadTDA {

    private static class NodoEspecial {
        int valor;
        int prioridad;

        public NodoEspecial(int valor, int prioridad) {
            this.valor = valor;
            this.prioridad = prioridad;
        }
    }

    private NodoEspecial[] cola;
    private int cantidad; // num de elementos en la cola
    private final int TAMANIO = 100; // Tamaño maximo de la cola

    // O(1)
    @Override
    public void inicializarCola() {
        cola = new NodoEspecial[TAMANIO];
        cantidad = 0;
    }

    // O(n)
    @Override
    public void acolarPrioridad(int valor, int prioridad) {
        if (cantidad == TAMANIO) {
            throw new RuntimeException("La cola está llena");
        }
        int i = cantidad - 1;
        while (i >= 0 && cola[i].prioridad >= prioridad) {
            cola[i + 1] = cola[i];
            i--;
        }
        cola[i + 1] = new NodoEspecial(valor, prioridad);
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
            return cola[0].valor;
        }
        return -1;
    }

    // O(1)
    @Override
    public int prioridad() {
        if (cantidad > 0) {
            return cola[0].prioridad;
        }
        return -1;
    }

    // O(1)
    @Override
    public boolean colaVacia() {
        return cantidad == 0;
    }
}
