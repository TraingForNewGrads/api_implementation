package org.example.insurance;

public abstract class InsuranceProduct<T> {

    protected double amount;

    public double getAmount() {
        return amount;
    }

    public abstract double calculate(T param);
}
