package edu.co.uniquindio;

import edu.co.uniquindio.controller.ArbolBinarioController;
import edu.co.uniquindio.model.ArbolBinario;
import edu.co.uniquindio.view.ArbolBinarioView;

public class Main {
    public static void main(String[] args) {
        // Crea las instancias del árbol y la vista
        ArbolBinario<Integer> arbol = new ArbolBinario<>();
        ArbolBinario<Integer> arbolComparacion = new ArbolBinario<>();
        ArbolBinarioView vista = new ArbolBinarioView();

        // Conecta el modelo, vista y controlador
        new ArbolBinarioController(arbol, arbolComparacion, vista);

        // Muestra la vista
        vista.setVisible(true);
    }
}
