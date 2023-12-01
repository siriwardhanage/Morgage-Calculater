package com.youtube;

import java.text.NumberFormat;
import java.util.Locale;

public class MortgageReport {

    private final NumberFormat currency;
    private MortgageCalculate calculate;

    public MortgageReport(MortgageCalculate calculate) {
        this.calculate = calculate;
        currency = NumberFormat.getCurrencyInstance(new Locale("en", "LK"));
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("-------------------");

        for (double balance : calculate.getRemainingBalance())
            System.out.println(currency.format(balance));

    }

    public void printMortgage() {
        double mortgage = calculate.calculateMortgage();
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("-------------------");
        String monthlyPayment = currency.format(mortgage);
        System.out.println("Monthly Payment : " + monthlyPayment);
    }
}
