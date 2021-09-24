#include <iostream>

using namespace std;

const int POCET_PRVKU = 10;

int binarySearch(int pole[], int x)
{
    int levy = 0, pravy = POCET_PRVKU - 1;
    while (levy <= pravy) {
        int pivot = (levy + pravy) / 2;

        if (pole[pivot] == x)
            return pivot;

        if (pole[pivot] < x)
            levy = pivot + 1;

        else
            pravy = pivot - 1;
    }

    return -1;
}

int main()
{
    int pole[POCET_PRVKU] = {10, 12, 13, 14, 20, 80, 81, 82, 100, 200};

    int x = 20;

    int vysledek = binarySearch(pole, x);

    if(vysledek < 0)
        cout << "Dane cislo neni v poli.";
    else
        cout << "Cislo je na indexu " << vysledek;


    return 0;
}