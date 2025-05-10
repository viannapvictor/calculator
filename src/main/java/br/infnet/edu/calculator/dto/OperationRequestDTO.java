package br.infnet.edu.calculator.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import static org.apache.coyote.http11.Constants.a;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class OperationRequestDTO {

    @NotNull @Min(0)
    private Integer a;

    @NotNull @Min(0)
    private Integer b;
}
