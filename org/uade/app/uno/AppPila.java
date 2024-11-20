package org.uade.app.uno;

import org.uade.api.PilaTDA;
import org.uade.utils.PilaOps;
import org.uade.impl.PilaEstatica;

public class AppPila {

    public static void main(String[] args) {
        AppPila app = new AppPila();

        // a) Pasar una Pila a otra (dejándola en orden inverso)
        app.pasarPilaInvertida();

        // b) Copiar una Pila en otra (dejándola en el mismo orden que la original)
        app.pasarPilaEnOrdenOriginal();

        // c) Invertir el contenido de una Pila
        app.invertirContenidoPila();

        // d) Contar los elementos de una Pila
        app.contarElementos();

        // e) Sumar los elementos de una Pila
        app.sumarElementos();

        // f) Calcular el promedio de los elementos de una Pila
        app.calcularPromedioElementos();
    }

    // a) Pasar una Pila a otra (dejándola en orden inverso)
    public void pasarPilaInvertida() {
        System.out.println("Ejercicio a) Pasar una pila a otra en orden inverso:");

        PilaTDA pilaOrigen = new PilaEstatica();
        PilaTDA pilaDestino = new PilaEstatica();

        pilaOrigen.inicializarPila();
        pilaDestino.inicializarPila();

        for (int i = 1; i < 6; i++) {
            pilaOrigen.apilar(i);
        }

        System.out.println("Pila origen antes de transferir: ");
        PilaOps.mostrar(pilaOrigen);

        while (!pilaOrigen.pilaVacia()) {
            int valor = pilaOrigen.tope();
            pilaDestino.apilar(valor);
            pilaOrigen.desapilar();
        }

        System.out.println("Pila destino en orden inverso: ");
        PilaOps.mostrar(pilaDestino);
    }

    // b) Copiar una Pila en otra (dejándola en el mismo orden que la original)
    public void pasarPilaEnOrdenOriginal() {
        System.out.println("\nEjercicio b) Copiar una pila en otra (mismo orden):");

        PilaTDA pilaParaCopiar = new PilaEstatica();
        PilaTDA pilaCopia = new PilaEstatica();
        PilaTDA pilaAuxiliar = new PilaEstatica();

        pilaParaCopiar.inicializarPila();
        pilaCopia.inicializarPila();
        pilaAuxiliar.inicializarPila();

        for (int i = 1; i < 6; i++) {
            pilaParaCopiar.apilar(i);
        }

        System.out.println("Pila original antes de copiar: ");
        PilaOps.mostrar(pilaParaCopiar);

        while (!pilaParaCopiar.pilaVacia()) {
            int valorAux = pilaParaCopiar.tope();
            pilaAuxiliar.apilar(valorAux);
            pilaParaCopiar.desapilar();
        }

        while (!pilaAuxiliar.pilaVacia()) {
            int valor = pilaAuxiliar.tope();
            pilaCopia.apilar(valor);
            pilaAuxiliar.desapilar();
        }

        System.out.println("Pila copiada (mismo orden que la original): ");
        PilaOps.mostrar(pilaCopia);
    }

    // c) Invertir el contenido de una Pila
    public void invertirContenidoPila() {
        System.out.println("\nEjercicio c) Invertir el contenido de una pila:");

        PilaTDA pilaOrigen = new PilaEstatica();
        PilaTDA pilaDestino = new PilaEstatica();

        pilaOrigen.inicializarPila();
        pilaDestino.inicializarPila();

        for (int i = 1; i < 6; i++) {
            pilaOrigen.apilar(i);
        }

        System.out.println("Pila original: ");
        PilaOps.mostrar(pilaOrigen);

        while (!pilaOrigen.pilaVacia()) {
            int valor = pilaOrigen.tope();
            pilaDestino.apilar(valor);
            pilaOrigen.desapilar();
        }

        while (!pilaDestino.pilaVacia()) {
            int valorInvertido = pilaDestino.tope();
            pilaOrigen.apilar(valorInvertido);
            pilaDestino.desapilar();
        }

        System.out.println("Pila invertida: ");
        PilaOps.mostrar(pilaOrigen);
    }

    // d) Contar los elementos de una Pila
    public void contarElementos() {
        System.out.println("\nEjercicio d) Contar los elementos de una pila:");

        PilaTDA pila = new PilaEstatica();
        pila.inicializarPila();

        for (int i = 1; i < 6; i++) {
            pila.apilar(i);
        }

        System.out.println("Pila original: ");
        PilaOps.mostrar(pila);

        int contador = 0;
        while (!pila.pilaVacia()) {
            pila.desapilar();
            contador++;
        }

        System.out.println("Cantidad de elementos en la pila: " + contador);
    }

    // e) Sumar los elementos de una Pila
    public void sumarElementos() {
        System.out.println("\nEjercicio e) Sumar los elementos de una pila:");

        PilaTDA pila = new PilaEstatica();
        pila.inicializarPila();

        for (int i = 1; i < 6; i++) {
            pila.apilar(i);
        }

        System.out.println("Pila original: ");
        PilaOps.mostrar(pila);

        int suma = 0;
        while (!pila.pilaVacia()) {
            suma += pila.tope();
            pila.desapilar();
        }

        System.out.println("Suma de los elementos en la pila: " + suma);
    }

    // f) Calcular el promedio de los elementos de una Pila
    public void calcularPromedioElementos() {
        System.out.println("\nEjercicio f) Calcular el promedio de los elementos de una pila:");

        PilaTDA pila = new PilaEstatica();
        pila.inicializarPila();

        for (int i = 1; i < 6; i++) {
            pila.apilar(i);
        }

        System.out.println("Pila original: ");
        PilaOps.mostrar(pila);

        int suma = 0;
        int contador = 0;
        while (!pila.pilaVacia()) {
            suma += pila.tope();
            pila.desapilar();
            contador++;
        }

        float promedio = (float) suma / contador;
        System.out.println("Promedio de los elementos en la pila: " + promedio);
    }


}
