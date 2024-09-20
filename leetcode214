public class Solution {
    public static String shortestPalindrome(String s) {
        String rev_s = new StringBuilder(s).reverse().toString();
        
        String new_s = s + "#" + rev_s;
        
        int[] kmpTable = new int[new_s.length()];
        
        for (int i = 1; i < new_s.length(); i++) {
            int j = kmpTable[i - 1];
            
            while (j > 0 && new_s.charAt(i) != new_s.charAt(j)) {
                j = kmpTable[j - 1];
            }
            
            if (new_s.charAt(i) == new_s.charAt(j)) {
                j++;
            }
            
            kmpTable[i] = j;
        }
        
        int longestPalindromePrefixLength = kmpTable[new_s.length() - 1];
        
        String toPrepend = rev_s.substring(0, s.length() - longestPalindromePrefixLength);
        
        return toPrepend + s;
    }

}

