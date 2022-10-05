package org.example.insurance.adapters.product.dreadDiseaseInsurance;

import org.example.insurance.adapters.product.InsuranceDto;
import org.example.insurance.domain.product.DreadDiseaseInsurance;
import org.example.insurance.domain.product.DreadDiseaseInsurance.Gender;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/dread-disease-insurance", produces = APPLICATION_JSON_VALUE)
public class DreadDiseaseInsuranceController {
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> post(@RequestBody CalculateDreadDiseaseRequest data) {
        DreadDiseaseInsurance dreadDiseaseInsurance = new DreadDiseaseInsurance();
        Gender gender;
        if(Objects.equals(data.gender, "male")) {
            gender = Gender.MALE;
        } else if(Objects.equals(data.gender, "female")) {
            gender = Gender.FEMALE;
        } else {
            return ResponseEntity.badRequest().body("gender is not correct");
        }
        return ResponseEntity.ok().body(new InsuranceDto(dreadDiseaseInsurance.calculate(gender)));
    }
}
