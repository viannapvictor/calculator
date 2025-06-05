package br.infnet.edu.calculator.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class SqrtRequestDTO {

    @NotNull
    @Min(0)
    private Integer a;
}

