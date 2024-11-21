package org.uade.app.tres;

import org.uade.api.ConjuntoTDA;
import org.uade.api.ColaTDA;
import org.uade.api.PilaTDA;
import org.uade.impl.ConjuntoMaxNoAcotado;
import org.uade.impl.ColaDinamica;
import org.uade.impl.PilaDinamica;
import org.uade.utils.ConjuntoOps;
import org.uade.utils.ColaOps;
import org.uade.utils.PilaOps;

public class ConjuntoApp {

    public static void main(String[] args) {
        //calcularDiferenciaSimetrica();
        //verificarIgualdad();
        //calcularCardinalidad();
        elementosComunesPilaCola();
        verificarPilaYColaIguales();
    }

    public static void calcularDiferenciaSimetrica() {
        ConjuntoTDA conjuntoA = new ConjuntoMaxNoAcotado();
        conjuntoA.inicializarConjunto();

        ConjuntoTDA conjuntoB = new ConjuntoMaxNoAcotado();
        conjuntoB.inicializarConjunto();

        ConjuntoOps.llenarConjunto(conjuntoA);
        ConjuntoOps.llenarConjunto(conjuntoB);

        ConjuntoTDA resultado = diferenciaSimetrica(conjuntoA, conjuntoB);
        ConjuntoOps.mostrarConj(resultado);
    }

    public static ConjuntoTDA diferenciaSimetrica(ConjuntoTDA A, ConjuntoTDA B) {
        ConjuntoTDA resultado = new ConjuntoMaxNoAcotado();
        resultado.inicializarConjunto();

        ConjuntoTDA copiaA = new ConjuntoMaxNoAcotado();
        copiaA.inicializarConjunto();
        ConjuntoOps.llenarConjunto(copiaA, A);

        while (!copiaA.conjuntoVacio()) {
            int elemento = copiaA.elegir();
            copiaA.sacar(elemento);
            if (!B.pertenece(elemento)) {
                resultado.agregar(elemento);
            }
        }

        ConjuntoTDA copiaB = new ConjuntoMaxNoAcotado();
        copiaB.inicializarConjunto();
        ConjuntoOps.llenarConjunto(copiaB, B);

        while (!copiaB.conjuntoVacio()) {
            int elemento = copiaB.elegir();
            copiaB.sacar(elemento);
            if (!A.pertenece(elemento)) {
                resultado.agregar(elemento);
            }
        }

        return resultado;
    }

    public static void verificarIgualdad() {
        ConjuntoTDA conjuntoA = new ConjuntoMaxNoAcotado();
        conjuntoA.inicializarConjunto();

        ConjuntoTDA conjuntoB = new ConjuntoMaxNoAcotado();
        conjuntoB.inicializarConjunto();

        ConjuntoOps.llenarConjunto(conjuntoA);
        ConjuntoOps.llenarConjunto(conjuntoB);

        boolean iguales = sonIguales(conjuntoA, conjuntoB);
        System.out.println("¿Son iguales?: " + iguales);
    }

    public static boolean sonIguales(ConjuntoTDA A, ConjuntoTDA B) {
        ConjuntoTDA copiaA = new ConjuntoMaxNoAcotado();
        copiaA.inicializarConjunto();
        ConjuntoOps.llenarConjunto(copiaA, A);

        while (!copiaA.conjuntoVacio()) {
            int elemento = copiaA.elegir();
            copiaA.sacar(elemento);
            if (!B.pertenece(elemento)) {
                return false;
            }
        }

        return cardinalidad(A) == cardinalidad(B);
    }

    public static void calcularCardinalidad() {
        ConjuntoTDA conjunto = new ConjuntoMaxNoAcotado();
        conjunto.inicializarConjunto();

        ConjuntoOps.llenarConjunto(conjunto);

        int cardinalidad = cardinalidad(conjunto);
        System.out.println("Cardinalidad del conjunto: " + cardinalidad);
    }

    public static int cardinalidad(ConjuntoTDA conjunto) {
        int contador = 0;
        ConjuntoTDA aux = new ConjuntoMaxNoAcotado();
        aux.inicializarConjunto();

        while (!conjunto.conjuntoVacio()) {
            int elemento = conjunto.elegir();
            conjunto.sacar(elemento);
            aux.agregar(elemento);
            contador++;
        }

        while (!aux.conjuntoVacio()) {
            int elemento = aux.elegir();
            aux.sacar(elemento);
            conjunto.agregar(elemento);
        }

        return contador;
    }

    public static void elementosComunesPilaCola() {
        PilaTDA pila = new PilaDinamica();
        pila.inicializarPila();

        ColaTDA cola = new ColaDinamica();
        cola.inicializarCola();

        PilaOps.llenarPila(pila);
        ColaOps.llenarCola(cola, new java.util.Scanner(System.in), "C");

        ConjuntoTDA comunes = elementosComunesPilaCola(pila, cola);
        ConjuntoOps.mostrarConj(comunes);
    }

    public static ConjuntoTDA elementosComunesPilaCola(PilaTDA pila, ColaTDA cola) {
        ConjuntoTDA conjuntoPila = new ConjuntoMaxNoAcotado();
        conjuntoPila.inicializarConjunto();

        ConjuntoTDA conjuntoCola = new ConjuntoMaxNoAcotado();
        conjuntoCola.inicializarConjunto();

        while (!pila.pilaVacia()) {
            conjuntoPila.agregar(pila.tope());
            pila.desapilar();
        }

        while (!cola.colaVacia()) {
            conjuntoCola.agregar(cola.primero());
            cola.desacolar();
        }

        return diferenciaSimetrica(conjuntoPila, conjuntoCola);
    }

    public static void verificarPilaYColaIguales() {
        PilaTDA pila = new PilaDinamica();
        pila.inicializarPila();

        ColaTDA cola = new ColaDinamica();
        cola.inicializarCola();

        PilaOps.llenarPila(pila);
        ColaOps.llenarCola(cola, new java.util.Scanner(System.in), "C");

        boolean sonIguales = pilaYColaIguales(pila, cola);
        System.out.println("¿Pila y Cola tienen los mismos elementos?: " + sonIguales);
    }

    public static boolean pilaYColaIguales(PilaTDA pila, ColaTDA cola) {
        ConjuntoTDA conjuntoPila = new ConjuntoMaxNoAcotado();
        conjuntoPila.inicializarConjunto();

        ConjuntoTDA conjuntoCola = new ConjuntoMaxNoAcotado();
        conjuntoCola.inicializarConjunto();

        while (!pila.pilaVacia()) {
            conjuntoPila.agregar(pila.tope());
            pila.desapilar();
        }

        while (!cola.colaVacia()) {
            conjuntoCola.agregar(cola.primero());
            cola.desacolar();
        }

        return sonIguales(conjuntoPila, conjuntoCola);
    }
}
