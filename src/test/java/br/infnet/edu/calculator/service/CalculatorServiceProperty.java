package br.infnet.edu.calculator.service;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceProperty {

    private final CalculatorService service = new CalculatorService();

    @Property
    void add_shouldAlwaysReturnSum(@ForAll @IntRange(min = 1, max = 1000) int a,
                                   @ForAll @IntRange(min = 1, max = 1000) int b) {
        assertEquals((double) (a + b), service.add(a, b));
    }

    @Property
    void subtract_shouldAlwaysReturnDifference(@ForAll @IntRange(min = 1, max = 1000) int a,
                                               @ForAll @IntRange(min = 1, max = 1000) int b) {
        assertEquals((double) (a - b), service.subtract(a, b));
    }

    @Property
    void multiply_shouldAlwaysReturnProduct(@ForAll @IntRange(min = 1, max = 1000) int a,
                                            @ForAll @IntRange(min = 1, max = 1000) int b) {
        assertEquals((double) (a * b), service.multiply(a, b));
    }

    @Property
    void divide_shouldAlwaysReturnQuotient(@ForAll @IntRange(min = 1, max = 1000) int a,
                                           @ForAll @IntRange(min = 1, max = 1000) int b) {

        double expected = (double) a / b;
        assertEquals(expected, service.divide(a, b));
    }
    @Property
    void sqrt_shouldReturnCorrectRoot(@ForAll @IntRange(min = 0, max = 10000) int x) {
        double expected = Math.sqrt(x);
        assertEquals(expected, service.sqrt(x));
    }
}
