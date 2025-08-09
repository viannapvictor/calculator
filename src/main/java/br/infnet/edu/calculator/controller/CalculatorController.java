package br.infnet.edu.calculator.controller;

import br.infnet.edu.calculator.dto.ApiResponse;
import br.infnet.edu.calculator.dto.OperationRequestDTO;
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

    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<ApiResponse<Double>> add(
            @Valid @ModelAttribute OperationRequestDTO req) {

        return ResponseEntity.ok(ApiResponse.ok(service.add(req.getA(), req.getB())));
    }

    @RequestMapping(value = "/subtract", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<ApiResponse<Double>> subtract(
            @Valid @ModelAttribute OperationRequestDTO req) {

        return ResponseEntity.ok(ApiResponse.ok(service.subtract(req.getA(), req.getB())));
    }

    @RequestMapping(value = "/multiply", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<ApiResponse<Double>> multiply(
            @Valid @ModelAttribute OperationRequestDTO req) {

        return ResponseEntity.ok(ApiResponse.ok(service.multiply(req.getA(), req.getB())));
    }

    @RequestMapping(value = "/divide", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<ApiResponse<Double>> divide(
            @Valid @ModelAttribute OperationRequestDTO req) {

        return ResponseEntity.ok(ApiResponse.ok(service.divide(req.getA(), req.getB())));
    }
    @RequestMapping(value = "/pow", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<ApiResponse<Double>> sqrt(
            @Valid @ModelAttribute OperationRequestDTO req) {
        return ResponseEntity.ok(ApiResponse.ok(service.expo(req.getA(), req.getB())));
    }

}
