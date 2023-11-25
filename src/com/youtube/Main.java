package com.youtube;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("****** Mortgage Calculator ***** \n");

        Scanner scanner = new Scanner(System.in);

        //for principal
        System.out.print("Principal : ");
        double value = scanner.nextDouble();

        //for Annual Interest Rate
        System.out.print("Annual Interest Rate : ");
        double annualRate = scanner.nextDouble();
        //for monthly Interest Rate
        double mRate = annualRate/1200;

        //for time period
        System.out.print("Period (Years) : ");
        double year = scanner.nextDouble();
        //No of payment
        double numberOfPayment = year*12;

        //for monthly payment
         /*          M = P * r(1+r)^n / [(1+r)^n - 1]      */
        //for (1+r)^n
        double pValue = Math.pow((1+mRate),numberOfPayment);
        double mPayment = (value
                * mRate * pValue)
                /(pValue-1);
        NumberFormat currency = NumberFormat.getCurrencyInstance(new Locale("en","LK"));
        String result = currency.format(mPayment);
        System.out.println("Monthly Payment : " + result);

    }
}
