package org.uade.impl;

import org.uade.api.ColaPrioridadTDA;

public class ColaPrioridadDinamica implements ColaPrioridadTDA {

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

    // O(1) (inicializa la estructura)
    @Override
    public void inicializarCola() {
        inicio = null;
    }

    // O(n) (inserta en la posición adecuada según prioridad)
    @Override
    public void acolarPrioridad(int valor, int prioridad) {
        NodoEspecial nuevo = new NodoEspecial(valor, prioridad);
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

    // O(1) (elimina el primer elemento, que es el de mayor prioridad)
    @Override
    public void desacolar() {
        if (inicio != null) {
            inicio = inicio.siguiente;
        }
    }

    // O(1) (retorna el valor del primer elemento)
    @Override
    public int primero() {
        if (inicio != null) {
            return inicio.valor;
        }
        return -1; // Indicador de que la cola está vacía
    }

    // O(1) (retorna la prioridad del primer elemento)
    @Override
    public int prioridad() {
        if (inicio != null) {
            return inicio.prioridad;
        }
        return -1; // Indicador de que la cola está vacía
    }

    // O(1) (verifica si la cola está vacía)
    @Override
    public boolean colaVacia() {
        return inicio == null;
    }
}
