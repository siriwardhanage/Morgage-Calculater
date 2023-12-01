package com.youtube;

import java.text.NumberFormat;
import java.util.Locale;

public class MortgageReport {

    private MortgageCalculate calculate;

    public MortgageReport(MortgageCalculate calculate) {
        this.calculate = calculate;
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("-------------------");
        for (int month = 1; month <= calculate.getYear() * Main.MONTHS_IN_YEARS; month++) {
            double balance = calculate.calculateBalance(month);
            System.out.println(NumberFormat.getCurrencyInstance(new Locale("en", "LK")).format(balance));
        }
    }

    public void printMortgage() {
        double mortgage = calculate.calculateMortgage();
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("-------------------");
        String monthlyPayment = NumberFormat.getCurrencyInstance(new Locale("en", "LK")).format(mortgage);
        System.out.println("Monthly Payment : " + monthlyPayment);
    }
}
