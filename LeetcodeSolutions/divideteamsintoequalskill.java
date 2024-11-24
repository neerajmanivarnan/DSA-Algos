import java.util.*;

class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        int teamSkill = Arrays.stream(skill).sum() / (n / 2);
        long ans = 0;
        Map<Integer, Integer> count = new HashMap<>();

        
        for (int s : skill) {
            count.put(s, count.getOrDefault(s, 0) + 1);
        }

        
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int s = entry.getKey();
            int freq = entry.getValue();
            int requiredSkill = teamSkill - s;
            
            
            if (count.getOrDefault(requiredSkill, 0) != freq) {
                return -1;  
            }

            
            ans += (long) s * requiredSkill * freq;
        }

        return ans / 2;
    }
}
