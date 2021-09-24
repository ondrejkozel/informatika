package cz.okozel.insertionSort;

import java.util.Arrays;

/**
 * Jednoduchá ukázka algoritmu Insertion sort.
 *
 * Pořád nebylo řečeno, že to musí být v cpp :) kdyžtak to přepíšu :D
 *
 * @author ondra
 */
public class Main {

    /**
     * pole čísel k seřazení
     */
    private static final int[] CISLA = {1, 56, 48, 85, 97, 52, 42, 88, 99};

    /**
     * Vypíše seznam čísel před a po seřazení.
     * @param args argumenty z konzole, jsou ignorovány
     */
    public static void main(String[] args) {
        System.out.println("Před:\t" + Arrays.toString(CISLA));
        new InsertionSort().serad(CISLA);
        System.out.println("Po:\t\t" + Arrays.toString(CISLA));
    }
}
