package org.uade.util;
import org.uade.api.ColaTDA;

import java.util.Scanner;

public class ColaOps {

    public void mostrarCola(ColaTDA cola){
        while(!cola.colaVacia()){
            System.out.println(cola.primero());
            cola.desacolar();
        }
    }

    public void llenarCola(ColaTDA cola, Scanner sc, String nombre){
        System.out.println("Ingrese la cantidad de elementos para la cola "+ nombre);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++){
            System.out.println("Ingrese los elementos de la cola: "+ nombre);
            int element = sc.nextInt();
            cola.acolar(element);

        }

    }


}
