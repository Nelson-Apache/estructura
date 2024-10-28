package edu.co.uniquindio.model;

import java.util.NoSuchElementException;

public class Cola<E> {
    /**
     * primero elemento en la cola
     */
    private NodoSimple<E> primero;

    /**
     * ultimo elemento en la cola
     */
    private NodoSimple<E> ultimo;

    /**
     * longitud de la cola
     */
    private int longitud;


    @SuppressWarnings("unchecked")
    public static <E> Cola<E> de(E... elementos) {
        Cola<E> cola = new Cola<E>();
        for (E elemento : elementos) {
            cola.encolar(elemento);
        }
        return cola;
    }

    /**
     * agrega un elemento al final de la cla
     * 
     * @param elemento
     */
    public void encolar(E elemento) {
        NodoSimple<E> nodo = new NodoSimple<>(elemento);
        if (estaVacia()) {
            primero = ultimo = nodo;
        } else {
            ultimo.setSiguiente(nodo);
            ultimo = nodo;
        }
        longitud++;
    }

    /**
     * obtiene y remueve el primer elemento de la cola
     * 
     * @return primer elemento en la cola
     * 
     * @throws NoSuchElementException si no hay elementos en la cola
     */
    public E desencolar() {
        if (estaVacia()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        E elemento = primero.getDato();
        primero = primero.getSiguiente();
        longitud--;
        return elemento;
    }


    /**
     * obtiene el primer elemento de la cola
     * 
     * @return primer elemento en la cola
     * 
     * @throws NoSuchElementException si no hay elementos en la cola
     */
    public E elemento() {
        if (estaVacia()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        return primero.getDato();
    }


    /**
     * comprueba si la cola se encuentra vacia
     */
    public boolean estaVacia() {
        return longitud == 0;
    }


    /**
     * comprueba si la cola no esta vacia
     */
    public boolean noEstaVacia()
    {
        return this.longitud > 0;
    }

    /**
     * obtiene la longitud de la cola
     * 
     * @return cantidad de elementos en la cola
     */
    public int longitud()
    {
        return this.longitud;
    }

    @Override
    protected Cola<E> clone() throws CloneNotSupportedException {
        Cola<E> nueva = new Cola<>();
        NodoSimple<E> aux = primero;
        while (aux != null) {
            nueva.encolar(aux.getDato());
            aux = aux.getSiguiente();
        }
        return nueva;
    }
}