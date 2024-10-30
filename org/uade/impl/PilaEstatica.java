package org.uade.impl;

import org.uade.api.PilaTDA;

public class PilaEstatica implements PilaTDA {

    private int[] pila;
    private int indexPila = 0;
    private final int maxLong= 5;

    @Override
    public void inicializarPila() {

        if (pila == null) {
            pila = new int[maxLong];
        }  else {
            System.out.println("La pila ya esta inicializada.");
        }

    }

    @Override
    public void apilar(int elemento) {

        if (indexPila < maxLong) {
            pila[indexPila] = elemento;
            indexPila++;
        } else {
            System.out.println("✖️ No se puede apilar mas elementos, la pila se lleno ✖️");
        }

    }

    @Override
    public void desapilar() {

        if (indexPila > 0) {
            indexPila--;
            pila[indexPila] = 0;
        } else {
            System.out.println("✖️ No se puede desapilar, la pila está vacía ✖️");
        }

    }


    @Override
    public int tope() {

        int tope = -1;
        if (pila != null && indexPila > 0) {
            tope = pila[indexPila - 1];
        }else {
            System.out.println("La pila esta vacia o no fue inicializada, se devuelve -1");
        }
        return tope;

    }

    @Override
    public boolean pilaVacia() {

        if (pila == null) {
            System.out.println("La pila no fue inicializada");
            return true;
        }

        return indexPila == 0;

    }
}
