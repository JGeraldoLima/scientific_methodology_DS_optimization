
package com.utils;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class GeradorMainEnsaio1 {
    final static int minValue = 65; // 91 sao simbolos
    static Random gerador = new Random();
    static Random geradorP = new Random();

    public static void generateSample() throws FileNotFoundException {

        // final int maxValue = 91;

        PrintWriter writer = new PrintWriter("content/consults_ensaio1.txt");
        System.out.println("Running");
        System.out.println("Starting....make consults");
        generateSample(writer, 20000);
        System.out.println("consults done");
        writer = new PrintWriter("content/sample_ensaio1.txt");
        System.out.println("Starting....make consults");
        generateSample(writer, 2000000);
        System.out.println("sample done");
        System.out.println("done all generates");

    }

    private static void generateSample(PrintWriter writer, int maxValue) {
        for (int i = 0; i < maxValue; i++) {
            int numero = gerador.nextInt(26) + minValue;
            int numero2 = gerador.nextInt(26) + minValue;
            int numero3 = gerador.nextInt(26) + minValue;
            int numero4 = gerador.nextInt(26) + minValue;
            int numero5 = gerador.nextInt(26) + minValue;
            int numero6 = gerador.nextInt(26) + minValue;
            int numero7 = gerador.nextInt(26) + minValue;
            int palavra = geradorP.nextInt(7) + 1;
            if (palavra == 3) {
                writer.println((char) numero + "" + (char) numero2 + ""
                        + (char) numero3);
            } else if (palavra == 4) {
                writer.println((char) numero + "" + (char) numero2 + ""
                        + (char) numero3 + "" + (char) numero4);
            } else if (palavra == 5) {
                writer.println((char) numero + "" + (char) numero2 + ""
                        + (char) numero3 + "" + (char) numero4 + ""
                        + (char) numero5);
            } else if (palavra == 6) {
                writer.println((char) numero + "" + (char) numero2 + ""
                        + (char) numero3 + "" + (char) numero4 + ""
                        + (char) numero5 + "" + (char) numero6);
            } else {
                writer.println((char) numero + "" + (char) numero2 + ""
                        + (char) numero3 + "" + (char) numero4 + ""
                        + (char) numero5 + "" + (char) numero6 + ""
                        + (char) numero7);
            }
        }
        writer.close();
    }
}
