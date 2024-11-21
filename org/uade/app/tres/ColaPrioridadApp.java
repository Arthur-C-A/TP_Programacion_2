package org.uade.app.tres;

import org.uade.api.ColaPrioridadTDA;
import org.uade.api.ConjuntoTDA;
import org.uade.impl.ConjuntoMaxNoAcotado;
import org.uade.impl.ColaPrioridadEstatica;
import org.uade.utils.ColaOps;
import org.uade.utils.ConjuntoOps;

import java.util.Scanner;

public class ColaPrioridadApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ColaPrioridadTDA cola = new ColaPrioridadEstatica();
        cola.inicializarCola();

        ColaOps.llenarCola(cola, sc, "cola");

        generarConjuntosDePrioridades(cola);

        mostrarConjuntosDePrioridades(cola);
    }

    public static void generarConjuntosDePrioridades(ColaPrioridadTDA cola) {
        ConjuntoTDA valores = new ConjuntoMaxNoAcotado();
        valores.inicializarConjunto();

        ConjuntoTDA prioridades = new ConjuntoMaxNoAcotado();
        prioridades.inicializarConjunto();

        while (!cola.colaVacia()) {
            int valor = cola.primero();
            int prioridad = cola.prioridad();
            cola.desacolar();

            if (valores.pertenece(valor)) {
                ConjuntoTDA conjuntoDePrioridades = new ConjuntoMaxNoAcotado();
                conjuntoDePrioridades.inicializarConjunto();
                ConjuntoOps.llenarConjunto(conjuntoDePrioridades, prioridades); // Copia las prioridades anteriores

                conjuntoDePrioridades.agregar(prioridad);
                ConjuntoOps.llenarConjunto(prioridades, conjuntoDePrioridades);
            } else {
                valores.agregar(valor);
                prioridades.agregar(prioridad);
            }
        }
    }


    public static void mostrarConjuntosDePrioridades(ColaPrioridadTDA cola) {
        ConjuntoTDA valores = new ConjuntoMaxNoAcotado();
        valores.inicializarConjunto();
        ConjuntoTDA prioridades = new ConjuntoMaxNoAcotado();
        prioridades.inicializarConjunto();

        // Recorremos la cola para mostrar los valores y sus prioridades
        while (!cola.colaVacia()) {
            int valor = cola.primero();
            int prioridad = cola.prioridad();
            cola.desacolar();

            valores.agregar(valor);
            prioridades.agregar(prioridad);

            System.out.println("Valor: " + valor + " tiene prioridad: ");
            ConjuntoOps.mostrarConj(prioridades);
        }
    }
}
