package com.youtube;

public class Main {
    final static int MONTHS_IN_YEARS = 12;
    final static int PERCENT = 100;
    public static void main(String[] args) {

        System.out.println("****** Mortgage Calculator ***** \n");

        double principal = Console.readNumber("principal : ",10_000, 1_000_000);
        double annualRate = Console.readNumber("Annual Rate : ",1, 30);
        int year = (int) Console.readNumber("Years : ", 1, 30);

        MortgageReport.printMortgage(principal, annualRate, year);
        MortgageReport.printPaymentSchedule(year, principal, annualRate);
    }

}
