package org.uade.app.dos;

import org.uade.api.ConjuntoTDA;
import org.uade.impl.ConjuntoMaxNoAcotado;
import org.uade.utils.ConjuntoOps;

public class ConjuntoApp {

    public static void main(String[] args) {

        // para probar el resto solo cambiar el nombre de los metodos
        ConjuntoTDA c1 = new ConjuntoMaxNoAcotado();
        ConjuntoTDA c2 = new ConjuntoMaxNoAcotado();
        ConjuntoOps.llenarConjunto(c1);
        ConjuntoOps.llenarConjunto(c2);
        ConjuntoTDA v = ConjuntoApp.union(c1, c2);
        ConjuntoOps.mostrarConj(v);

    }

    public static ConjuntoTDA union(ConjuntoTDA c1, ConjuntoTDA c2) {
        ConjuntoTDA resultado = new ConjuntoMaxNoAcotado();
        resultado.inicializarConjunto();

        while (!c1.conjuntoVacio()) {
            int elemento = c1.elegir();
            resultado.agregar(elemento);
            c1.sacar(elemento);
        }

        while (!c2.conjuntoVacio()) {
            int elemento = c2.elegir();
            resultado.agregar(elemento);
            c2.sacar(elemento);
        }

        return resultado;
    }

    public static ConjuntoTDA interseccion(ConjuntoTDA c1, ConjuntoTDA c2) {
        ConjuntoTDA resultado = new ConjuntoMaxNoAcotado();
        resultado.inicializarConjunto();

        // Revisar elementos de c1
        while (!c1.conjuntoVacio()) {
            int elemento = c1.elegir();
            if (c2.pertenece(elemento)) {
                resultado.agregar(elemento);
            }
            c1.sacar(elemento);
        }

        return resultado;
    }

    public static ConjuntoTDA diferencia(ConjuntoTDA c1, ConjuntoTDA c2) {
        ConjuntoTDA resultado = new ConjuntoMaxNoAcotado();
        resultado.inicializarConjunto();

        while (!c1.conjuntoVacio()) {
            int elemento = c1.elegir();
            if (!c2.pertenece(elemento)) {
                resultado.agregar(elemento);
            }
            c1.sacar(elemento);
        }

        return resultado;
    }

}
