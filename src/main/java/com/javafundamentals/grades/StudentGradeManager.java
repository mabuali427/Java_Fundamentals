package com.javafundamentals.grades;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentGradeManager {
    
    private static class Student {
        private String id;
        private String name;
        private List<Integer> scores;
        
        public Student(String id, String name) {
            this.id = id;
            this.name = name;
            this.scores = new ArrayList<>();
        }
        
        public void addScore(int score) {
            if (score >= 0 && score <= 100) {
                scores.add(score);
            }
        }
        
        public double calculateAverage() {
            if (scores.isEmpty()) {
                return 0.0;
            }
            int sum = 0;
            for (int score : scores) {
                sum += score;
            }
            return sum / (double) scores.size();
        }
        
        public char getLetterGrade() {
            double average = calculateAverage();
            if (average >= 90) {
                return 'A';
            } else if (average >= 80) {
                return 'B';
            } else if (average >= 70) {
                return 'C';
            } else if (average >= 60) {
                return 'D';
            } else {
                return 'F';
            }
        }
    }
    
    private static List<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        runGradeManager();
        scanner.close();
    }
    
    private static void runGradeManager() {
        System.out.println("========== Student Grade Manager ==========\n");
        boolean isRunning = true;
        
        while (isRunning) {
            showMainMenu();
            String userChoice = getUserInput("Select an option: ");
            
            switch (userChoice.trim()) {
                case "1":
                    addNewStudent();
                    break;
                case "2":
                    addScoreToStudent();
                    break;
                case "3":
                    displayAllStudents();
                    break;
                case "4":
                    findAndDisplayStudent();
                    break;
                case "5":
                    showClassStatistics();
                    break;
                case "6":
                    System.out.println("Exiting Grade Manager. Goodbye!\n");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid selection. Please choose 1-6.\n");
            }
        }
    }
    
    private static void showMainMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("1. Add New Student");
        System.out.println("2. Add Score to Student");
        System.out.println("3. Display All Students");
        System.out.println("4. Find Student & View Details");
        System.out.println("5. Show Class Statistics");
        System.out.println("6. Exit Program");
    }
    
    private static void addNewStudent() {
        System.out.println("\n--- Add New Student ---");
        String studentId = getUserInput("Enter student ID: ");
        
        // Check if student already exists
        if (studentIdExists(studentId)) {
            System.out.println("Student with ID " + studentId + " already exists.\n");
            return;
        }
        
        String studentName = getUserInput("Enter student name: ");
        studentList.add(new Student(studentId, studentName));
        System.out.println("Student " + studentName + " added successfully!\n");
    }
    
    private static void addScoreToStudent() {
        System.out.println("\n--- Add Score ---");
        String studentId = getUserInput("Enter student ID: ");
        
        Student foundStudent = findStudentById(studentId);
        if (foundStudent == null) {
            System.out.println("Student not found.\n");
            return;
        }
        
        int score = getValidScore("Enter score (0-100): ");
        foundStudent.addScore(score);
        System.out.println("Score added successfully!\n");
    }
    
    private static void displayAllStudents() {
        System.out.println("\n--- All Students ---\n");
        
        if (studentList.isEmpty()) {
            System.out.println("No students in the system.\n");
            return;
        }
        
        System.out.printf("%-10s %-20s %-10s %-10s\n", "ID", "Name", "Average", "Grade");
        System.out.println("-------------------------------------------");
        
        for (Student student : studentList) {
            System.out.printf("%-10s %-20s %-10.2f %-10s\n",
                student.id, student.name, student.calculateAverage(), student.getLetterGrade());
        }
        System.out.println();
    }
    
    private static void findAndDisplayStudent() {
        System.out.println("\n--- Search Student ---");
        String studentId = getUserInput("Enter student ID: ");
        
        Student foundStudent = findStudentById(studentId);
        if (foundStudent == null) {
            System.out.println("Student not found.\n");
            return;
        }
        
        System.out.println("\nStudent Details:");
        System.out.println("ID: " + foundStudent.id);
        System.out.println("Name: " + foundStudent.name);
        System.out.println("Scores: " + foundStudent.scores);
        System.out.printf("Average: %.2f\n", foundStudent.calculateAverage());
        System.out.println("Letter Grade: " + foundStudent.getLetterGrade());
        System.out.println();
    }
    
    private static void showClassStatistics() {
        System.out.println("\n--- Class Statistics ---\n");
        
        if (studentList.isEmpty()) {
            System.out.println("No student data available.\n");
            return;
        }
        
        int totalStudents = studentList.size();
        double classAverage = 0;
        double highestAverage = 0;
        double lowestAverage = 100;
        
        for (Student student : studentList) {
            double average = student.calculateAverage();
            classAverage += average;
            highestAverage = Math.max(highestAverage, average);
            lowestAverage = Math.min(lowestAverage, average);
        }
        
        classAverage /= totalStudents;
        
        System.out.println("Total Students: " + totalStudents);
        System.out.printf("Class Average: %.2f\n", classAverage);
        System.out.printf("Highest Average: %.2f\n", highestAverage);
        System.out.printf("Lowest Average: %.2f\n", lowestAverage);
        
        // Count grades
        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;
        
        for (Student student : studentList) {
            char grade = student.getLetterGrade();
            switch (grade) {
                case 'A':
                    countA++;
                    break;
                case 'B':
                    countB++;
                    break;
                case 'C':
                    countC++;
                    break;
                case 'D':
                    countD++;
                    break;
                case 'F':
                    countF++;
                    break;
            }
        }
        
        System.out.println("\nGrade Distribution:");
        System.out.println("A: " + countA + " students");
        System.out.println("B: " + countB + " students");
        System.out.println("C: " + countC + " students");
        System.out.println("D: " + countD + " students");
        System.out.println("F: " + countF + " students\n");
    }
    
    private static Student findStudentById(String id) {
        for (Student student : studentList) {
            if (student.id.equals(id)) {
                return student;
            }
        }
        return null;
    }
    
    private static boolean studentIdExists(String id) {
        return findStudentById(id) != null;
    }
    
    private static int getValidScore(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                int score = Integer.parseInt(input);
                
                if (score < 0 || score > 100) {
                    System.out.println("Score must be between 0 and 100.");
                    continue;
                }
                
                return score;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }
    
    private static String getUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
