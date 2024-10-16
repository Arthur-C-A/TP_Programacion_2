package org.uade.impl;

import org.uade.api.PilaTDA;

public class PilaStatic implements PilaTDA {

    private int[] pila;
    private int indexPila = 0;
    private final int maxLong= 5;

    @Override
    public void inicializarPila() {
        if (pila == null) {
            System.out.println("Inicializando Pila...");
            pila = new int[maxLong];
            System.out.println("Pila inicializada✅!");
        }  else {
            System.out.println("La pila ya estaba inicializada.");
        }
    }

    @Override
    public void apilar(int elemento) {
        if (indexPila < maxLong) {
            System.out.println("Apilando " + elemento);
            pila[indexPila] = elemento;
            System.out.println("Se apilo exitosamente "+ elemento);
            indexPila++;
        } else {
            System.out.println("✖️ La pila se lleno ✖️");
        }
    }

    @Override
    public void desapilar() {
        if (indexPila > 0) {
            indexPila--;
            System.out.println("Desapilando " + pila[indexPila]);
            pila[indexPila] = 0;
            System.out.println("Se desapiló con éxito " + pila[indexPila]);
        } else {
            System.out.println("✖️ No se puede desapilar, la pila está vacía ✖️");
        }
    }


    @Override
    public int tope() {
        int tope = -1;
        if (pila != null && indexPila > 0) {
            tope = pila[indexPila - 1];
            System.out.println("El Tope es: " + tope);
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
