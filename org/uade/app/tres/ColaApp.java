package org.uade.app.tres;

import org.uade.api.ColaTDA;
import org.uade.api.ConjuntoTDA;
import org.uade.impl.ColaDinamica;
import org.uade.impl.ConjuntoMaxNoAcotado;
import org.uade.utils.ColaOps;
import org.uade.utils.ConjuntoOps;

import java.util.Scanner;

public class ColaApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //eliminarRepetidos(scanner);

        //repartirCola(scanner);

        elementosRepetidos(scanner);
    }

    public static void eliminarRepetidos(Scanner scanner) {
        ColaTDA cola = new ColaDinamica();
        cola.inicializarCola();

        ColaOps.llenarCola(cola, scanner, "C");

        System.out.println("Cola original:");
        ColaOps.mostrarCola(cola);

        ConjuntoTDA conjunto = new ConjuntoMaxNoAcotado();
        conjunto.inicializarConjunto();

        ColaTDA aux = new ColaDinamica();
        aux.inicializarCola();

        while (!cola.colaVacia()) {
            int elemento = cola.primero();
            cola.desacolar();

            if (!conjunto.pertenece(elemento)) {
                conjunto.agregar(elemento);
                aux.acolar(elemento);
            }
        }

        while (!aux.colaVacia()) {
            cola.acolar(aux.primero());
            aux.desacolar();
        }

        System.out.println("Cola sin elementos repetidos:");
        ColaOps.mostrarCola(cola);
    }

    public static void repartirCola(Scanner scanner) {
        ColaTDA cola = new ColaDinamica();
        cola.inicializarCola();

        ColaOps.llenarCola(cola, scanner, "C");

        System.out.println("Cola original:");
        ColaOps.mostrarCola(cola);

        ColaTDA mitad1 = new ColaDinamica();
        ColaTDA mitad2 = new ColaDinamica();
        mitad1.inicializarCola();
        mitad2.inicializarCola();

        ColaTDA aux = new ColaDinamica();
        aux.inicializarCola();

        int totalElementos = 0;

        while (!cola.colaVacia()) {
            aux.acolar(cola.primero());
            cola.desacolar();
            totalElementos++;
        }

        int mitad = totalElementos / 2;

        for (int i = 0; i < mitad; i++) {
            mitad1.acolar(aux.primero());
            aux.desacolar();
        }

        while (!aux.colaVacia()) {
            mitad2.acolar(aux.primero());
            aux.desacolar();
        }

        System.out.println("Primera mitad:");
        ColaOps.mostrarCola(mitad1);
        System.out.println("Segunda mitad:");
        ColaOps.mostrarCola(mitad2);
    }

    public static void elementosRepetidos(Scanner scanner) {
        ColaTDA cola = new ColaDinamica();
        cola.inicializarCola();

        ColaOps.llenarCola(cola, scanner, "C");

        System.out.println("Cola original:");
        ColaOps.mostrarCola(cola);

        ConjuntoTDA vistos = new ConjuntoMaxNoAcotado();
        ConjuntoTDA repetidos = new ConjuntoMaxNoAcotado();
        vistos.inicializarConjunto();
        repetidos.inicializarConjunto();

        ColaTDA aux = new ColaDinamica();
        aux.inicializarCola();

        while (!cola.colaVacia()) {
            int elemento = cola.primero();
            cola.desacolar();

            if (vistos.pertenece(elemento)) {
                repetidos.agregar(elemento);
            } else {
                vistos.agregar(elemento);
            }

            aux.acolar(elemento);
        }

        while (!aux.colaVacia()) {
            cola.acolar(aux.primero());
            aux.desacolar();
        }

        System.out.println("Elementos repetidos:");
        ConjuntoOps.mostrarConj(repetidos);
    }
}
