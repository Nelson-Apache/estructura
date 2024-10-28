package edu.co.uniquindio.view;

import edu.co.uniquindio.model.ArbolBinario;
import edu.co.uniquindio.model.Nodo;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class ArbolBinarioView<T> extends JFrame {

    private ArbolBinario<Integer> arbol;
    private ArbolBinario<Integer> arbol2;
    private JTextPane outputArea;
    private ArbolPanel arbolPanel;

    public ArbolBinarioView() {
        arbol = new ArbolBinario<>();
        arbol2 = null; // Inicialmente no se crea el segundo árbol
        outputArea = new JTextPane();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));

        // Establecer el estilo de centrado
        StyledDocument doc = outputArea.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setPreferredSize(new Dimension(300, 200));

        // Panel de botones en dos columnas
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(0, 2, 10, 10));

        // Creación de los botones
        JButton btnAgregarNodo = new JButton("Agregar Nodo");
        JButton btnAltura = new JButton("Altura");
        JButton btnNivelElemento = new JButton("Nivel de Elemento");
        JButton btnContarHojas = new JButton("Contar Hojas");
        JButton btnMinimo = new JButton("Valor Minimo");
        JButton btnEliminar = new JButton("Eliminar Nodo");
        JButton btnIdentico = new JButton("Comparar Arboles");
        JButton btnRecorridoAmplitud = new JButton("Recorrido en Amplitud");
        JButton btnAlturaIterativa = new JButton("Altura Iterativa");
        JButton btnArbolExpresion = new JButton("Arbol Expresión");

        // Añadir botones al panel
        panelBotones.add(btnAgregarNodo);
        panelBotones.add(btnAltura);
        panelBotones.add(btnNivelElemento);
        panelBotones.add(btnContarHojas);
        panelBotones.add(btnMinimo);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnIdentico);
        panelBotones.add(btnRecorridoAmplitud);
        panelBotones.add(btnAlturaIterativa);
        panelBotones.add(btnArbolExpresion);

        // Configurar eventos para cada botón
        btnAgregarNodo.addActionListener(e -> agregarNodo());
        btnAltura.addActionListener(e -> mostrarAltura());
        btnNivelElemento.addActionListener(e -> mostrarNivelElemento());
        btnContarHojas.addActionListener(e -> mostrarContarHojas());
        btnMinimo.addActionListener(e -> mostrarValorMinimo());
        btnEliminar.addActionListener(e -> eliminarNodo());
        btnIdentico.addActionListener(e -> iniciarComparacionArboles());
        btnRecorridoAmplitud.addActionListener(e -> mostrarRecorridoAmplitud());
        btnAlturaIterativa.addActionListener(e -> mostrarAlturaIterativa());
        btnArbolExpresion.addActionListener(e -> crearArbolExpresion());

        // Panel para el árbol gráfico
        arbolPanel = new ArbolPanel();
        JScrollPane arbolScrollPane = new JScrollPane(arbolPanel);
        arbolScrollPane.setPreferredSize(new Dimension(400, 300));

        // Crear un JSplitPane para dividir outputArea y arbolPanel
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, arbolScrollPane);
        splitPane.setDividerLocation(300); // Configura la ubicación inicial del divisor
        splitPane.setResizeWeight(0.5);

        // Añadir componentes al JFrame con BorderLayout
        setLayout(new BorderLayout(10, 10));
        add(splitPane, BorderLayout.CENTER); // Panel dividido en el centro
        add(panelBotones, BorderLayout.SOUTH); // Panel de botones en la parte inferior

        setTitle("Visualización de Árbol Binario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Métodos de acción para cada botón
    private void agregarNodo() {
        String valor = JOptionPane.showInputDialog(this, "Ingrese valor para el nodo:");
        if (valor != null) {
            try {
                int dato = Integer.parseInt(valor);
                arbol.agregar(dato);
                outputArea.setText(arbol.imprimirHorizontal());
                arbolPanel.repaint();  // Redibuja el árbol gráfico después de agregar un nodo
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido.");
            }
        }
    }

    private void iniciarComparacionArboles() {
        arbol2 = new ArbolBinario<>();
        String mensaje = "Ingrese los valores del segundo árbol (separados por comas):";
        String valores = JOptionPane.showInputDialog(this, mensaje);

        if (valores != null && !valores.isEmpty()) {
            try {
                String[] datos = valores.split(",");
                for (String dato : datos) {
                    arbol2.agregar(Integer.parseInt(dato.trim()));
                }
                outputArea.setText(arbol.imprimirHorizontal() + "\n\nSegundo Árbol:\n" + arbol2.imprimirHorizontal());
                arbolPanel.repaint();
                appendToOutputArea("¿Son idénticos?: " + arbol.esIdentico(arbol2) + "\n");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Asegúrese de ingresar solo números válidos separados por comas.");
            }
        }
    }

    private void mostrarAltura() {
        appendToOutputArea("Altura: " + arbol.obtenerAltura() + "\n");
    }

    private void mostrarNivelElemento() {
        String valor = JOptionPane.showInputDialog(this, "Ingrese el elemento para obtener su nivel:");
        if (valor != null) {
            try {
                int dato = Integer.parseInt(valor);
                appendToOutputArea("Nivel de " + dato + ": " + arbol.obtenerNivel(dato) + "\n");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido.");
            }
        }
    }

    private void mostrarContarHojas() {
        appendToOutputArea("Número de hojas: " + arbol.contarHojas() + "\n");
    }

    private void mostrarValorMinimo() {
        appendToOutputArea("Valor mínimo (iterativo): " + arbol.obtenerMinimoIt() + "\n");
        appendToOutputArea("Valor mínimo (recursivo): " + arbol.obtenerMinimoRec() + "\n");
    }

    private void eliminarNodo() {
        String valor = JOptionPane.showInputDialog(this, "Ingrese valor del nodo a eliminar:");
        if (valor != null) {
            try {
                int dato = Integer.parseInt(valor);
                arbol.eliminar(dato);
                outputArea.setText(arbol.imprimirHorizontal());
                arbolPanel.repaint();  // Redibuja el árbol gráfico después de eliminar un nodo
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido.");
            }
        }
    }

    private void mostrarRecorridoAmplitud() {
        appendToOutputArea("\nRecorrido en amplitud:\n" + arbol.imprimirAmplitud());
    }

    private void mostrarAlturaIterativa() {
        appendToOutputArea("Altura (iterativa): " + arbol.obtenerAlturaIt() + "\n");
    }

    private void appendToOutputArea(String text) {
        StyledDocument doc = outputArea.getStyledDocument();
        try {
            doc.insertString(doc.getLength(), text, null);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }

    // Clase interna para representar el árbol como círculos y líneas
    class ArbolPanel extends JPanel {

        private final int DIAMETER = 30;
        private final int VERTICAL_SPACING = 50;
        private final int HORIZONTAL_SPACING = 30;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (arbol.getRaiz() != null) {
                drawTree(g, arbol.getRaiz(), getWidth() / 4, 30, getWidth() / 8);
            }
            if (arbol2 != null && arbol2.getRaiz() != null) {
                drawTree(g, arbol2.getRaiz(), (3 * getWidth()) / 4, 30, getWidth() / 8);
            }
        }

        private void drawTree(Graphics g, Nodo<?> node, int x, int y, int offset) {
            if (node == null) {
                return;
            }

            g.drawOval(x - DIAMETER / 2, y - DIAMETER / 2, DIAMETER, DIAMETER);
            g.drawString(node.getDato().toString(), x - 4, y + 4);

            if (node.getIzquierda() != null) {
                g.drawLine(x, y, x - offset, y + VERTICAL_SPACING);
                drawTree(g, node.getIzquierda(), x - offset, y + VERTICAL_SPACING, offset / 2);
            }
            if (node.getDerecha() != null) {
                g.drawLine(x, y, x + offset, y + VERTICAL_SPACING);
                drawTree(g, node.getDerecha(), x + offset, y + VERTICAL_SPACING, offset / 2);
            }
        }
    }

    private void crearArbolExpresion() {
        String expresion = JOptionPane.showInputDialog(this, "Ingrese la expresión infija (sin espacios):");
        if (expresion != null && !expresion.isEmpty()) {
            try {
                arbol.setRaiz(arbol.ArbolBinarioExp(expresion));
                outputArea.setText("Expresión: " + expresion + "\n");
                arbolPanel.repaint();  // Redibuja el árbol gráfico
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al crear el árbol de expresión. Asegúrese de que la expresión sea válida.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ArbolBinarioView());
    }
}
