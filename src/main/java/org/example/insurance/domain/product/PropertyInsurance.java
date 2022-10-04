package org.example.insurance.domain.product;

import org.example.insurance.domain.InsuranceProduct;

import java.math.BigDecimal;

public class PropertyInsurance extends InsuranceProduct<Double> {

    private String name = "资产平安 延续万年";

    private BigDecimal rate = new BigDecimal("0.001");

    public PropertyInsurance() {
        this.amount = 6000000;
    }

    @Override
    public double calculate(Double value) {
        return BigDecimal.valueOf(value).multiply(rate).doubleValue();
    }

}
