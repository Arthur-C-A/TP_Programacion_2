package org.uade.impl;

import org.uade.api.PilaTDA;

public class PilaDinamica implements PilaTDA {

    // Nodo interno que representará cada elemento de la pila
    private class Nodo {
        int valor;
        Nodo siguiente;
    }

    private Nodo tope;  // Apunta al nodo que está en la cima de la pila

    @Override
    public void inicializarPila() {
        tope = null;  // Inicializa la pila como vacía
    }

    @Override
    public void apilar(int elemento) {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.valor = elemento;
        nuevoNodo.siguiente = tope;  // El nuevo nodo apunta al antiguo "tope"
        tope = nuevoNodo;  // El nuevo nodo ahora es el tope de la pila
    }

    @Override
    public void desapilar() {
        if (tope != null) {
            tope = tope.siguiente;  // El tope ahora apunta al siguiente nodo
        } else {
            throw new IllegalStateException("✖️ No se puede desapilar, la pila está vacía ✖️");
        }
    }

    @Override
    public int tope() {
        if (tope != null) {
            return tope.valor;
        } else {
            throw new IllegalStateException("✖️ La pila está vacía ✖️");
        }
    }

    @Override
    public boolean pilaVacia() {
        return tope == null;  // Si el tope es null, la pila está vacía
    }
}