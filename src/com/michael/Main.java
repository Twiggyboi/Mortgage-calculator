package com.michael;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    // Mortgage Calculator project
    // Principal:
    // Annual Interest Rate:
    // Period (Years):
    // Mortgage: ?
    // M = P * (r(1+r)nth power/ (1+r)nth power - 1)
    public static void main(String[] args) {
        final byte MONTHS_IN_YEARS = 12;
        final byte PERCENT = 100;

        Scanner scanner =  new Scanner(System.in);
        System.out.println("Hello, to find out what your monthly mortgage payments would be enter your information below.");
        System.out.print("What is the Principal? (number between 1K & 1M): ");
        int principal = scanner.nextInt();
        System.out.print("Enter down payment amount, if there is no down payment enter 0: ");
        int downPayment = scanner.nextInt();
        System.out.print("What would your yearly interest rate be?: ");
        float annualRate = scanner.nextFloat();
        float monthlyRate = annualRate / PERCENT / MONTHS_IN_YEARS;
        System.out.print("How many years is your loan for?: ");
        byte years = scanner.nextByte();
        int monthlyPayments = years * MONTHS_IN_YEARS;

        double mortgage = (principal - downPayment)
                * ( monthlyRate * Math.pow(1 + monthlyRate, monthlyPayments))
                / (Math.pow(1 + monthlyRate, monthlyPayments) - 1);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Your monthly mortgage payments would be: " + mortgageFormatted);

    }
}
