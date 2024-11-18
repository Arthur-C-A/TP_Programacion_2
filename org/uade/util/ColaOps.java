package org.uade.util;
import org.uade.api.ColaPrioridadTDA;
import org.uade.api.ColaTDA;
import org.uade.api.PilaTDA;
import org.uade.impl.ColaEstatica;
import org.uade.impl.PilaDinamica;

import java.util.Scanner;

public class ColaOps {

    public static void mostrar(ColaTDA cola) {
        while (!cola.colaVacia()) {
            System.out.println(cola.primero());
            cola.desacolar();
        }
    }

    public static void llenarCola(ColaTDA cola, Scanner scanner, String nombre) {
        System.out.println("Ingrese la cantidad de elementos para la cola " + nombre + ":");
        int n = scanner.nextInt();

        System.out.println("Ingrese los elementos de la cola " + nombre + ":");
        for (int i = 0; i < n; i++) {
            int elemento = scanner.nextInt();
            cola.acolar(elemento);
        }
    }

    public static boolean esInversa(ColaTDA cola1, ColaTDA cola2) {
        PilaTDA pila = new PilaDinamica();
        pila.inicializarPila();

        while (!cola2.colaVacia()) {
            pila.apilar(cola2.primero());
            cola2.desacolar();
        }

        while (!cola1.colaVacia() && !pila.pilaVacia()) {
            if (cola1.primero() != pila.tope()) {
                return false;
            }
            cola1.desacolar();
            pila.desapilar();
        }

        return cola1.colaVacia() && pila.pilaVacia();
    }

    public static boolean verificarCapicua(ColaTDA cola) {
        PilaTDA pila = new PilaDinamica();
        pila.inicializarPila();

        ColaTDA copia = new ColaEstatica();
        copia.inicializarCola();

        while (!cola.colaVacia()) {
            int elemento = cola.primero();
            pila.apilar(elemento);
            copia.acolar(elemento);
            cola.desacolar();
        }

        boolean esCapicua = true;
        while (!copia.colaVacia() && !pila.pilaVacia()) {
            if (copia.primero() != pila.tope()) {
                esCapicua = false;
                break;
            }
            copia.desacolar();
            pila.desapilar();
        }
        return esCapicua;
    }

    public static boolean verificarFinal(ColaTDA cola1, ColaTDA cola2) {
        while (!cola1.colaVacia() && !cola2.colaVacia()) {
            int valor1 = cola1.primero();
            cola1.desacolar();
            if (!cola2.colaVacia()) {
                int valor2 = cola2.primero();
                cola2.desacolar();
                if (cola1.colaVacia() && cola2.colaVacia() && valor1 == valor2) {
                    return true;
                }
            }
        }
        return false;
    }


    public static int extraerUltimo(ColaTDA cola) {
        ColaTDA auxiliar = new ColaEstatica();
        auxiliar.inicializarCola();

        int ultimo = 0;
        while (!cola.colaVacia()) {
            ultimo = cola.primero();
            cola.desacolar();
            if (!cola.colaVacia()) {
                auxiliar.acolar(ultimo);
            }
        }
        return ultimo;
    }

    // Version para Cola Prioridad
    public static void llenarCola(ColaPrioridadTDA cola) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de elementos:");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese el valor:");
            int valor = scanner.nextInt();
            System.out.println("Ingrese la prioridad:");
            int prioridad = scanner.nextInt();
            cola.acolarPrioridad(valor, prioridad);
        }
    }
    // Version para cola Prioridad
    public static void mostrarCola(ColaPrioridadTDA cola) {
        while (!cola.colaVacia()) {
            System.out.println("Valor: " + cola.primero() + ", Prioridad: " + cola.prioridad());
            cola.desacolar();
        }
    }


    public static boolean compararColas(ColaPrioridadTDA cp1, ColaPrioridadTDA cp2) {
        while (!cp1.colaVacia() && !cp2.colaVacia()) {
            if (cp1.primero() != cp2.primero() || cp1.prioridad() != cp2.prioridad()) {
                return false;
            }
            cp1.desacolar();
            cp2.desacolar();
        }
        return cp1.colaVacia() && cp2.colaVacia();
    }

}
