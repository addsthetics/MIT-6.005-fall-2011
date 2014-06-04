package piwords;

import static org.junit.Assert.*;

import org.junit.Test;

public class BaseTranslatorTest {
    @Test
    public void basicBaseTranslatorTest() {
        // Expect that .01 in base-2 is .25 in base-10
        // (0 * 1/2^1 + 1 * 1/2^2 = .25)
        int[] input = {0, 1};
        int[] expectedOutput = {2, 5};
        assertArrayEquals(expectedOutput,
                BaseTranslator.convertBase(input, 2, 10, 2));
    }
   
    
    @Test
    public void longerInputTest(){
    	// Expect that .4809 in base-10 is .111 in base-8
    	int[] input3 = {4,8,0,9};
        int[] expectedOutput3 = {0,1,1,1};
        assertArrayEquals(expectedOutput3, 
	              BaseTranslator.convertBase(input3, 10, 2, 4));
    }
    
    @Test
    public void longerPrecisionBThanInputTest(){
        // Expect that .232 in base-10 is .16662 in base-8
        // Precision of output is higher than input
        int[] input2 = {2,3,2};
        int[] expectedOutput2 = {1,6,6,6,2};
        assertArrayEquals(expectedOutput2, 
	              BaseTranslator.convertBase(input2, 10, 8, 5));
    }
    
    @Test
    public void precisionLessThanSizeInputTest(){
        // Expect that .232 in base-10 is .16in base-8.
        // Precision of output is less than input.length
    	// output should be truncated.
        int[] input2 = {2,3,2};
        int[] expectedOutput2 = {1,6};
        assertArrayEquals(expectedOutput2, 
	              BaseTranslator.convertBase(input2, 10, 8, 2));
    }
    @Test
    public void baseALessThanTwoTest(){   
        //Test baseA < 2
    	int[] input3 = {4,8,0,9};
    	assertArrayEquals(null, 
	              	BaseTranslator.convertBase(input3, 1, 2, 5));
    }
    
    @Test
    public void baseBLessThanTwoTest(){   
        //Test baseB < 2
    	int[] input3 = {4,8,0,9};
    	assertArrayEquals(null, 
	              	BaseTranslator.convertBase(input3, 10, 0, 5));
    }
    
    @Test
    public void basesAreEqual() {
    	// baseA = baseB and precision = digits.length outcome should not change
        int[] input = {2,4,5};
        assertArrayEquals(input, BaseTranslator.convertBase(input,  10, 10, 3));
    }
    
    @Test
    public void precisionLessThanOneTest(){   
        //Test precision < 1
    	int[] input = {4,8,0,9};
    	assertArrayEquals(null, 
	              	BaseTranslator.convertBase(input, 10, 0, 0));
    }
    
    @Test
    public void inputHasNegTest(){   
        //Test outcome of digits[i] < 0
    	int[] input = {4,8,0,-9};
    	assertArrayEquals(null, 
              		BaseTranslator.convertBase(input, 10, 2, 5));
    }
    
    @Test
    public void inputHasValueGreaterThanBaseA(){   
        //Test outcome of digits[i] >= baseA
    	int[] input = {4,8,0,11};
    	assertArrayEquals(null, 
              		BaseTranslator.convertBase(input, 10, 2, 5));
    }
    
    @Test
    public void emptyInput(){   
        //Test outcome of digits[i] >= baseA
    	int[] input = {};
    	assertArrayEquals(null, 
              		BaseTranslator.convertBase(input, 10, 2, 5));
    }

   
}
