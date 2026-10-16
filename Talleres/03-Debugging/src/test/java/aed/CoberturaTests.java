package aed;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CoberturaTests {
    Cobertura cobertura = new Cobertura();

    @Test
    void testFizzBuzz() {
        assertEquals("FizzBuzz", cobertura.fizzBuzz(15));
        assertEquals("Fizz", cobertura.fizzBuzz(18));
        assertEquals("Buzz", cobertura.fizzBuzz(20));
        assertEquals("7", cobertura.fizzBuzz(7));


    }

    @Test
    void testNumeroCombinatorio() {
        assertEquals(1, cobertura.numeroCombinatorio(0, 0));
        assertEquals(1, cobertura.numeroCombinatorio(10, 0));
        assertEquals(1, cobertura.numeroCombinatorio(10, 10));
        assertEquals(0, cobertura.numeroCombinatorio(5, 10));
        assertEquals(6, cobertura.numeroCombinatorio(4, 2));
    }

    @Test
    void testRepeticionesConsecutivas() {
        assertEquals(0, cobertura.repeticionesConsecutivas(new int[]{0}));
        assertEquals(1, cobertura.repeticionesConsecutivas(new int[]{0,1,2}));
        assertEquals(1, cobertura.repeticionesConsecutivas(new int[]{0,1,2,3,2}));
        assertEquals(2, cobertura.repeticionesConsecutivas(new int[]{0,1,2,2,3,4,4}));
        assertEquals(4, cobertura.repeticionesConsecutivas(new int[]{1,1,1,1,2,3,4,5}));
        assertEquals(3, cobertura.repeticionesConsecutivas(new int[]{1,2,3,4,5,6,6,6}));
        assertEquals(5, cobertura.repeticionesConsecutivas(new int[]{0,1,2,3,4,4,4,5,6,7,7,7,7,7,8}));

    }
}
