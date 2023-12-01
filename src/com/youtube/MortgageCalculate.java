package com.youtube;

public class MortgageCalculate {
    private final static int MONTHS_IN_YEARS = 12;
    private final static int PERCENT = 100;
    private double principal;
    private double annualRate;
    private int year;
    public MortgageCalculate(double principal, double annualRate, int year) {
        this.principal = principal;
        this.annualRate = annualRate;
        this.year = year;
    }

    public double calculateBalance(int numberOfPaymentsMade) {
        double monthlyInterest = getMonthlyInterest();
        double numberOfPayment = getNumberOfPayment(MONTHS_IN_YEARS);

        double balance = principal
                * (Math.pow(1 + monthlyInterest, numberOfPayment) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, numberOfPayment) - 1);

        return balance;
    }


    public double calculateMortgage() {

        final int MONTHS_IN_YEARS = 12;
        final int PERCENT = 100;

        double monthlyInterest = getMonthlyInterest();
        double numberOfPayment = getNumberOfPayment(MONTHS_IN_YEARS);

        double mortgage = principal
                * monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayment)
                / (Math.pow(1 + monthlyInterest, numberOfPayment) - 1);

        return mortgage;
    }

    private int getNumberOfPayment(int MONTHS_IN_YEARS) {
        return year * MONTHS_IN_YEARS;
    }
    private double getMonthlyInterest() {
        return annualRate / MONTHS_IN_YEARS / PERCENT;
    }

    public double[] getRemainingBalance(){
        double[] balances = new double[getNumberOfPayment()];
        for (int month = 1; month <= balances.length; month++)
            balances[month - 1] = calculateBalance(month);

        return balances;
    }

}
