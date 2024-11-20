package org.uade.app;

import org.uade.api.ColaTDA;
import org.uade.api.ConjuntoTDA;
import org.uade.api.DiccionarioSimpleTDA;
import org.uade.api.PilaTDA;
import org.uade.impl.*;
import org.uade.utils.*;

import java.util.Scanner;

public class AppImplementacionesCostos {


    public static void main(String[] args) {

        // Instanciar TDA que se quiere comparar

        // Comparación de Pila
        PilaTDA pilaD = new PilaDinamica();
        PilaTDA pilaE = new PilaEstatica();

        pilaD.inicializarPila();
        pilaE.inicializarPila();

        compararOperacion("Apilar en Pila Estática", () -> {
            PilaOps.llenarPila(pilaE);  // Acolar en Pila Estática
        });

        compararOperacion("Apilar en Pila Dinámica", () -> {
            PilaOps.llenarPila(pilaD);  // Acolar en Pila Dinámica
        });

        // Comparación de Cola
        ColaTDA colaD = new ColaDinamica();
        ColaTDA colaE = new ColaEstatica();

        colaD.inicializarCola();
        colaE.inicializarCola();

        compararOperacion("Acolar en Cola Dinámica", () -> {
            ColaOps.llenarCola(colaD, new Scanner(System.in), "Cola D");
        });

        compararOperacion("Acolar en Cola Estática", () -> {
            ColaOps.llenarCola(colaE, new Scanner(System.in), "Cola E");
        });

        // Comparación de Conjunto
        ConjuntoTDA conjuntoD = new ConjuntoDinamico();
        ConjuntoTDA conjuntoE = new ConjuntoEstatico();

        conjuntoD.inicializarConjunto();
        conjuntoE.inicializarConjunto();

        compararOperacion("Agregar en Conjunto Dinámico", () -> {
            ConjuntoOps.llenarConjunto(conjuntoD);  // Agregar en Conjunto Dinámico
        });

        compararOperacion("Agregar en Conjunto Estático", () -> {
            ConjuntoOps.llenarConjunto(conjuntoE);  // Agregar en Conjunto Estático
        });

        // Comparación de Diccionario
        DiccionarioSimpleTDA diccionarioD = new DiccionarioSimpleDinamico();
        DiccionarioSimpleTDA diccionarioE = new DiccionarioSimpleEstatico();

        diccionarioD.inicializarDiccionario();
        diccionarioE.inicializarDiccionario();

        compararOperacion("Agregar en Diccionario Dinámico", () -> {
            DiccionarioOps.llenarDiccionario(diccionarioD);  // Agregar en Diccionario Dinámico
        });

        compararOperacion("Agregar en Diccionario Estático", () -> {
            DiccionarioOps.llenarDiccionario(diccionarioE);  // Agregar en Diccionario Estático
        });
    }

    private static void compararOperacion(String nombreOperacion, Runnable operacion) {
        long inicio = System.nanoTime();
        operacion.run();
        long fin = System.nanoTime();
        System.out.println(nombreOperacion + " duró: " + (fin - inicio) + " nanosegundos.");
    }
}

