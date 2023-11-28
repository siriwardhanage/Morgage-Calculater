package com.youtube;

import java.text.NumberFormat;
import java.util.Locale;

public class Main {
    final static int MONTHS_IN_YEARS = 12;
    final static int PERCENT = 100;
    public static void main(String[] args) {

        System.out.println("****** Mortgage Calculator ***** \n");

        double principal = Console.readNumber("principal : ",10_000, 1_000_000);
        double annualRate = Console.readNumber("Annual Rate : ",1, 30);
        int year = (int) Console.readNumber("Years : ", 1, 30);

        printMortgage(principal, annualRate, year);
        printPaymentSchedule(year, principal, annualRate);
    }

    private static void printMortgage(double principal, double annualRate, int year) {
        double mortgage = calculateMortgage(principal, annualRate, year);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("-------------------");
        String monthlyPayment = NumberFormat.getCurrencyInstance(new Locale("en","LK")).format(mortgage);
        System.out.println("Monthly Payment : " + monthlyPayment);
    }

    private static void printPaymentSchedule(int year, double principal, double annualRate) {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("-------------------");
        for (int month = 1; month <= year * MONTHS_IN_YEARS; month++){
            double balance = calculateBalance(principal, annualRate, year, month);
            System.out.println(NumberFormat.getCurrencyInstance(new Locale("en", "LK")).format(balance));
        }
    }

    public static double calculateBalance (
            double principal,
            double annualRate,
            int year,
            int numberOfPaymentsMade
    ){
        double monthlyInterest = annualRate / MONTHS_IN_YEARS / PERCENT;
        double numberOfPayment = year * MONTHS_IN_YEARS;

        double balance = principal
                * (Math.pow(1+ monthlyInterest, numberOfPayment) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1+ monthlyInterest, numberOfPayment) - 1);

        return balance;
    }
    public static double calculateMortgage(
            double principal,
            double annualRate,
            int year){

        final int MONTHS_IN_YEARS = 12;
        final int PERCENT = 100;

        double monthlyInterest = annualRate / MONTHS_IN_YEARS / PERCENT;
        double numberOfPayment = year * MONTHS_IN_YEARS;

        double mortgage = principal
                * monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayment)
                / (Math.pow(1 + monthlyInterest, numberOfPayment)-1);

        return mortgage;
    }
}
