#include <iostream>

using namespace std;

#define POCET_PRVKU 10

int najdiBinarne(int pole[], int hledanyPrvek) {
    int levyIndex = 0;
    int pravyIndex = POCET_PRVKU - 1;
    while (levyIndex <= pravyIndex) {
        int stredIndex = (levyIndex+pravyIndex)/2;
        if (pole[stredIndex] == hledanyPrvek) return stredIndex;
        if (pole[stredIndex] > hledanyPrvek) pravyIndex = stredIndex - 1;
        else if (pole[stredIndex] < hledanyPrvek) levyIndex = stredIndex + 1;
    }
    return -1;
}

int main()
{
    int pole[POCET_PRVKU] = {1,4,8,12,52,408,550,600,700,999};
    int index = najdiBinarne(pole, 12);
    cout << index << endl;
    return 0;
}
