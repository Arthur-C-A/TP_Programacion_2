package org.uade.impl;
import org.uade.util.Nodo;

import org.uade.api.PilaTDA;

// Clase Nodo,   lo que hace la magia



public class PilaDinamica implements PilaTDA {

    private Nodo topeNodo; // Referencia al nodo en la cima de la pila

    @Override
    public void inicializarPila() {
        topeNodo = null;
    }

    @Override
    public void apilar(int elemento) {

        Nodo nuevoNodo = new Nodo(elemento);// asignamos valor n
        nuevoNodo.siguiente = topeNodo; // tuki
        topeNodo = nuevoNodo;//tuki
    }

    @Override
    public void desapilar() {

        if (topeNodo != null) {
            topeNodo = topeNodo.siguiente; // La cima se mueve al siguiente nodo
        } else {
            System.out.println("✖️ No se puede desapilar, la pila está vacía ✖️");
        }

    }

    @Override
    public int tope() {

        if (topeNodo != null) {
            System.out.println("✔️ El tope actual es: " + topeNodo.dato);
            return topeNodo.dato;
        } else {
            System.out.println("✖️ La pila está vacía o no fue inicializada, se devuelve -1 ✖️");
            return -1;
        }

    }

    @Override
    public boolean pilaVacia() {

        if (topeNodo == null) {
            System.out.println("✔️ La pila está vacía.");
            return true;
        }
        return false;

    }
}
