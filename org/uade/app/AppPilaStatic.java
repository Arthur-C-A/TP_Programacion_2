package org.uade.app;

import org.uade.api.PilaTDA;
import org.uade.impl.PilaStatic;

public class AppPilaStatic {

    public static void main(String[] args) {

        PilaTDA pilaOrigen = new PilaStatic();
        PilaTDA pilaDestino = new PilaStatic();

        pilaOrigen.inicializarPila();

        for (int i = 1; i < 6; i++) {
            pilaOrigen.apilar(i);
        }

        pilaDestino.inicializarPila();
        for (int i = 1; i < 6; i++) {
            int valor = pilaOrigen.tope();
            pilaDestino.apilar(valor);
            pilaDestino.desapilar();
        }


    }
}
