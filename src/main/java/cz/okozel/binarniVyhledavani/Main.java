package cz.okozel.binarniVyhledavani;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;


/**
 * Zadáni neobsahovalo požadovaný jazyk, tak to máte v Javě :)
 */
public class Main {

    public static void main(String[] args) {
        int[] cisla = {0, 10, 13, 54, 65, 77, 89, 101, 123, 150, 1000};
        for (int i : cisla) System.out.println(i);
        System.out.println("\nZadej číslo k vyhledání: ");
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);
        int hledaneCislo = Integer.parseInt(sc.nextLine());
        int index = new Vyhledavac().vyhledejPrvek(cisla, hledaneCislo);
        System.out.println(index == -1 ? "Pole neobsahuje toto číslo." : "Toto číslo má index " + index);
    }

    public static class Vyhledavac {

        /**
         * Náhodné vysoké číslo proti přetečení zásobníku.
         */
        private static final int MAX_PRUCHODY = 25;

        private int cykly;

        public int vyhledejPrvek(int[] pole, int hledaneCislo) {
            cykly = 0;
            return vyhledejPrvek(pole, hledaneCislo, 0, pole.length - 1);
        }

        private int vyhledejPrvek(int[] pole, int hledaneCislo, int minIndex, int maxIndex) {
            if (cykly++ > MAX_PRUCHODY) return -1;
            int stredIndex = (minIndex + maxIndex) / 2;
            if (hledaneCislo < pole[stredIndex]) return vyhledejPrvek(pole, hledaneCislo, minIndex, stredIndex - 1);
            if (hledaneCislo > pole[stredIndex]) return vyhledejPrvek(pole, hledaneCislo, stredIndex + 1, maxIndex);
            return stredIndex;
        }

    }
}
