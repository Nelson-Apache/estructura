import java.util.NoSuchElementException;

public class Cola<E>
{
    /**
     * primero elemento en la cola
     */
    private NodoSimple primero;

    /**
     * ultimo elemento en la cola
     */
    private NodoSimple ultimo;

    /**
     * longitud de la cola
     */
    private int longitud;

    @SuppressWarnings("unchecked")
    public static <E> Cola<E> de(E... elementos)
    {
        Cola<E> cola = new Cola<E>();

        for (int i = 0; i < elementos.length; i++) {
            cola.encolar(elementos[i]);
        }

        return cola;
    }

    /**
     * agrega un elemento al final de la cla
     * 
     * @param elemento
     */
    public void encolar(E elemento)
    {
        if (this.estaVacia()) {
            primero = ultimo = new NodoSimple(elemento);
        } else {
            NodoSimple nodo = new NodoSimple(elemento);
            ultimo.setSiguiente(nodo);
            ultimo = nodo;
        }

        this.longitud++;
    }

    /**
     * obtiene y remueve el primer elemento de la cola
     * 
     * @return primer elemento en la cola
     * 
     * @throws NoSuchElementException si no hay elementos en la cola
     */
    public E desencolar()
    {
        if (this.estaVacia()) {
            throw new NoSuchElementException();
        }

        E elemento = primero.dato;
        primero = primero.siguiente();
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
    public E elemento()
    {
        if (this.estaVacia()) {
            throw new NoSuchElementException();
        }

        return primero.dato;
    }

    /**
     * comprueba si la cola se encuentra vacia
     */
    public boolean estaVacia()
    {
        return this.longitud == 0;
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
    protected Cola<E> clone() throws CloneNotSupportedException
    {
        Cola<E> nueva = new Cola<E>();
        NodoSimple aux = primero; 

        while (aux != null) {
            nueva.encolar(aux.dato);
            aux = aux.siguiente();
        }

        return nueva;
    }

    /**
     * clase nodo de la cola
     */
    private class NodoSimple
    {
        /**
         * dato/informacion/objeto del nodo
         */
        public E dato;

        /**
         * el siguiente nodo
         */
        private NodoSimple siguiente;

        /**
         * construye una nueva instancia
         * 
         * @param dato valor/informacion para el nodo
         * @param siguiente siguiente nodo
         */
        public NodoSimple(E dato, NodoSimple siguiente)
        {
            this.dato = dato;
            this.setSiguiente(siguiente);
        }

        /**
         * construye una nueva instancia 
         * 
         * @param dato valor/informacion para el nodo
         */
        public NodoSimple(E dato)
        {
            this(dato, null);
        }

        /**
         * obtiene el siguiente nodo
         * 
         * @return el siguiente nodo o null
         */
        public NodoSimple siguiente()
        {
            return this.siguiente;
        }

        /**
         * establece cual es el siguiente nodo
         * 
         * @param nodo el nodo que sera el siguiente
         */
        public void setSiguiente(NodoSimple nodo)
        {
            this.siguiente = nodo;
        }
    }
}