package org.uade.utils;
import org.uade.api.ColaPrioridadTDA;
import org.uade.api.ColaTDA;
import org.uade.api.DiccionarioMultipleTDA;

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



}
