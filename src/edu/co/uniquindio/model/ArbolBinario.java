package edu.co.uniquindio.model;

public class ArbolBinario<E extends  Comparable<E>> {
    private Nodo<E> raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public void agregar(E dato) {
        if (this.raiz == null) {
            this.raiz = new Nodo<>(dato);
        } else {
            agregar(dato, raiz);
        }
    }

    private void agregar(E dato, Nodo<E> nodo) {
        if (nodo.dato.compareTo(dato) > 0) {
            if (nodo.izquierda == null) {
                nodo.izquierda = new Nodo<>(dato);
            } else {
                agregar(dato, nodo.izquierda);
            }
        } else if (nodo.dato.compareTo(dato) < 0) {
            if (nodo.derecha == null) {
                nodo.derecha = new Nodo<>(dato);
            } else {
                agregar(dato, nodo.derecha);
            }
        }
    }

    public boolean contiene(E dato) {
        return contiene(dato, raiz);
    }

    private boolean contiene(E dato, Nodo<E> nodo) {
        if (nodo == null) return false;

        int comparacion = nodo.dato.compareTo(dato);

        if (comparacion == 0) {
            return true;
        } else if (comparacion < 0) {
            return contiene(dato, nodo.derecha);
        } else {
            return contiene(dato, nodo.izquierda);
        }
    }

    /**
     * elimina un elemento del arbol
     * 
     * @param elemento elemento a eliminar/remover
     */
    public void eliminar(E elemento)
    {
        this.raiz = eliminar(elemento, this.raiz);
    }

    /**
     * elimina un elemento
     * 
     * @param elemento elemento a eliminar
     * @param nodo nodo para buscar
     * 
     * @return nodo para reemplazar el eliminado
     */
    private Nodo<E> eliminar(E elemento, Nodo<E> nodo)
    {
        if (nodo == null || elemento == null) return null;

        int comparacion = elemento.compareTo(nodo.dato);

        if (comparacion == 0) {
            if (nodo.izquierda == null) {
                return nodo.derecha;
            } else if (nodo.derecha == null) {
                return nodo.izquierda;
            } else {
                Nodo<E> aux = nodo.izquierda;

                while (aux.derecha != null) aux = aux.derecha;

                nodo.dato = aux.dato;
                nodo.izquierda = eliminar(aux.dato, nodo.izquierda);
            }
        } else if (comparacion < 0) {
            nodo.izquierda = eliminar(elemento, nodo.izquierda);
        } else {
            nodo.derecha = eliminar(elemento, nodo.derecha);
        }

        return nodo;
    }

    // metodos laboratorio

    /**
     * obtiene la altura del arbol
     * 
     * @return numero maximo de niveles
     */
    public int obtenerAltura()
    {
        return obtenerAltura(this.raiz);
    }

    private int obtenerAltura(Nodo<E> nodo)
    {
        if (nodo == null) return 0;

        int alturaIzquierda = obtenerAltura(nodo.izquierda);
        int alturaDerecha = obtenerAltura(nodo.derecha);

        return 1 + Math.max(alturaIzquierda, alturaDerecha);
    }

    /**
     * obtiene el nivel de un elemento en el arbol
     * 
     * @param elemento elemento a buscar
     * 
     * @return el nivel en el que esta el elemento o {@code -1} si no esta en la estructura
     */
    public int obtenerNivel(E elemento)
    {
        return obtenerNivel(elemento, this.raiz);
    }

    private int obtenerNivel(E elemento, Nodo<E> nodo)
    {
        if (elemento == null || nodo == null) return -1;

        int comparacion = elemento.compareTo(nodo.dato);

        if (comparacion == 0) return 0;

        int nivel = comparacion < 0
            ? obtenerNivel(elemento, nodo.izquierda)
            : obtenerNivel(elemento, nodo.derecha);

        return nivel == -1 ? -1 : 1 + nivel;
    }

    /**
     * cuenta el numero de hojas en el arbol
     * 
     * @return numero de hojas
     */
    public int contarHojas()
    {
        return contarHojas(this.raiz);
    }

    private int contarHojas(Nodo<E> nodo)
    {
        if (nodo == null) return 0;

        if (nodo.izquierda == null && nodo.derecha == null) {
            return 1;
        }

        return contarHojas(nodo.izquierda) + contarHojas(nodo.derecha);
    }

    /**
     * obtiene el valor minimo de forma recursiva
     * 
     * @return valor minimo del arbol
     */
    public E obtenerMinimoRec()
    {
        return obtenerMinimoRec(this.raiz);
    }

    private E obtenerMinimoRec(Nodo<E> nodo)
    {
        if (nodo == null) return null;

        if (nodo.izquierda == null) return nodo.dato;

        return obtenerMinimoRec(nodo.izquierda);
    }

    /**
     * obtiene el valor minimo fe forma iterativa
     * 
     * @return valor minimo del arbol
     */
    public E obtenerMinimoIt()
    {
        Nodo<E> aux = this.raiz;

        while (aux != null && aux.izquierda != null) {
            aux = aux.izquierda;
        }

        return aux == null ? null : aux.dato;
    }

    /**
     * imprime el arbol de forma horizontal
     */
    // Método que genera la representación en un String
    public String imprimirHorizontal() {
        StringBuilder sb = new StringBuilder();
        imprimirHorizontal(this.raiz, 0, sb);
        return sb.toString();
    }

    // Método auxiliar para construir el String
    private void imprimirHorizontal(Nodo<E> nodo, int nivel, StringBuilder sb) {
        if (nodo == null) return;

        imprimirHorizontal(nodo.derecha, nivel + 1, sb);
        sb.append(" ".repeat(nivel * 4)).append(nodo.dato).append("\n");
        imprimirHorizontal(nodo.izquierda, nivel + 1, sb);
    }

    /**
     * comprueba si un arbol tiene los mismos elementos y posiciones que el actual
     * 
     * @param arbol el otro arbol binario
     * 
     * @return son identicos
     */
    public boolean esIdentico(ArbolBinario<E> arbol)
    {
        return esIdentico(this.raiz, arbol.raiz);
    }

    private boolean esIdentico(Nodo<E> nodo1, Nodo<E> nodo2)
    {
        // si ambos son nulos son iguales al no tener hijos ni valor
        if (nodo1 == null && nodo2 == null) return true;

        // ya que los 2 nodos juntos no son nulos
        // si uno de ellos lo es ya no es identico
        if (nodo1 == null || nodo2 == null) return false;

        // dado que ninguno de los nodos es nulo
        // si el valor de los nodos es comparativamente diferente
        // no son identicos
        if (nodo1.dato.compareTo(nodo2.dato) != 0)  {
            return false;
        }

        // ya que los nodos son identicos delegaremos la opcion
        // de decidir a sus hijos izquierdos y derechos
        return esIdentico(nodo1.izquierda, nodo2.izquierda)
            && esIdentico(nodo1.derecha, nodo2.derecha);
    }


    /**
     * imprime el arbol por niveles
     */

    public String imprimirAmplitud() {
        StringBuilder sb = new StringBuilder();
        imprimirAmplitud(Cola.de(this.raiz), sb);
        return sb.toString();
    }

    private void imprimirAmplitud(Cola<Nodo<E>> cola, StringBuilder sb) {
        if (cola.estaVacia()) return;

        int enNivel = cola.longitud();

        for (int i = enNivel; i > 0; i--) {
            Nodo<E> nodo = cola.desencolar();

            if (nodo != null) {
                sb.append(nodo.dato).append("  ");

                if (nodo.izquierda != null) cola.encolar(nodo.izquierda);
                if (nodo.derecha != null) cola.encolar(nodo.derecha);
            }
        }

        // Agregar salto de línea para separar niveles
        sb.append("\n");

        imprimirAmplitud(cola, sb);
    }

    /**
     * comprueba la altura del arbol de forma iteratiba
     * 
     * @return la altura del arbol
     */
    public int obtenerAlturaIt()
    {
        if (this.raiz == null) return 0;

        int alturaMaxima = 0;
        Cola<Nodo<E>> cola = new Cola<>();
        cola.encolar(this.raiz);

        while (true) {
            if (cola.estaVacia()) return alturaMaxima;

            alturaMaxima++;

            // numero de nodos en el nivel
            int numNodos = cola.longitud();

            // recorremos los nodos de ese nivel y agregamos sus hijos
            while (numNodos > 0) {
                Nodo<E> aux = cola.desencolar();

                // estos hijos son del siguiente nivel
                if (aux.izquierda != null) cola.encolar(aux.izquierda);
                if (aux.derecha != null) cola.encolar(aux.derecha);

                // disminuimos el numero de nodos del nivel actual
                numNodos--;
            }
        }
    }
}

