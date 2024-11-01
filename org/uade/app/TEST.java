package org.uade.app;

import org.uade.api.ConjuntoTDA;
import org.uade.impl.ConjuntoDinamico;

public class TEST {
    public static void main(String[] args) {


        ConjuntoTDA a = new ConjuntoDinamico();
        a.inicializarConjunto();
        a.agregar(3);
        System.out.println(a.pertenece(3));
        System.out.println(a.elegir());
        System.out.println(a.conjuntoVacio());
    }
}
