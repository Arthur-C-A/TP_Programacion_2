package org.uade.utils;
import org.uade.api.ColaPrioridadTDA;
import org.uade.api.ColaTDA;
import org.uade.api.DiccionarioMultipleTDA;
import org.uade.api.PilaTDA;
import org.uade.impl.ColaEstatica;
import org.uade.impl.PilaDinamica;

import java.util.Scanner;

public class ColaOps {

    public static void mostrarCola(ColaTDA cola) {
        while (!cola.colaVacia()) {
            System.out.println(cola.primero());
            cola.desacolar();
        }
    }

    public static void mostrarCola(ColaPrioridadTDA cola) {
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

    public static void llenarCola(ColaPrioridadTDA cola, Scanner scanner, String nombre) {
        System.out.println("Ingrese la cantidad de elementos para la cola " + nombre + ":");
        int n = scanner.nextInt();

        System.out.println("Ingrese los elementos de la cola " + nombre + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese el valor del elemento " + (i + 1) + ":");
            int valor = scanner.nextInt();

            System.out.println("Ingrese la prioridad del elemento " + (i + 1) + ":");
            int prioridad = scanner.nextInt();

            // Agregamos el valor y la prioridad a la cola
            cola.acolarPrioridad(valor, prioridad);
        }
    }

    public static int extraerUltimo(ColaTDA cola) {
        // Crear una cola auxiliar para almacenar los elementos mientras extraemos
        ColaTDA colaAuxiliar = new ColaEstatica();
        colaAuxiliar.inicializarCola();

        // Desacolar todos los elementos hasta que la cola esté vacía
        int ultimo = -1;
        while (!cola.colaVacia()) {
            ultimo = cola.primero();  // Tomamos el primero (último en la cola original)
            cola.acolar(ultimo);  // Acomodamos temporalmente en colaAuxiliar
            colaAuxiliar.acolar(ultimo);
            cola.desacolar();   // Extraemos el primer elemento de la cola
        }

        // Devolver el último elemento
        return ultimo;
    }

    private static int tamanoCola(ColaTDA cola) {
        int tamaño = 0;
        ColaTDA colaAux = new ColaEstatica();
        colaAux.inicializarCola();

        // Pasamos los elementos a una cola auxiliar para contar
        while (!cola.colaVacia()) {
            int valor = cola.primero();
            colaAux.acolar(valor);
            cola.desacolar();
            tamaño++;
        }

        // Recuperamos los elementos originales en la cola
        while (!colaAux.colaVacia()) {
            cola.acolar(colaAux.primero());
            colaAux.desacolar();
        }

        return tamaño;
    }

    public static boolean verificarCapicua(ColaTDA cola) {
        // Si la cola está vacía o tiene un solo elemento, es capicúa por definición
        if (cola.colaVacia() || tamanoCola(cola) == 1) {
            return true;
        }

        // Usamos una pila auxiliar para verificar si los elementos son iguales en orden inverso
        PilaTDA pila = new PilaDinamica();
        pila.inicializarPila();

        // Copiamos los elementos de la cola a la pila
        ColaTDA colaAux = new ColaEstatica();
        colaAux.inicializarCola();

        // Llenamos la cola auxiliar con los elementos de la cola original
        while (!cola.colaVacia()) {
            int valor = cola.primero();
            colaAux.acolar(valor);
            pila.apilar(valor);
            cola.desacolar();
        }

        // Comprobamos si los elementos de la cola son los mismos que los de la pila
        while (!colaAux.colaVacia()) {
            if (colaAux.primero() != pila.tope()) {
                return false;  // Si algún elemento no coincide, no es capicúa
            }
            colaAux.desacolar();
            pila.desapilar();
        }

        // Si todos los elementos coinciden, la cola es capicúa
        return true;
    }


    public static boolean verificarFinal(ColaTDA cola1, ColaTDA cola2) {
        // Crear colas auxiliares para invertir las colas originales
        ColaTDA cola1Invertida = new ColaEstatica();
        ColaTDA cola2Invertida = new ColaEstatica();

        cola1Invertida.inicializarCola();
        cola2Invertida.inicializarCola();

        // Invertir las colas
        while (!cola1.colaVacia()) {
            cola1Invertida.acolar(cola1.primero());
            cola1.desacolar();
        }

        while (!cola2.colaVacia()) {
            cola2Invertida.acolar(cola2.primero());
            cola2.desacolar();
        }

        // Comparar los elementos de las colas invertidas
        boolean coincide = true;

        while (!cola1Invertida.colaVacia() && !cola2Invertida.colaVacia()) {
            if (cola1Invertida.primero() != cola2Invertida.primero()) {
                coincide = false;
                break;
            }
            cola1Invertida.desacolar();
            cola2Invertida.desacolar();
        }

        // Si las dos colas tienen diferentes tamaños, no coinciden
        if (!cola1Invertida.colaVacia() || !cola2Invertida.colaVacia()) {
            coincide = false;
        }

        return coincide;
    }

    public static boolean esInversa(ColaTDA cola1, ColaTDA cola2) {
        // Si las colas no tienen el mismo tamaño, no pueden ser inversas
        if (tamanoCola(cola1) != tamanoCola(cola2)) {
            return false;
        }

        // Usamos una pila auxiliar para almacenar los elementos de la primera cola
        PilaTDA pila = new PilaDinamica();
        pila.inicializarPila();

        // Llenamos la pila con los elementos de la primera cola
        while (!cola1.colaVacia()) {
            int valor = cola1.primero();
            pila.apilar(valor);
            cola1.desacolar();
        }

        // Comparamos los elementos de la segunda cola con la pila
        while (!cola2.colaVacia()) {
            int valor = cola2.primero();
            if (valor != pila.tope()) {
                return false;  // Si algún valor no coincide, no son inversas
            }
            cola2.desacolar();
            pila.desapilar();
        }

        return true; // Si todos los elementos coinciden, las colas son inversas
    }

    public static boolean compararColas(ColaTDA cola1, ColaTDA cola2) {
        // Si las colas no tienen el mismo tamaño, no pueden ser iguales
        if (tamanoCola(cola1) != tamanoCola(cola2)) {
            return false;
        }

        // Comparamos los elementos de las dos colas
        while (!cola1.colaVacia() && !cola2.colaVacia()) {
            int valor1 = cola1.primero();
            int valor2 = cola2.primero();
            if (valor1 != valor2) {
                return false;  // Si algún valor no coincide, las colas no son iguales
            }
            cola1.desacolar();
            cola2.desacolar();
        }

        // Si ambas colas están vacías y todos los elementos coincidieron, son iguales
        return true;
    }

    public static boolean compararColas(ColaPrioridadTDA cola1, ColaPrioridadTDA cola2) {
        if (tamanoCola((ColaTDA) cola1) != tamanoCola((ColaTDA) cola2)) {
            return false;
        }

        // Comparamos los elementos de las dos colas
        while (!cola1.colaVacia() && !cola2.colaVacia()) {
            int valor1 = cola1.primero();
            int valor2 = cola2.primero();
            if (valor1 != valor2) {
                return false;  // Si algún valor no coincide, las colas no son iguales
            }
            cola1.desacolar();
            cola2.desacolar();
        }

        // Si ambas colas están vacías y todos los elementos coincidieron, son iguales
        return true;
    }


}
