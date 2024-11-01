package org.uade.util;

import org.uade.api.ConjuntoTDA;
import org.uade.impl.ConjuntoDinamico;

public class ConjuntoOps {

    public void mostrarConj(ConjuntoTDA conjunto) {
        ConjuntoTDA temp = new ConjuntoDinamico(); // O estatico
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

}
