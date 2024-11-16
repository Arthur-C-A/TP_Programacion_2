package org.uade.impl;

import org.uade.api.ColaPrioridadTDA;

public class ColaPrioridad implements ColaPrioridadTDA {

    class NodoEspecial {
        int prioridad;
        int valor;
        NodoEspecial siguiente;

        public NodoEspecial(int valor, int prioridad) {
            this.prioridad = prioridad;
            this.valor = valor;
            this.siguiente = null;
        }
    }

    private NodoEspecial inicio;

    @Override
    public void inicializarCola() {
        inicio = null;
    }

    @Override
    public void acolarPrioridad(int valor, int prioridad) {
        NodoEspecial nuevo = new NodoEspecial(prioridad, valor);
        if (inicio == null || prioridad > inicio.prioridad) {
            nuevo.siguiente = inicio;
            inicio = nuevo;
        } else {
            NodoEspecial anterior = null, actual = inicio;
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
        return -1;
    }

    @Override
    public int prioridad() {
        if (inicio != null) {
            return inicio.prioridad;
        }
        return -1;
    }

    @Override
    public boolean colaVacia() {
        return inicio == null;
    }
}
