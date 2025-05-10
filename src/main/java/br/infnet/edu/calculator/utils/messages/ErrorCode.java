package br.infnet.edu.calculator.utils.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    DIVIDE_BY_ZERO("Divisor não pode ser zero."),
    VALIDATION_ERROR("Dados de entrada inválidos.");

    private final String message;
}
