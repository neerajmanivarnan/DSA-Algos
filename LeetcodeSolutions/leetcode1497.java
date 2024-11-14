import java.util.HashMap;

public class Solution {
    public boolean canArrange(int[] arr, int k) {
        
        int[] count = new int[k];
        
        
        for (int num : arr) {
            int remainder = num % k;
            if (remainder < 0) {  
                remainder += k;
            }
            count[remainder]++;
        }

        
        for (int i = 1; i <= k / 2; i++) {
            if (i != k - i) {  
                if (count[i] != count[k - i]) {
                    return false;
                }
            } else {  
                if (count[i] % 2 != 0) {
                    return false;
                }
            }
        }

        
        return count[0] % 2 == 0;
    }

    
}

