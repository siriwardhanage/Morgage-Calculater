package com.youtube;

public class MortgageCalculate {
    public final static int MONTHS_IN_YEARS = 12;
    public final static int PERCENT = 100;
    private double principal;
    private double annualRate;
    private int year;
    public MortgageCalculate(double principal, double annualRate, int year) {
        this.principal = principal;
        this.annualRate = annualRate;
        this.year = year;
    }

    public double calculateBalance(int numberOfPaymentsMade) {
        double monthlyInterest = annualRate / MONTHS_IN_YEARS / PERCENT;
        double numberOfPayment = year * MONTHS_IN_YEARS;

        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayment) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayment) - 1);

        return balance;
    }

    public double calculateMortgage() {

        final int MONTHS_IN_YEARS = 12;
        final int PERCENT = 100;

        double monthlyInterest = annualRate / MONTHS_IN_YEARS / PERCENT;
        double numberOfPayment = year * MONTHS_IN_YEARS;

        double mortgage = principal
                * monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayment)
                / (Math.pow(1 + monthlyInterest, numberOfPayment) - 1);

        return mortgage;
    }

    public int getYear() {
        return year;
    }
}
