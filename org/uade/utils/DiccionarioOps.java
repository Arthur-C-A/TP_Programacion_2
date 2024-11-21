package org.uade.utils;

import org.uade.api.ColaPrioridadTDA;
import org.uade.api.DiccionarioMultipleTDA;
import org.uade.api.DiccionarioSimpleTDA;
import org.uade.impl.DiccionarioSimpleDinamico;

import java.util.Scanner;

public class DiccionarioOps {

    public static void llenarDiccionario(DiccionarioSimpleTDA diccionario) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de elementos:");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese la clave:");
            int clave = scanner.nextInt();
            System.out.println("Ingrese el valor:");
            int valor = scanner.nextInt();
            diccionario.agregar(clave, valor);
        }
    }

}
