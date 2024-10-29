package org.uade.app;

import org.uade.api.PilaTDA;
import org.uade.api.ColaTDA;
import org.uade.impl.PilaDinamica;
import org.uade.impl.ColaDinamica;
import org.uade.impl.PilaEstatica;
import org.uade.util.ColaOps;

import java.util.Scanner;

public class EjercicioUno {

    public static void main(String[] args) {
        EjercicioUno app = new EjercicioUno();
        PilaTDA pl = new PilaEstatica();
        try {
            pl.apilar(3);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void ejUno(){
        PilaTDA destino = new PilaDinamica();
        ColaTDA origen = new ColaDinamica();

        origen.inicializarCola();
        destino.inicializarPila();

        ColaOps colaOps = new ColaOps();
        Scanner sc = new Scanner(System.in);

        colaOps.llenarCola(origen, sc,"origen");
        sc.close();

        while (!origen.colaVacia()){
            destino.apilar(origen.primero());
            origen.desacolar();
        }

        
    }

}