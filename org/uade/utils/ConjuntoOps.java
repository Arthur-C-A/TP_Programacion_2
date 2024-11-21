package org.uade.utils;

import org.uade.api.ConjuntoTDA;
import org.uade.impl.ConjuntoMaxNoAcotado;

import java.util.Scanner;

public class ConjuntoOps {

    public static void llenarConjunto(ConjuntoTDA conjunto) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de elementos:");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese el valor:");
            int valor = scanner.nextInt();
            conjunto.agregar(valor);
        }
    }


    public static void mostrarConj(ConjuntoTDA conjunto) {
        ConjuntoTDA temp = new ConjuntoMaxNoAcotado(); // O estatico
        temp.inicializarConjunto();

        while (!conjunto.conjuntoVacio()) {
            int elemento = conjunto.elegir();
            System.out.println(elemento); // Mostramos el elemento
            temp.agregar(elemento);
            conjunto.sacar(elemento);
        }

        // Restauramos el conjunto original
        while (!temp.conjuntoVacio()) {
            int elemento = temp.elegir();
            conjunto.agregar(elemento);
            temp.sacar(elemento);
        }
    }

    public static void llenarConjunto(ConjuntoTDA destino, ConjuntoTDA origen) {
        ConjuntoTDA temp = new ConjuntoMaxNoAcotado();
        temp.inicializarConjunto();

        while (!origen.conjuntoVacio()) {
            int elemento = origen.elegir();
            origen.sacar(elemento);
            destino.agregar(elemento);
            temp.agregar(elemento);
        }

        while (!temp.conjuntoVacio()) {
            int elemento = temp.elegir();
            temp.sacar(elemento);
            origen.agregar(elemento);
        }
    }


}
