package org.uade.app;

import org.uade.api.PilaTDA;
import org.uade.impl.PilaEstatica;

public class AppPilaEstatica {

    public static void main(String[] args) {




    }

    // Pasar una Pila a otra (dejándola en orden inverso)

    public void pasarPilaInvertida() {

        PilaTDA pilaOrigen = new PilaEstatica();
        PilaTDA pilaDestino = new PilaEstatica();

        pilaOrigen.inicializarPila();

        for (int i = 1; i < 6; i++) {
            pilaOrigen.apilar(i);
        }

        pilaDestino.inicializarPila();
        for (int i = 1; i < 6; i++) {
            int valor = pilaOrigen.tope();
            pilaDestino.apilar(valor);
            pilaOrigen.desapilar();
        }

        /* Revision */

        System.out.println(pilaOrigen.pilaVacia());

        for (int i = 1; i < 6; i++) {

            System.out.println(pilaDestino.tope());
            pilaDestino.desapilar();

        }
    }
        // Copiar una Pila en otra (dejándola en el mismo orden que la original)

        public void pasarPilaEnOrdenOriginal() {

            PilaTDA pilaParaCopiar = new PilaEstatica();
            PilaTDA pilaCopia = new PilaEstatica();
            PilaTDA pilaAuxiliar = new PilaEstatica();

            pilaParaCopiar.inicializarPila();

            for (int i = 1; i < 6; i++) {
                pilaParaCopiar.apilar(i);
            }
            pilaAuxiliar.inicializarPila();
            pilaCopia.inicializarPila();

            for (int i = 1; i < 6; i++) {
                int valorAux = pilaParaCopiar.tope();
                pilaAuxiliar.apilar(valorAux);
                pilaParaCopiar.desapilar();

            }

            for (int i = 1; i < 6; i++) {
                int valor = pilaAuxiliar.tope();
                pilaCopia.apilar(valor);
                pilaAuxiliar.desapilar();
            }
        }
}

