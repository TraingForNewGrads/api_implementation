package org.example.insurance.domain.product;


import org.example.insurance.domain.InsuranceProduct;

public class DreadDiseaseInsurance extends InsuranceProduct<DreadDiseaseInsurance.Gender> {

    private String name = "健康成长 一生无忧";

    public DreadDiseaseInsurance() {
        this.amount = 500000;
    }

    @Override
    public double calculate(Gender gender) {
        if (Gender.MALE == gender) {
            return 3090;
        } else {
            return 2970;
        }
    }

    public enum Gender {
        MALE,
        FEMALE
    }
}
