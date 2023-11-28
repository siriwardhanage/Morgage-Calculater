package com.youtube;

import java.text.NumberFormat;
import java.util.Locale;

public class MortgageReport {

    private static MortgageCalculate calculate;

    public static void printMortgage(double principal, double annualRate, int year) {
        calculate = new MortgageCalculate(principal, annualRate, year);
        double mortgage = calculate.calculateMortgage();
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("-------------------");
        String monthlyPayment = NumberFormat.getCurrencyInstance(new Locale("en", "LK")).format(mortgage);
        System.out.println("Monthly Payment : " + monthlyPayment);
    }

    public static void printPaymentSchedule(int year, double principal, double annualRate) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("-------------------");
        for (int month = 1; month <= year * Main.MONTHS_IN_YEARS; month++) {
            double balance = calculate.calculateBalance(month);
            System.out.println(NumberFormat.getCurrencyInstance(new Locale("en", "LK")).format(balance));
        }
    }
}
