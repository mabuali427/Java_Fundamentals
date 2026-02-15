package com.javafundamentals.primes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeFinder {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("========== Prime Number Finder ==========\n");
        
        int limit = getLimit(scanner);
        
        if (limit < 2) {
            System.out.println("There are no prime numbers less than 2.\n");
            scanner.close();
            return;
        }
        
        List<Integer> primes = findPrimesUsingSieve(limit);
        displayResults(primes, limit);
        
        scanner.close();
    }
    
    private static int getLimit(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter the upper limit (N): ");
                String input = scanner.nextLine().trim();
                int limit = Integer.parseInt(input);
                
                if (limit < 1) {
                    System.out.println("Please enter a positive number greater than 0.\n");
                    continue;
                }
                
                return limit;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.\n");
            }
        }
    }
    
    public static List<Integer> findPrimesUsingSieve(int limit) {
        List<Integer> primes = new ArrayList<>();
        
        if (limit < 2) {
            return primes;
        }
        
        // Initialize boolean array to track prime status
        boolean[] isPrime = new boolean[limit + 1];
        
        // Assume all numbers are prime initially
        for (int i = 2; i <= limit; i++) {
            isPrime[i] = true;
        }
        
        // Sieve of Eratosthenes: mark non-primes
        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                // Mark all multiples of i as not prime
                for (int j = i * i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        // Collect all prime numbers
        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        
        return primes;
    }
    
    private static void displayResults(List<Integer> primes, int limit) {
        System.out.println("\n--- Prime Numbers up to " + limit + " ---\n");
        
        if (primes.isEmpty()) {
            System.out.println("No prime numbers found.");
            return;
        }
        
        // Display primes in rows of 10 for readability
        for (int i = 0; i < primes.size(); i++) {
            System.out.print(primes.get(i));
            
            if ((i + 1) % 10 == 0) {
                System.out.println();
            } else if (i < primes.size() - 1) {
                System.out.print(", ");
            }
        }
        
        System.out.println("\n");
        System.out.println("Total primes found: " + primes.size());
        
        double percentage = (primes.size() * 100.0) / limit;
        System.out.printf("Prime density: %.2f%% of numbers up to %d\n\n", percentage, limit);
    }
}
