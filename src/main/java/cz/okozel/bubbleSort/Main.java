package cz.okozel.bubbleSort;

import cz.okozel.Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Jednoduchá ukázka algoritmu BubbleSort.
 *
 * @author ondra
 */
public class Main {

    /**
     * pole čísel k seřazení
     */
    private static final int[] CISLA = {1, 56, 48, 85, 97, 52, 42, 99, 88};

    /**
     * Vypíše seznam čísel před a po seřazení.
     * @param args argumenty z konzole, jsou ignorovány
     */
    public static void main(String[] args) {
        Sort bubbleSort = new BubbleSort();
        vypisSeradVypis(bubbleSort, CISLA);
        System.out.println("\nA nyní s náhodnými čísly:");
        int[] nahodnePole = new Random().ints(100, 0, 1000).toArray();
        vypisSeradVypis(bubbleSort, nahodnePole);
    }

    private static void vypisSeradVypis(Sort sort, int[] pole) {
        System.out.println("Před:\t" + Arrays.toString(pole));
        long pred = System.nanoTime();
        sort.serad(pole);
        long po = System.nanoTime();
        float ms = (float) ( po - pred) / 1000000;
        System.out.println("Po:\t\t" + Arrays.toString(pole));
        System.out.printf("Seřazování trvalo zhruba %.3f ms\n", ms);
    }
}
