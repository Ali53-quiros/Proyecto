/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dhytr;

import javax.swing.JOptionPane;

/**
 *
 * @author Laboratorio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Parqueo s1 = new Parqueo("S1", 4, 5);
        Parqueo s2 = new Parqueo("S2", 5, 5);
        Parqueo s3 = new Parqueo("S3", 6, 5);

        int opcion = 0;

        while (opcion != 4) {
            String menu = "===================="+"\nSISTEMA DE PARQUEOS"+"\n====================\n"
                    + "1. Mostrar los parqueos\n"
                    + "2. Asignar un espacio\n"
                    + "3. Liberar un espacio\n"
                    + "4. Salir\n"
                    + "-----------------------------------\n"
                    + "Seleccione la opción que desea:";
            opcion = leerEntero(menu);

            if (opcion == 1) {
                s1.mostrarMatriz();
                s2.mostrarMatriz();
                s3.mostrarMatriz();
            } else if (opcion == 2) {
                Parqueo parqueo = seleccionarParqueo(s1, s2, s3);
                if (parqueo != null) {
                    int fila = leerEntero("Digite la fila:");
                    int columna = leerEntero("Digite la columna:");
                    String tipo = JOptionPane.showInputDialog(
                            "Tipo de espacio:\nO = Ocupado \nD = Director\nE = Discapacidad");

                    if (tipo != null && tipo.length() == 1) {
                        char estado = Character.toUpperCase(tipo.charAt(0));
                        if (estado == 'O' || estado == 'D' || estado == 'E') {
                            parqueo.asignarEspacio(fila, columna, estado);
                        } else {
                            JOptionPane.showMessageDialog(null, "Tipo de espacio no es válido.");
                        }
                    }
                }
            } else if (opcion == 3) {
                Parqueo parqueo = seleccionarParqueo(s1, s2, s3);
                if (parqueo != null) {
                    int fila = leerEntero("Ingrese la fila:");
                    int columna = leerEntero("Ingrese la columna:");
                    parqueo.liberarEspacio(fila, columna);
                }
            } else if (opcion != 4) {
                JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }

        JOptionPane.showMessageDialog(null, "Programa finalizado.");
    }

    public static Parqueo seleccionarParqueo(Parqueo s1, Parqueo s2, Parqueo s3) {
        String nivel = JOptionPane.showInputDialog(
                "Seleccione el nivel:"+"\n----------------------------"+"\n1. S1\n2. S2\n3. S3");

        if (nivel == null) {
            return null;
        }

        if (nivel.equals("1")) {
            return s1;
        } else if (nivel.equals("2")) {
            return s2;
        } else if (nivel.equals("3")) {
            return s3;
        } else {
            JOptionPane.showMessageDialog(null, "Nivel no válido.");
            return null;
        }
    }

    public static int leerEntero(String mensaje) {
        while (true) {
            String dato = JOptionPane.showInputDialog(mensaje);
            if (dato == null) {
                return 4;
            }
            try {
                return Integer.parseInt(dato);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número.");
            }
        }
    }
}
    
    

