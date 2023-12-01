package com.youtube;

public class Main {
    public static void main(String[] args) {

        System.out.println("****** Mortgage Calculator ***** \n");

        double principal = Console.readNumber("principal : ",10_000, 1_000_000);
        double annualRate = Console.readNumber("Annual Rate : ",1, 30);
        int year = (int) Console.readNumber("Years : ", 1, 30);

        MortgageCalculate calculate = new MortgageCalculate(principal, annualRate, year);
        MortgageReport report = new MortgageReport(calculate);
        report.printMortgage();
        report.printPaymentSchedule();
    }

}
