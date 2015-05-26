
package com.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

import com.implementations.TextTwist;
import com.implementations.bst.TextTwistBST;
import com.utils.GeradorMainEnsaio2;

public class TestBT2 {

    private static TextTwistBST dictonaryBST;

    private static BufferedReader sample;
    private static BufferedReader consult;

    private static PrintWriter resultsForBST;

    static long startTime;
    private static String tempo_de_carga;
    private static String tempo_de_consulta;
    long endTime = System.nanoTime();

    private static Runtime runtime;
    private static String consumo_de_memoria;
    private static final long BYTE = 8L;
    private static final long KBYTE = 1024 * BYTE;
    private static final long MEGABYTE = 1024 * KBYTE;

    /**
     * Todo trecho de codigo referente ao calculo de consumo de memoria foi
     * copiado do seguinte link:
     * http://www.vogella.com/tutorials/JavaPerformance
     * /article.html#memory_overview
     */
    public static void main(String[] args) throws FileNotFoundException {

        // gerar arquivo com a classe GeradorMain
        GeradorMainEnsaio2.generateSample();

        resultsForBST = new PrintWriter("content/resultsForBSTTest2");

        resultsForBST.println("Test metrics:");
        resultsForBST.println(">>> words to search: 20.000");
        resultsForBST.println(">>> words to load: 50.000.000");
        resultsForBST.println("============================");
        resultsForBST.println();

        dictonaryBST = new TextTwistBST();
        openExperimentFiles();
        populateStructure(dictonaryBST);
        performSearch(dictonaryBST, resultsForBST);

        resultsForBST.println("============================");
        resultsForBST.println();

        resultsForBST.println(tempo_de_carga);
        resultsForBST.println(tempo_de_consulta);
        calculateSpentMemory();
        resultsForBST.println(consumo_de_memoria);
        resultsForBST.close();
        closeExperimentFiles();
        resultsForBST = null;
        dictonaryBST = null;

        System.out.println("End search");
    }

    private static void populateStructure(TextTwist structure) {
        runtime = Runtime.getRuntime();

        startTime = System.currentTimeMillis();

        try {
            String sCurrentLine;
            int i = 0;
            while ((sCurrentLine = sample.readLine()) != null) {
                System.out.println(i++);
                sCurrentLine = sCurrentLine.trim();
                structure.insertInDictionary(sCurrentLine);

            }
            structure.insertInDictionary("MARIA");

        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        tempo_de_carga = "tempo_de_carga : " + (endTime - startTime) / 1000.0 + "s";

    }

    private static void performSearch(TextTwist structure, PrintWriter results) {
        runtime = Runtime.getRuntime();

        startTime = System.currentTimeMillis();

        try {
            String sCurrentLine;
            while ((sCurrentLine = consult.readLine()) != null) {
                String result = "<" + sCurrentLine.trim() + "> : ";
                sCurrentLine = sCurrentLine.toUpperCase();
                result += structure.searchWord(sCurrentLine) ? "S" : "N";
                results.println(result);
                System.out.println(result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        tempo_de_consulta = "tempo_de_consulta : " + (endTime - startTime) / 1000.0 + "s";

    }

    private static long bytesToMegabytes(long bytes) {
        return bytes / MEGABYTE;
    }

    private static void calculateSpentMemory() {
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();
        consumo_de_memoria = "consumo_de_memoria: " + bytesToMegabytes(memory) + "MB";
    }

    private static void openExperimentFiles() throws FileNotFoundException {
        sample = new BufferedReader(new FileReader("content/sample_ensaio2.txt"));
        consult = new BufferedReader(new FileReader("content/consults_ensaio2.txt"));
    }

    private static void closeExperimentFiles() {
        try {
            if (sample != null) {
                sample.close();
            }
            sample = null;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            if (consult != null) {
                consult.close();
            }
            consult = null;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
