import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int maxUniqueSplit(String s) {
        return backtrack(s, 0, new HashSet<>());
    }

    
    private int backtrack(String s, int start, Set<String> uniqueSet) {
        
        if (start == s.length()) {
            return uniqueSet.size();
        }

        int max = 0;
        
        
        for (int i = start + 1; i <= s.length(); i++) {
            String substring = s.substring(start, i);
            
            
            if (!uniqueSet.contains(substring)) {
                uniqueSet.add(substring);  
                
                max = Math.max(max, backtrack(s, i, uniqueSet));
                uniqueSet.remove(substring);  
            }
        }
        
        return max;
    }
}

