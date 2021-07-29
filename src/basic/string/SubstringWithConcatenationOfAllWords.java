package basic.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
	//https://redquark.org/leetcode/0030-substring-with-concatenation-of-all-words/
	public static List<Integer> findSubstring(String s, String[] words) {
        // Resultant list
        List<Integer> indices = new ArrayList<>();
        // Base conditions
        if (s == null || s.isEmpty() || words == null || words.length == 0) {
            return indices;
        }
        // Store the words and their counts in a hash map
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        // Length of each word in the words array`
        int wordLength = words[0].length();
        // Length of all the words combined in the array
        int wordArrayLength = wordLength * words.length;
        // Loop for the entire string
        for (int i = 0; i <= s.length() - wordArrayLength; i++) {
            // Get the substring of length equal to wordArrayLength
            String current = s.substring(i, i + wordArrayLength);
            // Map to store each word of the substring
            Map<String, Integer> wordMap = new HashMap<>();
            // Index to loop through the words array
            // Index to get each word in the current
            int j = 0;
            // Loop through each word of the words array
            //while (index < words.length) {
            for(int index =0;index<words.length;index++) {
                // Divide the current string into strings of length of
                // each word in the array
                String part = current.substring(j, j + wordLength);
                // Put this string into the wordMap
                wordMap.put(part, wordMap.getOrDefault(part, 0) + 1);
                // Update j and index
                j += wordLength;
            }
            // At this point compare the maps
            if (wordCount.equals(wordMap)) {
                indices.add(i);
            }
        }
        return indices;
    }
	public static void main(String args[]) {
		String t[] = {"bar","foo","the"};
		findSubstring("barfoofoobarthefoobarman",t).forEach(x->System.out.println(x + " -"));
	}
}
