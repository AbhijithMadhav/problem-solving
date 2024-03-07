package org.am.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NAtomsTest {

    @Test
    void countOfAtoms() {

        assertEquals("H", new NAtoms().simplify("(H)"));

        assertEquals("H2O", new NAtoms().simplify("(H2O)"));
        assertEquals("C42K4N63O147S42U126", new NAtoms().simplify("K4(ON(SO3C)2U6N2)21"));

        assertEquals("K4N2O14S4", new NAtoms().simplify("K4(ON(SO3)2)2"));

        assertEquals("H2O", new NAtoms().simplify("H2O"));
        assertEquals("H2MgO2", new NAtoms().simplify("Mg(OH)2"));
        assertEquals("H", new NAtoms().simplify("H"));
        assertEquals("H2", new NAtoms().simplify("HH"));
        assertEquals("Herrt", new NAtoms().simplify("Herrt"));
        assertEquals("Herrt2", new NAtoms().simplify("HerrtHerrt"));
        assertEquals("H3O2", new NAtoms().simplify("H2OHO"));





    }
}