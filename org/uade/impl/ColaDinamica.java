package org.uade.impl;

import org.uade.api.ColaTDA;

public class ColaDinamica implements ColaTDA {

    class Nodo {
        int valor;
        Nodo siguiente;

        // Constructor para inicializar el valor del nodo
        public Nodo(int valor) {
            this.valor = valor;
            this.siguiente = null;
        }
    }

    private Nodo inicio;
    private Nodo fin;

    @Override
    public void inicializarCola() {
        inicio = null;
        fin = null;
    }

    @Override
    public void acolar(int x) {
        Nodo nuevo = new Nodo(x); // Usamos el constructor para asignar el valor
        if (inicio == null) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    @Override
    public void desacolar() {
        if (inicio == null) {
            System.out.println("✖️ No se puede desacolar, la cola está vacía ✖️");
        } else {
            inicio = inicio.siguiente;
            if (inicio == null) {
                fin = null;
            }
        }
    }

    @Override
    public int primero() {
        if (inicio == null) {
            System.out.println("✖️ No hay elementos en la cola ✖️");
            return -1;
        }
        return inicio.valor;
    }

    @Override
    public boolean colaVacia() {
        return inicio == null;
    }
}

