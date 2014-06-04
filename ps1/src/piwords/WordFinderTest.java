package piwords;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class WordFinderTest {
    @Test
    public void basicGetSubstringsTest() {
        String haystack = "abcde";
        String[] needles = {"ab", "abc", "de", "fg"};

        Map<String, Integer> expectedOutput = new HashMap<String, Integer>();
        expectedOutput.put("ab", 0);
        expectedOutput.put("abc", 0);
        expectedOutput.put("de", 3);

        assertEquals(expectedOutput, WordFinder.getSubstrings(haystack,
                                                              needles));
    }
    
    @Test
    public void dontFindSubstringsTest() {
        String haystack = "abcde";
        String[] needles = {"ww"};

        Map<String, Integer> expectedOutput = new HashMap<String, Integer>();

        assertEquals(expectedOutput, WordFinder.getSubstrings(haystack,
                                                              needles));
    }
    
    @Test
    public void returnFirstMatchSubstringsTest() {
        String haystack = "abcabhab";
        String[] needles = {"ab", "h"};

        Map<String, Integer> expectedOutput = new HashMap<String, Integer>();
        expectedOutput.put("ab", 0);
        expectedOutput.put("h", 5);
        
        assertEquals(expectedOutput, WordFinder.getSubstrings(haystack,
                                                              needles));
    }

}
