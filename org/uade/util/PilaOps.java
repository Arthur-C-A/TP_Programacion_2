package org.uade.util;

import org.uade.api.PilaTDA;
import org.uade.impl.PilaDinamica;

import java.util.Scanner;

public class PilaOps {

    public void mostrar(PilaTDA pila) {

        while (!pila.pilaVacia()) {
            System.out.println(pila.tope());
            pila.desapilar();
        }
    }

    public void llenar(PilaTDA pila, Scanner scanner, String nombre) {
        System.out.println("Ingrese la cantidad de elementos para la pila " + nombre + ":");
        int n = scanner.nextInt();

        System.out.println("Ingrese los elementos de la pila " + nombre + ":");
        for (int i = 0; i < n; i++) {
            int elemento = scanner.nextInt();
            pila.apilar(elemento);
        }
    }

    public boolean contieneElemento(PilaTDA mod, int elementoDada) {
        PilaTDA aux = new PilaDinamica();
        aux.inicializarPila();

        boolean encontrado = false;

        while (!mod.pilaVacia()) {
            int elementoMod = mod.tope();
            mod.desapilar();

            if (elementoMod == elementoDada) {
                encontrado = true;
            }

            aux.apilar(elementoMod);
        }

        while (!aux.pilaVacia()) {
            mod.apilar(aux.tope());
            aux.desapilar();
        }

        return encontrado;
    }

    public void pasarPila(PilaTDA origen, PilaTDA destino) {
        while (!origen.pilaVacia()) {
            destino.apilar(origen.tope());
            origen.desapilar();
        }
    }

    public int contarElementos(PilaTDA pila) {
        int contador = 0;

        PilaTDA aux = new PilaDinamica();
        aux.inicializarPila();

        while (!pila.pilaVacia()) {
            aux.apilar(pila.tope());
            pila.desapilar();
            contador++;
        }

        while (!aux.pilaVacia()) {
            pila.apilar(aux.tope());
            aux.desapilar();
        }

        return contador;
    }
}