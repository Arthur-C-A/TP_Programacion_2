package org.uade.impl;

import org.uade.api.ColaTDA;

public class ColaEstatica implements ColaTDA {

    private int[] colaArray;
    private int indiceUltimo;



    // Al ser estatico, la cantidad eleemntos permitidos es de 100 que fueron hardcodeados en colaArray
    // O(1)
    @Override
    public void inicializarCola() {
        indiceUltimo = 0;
        colaArray = new int[100];
    }
    //O(1)
    @Override
    public void acolar(int x) {
        colaArray[indiceUltimo] = x;
        indiceUltimo++;
    }
    // O(n)
    @Override
    public void desacolar() {
        for (int i = 0; i < indiceUltimo - 1; i++) {
            colaArray[i] = colaArray[i + 1];
        }
        indiceUltimo--;
    }
    // O(1)
    @Override
    public boolean colaVacia() {
        return indiceUltimo == 0;
    }
    // O(1)
    @Override
    public int primero() {
        return colaArray[0];
    }
}

