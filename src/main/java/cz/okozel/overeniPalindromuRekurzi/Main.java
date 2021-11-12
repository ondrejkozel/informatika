package cz.okozel.overeniPalindromuRekurzi;

public class Main {

    public static class OverovacPalindromu {

        public boolean over(String retezec) {
            if (retezec.length() <= 1) return true;
            if (retezec.charAt(0) != retezec.charAt(retezec.length() - 1)) return false;
            else return over(retezec.substring(1, retezec.length() - 1));
        }

    }

}
