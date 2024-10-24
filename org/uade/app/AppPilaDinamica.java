package org.uade.app;
import org.uade.api.PilaTDA;
import org.uade.impl.PilaDinamica;

public class AppPilaDinamica {

    public static void main(String[] args) {
        AppPilaDinamica app = new AppPilaDinamica();

        //app.pasarPilaInvertida();
        //app.copiarPila();
        //app.invertirElementos();
        app.contarElementos();
        app.sumarElementos();
        app.calcularPromedio();

    }

    public void pasarPilaInvertida(){
        PilaTDA pila = new PilaDinamica();
        PilaTDA pilaDestino = new PilaDinamica();
        pila.inicializarPila();
        pilaDestino.inicializarPila();

        //Asignamos valores a la pila
        for (int i = 1; i < 1000; i++) {
            pila.apilar(i);
        }

        while(!pila.pilaVacia()){
            int aux = pila.tope();
            System.out.println("Elemento añadido a la segunda Pila: "+pila.tope());
            pilaDestino.apilar(aux);
            pila.desapilar();
            System.out.println();

        }
    }

    public void copiarPila(){

        PilaTDA pila = new PilaDinamica();
        PilaTDA pilaAux = new PilaDinamica();
        PilaTDA pilaCopia = new PilaDinamica();

        pila.inicializarPila();
        pilaCopia.inicializarPila();

        for (int i = 1; i < 4; i++) {
            pila.apilar(i);
        }

        while (!pila.pilaVacia()){
            int aux = pila.tope();
            pilaAux.apilar(aux);
            pila.desapilar();
            System.out.println();
        }

        while (!pilaAux.pilaVacia()){
            int aux = pilaAux.tope();
            //Mostramos que el orden es el de la copiada (1,2,3)
            System.out.println("Aniadido elemento a la copia : " + aux);
            pilaCopia.apilar(aux);
            pilaAux.desapilar();
        }

    }

    public void invertirElementos(){
            PilaTDA pila = new PilaDinamica();
            PilaTDA pilaAux = new PilaDinamica();
            PilaTDA pilaAux2 = new PilaDinamica();
            pilaAux.inicializarPila();
            pila.inicializarPila();
            pilaAux2.inicializarPila();
        for (int i = 1; i < 4; i++) {
            pila.apilar(i);
        }

        while (!pila.pilaVacia()){
            int aux = pila.tope();
            pilaAux.apilar(aux);
            pila.desapilar();
        }

        while (!pilaAux.pilaVacia()){
            int aux = pilaAux.tope();
            pilaAux2.apilar(aux);
            pilaAux.desapilar();
        }

        while (!pilaAux2.pilaVacia()){
            int aux = pilaAux2.tope();
            System.out.println("Aniadido elemento a la copia : " + aux);
            pila.apilar(aux);
            pilaAux2.desapilar();
        }


    }

    public int contarElementos(){
        int longitudPila = 0;
        PilaTDA pila = new PilaDinamica();
        pila.inicializarPila();

        for (int i = 1; i < 4; i++) {
            pila.apilar(i);
        }

        while (!pila.pilaVacia()){
            int aux = pila.tope();
            pila.desapilar();
            longitudPila += 1;
        }

        return longitudPila;


    }

    public int sumarElementos(){
        PilaTDA pila = new PilaDinamica();
        int sumadorElementos = 0;
        pila.inicializarPila();

        for (int i = 1; i < 4; i++) {
            pila.apilar(i);
        }

        while (!pila.pilaVacia()){
            int aux = pila.tope();
            sumadorElementos += aux;
            pila.desapilar();
        }

        return sumadorElementos;
    }

    public void calcularPromedio(){

        int total = sumarElementos();
        int cant = contarElementos();
        System.out.println("El promedio es" +total/cant);

    }
}
