package org.example;


import org.example.product.DreadDiseaseInsurance;
import org.example.product.HealthInsurance;
import org.example.product.PropertyInsurance;

import static org.example.product.DreadDiseaseInsurance.Gender.FEMALE;
import static org.example.product.DreadDiseaseInsurance.Gender.MALE;

public class InsuranceCalculator {

    public static void main(String[] args) {

        InsuranceProduct dreadDiseaseInsurance = new DreadDiseaseInsurance();

        System.out.println(dreadDiseaseInsurance.getAmount() + "保费" + dreadDiseaseInsurance.calculate(MALE));
        System.out.println(dreadDiseaseInsurance.getAmount() + "保费" + dreadDiseaseInsurance.calculate(FEMALE));

        InsuranceProduct propertyInsurance = new PropertyInsurance();
        System.out.println(propertyInsurance.getAmount() + "保费" + propertyInsurance.calculate(6000000D));

        InsuranceProduct healthInsurance = new HealthInsurance();
        System.out.println(healthInsurance.getAmount() + "保费" + healthInsurance.calculate(40D));

        try {
            System.out.println("保费" + healthInsurance.calculate(15D));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
