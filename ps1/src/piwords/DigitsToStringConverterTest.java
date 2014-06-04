package piwords;

import static org.junit.Assert.*;

import org.junit.Test;

public class DigitsToStringConverterTest {
    @Test
    public void basicNumberSerializerTest() {
        // Input is a 4 digit number, 0.123 represented in base 4
        int[] input = {0, 1, 2, 3};

        // Want to map 0 -> "d", 1 -> "c", 2 -> "b", 3 -> "a"
        char[] alphabet = {'d', 'c', 'b', 'a'};

        String expectedOutput = "dcba";
        assertEquals(expectedOutput,
                     DigitsToStringConverter.convertDigitsToString(
                             input, 4, alphabet));
    }
    
    @Test
    public void longerNumberSerializerTest(){
        // Input is a 8 digit number, 0.34012 represented in base 8
        int[] input3 = {0,1,2,3,4,5,6};
        
        // Want to map 0 -> "z", 1 -> "e", 2 -> "d", 3 -> "r",
        // 4 -> "o", 5 -> "a", 6 -> "t"
        char[] alphabet3 = {'z', 'e', 'd', 'r','o','a','t'};
        
        String expectedOutput3 = "zedroat";
        assertEquals(expectedOutput3,
                DigitsToStringConverter.convertDigitsToString(
                        input3, 7, alphabet3));
    }
    
    @Test
    public void boudryConditoionsTest(){
	    int[] input = {0, 1, 2, 3};
		char[] alphabet = {'d', 'c', 'b', 'a'};
		// test alphabet.length != base
        assertEquals(null,
                DigitsToStringConverter.convertDigitsToString(
                        input, 7, alphabet));
        
        // test digits[i] > base
        int[] input2 = {0, 1, 2, 5};
        assertEquals(null,
                DigitsToStringConverter.convertDigitsToString(
                        input2, 4, alphabet));
        
        // test digits[i] < 0
        int[] input3 = {0, -1, 2, 5};
        assertEquals(null,
                DigitsToStringConverter.convertDigitsToString(
                        input3, 4, alphabet));
    }

}
