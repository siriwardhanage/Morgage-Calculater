package com.youtube;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("****** Mortgage Calculator ***** \n");

        //for principal
        double principal = readNumber("principal : ",10_000, 1_000_000);

        //for Annual Interest Rate
        double annualRate = readNumber("Annual Rate : ",1, 30);

        //for time period
        int year = (int)readNumber("Years : ", 1, 30);

        double mortgage = calculateMortgage(principal, annualRate, year);

       String monthlyPayment = NumberFormat.getCurrencyInstance(new Locale("en","LK")).format(mortgage);
       System.out.println("Monthly Payment : " + monthlyPayment);

    }

    public static double readNumber(String prompt, double min, double max){
        Scanner scanner = new Scanner(System.in);
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between LKR " + min +"and LKR " + max);
        }
        return value;
    }

    public static double calculateMortgage(
            double principal,
            double annualRate,
            int year){

        final int MONTHS_IN_YEARS = 12;
        final int PERCENT = 100;

        //for monthly Interest Rate
        double monthlyInterest = annualRate / MONTHS_IN_YEARS / PERCENT;

        //No of payment
        double numberOfPayment = year * MONTHS_IN_YEARS;

        //for monthly payment
        /*          M = P * r(1+r)^n / [(1+r)^n - 1]      */
        //for (1+r)^n
        double mortgage = principal
                * monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayment)
                / (Math.pow(1 + monthlyInterest, numberOfPayment)-1);

        return mortgage;
    }
}
