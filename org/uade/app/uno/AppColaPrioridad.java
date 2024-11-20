package org.uade.app.uno;

import org.uade.api.ColaPrioridadTDA;
import org.uade.impl.ColaPrioridadDinamica;
import org.uade.utils.ColaOps;

public class AppColaPrioridad {

    public static void main(String[] args) {
        AppColaPrioridad app = new AppColaPrioridad();

        // a) Combinar dos colas con prioridades CP1 y CP2, generando una nueva
        app.combinarColas();

        // b) Determinar si dos Colas con prioridad son idénticas
        app.esIgual();
    }

    // a) Combinar dos colas con prioridades CP1 y CP2, generando una nueva
    private void combinarColas() {
        System.out.println("Ejercicio a) Combinar dos colas con prioridades:");

        ColaPrioridadTDA cp1 = new ColaPrioridadDinamica();
        ColaPrioridadTDA cp2 = new ColaPrioridadDinamica();
        ColaPrioridadTDA resultado = new ColaPrioridadDinamica();

        cp1.inicializarCola();
        cp2.inicializarCola();
        resultado.inicializarCola();

        System.out.println("Ingrese los elementos de la Cola Prioridad 1:");
        ColaOps.llenarCola(cp1);

        System.out.println("Ingrese los elementos de la Cola Prioridad 2:");
        ColaOps.llenarCola(cp2);

        while (!cp1.colaVacia() || !cp2.colaVacia()) {
            if (cp1.colaVacia()) {
                resultado.acolarPrioridad(cp2.primero(), cp2.prioridad());
                cp2.desacolar();
            } else if (cp2.colaVacia()) {
                resultado.acolarPrioridad(cp1.primero(), cp1.prioridad());
                cp1.desacolar();
            } else if (cp1.prioridad() >= cp2.prioridad()) {
                resultado.acolarPrioridad(cp1.primero(), cp1.prioridad());
                cp1.desacolar();
            } else {
                resultado.acolarPrioridad(cp2.primero(), cp2.prioridad());
                cp2.desacolar();
            }
        }

        System.out.println("Cola combinada:");
        ColaOps.mostrarCola(resultado);
    }

    // b) Determinar si dos Colas con prioridad son idénticas
    private void esIgual() {
        System.out.println("\nEjercicio b) Determinar si dos colas con prioridad son idénticas:");

        ColaPrioridadTDA cp1 = new ColaPrioridadDinamica();
        ColaPrioridadTDA cp2 = new ColaPrioridadDinamica();

        cp1.inicializarCola();
        cp2.inicializarCola();

        System.out.println("Ingrese los elementos de la Cola Prioridad 1:");
        ColaOps.llenarCola(cp1);

        System.out.println("Ingrese los elementos de la Cola Prioridad 2:");
        ColaOps.llenarCola(cp2);

        boolean iguales = ColaOps.compararColas(cp1, cp2);
        System.out.println("¿Son idénticas las colas?: " + iguales);
    }
}
