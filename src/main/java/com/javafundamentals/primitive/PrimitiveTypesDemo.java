package com.javafundamentals.primitive;

public class PrimitiveTypesDemo {
    public static void main(String[] args) {
        System.out.println("========== Java Primitive Data Types ==========\n");
        
        // Byte: smallest integer type
        byte myByte = 100;
        System.out.println("1. BYTE");
        System.out.println("   Size: 1 byte (8 bits)");
        System.out.println("   Range: -128 to 127");
        System.out.println("   Value: " + myByte);
        System.out.println();
        
        // Short: 16-bit signed integer
        short myShort = 5000;
        System.out.println("2. SHORT");
        System.out.println("   Size: 2 bytes (16 bits)");
        System.out.println("   Range: -32,768 to 32,767");
        System.out.println("   Value: " + myShort);
        System.out.println();
        
        // Int: 32-bit signed integer (most commonly used)
        int myInt = 100000;
        System.out.println("3. INT");
        System.out.println("   Size: 4 bytes (32 bits)");
        System.out.println("   Range: -2,147,483,648 to 2,147,483,647");
        System.out.println("   Value: " + myInt);
        System.out.println();
        
        // Long: 64-bit signed integer
        long myLong = 15_000_000_000L;
        System.out.println("4. LONG");
        System.out.println("   Size: 8 bytes (64 bits)");
        System.out.println("   Range: -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807");
        System.out.println("   Value: " + myLong);
        System.out.println();
        
        // Float: 32-bit decimal
        float myFloat = 10.5f;
        System.out.println("5. FLOAT");
        System.out.println("   Size: 4 bytes (32 bits)");
        System.out.println("   Precision: ~6-7 decimal digits");
        System.out.println("   Value: " + myFloat);
        System.out.println();
        
        // Double: 64-bit decimal (more precise)
        double myDouble = 3.14159265358979;
        System.out.println("6. DOUBLE");
        System.out.println("   Size: 8 bytes (64 bits)");
        System.out.println("   Precision: ~15-17 decimal digits");
        System.out.println("   Value: " + myDouble);
        System.out.println();
        
        // Char: single character (16-bit Unicode)
        char myChar = 'A';
        System.out.println("7. CHAR");
        System.out.println("   Size: 2 bytes (16 bits)");
        System.out.println("   Range: 0 to 65,535 (Unicode characters)");
        System.out.println("   Value: " + myChar);
        System.out.println();
        
        // Boolean: true or false (logical)
        boolean myBoolean = true;
        System.out.println("8. BOOLEAN");
        System.out.println("   Size: Compiler dependent (typically 1 byte)");
        System.out.println("   Values: true or false");
        System.out.println("   Value: " + myBoolean);
        System.out.println();
        
        demonstrateOperations();
    }
    
    private static void demonstrateOperations() {
        System.out.println("========== Arithmetic Operations ==========\n");
        
        int x = 15;
        int y = 4;
        
        System.out.println("Using: x = " + x + ", y = " + y);
        System.out.println("Addition:       x + y = " + (x + y));
        System.out.println("Subtraction:    x - y = " + (x - y));
        System.out.println("Multiplication: x * y = " + (x * y));
        System.out.println("Division:       x / y = " + (x / y));
        System.out.println("Modulus:        x % y = " + (x % y));
    }
}
