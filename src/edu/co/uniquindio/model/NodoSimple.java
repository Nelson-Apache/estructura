package edu.co.uniquindio.model;

public class NodoSimple <E> {
    private final E dato;
    private NodoSimple<E> siguiente;

    public NodoSimple(E dato, NodoSimple<E> siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public NodoSimple(E dato) {
        this(dato, null);
    }

    public E getDato() {
        return dato;
    }

    public NodoSimple<E> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoSimple<E> siguiente) {
        this.siguiente = siguiente;
    }
}
