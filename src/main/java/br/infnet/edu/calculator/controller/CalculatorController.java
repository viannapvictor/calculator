package br.infnet.edu.calculator.controller;

import br.infnet.edu.calculator.dto.ApiResponse;
import br.infnet.edu.calculator.dto.OperationRequestDTO;
import br.infnet.edu.calculator.dto.SqrtRequestDTO;
import br.infnet.edu.calculator.service.CalculatorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/web-calculator")
@RequiredArgsConstructor
@Validated
public class CalculatorController {
    private final CalculatorService service;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<Double>> add(
            @Valid @ModelAttribute OperationRequestDTO req) {

        return ResponseEntity.ok(ApiResponse.ok(service.add(req.getA(), req.getB())));
    }

    @PostMapping("/subtract")
    public ResponseEntity<ApiResponse<Double>> subtract(
            @Valid @ModelAttribute OperationRequestDTO req) {

        return ResponseEntity.ok(ApiResponse.ok(service.subtract(req.getA(), req.getB())));
    }

    @PostMapping("/multiply")
    public ResponseEntity<ApiResponse<Double>> multiply(
            @Valid @ModelAttribute OperationRequestDTO req) {

        return ResponseEntity.ok(ApiResponse.ok(service.multiply(req.getA(), req.getB())));
    }

    @PostMapping("/divide")
    public ResponseEntity<ApiResponse<Double>> divide(
            @Valid @ModelAttribute OperationRequestDTO req) {

        return ResponseEntity.ok(ApiResponse.ok(service.divide(req.getA(), req.getB())));
    }
    @PostMapping("/sqrt")
    public ResponseEntity<ApiResponse<Double>> sqrt(
            @Valid @ModelAttribute SqrtRequestDTO req) {
        return ResponseEntity.ok(ApiResponse.ok(service.sqrt(req.getA())));
    }

}
