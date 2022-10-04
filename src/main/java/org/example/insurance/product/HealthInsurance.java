package org.example.insurance.product;

import org.example.insurance.InsuranceProduct;

public class HealthInsurance extends InsuranceProduct<Double> {

    private String name = "大小没病 远离医生";

    public HealthInsurance() {
        this.amount = 1000000;
    }
    @Override
    public double calculate(Double age) {
        if (age < 20) {
            throw new IllegalArgumentException("年龄不符合投保规则，不能投保。");
        }
        return 100 + (age - 20) * 100;
    }

}
