package org.example.insurance.adapters.product.healthInsurance;

import org.example.insurance.adapters.product.InsuranceDto;
import org.example.insurance.domain.product.DreadDiseaseInsurance;
import org.example.insurance.domain.product.DreadDiseaseInsurance.Gender;
import org.example.insurance.domain.product.HealthInsurance;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/health-insurance", produces = APPLICATION_JSON_VALUE)
public class HealthInsuranceController {
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> post(@RequestBody CalculateHealthRequest data, UriComponentsBuilder uriComponentsBuilder) {
        HealthInsurance healthInsurance = new HealthInsurance();
        double totalAmount;
        try {
            totalAmount = healthInsurance.calculate(data.age);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body(new InsuranceDto(totalAmount));
    }
}
