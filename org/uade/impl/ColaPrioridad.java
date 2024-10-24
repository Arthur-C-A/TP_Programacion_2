package org.uade.impl;

import org.uade.api.ColaPrioridadTDA;

public class ColaPrioridad implements ColaPrioridadTDA {

    class Nodo {
        int prioridad;
        int valor;
        Nodo siguiente;

        public Nodo(int prioridad, int valor) {
            this.prioridad = prioridad;
            this.valor = valor;
            this.siguiente = null;
        }
    }

    private Nodo inicio;

    @Override
    public void inicializarCola() {
        inicio = null;
    }

    @Override
    public void acolarPrioridad(int prioridad, int valor) {
        Nodo nuevo = new Nodo(prioridad, valor);
        if (inicio == null || prioridad > inicio.prioridad) {
            nuevo.siguiente = inicio;
            inicio = nuevo;
        } else {
            Nodo anterior = null, actual = inicio;
            while (actual != null && prioridad <= actual.prioridad) {
                anterior = actual;
                actual = actual.siguiente;
            }
            nuevo.siguiente = actual;
            anterior.siguiente = nuevo;
        }
    }

    @Override
    public void desacolar() {
        if (inicio != null) {
            inicio = inicio.siguiente;
        }
    }

    @Override
    public int primero() {
        if (inicio != null) {
            return inicio.valor;
        }
        System.out.println("✖️ La cola está vacía ✖️");
        return -1;
    }

    @Override
    public int prioridad() {
        if (inicio != null) {
            return inicio.prioridad;
        }
        System.out.println("✖️ No hay prioridad en una cola vacía ✖️");
        return -1;
    }

    @Override
    public boolean colaVacia() {
        return inicio == null;
    }
}
