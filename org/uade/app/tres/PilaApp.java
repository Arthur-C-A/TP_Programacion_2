package org.uade.app.tres;

import org.uade.api.ConjuntoTDA;
import org.uade.api.PilaTDA;
import org.uade.impl.ConjuntoMaxNoAcotado;
import org.uade.impl.PilaDinamica;
import org.uade.utils.PilaOps;
import org.uade.utils.ConjuntoOps;

public class PilaApp {

    public static void main(String[] args) {
        esCapicua();

        eliminarRepetidos();

        repartirPila();

        elementosRepetidos();
    }

    public static void esCapicua() {
        PilaTDA pila = new PilaDinamica();
        pila.inicializarPila();

        PilaOps.llenarPila(pila);

        System.out.println("Pila original:");
        PilaOps.mostrar(pila);

        PilaTDA invertida = new PilaDinamica();
        invertida.inicializarPila();

        while (!pila.pilaVacia()) {
            invertida.apilar(pila.tope());
            pila.desapilar();
        }

        boolean capicua = true;

        while (!invertida.pilaVacia()) {
            int elemento = invertida.tope();
            invertida.desapilar();
            pila.apilar(elemento);

            if (!invertida.pilaVacia() && elemento != invertida.tope()) {
                capicua = false;
            }
        }

        System.out.println("es capicua?: " + capicua);
    }

    public static void eliminarRepetidos() {
        PilaTDA pila = new PilaDinamica();
        pila.inicializarPila();

        PilaOps.llenarPila(pila);

        System.out.println("Pila original:");
        PilaOps.mostrar(pila);

        ConjuntoTDA conjunto = new ConjuntoMaxNoAcotado();
        conjunto.inicializarConjunto();

        PilaTDA aux = new PilaDinamica();
        aux.inicializarPila();

        while (!pila.pilaVacia()) {
            int elemento = pila.tope();
            pila.desapilar();

            if (!conjunto.pertenece(elemento)) {
                conjunto.agregar(elemento);
                aux.apilar(elemento);
            }
        }

        while (!aux.pilaVacia()) {
            pila.apilar(aux.tope());
            aux.desapilar();
        }

        System.out.println("Pila sin elementos repetidos:");
        PilaOps.mostrar(pila);
    }

    public static void repartirPila() {
        PilaTDA pila = new PilaDinamica();
        pila.inicializarPila();

        PilaOps.llenarPila(pila);

        System.out.println("Pila original:");
        PilaOps.mostrar(pila);

        PilaTDA aux = new PilaDinamica();
        aux.inicializarPila();

        int totalElementos = 0;

        while (!pila.pilaVacia()) {
            aux.apilar(pila.tope());
            pila.desapilar();
            totalElementos++;
        }

        int mitad = totalElementos / 2;

        PilaTDA mitad1 = new PilaDinamica();
        mitad1.inicializarPila();

        PilaTDA mitad2 = new PilaDinamica();
        mitad2.inicializarPila();

        for (int i = 0; i < mitad; i++) {
            mitad1.apilar(aux.tope());
            aux.desapilar();
        }

        while (!aux.pilaVacia()) {
            mitad2.apilar(aux.tope());
            aux.desapilar();
        }

        System.out.println("Primera mitad:");
        PilaOps.mostrar(mitad1);
        System.out.println("Segunda mitad:");
        PilaOps.mostrar(mitad2);
    }

    public static void elementosRepetidos() {
        PilaTDA pila = new PilaDinamica();
        pila.inicializarPila();

        PilaOps.llenarPila(pila);

        System.out.println("Pila original:");
        PilaOps.mostrar(pila);

        ConjuntoTDA vistos = new ConjuntoMaxNoAcotado();
        ConjuntoTDA repetidos = new ConjuntoMaxNoAcotado();
        vistos.inicializarConjunto();
        repetidos.inicializarConjunto();

        PilaTDA aux = new PilaDinamica();
        aux.inicializarPila();

        while (!pila.pilaVacia()) {
            int elemento = pila.tope();
            pila.desapilar();

            if (vistos.pertenece(elemento)) {
                repetidos.agregar(elemento);
            } else {
                vistos.agregar(elemento);
            }

            aux.apilar(elemento);
        }

        while (!aux.pilaVacia()) {
            pila.apilar(aux.tope());
            aux.desapilar();
        }

        System.out.println("Elementos repetidos:");
        ConjuntoOps.mostrarConj(repetidos);
    }
}
