package org.uade.app.uno;

import org.uade.api.ColaTDA;
import org.uade.impl.ColaEstatica;
import org.uade.api.PilaTDA;
import org.uade.impl.PilaDinamica;

import org.uade.utils.ColaOps;

import java.util.Scanner;

public class AppCola {

    public static void main(String[] args) {
        AppCola app = new AppCola();

        // a) Pasar una Cola a otra
        //app.pasarCola();

        // b) Invertir el contenido de una Cola (usando Pilas auxiliares)
        //app.invertirCola();

        // c) Invertir el contenido de una Cola (sin usar Pilas auxiliares)
        //app.invertirColaB();

        // d) Determinar si el final de la Cola C1 coincide con la Cola C2
        //app.coincideFinal();

        // e) Determinar si una Cola es capicúa
        //app.esCapicua();

        // f) Determinar si la Cola C1 es la inversa de la Cola C2
        app.esInversa();
    }

    // a) Pasar una Cola a otra
    private static void pasarCola() {
        System.out.println("Ejercicio a) Pasar una Cola a otra:");

        ColaTDA colaOrigen = new ColaEstatica();
        ColaTDA colaDestino = new ColaEstatica();

        colaOrigen.inicializarCola();
        colaDestino.inicializarCola();

        ColaOps.llenarCola(colaOrigen, new Scanner(System.in), "Cola Origen");

        while (!colaOrigen.colaVacia()) {
            int value = colaOrigen.primero();
            colaDestino.acolar(value);
            colaOrigen.desacolar();
        }
        System.out.println("Elementos de Cola Destino:");
        ColaOps.mostrar(colaDestino);
    }

    // b) Invertir el contenido de una Cola (usando Pilas auxiliares)
    private void invertirCola() {
        ColaTDA colaOrigen = new ColaEstatica();
        ColaTDA colaDestino = new ColaEstatica();
        PilaTDA pilaAux = new PilaDinamica();

        colaOrigen.inicializarCola();
        colaDestino.inicializarCola();
        pilaAux.inicializarPila();

        ColaOps.llenarCola(colaOrigen, new Scanner(System.in), "origen");

        while (!colaOrigen.colaVacia()) {
            int valor = colaOrigen.primero();
            pilaAux.apilar(valor);
            colaOrigen.desacolar();
        }

        while (!pilaAux.pilaVacia()) {
            int valor = pilaAux.tope();
            colaOrigen.acolar(valor);
            ColaOps.mostrar(colaOrigen);
            pilaAux.desapilar();
        }
    }

    // c) Invertir el contenido de una Cola (sin usar Pilas auxiliares)
    private void invertirColaB() {
        System.out.println("\nEjercicio c) Invertir el contenido de una Cola (sin usar Pilas auxiliares):");

        ColaTDA cola = new ColaEstatica();
        ColaTDA auxiliar = new ColaEstatica();

        cola.inicializarCola();
        auxiliar.inicializarCola();

        ColaOps.llenarCola(cola, new Scanner(System.in), "original");

        while (!cola.colaVacia()) {
            int ultimo = ColaOps.extraerUltimo(cola);
            auxiliar.acolar(ultimo);
        }

        System.out.println("Cola invertida:");
        ColaOps.mostrar(auxiliar);
    }

    // d) Determinar si el final de la Cola C1 coincide con la Cola C2
    private void coincideFinal() {
        System.out.println("\nEjercicio d) Determinar si el final de la Cola C1 coincide con la Cola C2:");

        ColaTDA cola1 = new ColaEstatica();
        ColaTDA cola2 = new ColaEstatica();

        cola1.inicializarCola();
        cola2.inicializarCola();

        ColaOps.llenarCola(cola1, new Scanner(System.in), "Cola 1");
        ColaOps.llenarCola(cola2, new Scanner(System.in), "Cola 2");

        boolean coincide = ColaOps.verificarFinal(cola1, cola2);
        System.out.println("¿El final de C1 coincide con C2?: " + coincide);
    }

    // e) Determinar si una Cola es capicúa
    private void esCapicua() {
        System.out.println("\nEjercicio e) Determinar si una Cola es capicúa:");

        ColaTDA cola = new ColaEstatica();
        cola.inicializarCola();

        ColaOps.llenarCola(cola, new Scanner(System.in), "capicúa");

        boolean capicua = ColaOps.verificarCapicua(cola);
        System.out.println("¿La cola es capicúa?: " + capicua);
    }

    // f) Determinar si la Cola C1 es la inversa de la Cola C2
    private void esInversa() {
        System.out.println("\nEjercicio f) Determinar si la Cola C1 es la inversa de la Cola C2:");

        ColaTDA cola1 = new ColaEstatica();
        ColaTDA cola2 = new ColaEstatica();

        cola1.inicializarCola();
        cola2.inicializarCola();

        ColaOps.llenarCola(cola1, new Scanner(System.in), "Cola 1");
        ColaOps.llenarCola(cola2, new Scanner(System.in), "Cola 2");

        boolean inversas = ColaOps.esInversa(cola1, cola2);
        System.out.println("¿C1 es inversa de C2?: " + inversas);
    }
}
