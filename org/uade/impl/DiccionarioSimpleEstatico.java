package org.uade.impl;

import org.uade.api.ConjuntoTDA;
import org.uade.api.DiccionarioSimpleTDA;

public class DiccionarioSimpleEstatico implements DiccionarioSimpleTDA {
    private int[] claves;
    private int[] valores;
    private int cantidad;

    public DiccionarioSimpleEstatico() {
        this.claves = new int[100];
        this.valores = new int[100];
        this.cantidad = 0;
    }

    @Override
    public void inicializarDiccionario() {
        cantidad = 0;
    }

    @Override
    public void agregar(int clave, int valor) {
        int pos = obtenerPosicion(clave);
        if (pos == -1) { // Clave no encontrada, agregar nueva entrada
            claves[cantidad] = clave;
            valores[cantidad] = valor;
            cantidad++;
        } else { // Clave encontrada, actualizar valor
            valores[pos] = valor;
        }
    }

    @Override
    public void eliminar(int clave) {
        int pos = obtenerPosicion(clave);
        if (pos != -1) { // Clave encontrada
            claves[pos] = claves[cantidad - 1];
            valores[pos] = valores[cantidad - 1];
            cantidad--;
        }
    }

    @Override
    public int recuperar(int clave) {
        int pos = obtenerPosicion(clave);
        return (pos != -1) ? valores[pos] : -1; // Devuelve -1 si la clave no se encuentra
    }

    @Override
    public ConjuntoTDA claves() {
        ConjuntoTDA conjuntoClaves = new ConjuntoEstatico();
        conjuntoClaves.inicializarConjunto();
        for (int i = 0; i < cantidad; i++) {
            conjuntoClaves.agregar(claves[i]);
        }
        return conjuntoClaves;
    }

    private int obtenerPosicion(int clave) {
        for (int i = 0; i < cantidad; i++) {
            if (claves[i] == clave) {
                return i;
            }
        }
        return -1; // Clave no encontrada
    }
}
