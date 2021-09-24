package cz.okozel.insertionSort;

import cz.okozel.Sort;

/**
 * Jednoduchá implementace Insertion sort.
 *
 * @author ondra
 */
public class InsertionSort implements Sort {

    /**
     * Seřadí pole čísel s časovou složitostí n<sup>2</sup>.
     * @param pole pole k seřazení
     */
    @Override
    public void serad(int[] pole) {
        for (int i = 1; i < pole.length - 1; i++) {
            //aktuálně seřazovaný prvek
            int aktPrvek = pole[i];
            int o = i - 1;
            while (o >= 0 && pole[o] > aktPrvek) {
                pole[o + 1] = pole[o];
                o--;
            }
            pole[o + 1] = aktPrvek;
        }
    }
}
