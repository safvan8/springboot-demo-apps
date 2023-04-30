// Package and import statements
package in.ineuron;
import junit.framework.*;
import in.ineuron.*;

// Test class that extends TestCase
public class AppTest extends TestCase {
    
    // Test case for adding positive numbers
    public void testSumWithPositiveNumber(){
        MathApp ar = new MathApp();
        int actual = ar.add(10,20);
        int expected = 30;
				// assert equal method will check if both are equal, if true test success
        assertEquals(actual,expected);
    }
    
    // Test case for adding negative numbers
    public void testSumWithNegativeNumber(){
        MathApp ar = new MathApp();
        int actual = ar.add(-10,-20);
        int expected = -30;
        assertEquals(actual,expected);
    }
    
    // Test case for adding mixed numbers
    public void testSumWithMixedNumber(){
        MathApp ar = new MathApp();
        int actual = ar.add(-10,20);
        int expected = 10;
        assertEquals(actual,expected);
    }
    
    // Test case for adding zero
    public void testSumWithZero(){
        MathApp ar = new MathApp();
        int actual = ar.add(0,0);
        int expected = 0;
        assertEquals(actual,expected);
    } 
}