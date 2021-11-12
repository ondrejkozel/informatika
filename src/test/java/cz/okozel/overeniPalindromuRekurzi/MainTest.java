package cz.okozel.overeniPalindromuRekurzi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private Main.OverovacPalindromu overovacPalindromu;

    @BeforeEach
    void setUp() {
        overovacPalindromu = new Main.OverovacPalindromu();
    }

    @Test
    void rotorJePalindrom() {
        assertTrue(overovacPalindromu.over("rotor"));
    }

    @Test
    void rottorJePalindrom() {
        assertTrue(overovacPalindromu.over("rottor"));
    }

    @Test
    void motorkaNeniPalindrom() {
        assertFalse(overovacPalindromu.over("motorka"));
    }

    @Test
    void autoNeniPalindrom() {
        assertFalse(overovacPalindromu.over("auto"));
    }

    @Test
    void prazdnyRetezecJePalindrom() {
        assertTrue(overovacPalindromu.over(""));
    }

    @Test
    void kratkyRetezecJePalindrom() {
        assertTrue(overovacPalindromu.over("O"));
    }

    @Test
    void rOtorNeniPalindrom() {
        assertFalse(overovacPalindromu.over("rOtor"));
    }

}