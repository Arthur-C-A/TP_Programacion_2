package org.uade.impl;

import org.uade.api.ColaTDA;

public class ColaDinamica implements ColaTDA {

    private Nodo inicio;
    private Nodo fin;

    // O(1) (Inicializa la estructura, ambos punteros quedan apuntando a null)
    @Override
    public void inicializarCola() {
        inicio = null;
        fin = null;
    }

    // O(1) (Inserta un elemento al final de la cola)
    @Override
    public void acolar(int x) {
        Nodo nuevo = new Nodo(x); // Se crea un nuevo nodo con el valor proporcionado
        if (inicio == null) { // Si la cola está vacía, el nuevo nodo es tanto inicio como fin
            inicio = nuevo;
            fin = nuevo;
        } else { // Caso general: enlazar el nuevo nodo al final y actualizar el puntero "fin"
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    // O(1) (Elimina el primer elemento de la cola)
    @Override
    public void desacolar() {
        if (inicio == null) { // Si la cola está vacía, no hay nada que desacolar
            System.out.println("✖️ No se puede desacolar, la cola está vacía ✖️");
        } else {
            inicio = inicio.siguiente; // Avanzar el puntero "inicio" al siguiente nodo
            if (inicio == null) { // Si la cola queda vacía después de desacolar, "fin" también debe ser null
                fin = null;
            }
        }
    }

    // O(1) (Devuelve el valor del primer elemento de la cola, sin eliminarlo)
    @Override
    public int primero() {
        if (inicio == null) { // Si la cola está vacía, no hay un primer elemento que devolver
            System.out.println("✖️ No hay elementos en la cola ✖️");
            return -1;
        }
        return inicio.dato;
    }

    // O(1) (Verifica si la cola está vacía revisando el puntero "inicio")
    @Override
    public boolean colaVacia() {
        return inicio == null;
    }
}
