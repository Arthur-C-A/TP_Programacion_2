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
        System.out.println("✔️ Pila inicializada.");
    }

    @Override
    public void apilar(int elemento) {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.valor = elemento;
        nuevoNodo.siguiente = tope;  // El nuevo nodo apunta al antiguo "tope"
        tope = nuevoNodo;  // El nuevo nodo ahora es el tope de la pila
        System.out.println("✔️ Elemento " + elemento + " apilado.");
    }

    @Override
    public void desapilar() {
        if (tope != null) {
            System.out.println("✔️ Elemento " + tope.valor + " desapilado.");
            tope = tope.siguiente;  // El tope ahora apunta al siguiente nodo
        } else {
            System.out.println("✖️ No se puede desapilar, la pila está vacía ✖️");
        }
    }

    @Override
    public int tope() {
        if (tope != null) {
            System.out.println("✔️ El tope de la pila es: " + tope.valor);
            return tope.valor;
        } else {
            System.out.println("✖️ La pila está vacía ✖️");
            return -1;  // Retorna -1 como valor indicativo de error
        }
    }

    @Override
    public boolean pilaVacia() {
        boolean vacia = (tope == null);
        System.out.println(vacia ? "✔️ La pila está vacía." : "✔️ La pila NO está vacía.");
        return vacia;
    }
}
