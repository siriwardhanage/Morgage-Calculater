package com.youtube;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("****** Mortgage Calculator ***** \n");

        Scanner scanner = new Scanner(System.in);
        final int MONTHS_IN_YEARS = 12;
        final int PERCENT = 100;

        double principal = 0;
        double monthlyInterest = 0;
        double numberOfPayment = 0;

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
            double annualRate = scanner.nextDouble();
            if (annualRate >= 1 && annualRate <= 30) {
                //for monthly Interest Rate
                monthlyInterest = annualRate / MONTHS_IN_YEARS / PERCENT;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

        //for time period
        while (true){
            System.out.print("Period (Years) : ");
            double year = scanner.nextDouble();
            //No of payment
            if (year >= 1 && year <= 30) {
                numberOfPayment = year * MONTHS_IN_YEARS;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

        //for monthly payment
         /*          M = P * r(1+r)^n / [(1+r)^n - 1]      */
        //for (1+r)^n
       double mortgage = principal
               * monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayment)
               / (Math.pow(1 + monthlyInterest, numberOfPayment)-1);

       String monthlyPayment = NumberFormat.getCurrencyInstance(new Locale("en","LK")).format(mortgage);
       System.out.println("Monthly Payment : " + monthlyPayment);

    }
}
