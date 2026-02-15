package com.javafundamentals.calculator;

import java.util.Scanner;

public class Calculator {
    private static Scanner scanner;
    
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        startCalculator();
        scanner.close();
    }
    
    private static void startCalculator() {
        System.out.println("========== Basic Calculator ==========\n");
        boolean running = true;
        
        while (running) {
            displayMenu();
            String choice = getUserInput("Enter your choice (1-5): ");
            
            switch (choice.trim()) {
                case "1":
                    performAddition();
                    break;
                case "2":
                    performSubtraction();
                    break;
                case "3":
                    performMultiplication();
                    break;
                case "4":
                    performDivision();
                    break;
                case "5":
                    System.out.println("Thank you for using Calculator. Goodbye!\n");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-5.\n");
            }
        }
    }
    
    private static void displayMenu() {
        System.out.println("\n--- Calculator Menu ---");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Exit");
    }
    
    private static void performAddition() {
        double num1 = getValidNumber("Enter first number: ");
        double num2 = getValidNumber("Enter second number: ");
        double result = num1 + num2;
        System.out.printf("\nResult: %.2f + %.2f = %.2f\n", num1, num2, result);
    }
    
    private static void performSubtraction() {
        double num1 = getValidNumber("Enter first number: ");
        double num2 = getValidNumber("Enter second number: ");
        double result = num1 - num2;
        System.out.printf("\nResult: %.2f - %.2f = %.2f\n", num1, num2, result);
    }
    
    private static void performMultiplication() {
        double num1 = getValidNumber("Enter first number: ");
        double num2 = getValidNumber("Enter second number: ");
        double result = num1 * num2;
        System.out.printf("\nResult: %.2f * %.2f = %.2f\n", num1, num2, result);
    }
    
    private static void performDivision() {
        double num1 = getValidNumber("Enter first number: ");
        double num2 = getValidNumber("Enter second number: ");
        
        if (num2 == 0) {
            System.out.println("\nError: Cannot divide by zero!\n");
            return;
        }
        
        double result = num1 / num2;
        System.out.printf("\nResult: %.2f / %.2f = %.2f\n", num1, num2, result);
    }
    
    private static double getValidNumber(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
    
    private static String getUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
