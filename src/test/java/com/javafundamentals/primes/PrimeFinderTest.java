package com.javafundamentals.primes;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class PrimeFinderTest {
    
    @Test
    public void testPrimesUpTo10() {
        List<Integer> primes = PrimeFinder.findPrimesUsingSieve(10);
        assertEquals(4, primes.size());
        assertTrue(primes.contains(2));
        assertTrue(primes.contains(3));
        assertTrue(primes.contains(5));
        assertTrue(primes.contains(7));
    }
    
    @Test
    public void testPrimesUpTo2() {
        List<Integer> primes = PrimeFinder.findPrimesUsingSieve(2);
        assertEquals(1, primes.size());
        assertEquals(2, primes.get(0).intValue());
    }
    
    @Test
    public void testPrimesUpTo1() {
        List<Integer> primes = PrimeFinder.findPrimesUsingSieve(1);
        assertEquals(0, primes.size());
    }
    
    @Test
    public void testPrimesNegative() {
        List<Integer> primes = PrimeFinder.findPrimesUsingSieve(-10);
        assertEquals(0, primes.size());
    }
    
    @Test
    public void testPrimesUpTo20() {
        List<Integer> primes = PrimeFinder.findPrimesUsingSieve(20);
        assertEquals(8, primes.size());
    }
    
    @Test
    public void testPrimesUpTo100() {
        List<Integer> primes = PrimeFinder.findPrimesUsingSieve(100);
        assertEquals(25, primes.size());
    }
    
    @Test
    public void testFirstTenPrimes() {
        List<Integer> primes = PrimeFinder.findPrimesUsingSieve(29);
        int[] expected = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        assertEquals(expected.length, primes.size());
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], primes.get(i).intValue());
        }
    }
}
