package piwords;

import static org.junit.Assert.*;

import org.junit.Test;

public class PiGeneratorTest {
    @Test
    public void basicPowerModTest() {
        // 5^7 mod 23 = 17
        assertEquals(17, PiGenerator.powerMod(5, 7, 23));
        
    }
    @Test
    public void basicPowerModTest2() {
    	// 2^8 mod 16 = 0
        assertEquals(0, PiGenerator.powerMod(2,8 , 16));
        
    }
    
    @Test
    public void firstNegVarPowerModTest() {
    	// test that a < 0 
        assertEquals(-1, PiGenerator.powerMod(-2, 1, 1));
    }
    
    @Test
    public void secondNegVarPowerModTest() {
    	// test that b < 0 output = -1
        assertEquals(-1, PiGenerator.powerMod(2, -1, 1));
    }
    
    @Test
    public void thirdNegVarPowerModTest() {
    	//test that c < 0 output = -1
        assertEquals(-1, PiGenerator.powerMod(2, 1, -1));
    }
    
    @Test
    public void firstSecondNegVarPowerModTest() {
    	// test that a & b < 0 output = -1
        assertEquals(-1, PiGenerator.powerMod(-2, -1, 1));
    }
    
    @Test
    public void secondThirdNegVarPowerModTest() {
    	// test that b & c < 0 output = -1
        assertEquals(-1, PiGenerator.powerMod(2, -1, -1));
    }
    
    @Test
    public void firstThirdNegVarPowerModTest() {
    	// test when a & c < 0 output = -1
        assertEquals(-1, PiGenerator.powerMod(-2, 1, -1));
    }
    
    @Test
    public void firstSecondThirdNegVarPowerModTest() {
    	// test when a & c < 0 output = -1
        assertEquals(-1, PiGenerator.powerMod(-2, -1, -1));
    }
    @Test
    public void basicComputePiInHexText(){
    	int[] a = {2,4};
    	int[] b = {2,4,3,15,6,10};
    	int[] c = {2,4,3,15,6,10,8,8};
    	// A couple of samples
    	assertArrayEquals(a, PiGenerator.computePiInHex(2));
    	assertArrayEquals(b, PiGenerator.computePiInHex(6));
    	assertArrayEquals(c, PiGenerator.computePiInHex(8));
    	// Test the with precision
    	assertArrayEquals(null, PiGenerator.computePiInHex(-2));
    }
}
