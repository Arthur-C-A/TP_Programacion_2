package org.uade.app.cuatro;

import org.uade.api.ConjuntoTDA;
import org.uade.app.dos.ConjuntoApp;
import org.uade.impl.ArbolTDA;
import org.uade.api.ABBTDA;
import org.uade.impl.ConjuntoMaxNoAcotado;
import org.uade.utils.ConjuntoOps;

import java.util.Scanner;

public class ArbolApp {

    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            ABBTDA arbol = new ArbolTDA();
            arbol.inicializarArbol();

            System.out.println("Agregar elementos al árbol:");
            arbol.agregar(50);
            arbol.agregar(30);
            arbol.agregar(70);
            arbol.agregar(20);
            arbol.agregar(40);
            arbol.agregar(60);
            arbol.agregar(80);

            System.out.println("¿Está el elemento 40 en el árbol? " + estaEnArbolRecursivo(arbol, 40));

            System.out.println("¿Es la hoja el elemento 20? " + esHojaRecursivo(arbol, 20));

            System.out.println("Profundidad del elemento 40: " + profundidadRecursiva(arbol, 40));

            System.out.println("Menor elemento del árbol: " + obtenerMenorElementoIterativo(arbol));

            System.out.println("Cantidad de elementos en el árbol: " + contarElementosRecursivo(arbol));

            System.out.println("Suma de los elementos en el árbol: " + sumaElementosRecursivo(arbol));

            System.out.println("Cantidad de hojas en el árbol: " + contarHojasRecursivo(arbol));

            System.out.println("Altura del árbol: " + calcularAlturaRecursiva(arbol));

            System.out.println("¿Tienen la misma forma el árbol y otro árbol? " + comprobarMismaForma(arbol, arbol));

            System.out.println("es igual: " + comprobarIgualdad(arbol, arbol));

            System.out.println("elements iguales en lv2" + contarElementosNivel(arbol, 2));

            System.out.println("Elementos del árbol en In-orden:");
            recorrerInOrden(arbol);

            System.out.println("Elementos del árbol en Pre-orden:");
            recorrerPreOrden(arbol);

            System.out.println("Elementos del árbol en Post-orden:");
            recorrerPostOrden(arbol);

            System.out.println("Elementos mayores que 50:");
            ConjuntoTDA elementosMayores = elementosMayoresQue(arbol, 50);
            ConjuntoOps.mostrarConj(elementosMayores);
        }

    public static boolean estaEnArbolRecursivo(ABBTDA arbol, int x) {
        if (arbol.arbolVacio()) {
            return false;
        }
        return buscarElementoEnArbol(arbol, x);
    }

    private static boolean buscarElementoEnArbol(ABBTDA arbol, int x) {
        if (arbol.arbolVacio()) {
            return false;
        }
        if (x == arbol.raiz()) {
            return true;
        }
        return x < arbol.raiz()
                ? buscarElementoEnArbol(arbol.hijoIzq(), x)
                : buscarElementoEnArbol(arbol.hijoDer(), x);
    }

    public static boolean esHojaRecursivo(ABBTDA arbol, int x) {
        if (arbol.arbolVacio()) {
            return false;
        }
        return verificarSiEsHoja(arbol, x);
    }

    private static boolean verificarSiEsHoja(ABBTDA arbol, int x) {
        if (arbol.arbolVacio()) {
            return false;
        }
        if (x == arbol.raiz()) {
            return arbol.hijoIzq().arbolVacio() && arbol.hijoDer().arbolVacio();
        }
        return x < arbol.raiz()
                ? verificarSiEsHoja(arbol.hijoIzq(), x)
                : verificarSiEsHoja(arbol.hijoDer(), x);
    }

    public static int profundidadRecursiva(ABBTDA arbol, int x) {
        return calcularProfundidad(arbol, x, 0);
    }

    private static int calcularProfundidad(ABBTDA arbol, int x, int profundidad) {
        if (arbol.arbolVacio()) {
            return -1;
        }
        if (x == arbol.raiz()) {
            return profundidad;
        }
        return x < arbol.raiz()
                ? calcularProfundidad(arbol.hijoIzq(), x, profundidad + 1)
                : calcularProfundidad(arbol.hijoDer(), x, profundidad + 1);
    }

    public static int obtenerMenorElementoIterativo(ABBTDA arbol) {
        ABBTDA arbolTemp = arbol;
        while (!arbolTemp.hijoIzq().arbolVacio()) {
            arbolTemp = arbolTemp.hijoIzq();
        }
        return arbolTemp.raiz();
    }

    public static int contarElementosRecursivo(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return 0;
        }
        return 1 + contarElementosRecursivo(arbol.hijoIzq()) + contarElementosRecursivo(arbol.hijoDer());
    }

    public static int sumaElementosRecursivo(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return 0;
        }
        return arbol.raiz() + sumaElementosRecursivo(arbol.hijoIzq()) + sumaElementosRecursivo(arbol.hijoDer());
    }

    public static int contarHojasRecursivo(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return 0;
        }
        if (arbol.hijoIzq().arbolVacio() && arbol.hijoDer().arbolVacio()) {
            return 1;
        }
        return contarHojasRecursivo(arbol.hijoIzq()) + contarHojasRecursivo(arbol.hijoDer());
    }

    public static int calcularAlturaRecursiva(ABBTDA arbol) {
        if (arbol.arbolVacio()) {
            return -1;
        }
        int alturaIzq = calcularAlturaRecursiva(arbol.hijoIzq());
        int alturaDer = calcularAlturaRecursiva(arbol.hijoDer());
        return 1 + Math.max(alturaIzq, alturaDer);
    }

    public static boolean comprobarMismaForma(ABBTDA arbol1, ABBTDA arbol2) {
        if (arbol1.arbolVacio() && arbol2.arbolVacio()) {
            return true;
        }
        if (arbol1.arbolVacio() || arbol2.arbolVacio()) {
            return false;
        }
        return comprobarMismaForma(arbol1.hijoIzq(), arbol2.hijoIzq()) &&
                comprobarMismaForma(arbol1.hijoDer(), arbol2.hijoDer());
    }

    public static boolean comprobarIgualdad(ABBTDA arbol1, ABBTDA arbol2) {
        if (arbol1.arbolVacio() && arbol2.arbolVacio()) {
            return true;
        }
        if (arbol1.arbolVacio() || arbol2.arbolVacio()) {
            return false;
        }
        return arbol1.raiz() == arbol2.raiz() &&
                comprobarIgualdad(arbol1.hijoIzq(), arbol2.hijoIzq()) &&
                comprobarIgualdad(arbol1.hijoDer(), arbol2.hijoDer());
    }

    public static int contarElementosNivel(ABBTDA arbol, int nivel) {
        return contarElementosEnNivel(arbol, nivel, 0);
    }

    private static int contarElementosEnNivel(ABBTDA arbol, int nivel, int actual) {
        if (arbol.arbolVacio()) {
            return 0;
        }
        if (actual == nivel) {
            return 1;
        }
        return contarElementosEnNivel(arbol.hijoIzq(), nivel, actual + 1) +
                contarElementosEnNivel(arbol.hijoDer(), nivel, actual + 1);
    }

    // Métodos para mostrar los elementos en In-orden, Pre-orden y Post-orden
    public static void recorrerInOrden(ABBTDA arbol) {
        if (!arbol.arbolVacio()) {
            recorrerInOrden(arbol.hijoIzq());
            System.out.println(arbol.raiz());
            recorrerInOrden(arbol.hijoDer());
        }
    }

    public static void recorrerPreOrden(ABBTDA arbol) {
        if (!arbol.arbolVacio()) {
            System.out.println(arbol.raiz());
            recorrerPreOrden(arbol.hijoIzq());
            recorrerPreOrden(arbol.hijoDer());
        }
    }

    public static void recorrerPostOrden(ABBTDA arbol) {
        if (!arbol.arbolVacio()) {
            recorrerPostOrden(arbol.hijoIzq());
            recorrerPostOrden(arbol.hijoDer());
            System.out.println(arbol.raiz());
        }
    }

    public static ConjuntoTDA elementosMayoresQue(ABBTDA arbol, int k) {
        ConjuntoTDA resultado = new ConjuntoMaxNoAcotado();
        if (!arbol.arbolVacio()) {
            if (arbol.raiz() > k) {
                resultado.agregar(arbol.raiz());
            }
            resultado = ConjuntoApp.union(resultado, elementosMayoresQue(arbol.hijoIzq(), k));
            resultado = ConjuntoApp.union(resultado, elementosMayoresQue(arbol.hijoDer(), k));
        }
        return resultado;
    }
}
