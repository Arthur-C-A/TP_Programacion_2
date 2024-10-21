# 💻 Trabajo Práctico - Programación II - UADE : TDAs y Complejidad Algorítmica 🚀

¡Bienvenido a mi repositorio de Programación II! Este proyecto está dedicado a explorar, implementar y optimizar estructuras de datos abstractas (TDAs) como pilas, colas, árboles binarios y más, tanto en versiones estáticas como dinámicas. Es un viaje profundo en el mundo de las estructuras de datos, con un enfoque en la eficiencia y el análisis de costos temporal y espacial.

## 🎯 Objetivos del Proyecto

Definir y comprender los TDAs desde su raíz.
Implementar soluciones eficientes en Java y Python utilizando listas dinámicas y arreglos.
Evaluar y comparar el costo computacional entre diferentes implementaciones.
Desarrollar métodos avanzados para manipular pilas, colas y árboles con un toque de creatividad y rigor.

## 📜 Contenidos

1. TDA Pila
Definición y operaciones básicas: Push, Pop, Peek, etc.
Implementaciones estáticas (basadas en arreglos) y dinámicas (basadas en nodos enlazados).
Métodos adicionales para pilas:
Pasar una pila a otra en orden inverso: Usamos una segunda pila para voltear el orden de la primera. ¿Por qué una segunda pila? ¡Simple! Evita que el orden se deshaga mientras movemos los elementos.
Copiar una pila en el mismo orden: Este método duplica la pila original, preservando su estructura.
Invertir el contenido de una pila: Básicamente le damos la vuelta a la pila con una estrategia inteligente usando un almacenamiento auxiliar.
Contar los elementos: Recorremos la pila, contando sin destruir.
Sumar los elementos: Ideal para pilas numéricas, recorremos y sumamos.
Calcular el promedio: Simplemente sumamos y dividimos por el total de elementos.

2. TDA Cola
Definición y operaciones básicas: Enqueue, Dequeue, Front.
Implementaciones estáticas y dinámicas con listas enlazadas.
Métodos adicionales para colas:
Pasar una cola a otra: Transferimos elementos sin alterar el orden original.
Invertir el contenido de una cola: Dos versiones: una con ayuda de pilas y otra sin ellas (desafiante pero factible).
Comparar el final de dos colas: ¿Coinciden o no? Esta función lo verifica con precisión.
Determinar si una cola es capicúa: Comprobamos si los extremos son iguales.
Comparar si dos colas son inversas: Una cola es el espejo de la otra si sus elementos están en orden inverso.

3. TDA Cola con Prioridades
Definición y operaciones básicas: Insertar con prioridad, atender con prioridad.
Métodos adicionales para colas con prioridad:
Combinar dos colas con prioridad: Fusionamos dos colas, considerando que si dos elementos tienen la misma prioridad, la cola 1 siempre tiene más peso.
Comparar si dos colas con prioridad son idénticas: Se comparan uno a uno los elementos y sus prioridades.

4. Análisis de Costos
Este proyecto incluye un análisis exhaustivo de costos temporales y espaciales de las operaciones implementadas. Aquí destacamos las diferencias de eficiencia entre las versiones basadas en arreglos y aquellas que usan listas enlazadas, midiendo su impacto a medida que crece el número de elementos.

5. TDA Conjunto
Implementación de conjuntos con límites dinámicos y operaciones fundamentales como:

Intersección, unión y diferencia
Comparación de igualdad entre conjuntos
Cálculo de la cardinalidad (cantidad de elementos)

6. TDA Diccionario
Dos enfoques:

Claves con valores únicos: Similar a un diccionario clásico.
Claves con conjuntos de valores: Donde cada clave puede estar asociada a múltiples valores (útil en muchos contextos reales).

7. TDA Árbol Binario de Búsqueda (ABB)
Un enfoque iterativo y recursivo para los árboles binarios de búsqueda, con operaciones como:

Búsqueda de elementos
Calcular la altura y profundidad de nodos
Mostrar los elementos en distintos recorridos (In-orden, Pre-orden, Post-orden)

8. Árboles AVL y Árboles B
Árbol AVL: Balanceo automático mediante rotaciones.
Árbol B: Estructura especializada para grandes cantidades de datos con operaciones de inserción y eliminación bien optimizadas.

9. TDA Grafo
Los grafos se implementan usando dos representaciones: matriz de adyacencia y listas de adyacencia. Con métodos que resuelven problemas como:

Encontrar predecesores
Calcular el grado de un vértice
Detectar vértices aislados

## 🚀 Ejecución

Para correr los ejemplos en tu máquina:

Clona el repositorio:

```bash```
**Copiar código**
```git clone https://github.com/tuusuario/programacion-II-tdas.git```

Compila y ejecuta los archivos de Java o Python según lo requiera el ejercicio:

```bash```
**Copiar código**
```javac TDA_Pila.java```
```java TDA_Pila'```

## 🧠 Reflexión Final

Cada uno de estos TDAs está diseñado con un enfoque en la eficiencia, pensando en problemas del mundo real. Desde el manejo de grandes volúmenes de datos hasta la optimización del uso de memoria, este trabajo representa no solo un ejercicio académico, sino una caja de herramientas adaptable a múltiples escenarios en el desarrollo de software.
