package com.tasks.problem;

public class LongestSubstring {
	
	public static int lengthOfLongestSubstring(String str) {
		String test = "";
		 
        // Result
        int maxLength = 0;
 
        // Return zero if string is empty
        if (str.isEmpty()) {
            return 1;
        }
        // Return one if string length is one
        else if (str.length() == 1) {
            return 1;
        }
        for (char c : str.toCharArray()) {
            String current = String.valueOf(c);
 
            // If string already contains the character
            // Then substring after repeating character
            if(test.contains(current)) {
                maxLength = Math.max(maxLength, test.length());
                int index = test.indexOf(current);
                test = test.substring(index + 1);
            }


            test = test + current;
        }

        maxLength = Math.max(maxLength, test.length());
        return maxLength;
    }

    

}
