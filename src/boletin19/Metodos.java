/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin19;

import java.util.Scanner;

/**
 *
 * @author jalvarezbretana
 */
public class Metodos {

    public int[][] crearMatriz(int[][] taboa) {
        for (int i = 0; i < taboa.length; i++) {
            for (int j = 0; j < taboa[i].length; j++) {
                taboa[i][j] = (int) (Math.floor(Math.random() * (5 - 1) + 1));
            }
        }
        return taboa;
    }

    public String[] crearXornadas(String[] xornadas) {
        for (int i = 0; i < xornadas.length; i++) {
            xornadas[i] = "x" + (i + 1);
        }
        return xornadas;
    }

    public void amosarTodo(int[][] taboa, String[] equipos, String[] xornadas) {
        System.out.print("Equipo/xornada");
        for (int i = 0; i < xornadas.length; i++) {
            System.out.print("   " + xornadas[i]);
        }
        for (int f = 0; f < taboa.length; f++) {
            System.out.print("\n " + equipos[f]);
            for (int c = 0; c < taboa[f].length; c++) {
                System.out.print("  " + taboa[f][c] + "  ");
            }
        }
    }

    public void menorGoles(int[][] taboa, String[] equiposOrdenados) {
        int aux;
        String auxEquipos;
        int[] mGoles = new int[taboa.length];
        for (int f = 0; f < taboa.length; f++) {

            for (int c = 0; c < taboa[f].length; c++) {
                mGoles[f] = mGoles[f] + taboa[f][c];
            }
        }
        for (int i = 0; i < mGoles.length - 1; i++) {
            for (int j = i + 1; j < equiposOrdenados.length; j++) {
                if (mGoles[i] > mGoles[j]) {
                    aux = mGoles[i];
                    mGoles[i] = mGoles[j];
                    mGoles[j] = aux;
                    auxEquipos = equiposOrdenados[i];
                    equiposOrdenados[i] = equiposOrdenados[j];
                    equiposOrdenados[j] = auxEquipos;
                }
            }
        }
        for (int i = 0; i < equiposOrdenados.length; i++) {
            System.out.println(equiposOrdenados[i] + "(" + mGoles[i]
                    + " goles)");
        }
    }

    public void goleadorMaximo(int[][] taboa, String[] equipos, String[] xornadas) {
        int max = 0;
        String equipoMax[] = new String[equipos.length];
        for (int i = 0; i < taboa[0].length; i++) {
            for (int j = 0; j < taboa.length; j++) {
                if (max <= taboa[j][i]) {
                    max = taboa[j][i];
                    equipoMax[j] = equipos[j];
                }
            }
            for (int j = 0; j < taboa.length; j++) {
                if (max == taboa[j][i]) {
                    System.out.println("Xornada: " + xornadas[i]
                            + ", equipo: " + equipoMax[j] + ", goles: " + max);
                }
            }
        }

    }

    public void consultar(int[][] taboa, String[] equipos, String[] xornadas) {
        int posicionEquipo = 0, posicionXornada = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Que equipo quieres buscar?");
        String equipo = sc.nextLine();
        System.out.println("En que xornada?(x1,x2,x3,...)");
        String xornada = sc.nextLine();
        for (int i = 0; i < equipos.length; i++) {
            if (equipo.equals(equipos[i])) {
                posicionEquipo = i;
            }
        }
        for (int j = 0; j < xornadas.length; j++) {
            if (xornada.equals(xornadas[j])) {
                posicionXornada = j;
            }
        }
        System.out.println("O equipo: " + equipo + " marcou "
                + taboa[posicionEquipo][posicionXornada] + " gol/es na xornada "
                + xornada);
    }
}
