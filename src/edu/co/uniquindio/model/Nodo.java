package edu.co.uniquindio.model;

public class Nodo<E extends Comparable<E>> {
    public Nodo<E> izquierda;
    public Nodo<E> derecha;
    public E dato;

    public Nodo(Nodo<E> izq, E dato, Nodo<E> der) {
        this.izquierda = izq;
        this.derecha = der;
        this.dato = dato;
    }

    public Nodo(E dato) {
        this(null, dato, null);
    }
}
