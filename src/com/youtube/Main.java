package com.youtube;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("****** Mortgage Calculator ***** \n");

        Scanner scanner = new Scanner(System.in);


        double principal = 0;
        double annualRate = 0;
        int year = 0;

        //for principal
        while (true) {
            System.out.print("Principal : ");
            principal = scanner.nextDouble();
            if (principal >= 10_000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a value between LKR 10000 and LKR 1000000 ");
        }

        //for Annual Interest Rate
        while (true){
            System.out.print("Annual Interest Rate : ");
            annualRate = scanner.nextDouble();
            if (annualRate >= 1 && annualRate <= 30)
                break;
            System.out.println("Enter a value between 1 and 30");
        }

        //for time period
        while (true){
            System.out.print("Period (Years) : ");
            year = scanner.nextInt();
            if (year >= 1 && year <= 30)
                break;
            System.out.println("Enter a value between 1 and 30");
        }

        double mortgage = calculateMortgage(principal, annualRate, year);

       String monthlyPayment = NumberFormat.getCurrencyInstance(new Locale("en","LK")).format(mortgage);
       System.out.println("Monthly Payment : " + monthlyPayment);

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
