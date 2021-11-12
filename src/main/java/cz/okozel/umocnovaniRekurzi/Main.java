package cz.okozel.umocnovaniRekurzi;

public class Main {

    public static class Umocnovac {

        public float umocni(float zaklad, float exponent) {
            if (exponent < 0) return umocni(1 / zaklad, exponent * -1);
            if (exponent == 0) return 1;
            else return zaklad * umocni(zaklad, --exponent);
        }

    }

}
