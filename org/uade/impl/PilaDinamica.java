package org.uade.impl;

import org.uade.api.PilaTDA;

// Clase Nodo,   lo que hace la magia



public class PilaDinamica implements PilaTDA {

    private Nodo topeNodo; // Referencia al nodo en la cima de la pila

    @Override
    public void inicializarPila() {
        topeNodo = null;
    }
    //El costo es 0(1)
    @Override
    public void apilar(int elemento) {

        Nodo nuevoNodo = new Nodo(elemento);// asignamos valor n
        nuevoNodo.siguiente = topeNodo; // tuki
        topeNodo = nuevoNodo;//tuki
    }
    //El costo es 0(1)
    @Override
    public void desapilar() {

        if (topeNodo != null) {
            topeNodo = topeNodo.siguiente; // La cima se mueve al siguiente nodo
        } else {
            System.out.println("✖️ No se puede desapilar, la pila está vacía ✖️");
        }

    }
    //El costo es 0(1)
    @Override
    public int tope() {

        if (topeNodo != null) {
            return topeNodo.dato;
        } else {

            return -1;
        }

    }

    @Override
    public boolean pilaVacia() {

        if (topeNodo == null) {
            return true;
        }
        return false;

    }
}
