package org.uade.util;

import org.uade.impl.PilaDinamica;

public class Nodo {
    public int dato;
    public Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
