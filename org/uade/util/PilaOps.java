package org.uade.util;

import org.uade.api.PilaTDA;

public class PilaOps {

    public static void mostrar(PilaTDA pila) {

        while (!pila.pilaVacia()) {
            System.out.println(pila.tope());
            pila.desapilar();
        }
    }

}
