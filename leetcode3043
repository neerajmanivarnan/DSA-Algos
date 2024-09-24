import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static int findLongestCommonPrefix(int[] arr1, int[] arr2) {
        Set<String> prefixSet = new HashSet<>();

        for (int num1 : arr1) {
            String str1 = Integer.toString(num1);
            for (int i = 1; i <= str1.length(); i++) {
                prefixSet.add(str1.substring(0, i));
            }
        }

        int maxLength = 0;

        for (int num2 : arr2) {
            String str2 = Integer.toString(num2);
            for (int i = 1; i <= str2.length(); i++) {
                String prefix = str2.substring(0, i);
                if (prefixSet.contains(prefix)) {
                    maxLength = Math.max(maxLength, prefix.length());
                }
            }
        }

        return maxLength;
    }


