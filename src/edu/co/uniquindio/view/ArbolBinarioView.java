package edu.co.uniquindio.view;

import javax.swing.*;
import java.awt.*;

public class ArbolBinarioView extends JFrame {
    private JTextField txtNodo;
    private JButton btnAgregar, btnContarHojas, btnObtenerMinimo, btnCompararArboles, btnImprimirArbol,
            btnEliminarNodo, btnObtenerAltura, btnObtenerNivel, btnRecorridoAmplitud, btnAlturaIt;
    private JTextArea areaResultados;

    public ArbolBinarioView() {
        setTitle("Operaciones con Árbol Binario");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel superior
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new FlowLayout());

        txtNodo = new JTextField(5);
        panelSuperior.add(new JLabel("Nodo:"));
        panelSuperior.add(txtNodo);

        btnAgregar = new JButton("Agregar Nodo");
        panelSuperior.add(btnAgregar);

        add(panelSuperior, BorderLayout.NORTH);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(5, 2, 5, 5));

        btnObtenerAltura = new JButton("Obtener Altura");
        btnObtenerNivel = new JButton("Obtener Nivel");
        btnContarHojas = new JButton("Contar Hojas");
        btnObtenerMinimo = new JButton("Obtener Mínimo");
        btnEliminarNodo = new JButton("Eliminar Nodo");
        btnCompararArboles = new JButton("Comparar Árboles");
        btnImprimirArbol = new JButton("Imprimir Horizontal");
        btnRecorridoAmplitud = new JButton("Recorrido en Amplitud");
        btnAlturaIt = new JButton("Altura (Iterativa)");

        panelBotones.add(btnObtenerAltura);
        panelBotones.add(btnObtenerNivel);
        panelBotones.add(btnContarHojas);
        panelBotones.add(btnObtenerMinimo);
        panelBotones.add(btnEliminarNodo);
        panelBotones.add(btnCompararArboles);
        panelBotones.add(btnImprimirArbol);
        panelBotones.add(btnRecorridoAmplitud);
        panelBotones.add(btnAlturaIt);

        add(panelBotones, BorderLayout.CENTER);

        // Área de resultados
        areaResultados = new JTextArea();
        areaResultados.setEditable(false);
        add(new JScrollPane(areaResultados), BorderLayout.SOUTH);
    }

    public String getTxtNodo() {
        return txtNodo.getText();
    }

    public void mostrarMensaje(String mensaje) {
        areaResultados.append(mensaje + "\n");
    }

    public void limpiarCampoNodo() {
        txtNodo.setText("");
    }

    // Métodos para acceder a los botones
    public JButton getBtnAgregar() { return btnAgregar; }
    public JButton getBtnObtenerAltura() { return btnObtenerAltura; }
    public JButton getBtnObtenerNivel() { return btnObtenerNivel; }
    public JButton getBtnContarHojas() { return btnContarHojas; }
    public JButton getBtnObtenerMinimo() { return btnObtenerMinimo; }
    public JButton getBtnEliminarNodo() { return btnEliminarNodo; }
    public JButton getBtnCompararArboles() { return btnCompararArboles; }
    public JButton getBtnImprimirArbol() { return btnImprimirArbol; }
    public JButton getBtnRecorridoAmplitud() { return btnRecorridoAmplitud; }
    public JButton getBtnAlturaIt() { return btnAlturaIt; }
}
