package br.infnet.edu.calculator.service;

import br.infnet.edu.calculator.interfaces.ICalculatorService;
import br.infnet.edu.calculator.utils.messages.ErrorCode;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

    @Override
    public double add(int a, int b) {
        return (double) a + b;
    }

    @Override
    public double subtract(int a, int b) {
        return (double) a - b;
    }

    @Override
    public double multiply(int a, int b) {
        return (double) a * b;
    }

    @Override
    public double divide(int a, int b) {
        if (b == 0) throw new ArithmeticException(ErrorCode.DIVIDE_BY_ZERO.getMessage());
        return (double) a / b;
    }
    @Override
    public double sqrt(int a) {
        if (a < 0) throw new ArithmeticException("Não é possível calcular a raiz quadrada de número negativo.");
        return Math.sqrt(a);
    }
}
