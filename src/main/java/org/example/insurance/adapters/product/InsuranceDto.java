package org.example.insurance.adapters.product;

import org.example.insurance.adapters.ResponseDto;

public class InsuranceDto implements ResponseDto {
    public double totalAmount;

    public InsuranceDto(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
