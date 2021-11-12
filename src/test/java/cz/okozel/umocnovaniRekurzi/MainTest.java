package cz.okozel.umocnovaniRekurzi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private Main.Umocnovac umocnovac;

    @BeforeEach
    void setUp() {
        umocnovac = new Main.Umocnovac();
    }

    @Test
    void dvaNaTretiJeOsm() {
        assertEquals(8, umocnovac.umocni(2, 3));
    }

    @Test
    void dvanactNaSestouJe2985984() {
        assertEquals(2985984, umocnovac.umocni(12, 6));
    }

    @Test
    void petNaDruhouNeniTricet() {
        assertNotEquals(30, umocnovac.umocni(5, 2));
    }

    @Test
    void sedesatNaNultouJeJedna() {
        assertEquals(1, umocnovac.umocni(60, 0));
    }

    @Test
    void pulNaDruhouJeJednaCtvrtina() {
        assertEquals(0.25f, umocnovac.umocni(0.5f, 2));
    }

    @Test
    void osmNaMinusDruhouJeZadnaCela015625() {
        assertEquals(0.015625f, umocnovac.umocni(8, -2));
    }

    @Test
    void sestnactNaMinusDvanactouNeniDeset() {
        assertNotEquals(10, umocnovac.umocni(16, -12));
    }

}