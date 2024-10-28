package edu.co.uniquindio.controller;

import edu.co.uniquindio.model.ArbolBinario;
import edu.co.uniquindio.view.ArbolBinarioView;

import javax.swing.*;

public class ArbolBinarioController {
    private final ArbolBinario<Integer> arbol;
    private final ArbolBinario<Integer> arbolComparacion;
    private final ArbolBinarioView vista;

    public ArbolBinarioController(ArbolBinario<Integer> arbol, ArbolBinario<Integer> arbolComparacion, ArbolBinarioView vista) {
        this.arbol = arbol;
        this.arbolComparacion = arbolComparacion;
        this.vista = vista;
        inicializarEventos();
    }

    private void inicializarEventos() {
        vista.getBtnAgregar().addActionListener(e -> agregarNodo());
        vista.getBtnObtenerAltura().addActionListener(e -> obtenerAltura());
        vista.getBtnObtenerNivel().addActionListener(e -> obtenerNivel());
        vista.getBtnContarHojas().addActionListener(e -> contarHojas());
        vista.getBtnObtenerMinimo().addActionListener(e -> obtenerMinimo());
        vista.getBtnEliminarNodo().addActionListener(e -> eliminarNodo());
        vista.getBtnCompararArboles().addActionListener(e -> compararArboles());
        vista.getBtnImprimirArbol().addActionListener(e -> imprimirHorizontal());
        vista.getBtnRecorridoAmplitud().addActionListener(e -> recorridoAmplitud());
        vista.getBtnAlturaIt().addActionListener(e -> obtenerAlturaIterativa());
    }

    private void agregarNodo() {
        try {
            int dato = Integer.parseInt(vista.getTxtNodo());
            arbol.agregar(dato);
            vista.mostrarMensaje("Nodo " + dato + " agregado correctamente.");
            vista.mostrarMensaje("Árbol actualizado (horizontal):\n" + arbol.imprimirHorizontal());
            vista.limpiarCampoNodo(); // Limpiar el campo de texto
        } catch (NumberFormatException e) {
            vista.mostrarMensaje("Por favor, ingrese un número válido.");
        }
    }

    private void obtenerAltura() {
        int altura = arbol.obtenerAltura();
        System.out.println(altura);
        vista.mostrarMensaje("Altura del árbol: " + altura);
    }

    private void obtenerNivel() {
        try {
            int elemento = Integer.parseInt(vista.getTxtNodo());
            int nivel = arbol.obtenerNivel(elemento);
            if (nivel != -1) {
                vista.mostrarMensaje("Nivel del nodo " + elemento + ": " + nivel);
            } else {
                vista.mostrarMensaje("El nodo " + elemento + " no se encuentra en el árbol.");
            }
        } catch (NumberFormatException e) {
            vista.mostrarMensaje("Por favor, ingrese un número válido.");
        }
    }

    private void contarHojas() {
        vista.mostrarMensaje("Número de hojas: " + arbol.contarHojas());
    }

    private void obtenerMinimo() {
        vista.mostrarMensaje("Valor mínimo (iterativo): " + arbol.obtenerMinimoIt() +
                "\nValor mínimo (recursivo): " + arbol.obtenerMinimoRec());
    }

    private void eliminarNodo() {
        int elemento = Integer.parseInt(vista.getTxtNodo());
        arbol.eliminar(elemento);
        vista.mostrarMensaje("Nodo " + elemento + " eliminado.");
    }

    private void compararArboles() {
        vista.mostrarMensaje("Los árboles son " + (arbol.esIdentico(arbolComparacion) ? "idénticos." : "diferentes."));
    }

    private void imprimirHorizontal() {
        vista.mostrarMensaje("Árbol (horizontal):\n" + arbol.imprimirHorizontal());
    }

    private void recorridoAmplitud() {
        vista.mostrarMensaje("Recorrido en amplitud:\n" + arbol.imprimirAmplitud());
    }

    private void obtenerAlturaIterativa() {
        vista.mostrarMensaje("Altura (iterativa): " + arbol.obtenerAlturaIt());
    }
}
