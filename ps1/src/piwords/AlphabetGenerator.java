package piwords;

import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

public class AlphabetGenerator {
    /**
     * Given a numeric base, return a char[] that maps every digit that is
     * representable in that base to a lower-case char.
     * 
     * This method will try to weight each character of the alphabet
     * proportional to their occurrence in words in a training set.
     * 
     * This method should do the following to generate an alphabet:
     *   1. Count the occurrence of each character a-z in trainingData.
     *   2. Compute the probability of each character a-z by taking
     *      (occurrence / total_num_characters).
     *   3. The output generated in step (2) is a PDF of the characters in the
     *      training set. Convert this PDF into a CDF for each character.
     *   4. Multiply the CDF value of each character by the base we are
     *      converting into.
     *   5. For each index 0 <= i < base,
     *      output[i] = (the first character whose CDF * base is > i)
     * 
     * A concrete example:
     * 	 0. Input = {"aaaaa..." (302 "a"s), "bbbbb..." (500 "b"s),
     *               "ccccc..." (198 "c"s)}, base = 93
     *   1. Count(a) = 302, Count(b) = 500, Count(c) = 193
     *   2. Pr(a) = 302 / 1000 = .302, Pr(b) = 500 / 1000 = .5,
     *      Pr(c) = 198 / 1000 = .198
     *   3. CDF(a) = .302, CDF(b) = .802, CDF(c) = 1
     *   4. CDF(a) * base = 28.086, CDF(b) * base = 74.586, CDF(c) * base = 93
     *   5. Output = {"a", "a", ... (28 As, indexes 0-27),
     *                "b", "b", ... (47 Bs, indexes 28-74),
     *                "c", "c", ... (18 Cs, indexes 75-92)}
     * 
     * The letters should occur in lexicographically ascending order in the
     * returned array.
     *   - {"a", "b", "c", "c", "d"} is a valid output.
     *   - {"b", "c", "c", "d", "a"} is not.
     *   
     * If base >= 0, the returned array should have length equal to the size of
     * the base.
     * 
     * If base < 0, return null.
     * 
     * If a String of trainingData has any characters outside the range a-z,
     * ignore those characters and continue.
     * 
     * @param base A numeric base to get an alphabet for.
     * @param trainingData The training data from which to generate frequency
     *                     counts. This array is not mutated.
     * @return A char[] that maps every digit of the base to a char that the
     *         digit should be translated into.
     */
    public static char[] generateFrequencyAlphabet(int base,
                                                   String[] trainingData) {
    	if(base < 0){
    		
    		return null;
    		
    	}
    	
    	int count, total = 0;
    	char[] output = new char[base];
    	char[] keys;
        
        Map<Character, Integer> countMap = new HashMap<Character, Integer>();
        
        //Build a String to facilitate the counting of occurrence of unique characters in trainingData 
        String trainingDataString = "";
        
        for(String s : trainingData){
        	
        	trainingDataString += s;
        	
        }
        
        
        int len = trainingDataString.length();
        
        int numKeys = 0;
        
        // Count the occurrence of in the range of a-z in our trainingData.
        // Map the characters to their respected occurrence. The total
        // represents the total number characters in range a-z, thus it 
        // does not always equals  trainingDataString.length() if
        // trainingData contains non a-z characters (1, $ ,#, -).
        
        for( int j = 0; j < len; j++ ){
        	
        	count = 0;
        	
        	char c = trainingDataString.charAt(j);
        	
        	if( !countMap.containsKey(c) && Character.isLetter(c)){
        		numKeys++;
	        	for( int i = 0; i < len; i++ ){
	        		
	        		if( trainingDataString.charAt(i) == c ){
	        			
	        			count++;
	        			
	        		}
	        	}
	        	
	        	total += count;
	        	
	        	countMap.put(c, count);
        	}
        	
        }
        
        keys = new char[numKeys];

        int index = 0;
        
        // Build a sortable array for of our characters 
        for( Character ch : countMap.keySet() ){
        	
        	keys[index++] = ch.charValue();
        	
        }
        
        Arrays.sort(keys);
        
        //Build our output
        int lastIndex = 0;
        
        int endIndex = 0;
        
        for( char key : keys ){
        	
        	float countDouble = countMap.get(key);
            
        	endIndex += Math.round(countDouble/total*base);
        	
        	if(base < endIndex){
        		
        		return output;
        	}
        	
        	for(int i = lastIndex; i < endIndex;i++){
        		
        		output[i] = key;
        		
        	}
        	
        	lastIndex = endIndex;
        }
        return output;
    }
}
