package com.youtube;

import java.text.NumberFormat;
import java.util.Locale;

public class MortgageReport {
    public static void printMortgage(double principal, double annualRate, int year) {
        double mortgage = Main.calculateMortgage(principal, annualRate, year);
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
            double balance = Main.calculateBalance(principal, annualRate, year, month);
            System.out.println(NumberFormat.getCurrencyInstance(new Locale("en", "LK")).format(balance));
        }
    }
}
