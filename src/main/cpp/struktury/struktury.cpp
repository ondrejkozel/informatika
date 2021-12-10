#include <iostream>
using namespace std;

struct EMPLOYEE {
    string name;
    int yearOfBirth;
    int salary;
};

#define MAX_ZAMESTNANCU 50

EMPLOYEE zamestnanci[MAX_ZAMESTNANCU];
int pocetZamestnancu = 0;

int menu() {
    cout << "\tMENU\n1. Pridat noveho zamestnance\n2. Vypsat vsechny zamestnance\n3. Ukončit\n";
    int vstup;
    cin >> vstup;
    if (vstup < 1 || vstup > 3) {
        cout << "Byla zadana neplatna hodnota.\n";
        return menu();
    }
    return vstup;
}

bool vytvoritUzivatele() {
    if (pocetZamestnancu == MAX_ZAMESTNANCU) return false;
    EMPLOYEE novyZamestnanec;
    cout << "Jmeno: ";
    cin >> novyZamestnanec.name;
    cout << "Rok narozeni: ";
    cin >> novyZamestnanec.yearOfBirth;
    cout << "Plat: ";
    cin >> novyZamestnanec.salary;
    zamestnanci[pocetZamestnancu] = novyZamestnanec;
    pocetZamestnancu++;
    return true;
}

void vypsatVsechnyUzivatele() {
    for (int i = 0; i < pocetZamestnancu; i++) {
        EMPLOYEE zamestnanec = zamestnanci[i];
        cout << (i + 1) << ". " << zamestnanec.name << ", rocnik " << zamestnanec.yearOfBirth << ", plat " << zamestnanec.salary << " czk\n";
    }
    if (pocetZamestnancu == 0) cout << "Nebyl ulozen zadny uzivatel.\n";
}

int main() {
    cout << "Vitejte v managmentu zamestnancu!\n\n";
    //
    bool pokracuj = true;
    while (pokracuj) {
        switch (menu()) {
            case 1:
                if (vytvoritUzivatele()) cout << "Uzivatel byl uspesne vytvoren.\n";
                else cout << "Nepodarilo se vytvorit uzivatele.\n";
                break;
            case 2:
                vypsatVsechnyUzivatele();
                break;
            default:
                pokracuj = false;
        }
    }
    cout << "Dekuji za vyuzivani programu.\n";
    return 0;
}
