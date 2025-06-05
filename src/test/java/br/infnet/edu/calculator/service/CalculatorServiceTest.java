package br.infnet.edu.calculator.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    private CalculatorService service;

    @BeforeEach
    void setUp() {
        service = new CalculatorService();
    }

    @Test
    void add_shouldReturnCorrectSum() {
        double result = service.add(10, 5);
        assertEquals(15.0, result);
    }

    @Test
    void subtract_shouldReturnCorrectDifference() {
        double result = service.subtract(10, 5);
        assertEquals(5.0, result);
    }

    @Test
    void multiply_shouldReturnCorrectProduct() {
        double result = service.multiply(10, 5);
        assertEquals(50.0, result);
    }

    @Test
    void divide_shouldReturnCorrectQuotient() {
        double result = service.divide(10, 5);
        assertEquals(2.0, result);
    }

    @Test
    void divide_byZero_shouldThrowArithmeticException() {
        ArithmeticException ex = assertThrows(
                ArithmeticException.class,
                () -> service.divide(10, 0)
        );
        assertEquals("Divisor não pode ser zero.", ex.getMessage());
    }

    @Test
    void sqrt_shouldReturnCorrectRoot() {
        double result = service.sqrt(16);
        assertEquals(4.0, result);
    }

    @Test
    void sqrt_ofZero_shouldReturnZero() {
        double result = service.sqrt(0);
        assertEquals(0.0, result);
    }

    @Test
    void sqrt_negative_shouldThrowArithmeticException() {
        ArithmeticException ex = assertThrows(
                ArithmeticException.class,
                () -> service.sqrt(-9)
        );
        assertEquals("Não é possível calcular a raiz quadrada de número negativo.", ex.getMessage());
    }
}
