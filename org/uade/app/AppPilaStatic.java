package org.uade.app;

import org.uade.api.PilaTDA;
import org.uade.impl.PilaStatic;

public class AppPilaStatic {

    public static void main(String[] args) {
        // Pasar una Pila a otra (dejándola en orden inverso)
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
            pilaOrigen.desapilar();
        }

        //Con esto comprobamos que todo ta bom

        System.out.println(pilaOrigen.pilaVacia());

        for (int i = 1; i < 6; i++) {

            System.out.println(pilaDestino.tope());
            pilaDestino.desapilar();

        }

        // Copiar una Pila en otra (dejándola en el mismo orden que la original)

        PilaTDA pilaParaCopiar = new PilaStatic();
        PilaTDA pilaCopia = new PilaStatic();
        PilaTDA pilaAuxiliar = new PilaStatic();

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
