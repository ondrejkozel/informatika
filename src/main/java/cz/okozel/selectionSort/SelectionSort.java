package cz.okozel.selectionSort;

/**
 * Jednoduchá implementace Selection sort.
 *
 * @author ondra
 */
public class SelectionSort {

    /**
     * Seřadí pole čísel s časovou složitostí n<sup>2</sup>.
     * @param pole pole k seřazení
     */
    public void serad(int[] pole) {
        for (int i = 0; i < pole.length - 1; i++) prohod(pole, i, najdiIndexMin(pole, i));
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

    /**
     * Najde nejmenší číslo v poli a zjistí jeho index.
     * @param pole pole, ve kterém se má hledat
     * @param od index, od kterého se má hledat, indexy menší než <b>od</b> jsou ignorovány
     * @return index minima
     */
    private int najdiIndexMin(int[] pole, int od) {
        int min = pole[od];
        int index = od;
        for (int i = od + 1; i < pole.length; i++) if (pole[i] < min) {
            min = pole[i];
            index = i;
        }
        return index;
    }

    /**
     * Najde nejvyšší číslo v poli a zjistí jeho index.
     * @param pole pole, ve kterém se má hledat
     * @param od index, od kterého se má hledat, indexy menší než <b>od</b> jsou ignorovány
     * @return index maxima
     */
    @SuppressWarnings("unused")
    private int najdiIndexMax(int[] pole, int od) {
        int max = pole[od];
        int index = od;
        for (int i = od + 1; i < pole.length; i++) if (pole[i] > max) {
            max = pole[i];
            index = i;
        }
        return index;
    }

}