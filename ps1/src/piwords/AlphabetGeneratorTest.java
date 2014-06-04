package piwords;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlphabetGeneratorTest {
	@Test
	public void generateFrequencyAlphabetTest() {
		// Expect in the training data that Pr(a) = 2/5, Pr(b) = 2/5,
		// Pr(c) = 1/5.
		String[] trainingData = { "aa", "bbc" };
		// In the output for base 10, they should be in the same proportion.
		char[] expectedOutput = { 'a', 'a', 'a', 'a', 'b', 'b', 'b', 'b', 'c',
				'c' };

		assertArrayEquals(expectedOutput,
				AlphabetGenerator.generateFrequencyAlphabet(10, trainingData));
	}
	
	@Test
	public void largerFrequecyAlphabetTest(){
		String[] trainingData = { "aa", "bbc" };
		// In the output for base 20, they should be in the same proportion.
		char[] expectedOutput2 = { 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'b',
				'b', 'b', 'b', 'b', 'b', 'b', 'b', 'c', 'c', 'c', 'c' };
		assertArrayEquals(expectedOutput2,
				AlphabetGenerator.generateFrequencyAlphabet(20, trainingData));

		// Expect in the training data that Pr(a) = 3/12, Pr(b) = 2/12,
		// Pr(d) = 2/12, Pr(e) = 3/12, Pr(n) = 2/3.
		String[] trainingData2 = { "be", "deed", "banana" };

		// In the output for base 24, they should be in the same proportion
		/*
		 * for
		 */
		char[] expectedOutput3 = { 'a', 'a', 'a', 'a', 'a', 'a', 'b', 'b', 'b',
				'b', 'd', 'd', 'd', 'd', 'e', 'e', 'e', 'e', 'e', 'e', 'n',
				'n', 'n', 'n' };
		
		assertArrayEquals(expectedOutput3,
				AlphabetGenerator.generateFrequencyAlphabet(24, trainingData2));
	}
	
	@Test
	public void boundryConditionsTest(){
		String[] trainingData2 = { "be", "deed", "banana" };
		String[] trainingData3 = { "be0", "d0eed", "b0anana" };
		
		assertArrayEquals(null,
				AlphabetGenerator.generateFrequencyAlphabet(-19, trainingData2));
	
		assertArrayEquals(new char[] { 'a', 'e' },
				AlphabetGenerator.generateFrequencyAlphabet(2, trainingData2));
		
		//omit characters not a-z from output no matter the frequency
		assertArrayEquals(new char[] { 'a', 'b', 'd' },
				AlphabetGenerator.generateFrequencyAlphabet(3, trainingData3));
		
		assertArrayEquals(new char[] {},
				AlphabetGenerator.generateFrequencyAlphabet(0, trainingData2));

	}

}
