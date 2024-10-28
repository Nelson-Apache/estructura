import edu.co.uniquindio.model.ArbolBinario;

public class Main1
 {
    public static void main(String[] args) {
        ArbolBinario<Integer> abb = new ArbolBinario<>();

        abb.agregar(8);
        abb.agregar(10);
        abb.agregar(12);
        abb.agregar(9);
        abb.agregar(6);
        abb.agregar(3);
        abb.agregar(7);

        ArbolBinario<Integer> abb2 = new ArbolBinario<>();

        abb2.agregar(8);
        abb2.agregar(10);
        abb2.agregar(12);
        abb2.agregar(9);
        abb2.agregar(6);
        abb2.agregar(2);
        abb2.agregar(7);

        punto1(abb);
        punto2(abb);
        punto3(abb);
        punto4(abb);
        punto6(abb);
        punto7(abb, abb2);
        punto9(abb);
        punto8(abb);
        punto5(abb);
    }

    /**
     * obtener la altura del arbol
     */
    public static void punto1(ArbolBinario<?> abb) {
        System.out.println("Altura: " + abb.obtenerAltura());
    }

    /**
     * obtener el nivel de un elemento
     */
    @SuppressWarnings("unchecked")
    public static <E extends Comparable<E>> void punto2(ArbolBinario<E> abb) {
        System.out.println("Nivel de 9: " + abb.obtenerNivel((E) Integer.valueOf(9)));
    }

    /**
     * contar numero de hojas de un arbol
     */
    public static void punto3(ArbolBinario<?> abb) {
        System.out.println("Numero Hojas: " + abb.contarHojas());
    }

    /**
     * obtener el valor mas pequeño de un arbol
     */
    public static void punto4(ArbolBinario<?> abb) {
        System.out.println("Valor minimo: " + abb.obtenerMinimoIt());
        System.out.println("Valor minimo (rec): " + abb.obtenerMinimoRec());
    }

    /**
     * imprimir arbol de forma horizontal
     */
    public static void punto5(ArbolBinario<?> abb) {
        System.out.println("Arbol (horizontal) -------------");
        abb.imprimirHorizontal();
        System.out.println("--------------------------------");
    }

    /**
     * elimina un nodo del arbol
     */
    @SuppressWarnings("unchecked")
    public static <E extends Comparable<E>> void punto6(ArbolBinario<E> abb) {
        abb.eliminar((E) Integer.valueOf(8));
    }

    /**
     * comprobar si dos arboles son identicos
     */
    public static <E extends Comparable<E>> void punto7(ArbolBinario<E> abb1, ArbolBinario<E> abb2) {
        System.out.println("Identicos: " + abb1.esIdentico(abb2));
    }

    /**
     * recorrido en amplitud (niveles)
     */
    public static void punto8(ArbolBinario<?> abb) {
        System.out.println("\nArbol (niveles) -----------------");
        abb.imprimirAmplitud();
        System.out.println("---------------------------------");
    }

    /**
     * altura de arbol sin recursividad
     */
    public static void punto9(ArbolBinario<?> abb) {
        System.out.println("Altura (it): " + abb.obtenerAlturaIt());
    }
}