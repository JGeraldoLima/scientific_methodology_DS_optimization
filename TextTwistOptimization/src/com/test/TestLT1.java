
package com.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.implementations.TextTwist;
import com.implementations.list.TextTwistList;
import com.utils.GeradorMainEnsaio1;

public class TestLT1 {

    private static TextTwistList dictonaryList;

    private static BufferedReader sample;
    private static BufferedReader consult;

    private static PrintWriter resultsForList;

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
        GeradorMainEnsaio1.generateSample();
        dictonaryList = new TextTwistList();
        resultsForList = new PrintWriter("content/resultsForListTest1");

        resultsForList.println("Test metrics:");
        resultsForList.println(">>> words to search: 20.000");
        resultsForList.println(">>> words to load: 2.000.000");
        resultsForList.println("============================");
        resultsForList.println();

        openExperimentFiles();
        populateStructure(dictonaryList);
        performSearch(dictonaryList, resultsForList);

        resultsForList.println("============================");
        resultsForList.println();

        resultsForList.println(tempo_de_carga);
        resultsForList.println(tempo_de_consulta);
        calculateSpentMemory();
        resultsForList.println(consumo_de_memoria);
        resultsForList.close();
        closeExperimentFiles();
        dictonaryList = null;
        resultsForList = null;

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

        } catch (IOException e) {
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

        } catch (IOException e) {
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
        sample = new BufferedReader(new FileReader("content/sample_ensaio1.txt"));
        consult = new BufferedReader(new FileReader("content/consults_ensaio1.txt"));
    }

    private static void closeExperimentFiles() {
        try {
            if (sample != null) {
                sample.close();
            }
            sample = null;
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            if (consult != null) {
                consult.close();
            }
            consult = null;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
