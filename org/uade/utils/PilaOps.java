package org.uade.utils;

import org.uade.api.PilaTDA;

import java.util.Scanner;

public class PilaOps {

    public static void mostrar(PilaTDA pila) {

        while (!pila.pilaVacia()) {
            System.out.println(pila.tope());
            pila.desapilar();
        }
    }

    public static void llenarPila(PilaTDA pila) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de elementos:");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese el valor:");
            int valor = scanner.nextInt();
            pila.apilar(valor);  // Apila el valor en la pila
        }
    }

}
