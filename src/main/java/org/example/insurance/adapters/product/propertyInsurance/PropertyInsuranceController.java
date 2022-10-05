package org.example.insurance.adapters.product.propertyInsurance;

import org.example.insurance.adapters.product.InsuranceDto;
import org.example.insurance.domain.product.PropertyInsurance;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/property-insurance", produces = APPLICATION_JSON_VALUE)
public class PropertyInsuranceController {
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> post(@RequestBody CalculatePropertyRequest data) {
        PropertyInsurance propertyInsurance = new PropertyInsurance();
        return ResponseEntity.ok().body(new InsuranceDto(propertyInsurance.calculate(data.value)));
    }
}
