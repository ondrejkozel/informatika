package cz.okozel.bubbleSort;

import cz.okozel.Sort;

/**
 * Jednoduchá implementace Bubble sort.
 *
 * @author ondra
 */
public class BubbleSort implements Sort {

    /**
     * Seřadí pole čísel s časovou složitostí O(n<sup>2</sup>).
     * @param pole pole k seřazení
     */
    @Override
    public void serad(int[] pole) {
        boolean serazeno = false;
        int probublano = 0;
        while (!serazeno) {
            serazeno = true;
            for (int i = 0; i < pole.length - probublano - 1; i++) {
                if (pole[i] > pole[i + 1]) {
                    prohod(pole, i, i + 1);
                    serazeno = false;
                }
            }
            probublano++;
        }
    }

    /**
     * Prohodí dvě čísla v poli.
     * @param pole pole, ve které se má přehazovat
     * @param i1 index prvního z přehazovaných čísel
     * @param i2 index druhého z přehazovaných čísel
     */
    private void prohod(int[] pole, int i1, int i2) {
        int temp = pole[i1];
        pole[i1] = pole[i2];
        pole[i2] = temp;
    }
}
