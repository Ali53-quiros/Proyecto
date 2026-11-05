/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dhytr;

import javax.swing.JOptionPane;

/**
 *
 * @author Laboratorio
 */
public class Parqueo {
    private String nombre;
    private char[][] espacios;

    public Parqueo(String nombre, int filas, int columnas) {
        this.nombre = nombre;
        espacios = new char[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                espacios[i][j] = 'L';
            }
        }
    }

    public void mostrarMatriz() {
        String resultado = "PARQUEO " + nombre + "\n";
        resultado += "L = Libre, O = Ocupado, D = Director, E = Discapacidad\n\n";

        for (int i = 0; i < espacios.length; i++) {
            for (int j = 0; j < espacios[i].length; j++) {
                resultado += "[" + espacios[i][j] + "] ";
            }
            resultado += "\n";
        }

        JOptionPane.showMessageDialog(null, resultado);
    }

    public void asignarEspacio(int fila, int columna, char estado) {
        if (fila < 1 || fila > espacios.length
                || columna < 1 || columna > espacios[0].length) {
            JOptionPane.showMessageDialog(null, "La fila o columna no existe.");
        } else if (espacios[fila - 1][columna - 1] != 'L') {
            JOptionPane.showMessageDialog(null, "Ese espacio ya está ocupado.");
        } else {
            espacios[fila - 1][columna - 1] = estado;
            JOptionPane.showMessageDialog(null, "Espacio asignado correctamente.");
        }
    }

    public void liberarEspacio(int fila, int columna) {
        if (fila < 1 || fila > espacios.length
                || columna < 1 || columna > espacios[0].length) {
            JOptionPane.showMessageDialog(null, "La fila o columna no existe.");
        } else if (espacios[fila - 1][columna - 1] == 'L') {
            JOptionPane.showMessageDialog(null, "Ese espacio ya está libre.");
        } else {
            espacios[fila - 1][columna - 1] = 'L';
            JOptionPane.showMessageDialog(null, "Espacio liberado correctamente.");
        }
    }
}


